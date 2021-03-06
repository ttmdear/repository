systemctl status nginx.service
systemctl start nginx.service

# Wyświetlenie logów usługi o uruchomienia
journalctl -b -u nginx.service

# Wyświetlenie pliku jednostki
systemctl cat nginx.service

#
systemctl show nginx.service

# Lista zależności
systemctl list-dependencies nginx.service

# Lista jednostek
systemctl list-units
systemctl list-units --all
systemctl list-unit-files

# Run service
sudo systemctl start application.service
sudo systemctl start application

# Stop service
sudo systemctl stop application.service

# Restart
sudo systemctl restart application.service

# Przeładowanie powoduje np. zaczytanie nowych plików konfiguracyjnych.
sudo systemctl reload application.service

# Przeładowanie lub restart
sudo systemctl reload-or-restart application.service

# Aktywowanie/Dezaktywowanie (autostart) usługi
sudo systemctl enable application.service
sudo systemctl disable application.service

# State of service
systemctl status application.service
systemctl is-active application.service
systemctl is-enabled application.service
systemctl is-failed application.service

# List services
systemctl list-units
systemctl list-units --all
systemctl list-units --all --state=inactive
systemctl list-units --type=service
systemctl list-unit-files

# Wyświetlenie pliku jednostki
systemctl cat atd.service

# Wyświetlenie zależności dla usługi
systemctl list-dependencies sshd.service

# Wyświetlenie właściwości usługi
systemctl show sshd.service

# Ukrywanie usługi mask/unmask
sudo systemctl mask nginx.service
sudo systemctl unmask nginx.service

# Edycja usługi
sudo systemctl edit nginx.service
sudo systemctl edit --full nginx.service
sudo rm -r /etc/systemd/system/nginx.service.d
sudo rm /etc/systemd/system/nginx.service

# Przeładowanie po edycji
sudo systemctl daemon-reload
