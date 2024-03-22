param(
    [string] $ClientId,
    [string] $ClientSecret,
    [string] $TenantId,
    [string] $Organization,
    [string] $GroupIdentities,
    [string] $Member
)

Write-Host "Start Add-DistributionGroupMember.ps1"
Write-Host "ClientId $ClientId"
Write-Host "TenantId $TenantId"
Write-Host "Organization $Organization"
Write-Host "GroupIdentities $GroupIdentities"
Write-Host "Member $Member"

$tokenBody = @{
    Grant_Type = "client_credentials"
    Scope = "https://outlook.office365.com/.default"
    Client_Id = $ClientId
    Client_Secret = $ClientSecret
}

Write-Host "Getting token ..."
$token = Invoke-RestMethod -Uri "https://login.microsoftonline.com/$TenantId/oauth2/v2.0/token" -Method POST -Body $tokenBody

Write-Host "Connect ExchangeOnline ..."
Connect-ExchangeOnline -AccessToken $token.access_token -Organization $Organization;

DO
{
    Write-Host "Checking if $Member is available in the ExchangeOnline..."
    try {
        $ExchangeUser = Get-User -Identity $Member -ea Stop
    } catch {
        Write-Host "Sleep 5s..."
        Start-Sleep -Seconds 5
    }
} Until ($ExchangeUser -ne $null)

Start-Sleep -Seconds 5

$GroupIdentities.Split(",") | ForEach {
    Write-Host "Adding $Member into $_"

    $Group = Get-DistributionGroup -Identity $_
    Add-DistributionGroupMember -Identity $Group -Member $Member -Confirm:$false

    Write-Host "$Member added into $_"
}

Write-Host "OK"