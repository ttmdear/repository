# Install-Module Az -Force
# Install-Module ExchangeOnline -Force

#$password = ConvertTo-SecureString -String 'onboarding-app' -AsPlainText -Force
#
#Write-Host "Connecting with Exchange"
#
#Connect-ExchangeOnline `
#   -AppId "..." `
#   -CertificateFilePath "C:\Users\pawel.bobryk\Desktop\onboarding-app\inspeerity-servers\onboarding\onboarding-api\office-365\onboarding-app.pfx" `
#   -Organization "inspeerity.com" `
#   -CertificateThumbprint "..." `
#   -CertificatePassword $password

$clientId = "..."
$data = "..."
$tenantId = "..."

$tokenBody = @{
    Grant_Type    = "client_credentials"
    Scope         = "https://outlook.office365.com/.default"
    Client_Id     = $clientId
    Client_Secret = $data
}

$tokenResponse = Invoke-RestMethod -Uri https://login.microsoftonline.com/$tenantId/oauth2/v2.0/token -Method POST -Body $tokenBody

# You can then pass this bearer (JWT) token to the Connect-ExchangeOnline cmdlet using the AccessToken parameter
Connect-ExchangeOnline -AccessToken $tokenResponse.access_token -Organization "app.onmicrosoft.com";

#$Group = Get-DistributionGroup -Identity "all-devs"
#Add-DistributionGroupMember -Identity $Group -Member "test.user03@inspeerity.com" -Confirm:$false