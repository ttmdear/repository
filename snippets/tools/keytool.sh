# Tworzenie Keystora
keytool -v -importkeystore -srcstoretype PKCS12 -srckeystore client.p12 -destkeystore client.jks

# Tworzenie Keystora z aliasem
keytool -v -importkeystore -srcstoretype PKCS12 -srckeystore client.p12 -destkeystore client.jks -srcalias 1 -destalias nowy3

# Dodanie certyfikatu
keytool -v -keystore client.jks -importcert -alias cert2 -trustcacerts -file client-cert-chain.pem

# Wylistowanie zawartości
keytool -list -keystore client.jks

# Dodanie certyfikatów do Trustore
keytool -importcert -trustcacerts -file idp-encryption.crt -alias usos-idp-encryption -keystore "$JAVA_HOME\jre\lib\security\cacerts"
keytool -importcert -trustcacerts -file idp-signing.crt -alias usos-idp-signing -keystore "$JAVA_HOME\jre\lib\security\cacerts"
keytool -importcert -trustcacerts -file rootCA.pem -alias usos-rootca -keystore "$JAVA_HOME\jre\lib\security\cacerts"
keytool -importcert -trustcacerts -file rootCA.pem -alias usos-rootca -keystore "$JAVA_HOME\jre\lib\security\cacerts"

keytool -list -trustcacerts -keystore "$JAVA_HOME\jre\lib\security\cacerts"

keytool -delete -alias usos-idp-encryption -keystore "$JAVA_HOME\jre\lib\security\cacerts" -storepass changeit
keytool -delete -alias usos-idp-signing -keystore "$JAVA_HOME\jre\lib\security\cacerts" -storepass changeit
keytool -delete -alias usos-rootCA -keystore "$JAVA_HOME\jre\lib\security\cacerts" -storepass changeit

