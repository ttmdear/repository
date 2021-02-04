# Jest to symulator konsoli VT100 https://pl.wikipedia.org/wiki/VT100
#
# Polecenie może między innymi służyć do kumunikacji.
#
# Wcześniej można wywołac polecenie dmesg w celu ustalenia
# podłączone urządzenia.
#
# Podłączenie się do portu szeregowago. Po wykonaniu polecenia zostanie
# aktywowana konsola.
# Skróty:
# - 'C-a k' wyłączy konsolę
# - 'C-a d' odepnie konsolę
# Pozostałe skróty są w manualu.
screen /dev/ttyACM0 9600
