# Wyświetlenie zawartości certyfikatu x509 w formacie DER.
openssl.exe x509 -inform der -in sp-mock-local-encript.cert -noout -text

# Generowanie losowego klucza
openssl rand 128 > sym_keyfile.key

# Generowanie klucza CSR z wygenerowaniem klucza prywatnego (jedno polecenie)
openssl req -out CSR.csr -new -newkey rsa:2048 -nodes -keyout privateKey.key

# Generowanie selfsigned certyfikat z kluczem prywatnym
openssl req -x509 -sha256 -nodes -days 365 -newkey rsa:2048 -keyout privateKey.key -out certificate.crt

# Generowanie CSR
openssl req -out CSR.csr -key privateKey.key -new

# Generate a certificate signing request based on an existing certificate
openssl x509 -x509toreq -in certificate.crt -out CSR.csr -signkey privateKey.key

# Remove a passphrase from a private key
openssl rsa -in privateKey.pem -out newPrivateKey.pem

# Check a Certificate Signing Request (CSR)
openssl req -text -noout -verify -in CSR.csr

# Check a private key
openssl rsa -in privateKey.key -check

# Check a certificate
openssl x509 -in certificate.crt -text -noout

# Check a PKCS#12 file (.pfx or .p12)
openssl pkcs12 -info -in keyStore.p12

# Check an MD5 hash of the public key to ensure that it matches with what is in a CSR or private key
openssl x509 -noout -modulus -in certificate.crt | openssl md5
openssl rsa -noout -modulus -in privateKey.key | openssl md5
openssl req -noout -modulus -in CSR.csr | openssl md5

# Check an SSL connection. All the certificates (including Intermediates) should be displayed
openssl s_client -connect www.paypal.com:443

# Convert a DER file (.crt .cer .der) to PEM
openssl x509 -inform der -in certificate.cer -out certificate.pem

# Convert a PEM file to DER
openssl x509 -outform der -in certificate.pem -out certificate.der

# Convert a PKCS#12 file (.pfx .p12) containing a private key and certificates to PEM
openssl pkcs12 -in keyStore.pfx -out keyStore.pem -nodes

# You can add -nocerts to only output the private key or add -nokeys to only output the certificates.

# Convert a PEM certificate file and a private key to PKCS#12 (.pfx .p12)
openssl pkcs12 -export -out certificate.pfx -inkey privateKey.key -in certificate.crt -certfile CACert.crt

# Wyciągniecie klucza publicznego z certyfikatu
openssl x509 -pubkey -noout < cert.pem > pubkey.pem

# Wyświetlenie certyfikatu
openssl x509 -in cerfile.cer -noout -text
openssl x509 -inform pem -in cerfile.cer -noout -text
openssl x509 -inform der -in cerfile.cer -noout -text

# Dodawanie certyfikatu do JKS
keytool -import -trustcacerts -alias universityRoot -file RootCA.crt -keystore /etc/ssl/certs/java/cacerts

# Klucz można wygenerować takim poleceniem, jest to klucz prywatny o długości 2048 bits.
openssl genrsa -out private.pem

# Klucz prywatny, zaszyfrowany za pomocą AES256 o długości 3072
openssl genrsa -aes256 -out private.key.pem 3072

# Klucz prywatny, zaszyfrowany za pomocą AES256 o długości 3072, z podaniem hasła
openssl genrsa -aes256 -out intermediate/private/private.pem -passout pass:$2 3072

# Wygenerowanie klucza publicznego na postawie prywatnego, opcja -pubout, format PEM
openssl rsa -in keyfile.key -pubout -out keyfile.pub

# Wygenerowanie klucza publicznego na postawie prywatnego, opcja -pubout, format DER
openssl rsa -in private.key.pem -pubout -outform DER -out public.key.der
# Wefikowanie klucza
openssl rsa -in private.pem -check

# Werfikacja klucza w formacie DER
openssl rsa -inform DER -in private.key.der -check

# Wyświetlenie klucza publicznego
openssl rsa -in public.key.pem -pubin

# Wyświetlenie skrótu klucza publicznego, opcja -n
openssl rsa -in public.key.pem -pubin -noout | md5sum

# Wyświetlenie skrótu dla klucza publicznego na postawie prywatnego
openssl rsa -in private.key.pem -pubout -noout | md5sum

# Usunięcie hasła w kluczu prywatnym
openssl rsa -in private.key.pem -out private-no-e.key.pem

# Przekonwertowanie klucza z PEM na DER
openssl rsa -in private.key.pem --outform der -out private.key.der

# Wygenerowanie CSR na postawie klucza prywatnego
openssl req -key private.key.pem -new -subj "/C=PL/ST=Polska/O=Ofiko/OU=OfikoAuth Sign" -out csr.pem
openssl req -key private.key.pem -new -subj "/C=PL/ST=Polska/O=Ofiko/OU=OfikoAuth Sign" -outform DER -out csr.der

# Wyświetlenie zawartości CSR
openssl req -in csr.pem -text
openssl req -inform der -in csr.der -text
