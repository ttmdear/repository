# Connect-ExchangeOnline
$cert = New-SelfSignedCertificate `
    -DnsName "onboarding-app.inspeerity.com" `
    -CertStoreLocation "cert:\CurrentUser\My" `
    -NotAfter (Get-Date).AddYears(1) `
    -KeySpec KeyExchange

$cert | Export-Certificate -FilePath "C:\Users\pawel.bobryk\Desktop\onboarding-app\inspeerity-servers\onboarding\onboarding-api\office-365\onboarding-app.cer"
$cert | Export-PfxCertificate -FilePath "C:\Users\pawel.bobryk\Desktop\onboarding-app\inspeerity-servers\onboarding\onboarding-api\office-365\onboarding-app.pfx" -Password $(ConvertTo-SecureString -String "onboarding-app" -AsPlainText -Force)
