# Dodanie nagłówka za pomocą przełącznika -H oraz wyłączenie walidacji
# certyfikatu za pomocą przełącznika -k
curl -k -H "Cookie: session_id=fd020cc4-5bc4-45ab-83a0-5e70d6e7c8a4" https://rejestracje.ut.edu.pl/student/exam_registrations?era=7&session_id=fd020cc4-5bc4-45ab-83a0-5e70d6e7c8a4

# Wyświetlenie nagłówków za pomocą opcj -I
curl -I http://localhost:8280/kart/auth/logi

# Ustawienia CA
curl --cacert /pth/to/my/ca.pem https://url
curl --header 'Host: www.cyberciti.biz' --cacert /pth/to/my/ca.pem https://207.5.1.10/nixcraft.tar.gz

# Pozostałe przypadki
curl -X POST --data 'pass=123' www.test.pl
curl http://192.168.140.2/services/apisrv/installation -H "Host: apps.ut.edu.pl"

