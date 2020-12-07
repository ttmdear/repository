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