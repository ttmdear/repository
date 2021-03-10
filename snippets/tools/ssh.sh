# Local port forwarding
ssh -L 9000:imgur.com:80 user@example.com
ssh -L 1521:192.168.140.2:1521 usos@192.168.140.2

# Remote port forwarding
ssh -R 9090:localhost:80 user@example.com

# Nawiązanie połączenia
ssh -p 22 user@server-address

# Połączenie i wykonanie polecenia
ssh -p 22 root@192.168.140.2 -t "tail -f /var/log/tomcat8/usosadm"
ssh -t user@domain.com 'cd /some/path; bash -l'

# Generowanie pary kliczy publiczny i prywatny
ssh-keygen -t rsa -f id_rsa

# Program wygeneruje dwa klucze id_rsa.pub i id_rsa.
# Klucz publiczny wysyłamy na serwer.

# Możemy to wykonać poleceniem
ssh-copy-id demo@198.51.100.0

# Lub przez ssh
cat ~/.ssh/id_rsa.pub | ssh demo@198.51.100.0 "mkdir -p ~/.ssh && chmod 700 ~/.ssh && cat >>  ~/.ssh/authorized_keys"

# Lub ręcznie przeniść do katalogu.
cat id_rsa.pub > authorized_keys

# Nawiazanie połączenia za pomocą klucza
ssh -o "IdentitiesOnly=yes" -i "C:\\Projekty\\workspace\\usos\\PKI\\pw.pbobryk.id_rsa" -p 22 root@$USOS_EPW_WEB_SERVER_IP
