journalctl

# Od momenty uruchomienia
journalctl -b

# Lista wszystkich uruchomień
journalctl --list-boots

# Logi dla określonego uruchomienia
journalctl --boot=-2

# Tylko błędy jądra
journalctl -k

# Tylko błędy jądra od momenty uruchomienia
journalctl -k -b
