#!/bin/bash

# Dla CA-R, selfsigned
openssl genrsa -aes256 -out ca-root-private.key.pem 3072
openssl rsa -in ca-root-private.key.pem -pubout -out ca-root-public.key.pem
openssl req -key ca-root-private.key.pem -new -addext "keyUsage=keyCertSign" -subj "/C=PL/ST=Polska/O=Foo/OU=Foo - CAR" -out ca-root-csr.pem

openssl req -new -x509 -key ca-root-private.key.pem -out ca-root-cert.pem -subj "/C=PL/ST=Polska/O=Foo/OU=Foo root authority/CN=foo.org"
# openssl ca -selfsign -create_serial -rand_serial -keyfile "ca-root-private.key.pem" -subj "/C=PL/ST=Polska/O=Foo/OU=Foo root authority/CN=foo.org" -days 365 -notext -md sha256 -in ca-root-csr.pem -out ca-root-cert.pem

# Dla CA-I (intermiddiet)
openssl genrsa -aes256 -out ca-int-private.key.pem 3072
openssl rsa -in ca-int-private.key.pem -pubout -out ca-int-public.key.pem
openssl req -key ca-int-private.key.pem -new -addext "keyUsage=keyCertSign" -subj "/C=PL/ST=Polska/O=Foo/OU=Foo intermiddiet authority/CN=foo.org" -out ca-int-csr.pem

openssl x509 -req -in ca-int-csr.pem -CA ca-root-cert.pem -CAkey ca-root-private.key.pem -CAcreateserial -out ca-int-cert.pem
# openssl ca -create_serial -rand_serial -cert ca-root-cert.pem -keyfile "ca-root-private.key.pem" -days 365 -notext -md sha256 -in ca-int-csr.pem -out ca-int-cert.pem

# Dla CA-I (clientermiddiet)
openssl genrsa -aes256 -out client-private.key.pem 3072
openssl rsa -in client-private.key.pem -pubout -out client-public.key.pem
openssl req -key client-private.key.pem -new -addext "keyUsage=digitalSignature,dataEncipherment" -subj "/C=PL/ST=Polska/O=Foo/OU=Foo Corp./CN=foo.org" -out client-csr.pem

openssl x509 -req -in client-csr.pem -CA ca-int-cert.pem -CAkey ca-int-private.key.pem -CAcreateserial -out client-cert.pem

# Generowanie pliku PKCS12 z rozszerzeniem .p12, może być również .pfx
openssl pkcs12 -export -out client.p12 -inkey client-private.key.pem -in client-cert-chain.pem

keytool -v -importkeystore -srcstoretype PKCS12 -srckeystore client.p12 -deststoretype JKS -destkeystore client.jks
