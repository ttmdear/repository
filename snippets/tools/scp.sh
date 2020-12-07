# Narzędzie za pomocą którego można przenosić pliki/katalogi w bezpieczny sposób między lokalnym systemem i zdalnym.
# Do przenoszenia/kopiowania plików SCP wykorzystuje protokół SSH.

# Kopiowanie pliku lokalnego na zdalny
scp usosmain/target/usosadm.war root@192.168.140.2:/var/lib/tomcat8/webapps/ROOT.war

# Kopiowanie z podaniem portu
scp -P 2322 file.txt remote_username@10.10.0.2:/remote/directory

# W przypadku kopiowania całych katalogów
scp -r /local/directory remote_username@10.10.0.2:/remote/directory

# Kopiowanie z katalogu zdalnego na lokalny
scp remote_username@10.10.0.2:/remote/file.txt /local/directory

# Kopiowanie z jednej zdalnej lokalizacji na inna zdalna
scp user1@host1.com:/files/file.txt user2@host2.com:/files
scp -3 user1@host1.com:/files/file.txt user2@host2.com:/files