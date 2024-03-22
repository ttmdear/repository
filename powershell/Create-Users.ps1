Install-Module ExchangeOnlineManagement
Install-Module AzureAD

Import-Module AzureAD

Function WriteErrorMessageAndExit {
	Param (
		[Parameter(Mandatory = $true)] [string] $Message
	)
	Write-Host $Message -ForegroundColor Red
	$null = [System.Console]::ReadKey().Key.ToString()
	Exit
}

Function ValidateFileExists {
	Param (
		[Parameter(Mandatory = $true)] [string] $FilePath
	)

	$FileExists = Test-Path -Path $FilePath
	if (-Not $FileExists) {
		WriteErrorMessageAndExit "File $($FilePath) not found."
	}
}

$AppPropertiesFile = "createUsers.properties"
ValidateFileExists $AppPropertiesFile

$AppProperties = convertfrom-stringdata (get-content $AppPropertiesFile -raw)

Function AddUserToGroup {
	Param (
		[Parameter(Mandatory = $true)] [string] $GroupName,
		[Parameter(Mandatory = $true)] [string] $UserPrincipalName,
		[Parameter(Mandatory = $true)] [boolean] $IsExchangeGroup
	)

	try{
		if( $IsExchangeGroup ) {
			$Group = Get-DistributionGroup -Identity $GroupName
			Add-DistributionGroupMember -Identity $Group -Member $UserPrincipalName -Confirm:$false
		}
		else {
			$Group = (Get-AzureADGroup | Where-Object -Property DisplayName -Value $GroupName -IN).ObjectId
			Add-AzureADGroupMember -ObjectId $Group -RefObjectId $CreatedUser.ObjectId
		}
		Write-Host "Added user $($UserPrincipalName) to group $($GroupName)..."
	} catch {
		Write-Host "StatusCode:" $_.Exception.Response.StatusCode.value__ -ForegroundColor Red
		Write-Host "StatusDescription:" $_.Exception.Response.StatusDescription -ForegroundColor Red
	}
}

Function AddUserToExchangeGroup {
	Param (
		[Parameter(Mandatory = $true)] [string] $GroupName,
		[Parameter(Mandatory = $true)] [string] $UserPrincipalName
	)
	AddUserToGroup $GroupName $UserPrincipalName $true
}

Function AddUserToAzureADGroup {
	Param (
		[Parameter(Mandatory = $true)] [string] $GroupName,
		[Parameter(Mandatory = $true)] [string] $UserPrincipalName
	)
	AddUserToGroup $GroupName $UserPrincipalName $false
}

Function AddUserToJiraTempoTeam {
	Param (
		[Parameter(Mandatory = $true)] [string] $TeamName,
		[Parameter(Mandatory = $true)] [string] $JiraAccountId
	)
	Write-Host "Trying to add user $($UserPrincipalName) to group $($TeamName)"

	#	Tempo API token for account bot@inspeerity.com
	$MainUrl = "https://api.tempo.io/4"
	$PrivateToken = $AppProperties.'jira.tempo.private.token'
	$Headers = @{
		"Authorization" = "Bearer $($PrivateToken)"
	}

	#	get all Tempo teams
	$Response = Invoke-RestMethod -Method "Get" -Uri "$($MainUrl)/teams" -Headers $Headers -ContentType "application/json"
	#		Write-Host $Response.results

	#	find team and add member
	foreach ($tempoTeam in $Response.results) {
		if ( $tempoTeam.name -ilike $TeamName) {
			$Body = @{
				"teamId" = "$($tempoTeam.id)"
				"accountId" = "$($JiraAccountId)"
				"roleId" = 2
				"commitmentPercent" = 100
			} | ConvertTo-Json
			Write-Host $Body

			$Response = Invoke-RestMethod -Method "Post" -Uri "$($MainUrl)/team-memberships" -Headers $Headers -Body $Body -ContentType "application/json"
			Write-Host "User $($UserPrincipalName) added to group $($TeamName)"
			break
		}
	}
}

$LDAPFile = "..\ldap\tools\add-inspeerity-developer.cmd"
ValidateFileExists $LDAPFile

$CsvFile = "newUsers.csv"
ValidateFileExists $CsvFile

$users=Import-Csv -Path $CsvFile

#	validation
foreach ($user in $users) {
	#	no special characters in the password (cmd script add-inspeerity-developer.cmd does not like it)
	if ($user.Password -notmatch '^[a-zA-Z0-9]+$') {
		#	read user from CSV
		Write-Host `r
		Write-Host "$( $user.Password ), $( $user.MailNickName )"
		WriteErrorMessageAndExit "User password cannot contains special characters. Correct password for the user and start again."
	}
}

Write-Host "Connecting with AzureAD..."
Connect-AzureAD
Write-Host "Connecting with ExchangeOnline (for adding user to groups)..."
Connect-ExchangeOnline

$LicenseBasicName="O365_BUSINESS_ESSENTIALS"
$LicenseBasicSkuId=(Get-AzureADSubscribedSku | Where-Object -Property SkuPartNumber -Value $LicenseBasicName -IN).SkuID

# user creation
foreach ($user in $users) {
	#	read user from CSV
	Write-Host `r
	Write-Host "$( $user.Password ), $( $user.MailNickName ), $( $user.FirstName ), $( $user.LastName ), $( $user.City ), $( $user.ManagerEmail ), $( $user.Contract ), $( $user.TempoTeam )"
	Read-Host -Prompt "Check user data before processing..."

	$UserPrincipalName = "$( $user.MailNickName )@inspeerity.com"
	Write-Host "***** Adding to AzureAD"
	#	create password
	$PasswordProfile = New-Object -TypeName Microsoft.Open.AzureAD.Model.PasswordProfile
	$PasswordProfile.Password = $user.Password

	#	create user
	$CreatedUser = $null
	try
	{
		$CreatedUser = New-AzureADUser -AccountEnabled $true `
		-PasswordProfile $PasswordProfile `
		-MailNickName "$( $user.MailNickName )" `
		-UserPrincipalName "$( $UserPrincipalName )" `
		-DisplayName "$( $user.FirstName ) $( $user.LastName )" `
		-GivenName $user.FirstName `
		-Surname $user.LastName `
		-UsageLocation "PL"
	}catch{
		Write-Host "INFO: User is already created. Getting account info."
		$CreatedUser = Get-AzureADUser -ObjectId $UserPrincipalName
	}
	Write-Host "CreatedUser = $( $CreatedUser.MailNickName ), $( $CreatedUser.ObjectId )"

	#	add manager for user
	$UserManager = Get-AzureADUser -ObjectId $user.ManagerEmail
	Set-AzureADUserManager -ObjectId $CreatedUser.ObjectId -RefObjectId $UserManager.ObjectId

	#	assign license
	$License = New-Object -TypeName Microsoft.Open.AzureAD.Model.AssignedLicense
	$License.SkuId = $LicenseBasicSkuId
	$Licenses = New-Object -TypeName Microsoft.Open.AzureAD.Model.AssignedLicenses
	$Licenses.AddLicenses = $License

	Set-AzureADUserLicense -ObjectId $CreatedUser.ObjectId -AssignedLicenses $Licenses

	#	add groups
	Write-Host `r
	$ExchangeUser = $null
	DO {
		Write-Host "Checking if $( $UserPrincipalName ) is available in the ExchangeOnline..."
		try {
			$ExchangeUser = Get-User -Identity $UserPrincipalName -ea Stop
		}
		catch {
			Write-Host "Sleep 5s..."
			Start-Sleep -Seconds 5
		}
	} Until ($ExchangeUser -ne $null)

	Write-Host "Adding $( $UserPrincipalName ) to groups..."
	AddUserToExchangeGroup "all-pl" $UserPrincipalName
	AddUserToExchangeGroup "all-devs" $UserPrincipalName
	if ( $user.City -in "Warszawa", "Warsaw") {
		AddUserToExchangeGroup "Inspeerity Warsaw" $UserPrincipalName
	}
	AddUserToAzureADGroup "Inspeerity Public" $UserPrincipalName

	#	add to LDAP
	Write-Host `r
	Write-Host "Adding to LDAP..."
	cmd /c $LDAPFile $user.FirstName $user.LastName $user.MailNickName $($user.Password)

	# 	add to Gitlab
	Write-Host "***** Adding to Gitlab"
	#	token for account bot@inspeerity.com
	$PrivateToken = $AppProperties.'gitlab.private.token'
	$MainUrl = "https://git.int.inspeerity.com/api/v4"
	try {
		#	add new user
		$Body = @{
			"email" = "$($UserPrincipalName)"
			"extern_uid" = "cn=$($user.MailNickName),cn=users,dc=corp,dc=inspeerity,dc=com"
			"provider" = "ldapmain"
			"name" = "$($user.FirstName) $($user.LastName)"
			"username" = "$($user.MailNickName)"
			"force_random_password" = $true
			"skip_confirmation" = $true
		} | ConvertTo-Json
		Write-Host $Body

		$Response = Invoke-RestMethod -Method 'Post' -Uri "$($MainUrl)/users?$($PrivateToken)" -Body $Body -ContentType "application/json"
		# 	add user to groups examples and inspeerity
		# 	https://docs.gitlab.com/ee/api/access_requests.html
		$Response = Invoke-RestMethod -Method 'Post' -Uri "$($MainUrl)/groups/examples/members?$($PrivateToken)&user_id=$($Response.id)&access_level=30" -Body $Body -ContentType "application/json"
		Write-Host "User $($UserPrincipalName) added to group examples"
		$Response = Invoke-RestMethod -Method 'Post' -Uri "$($MainUrl)/groups/inspeerity/members?$($PrivateToken)&user_id=$($Response.id)&access_level=30" -Body $Body -ContentType "application/json"
		Write-Host "User $($UserPrincipalName) added to group inspeerity"
	} catch {
		Write-Host "StatusCode:" $_.Exception.Response.StatusCode.value__ -ForegroundColor Red
		Write-Host "StatusDescription:" $_.Exception.Response.StatusDescription -ForegroundColor Red
	}

	# 	add to JIRA
	Write-Host "***** Adding to JIRA"
	#	token for account bot@inspeerity.com
	$PrivateToken = $AppProperties.'jira.private.token'
	$MainUrl = "https://inspeerity.atlassian.net/rest/api/2"
	try {
		#	add new user
		$Headers = @{
			"Authorization" = "Basic $($PrivateToken)"
		}

		$Body = @{
			"emailAddress" = "$($UserPrincipalName)"
		} | ConvertTo-Json
		Write-Host $Body

		$Response = Invoke-RestMethod -Method 'Post' -Uri "$($MainUrl)/user" -Headers $Headers -Body $Body -ContentType "application/json"
		Write-Host $Response.accountId
		Start-Sleep -Seconds 20
		$JiraAccountId = $Response.accountId

		# 	add user to groups
		$Body = @{
			"accountId" = "$($JiraAccountId)"
		} | ConvertTo-Json
		Invoke-RestMethod -Method 'Post' -Uri "$($MainUrl)/group/user?groupname=inspeerity-internal-users" -Headers $Headers -Body $Body -ContentType "application/json"
		Write-Host "User $($UserPrincipalName) added to group inspeerity-internal-users"
		if ( $user.Contract -in "UoP", "uop", "UOP") {
			Invoke-RestMethod -Method 'Post' -Uri "$($MainUrl)/group/user?groupname=inspeerity-UoP" -Headers $Headers -Body $Body -ContentType "application/json"
			Write-Host "User $($UserPrincipalName) added to group inspeerity-UoP"
		}

		# 	add user to Tempo Teams
		#	Java/Cloud Team
		#	Absences Team
		#	External Team
		#	Frontend Team
		#	Office / HR Team
		#	React Team
		#	.NET Team
		#	QA Team
		#	PHP Team
		#	Mobile Team
		#	Rest of the Family
		#	Python Team
		AddUserToJiraTempoTeam "Absences Team" $JiraAccountId
		AddUserToJiraTempoTeam $user.TempoTeam $JiraAccountId
	} catch {
		Write-Host "StatusCode:" $_.Exception.Response.StatusCode.value__ -ForegroundColor Red
		Write-Host "StatusDescription:" $_.Exception.Response.StatusDescription -ForegroundColor Red
	}
}

Read-Host -Prompt "Process ended. Press any key to continue..."