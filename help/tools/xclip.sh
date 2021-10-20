# Odczytanie zawartości schowka PRIMARY i przekazanie go do polecenia wc
xclip -o | wc

# Odczytanie polecenia, wysłanie do md5sum, umieszczenie wyniku w schowku
xclip -o | md5sum | xclip -in