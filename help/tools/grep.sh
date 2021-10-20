# Opcje do polecenia
# -r przeszukuje rekursywanie wszystki pliki
# -I pomija pliki binarne
# -l wyświetla tylko nazwy plików

# Wyszukanie bez wyświetlenie nazw plików.
grep -hr 'params->get'

# Z przekierowaniem go gvim.
grep -hr 'params->get' | gvim -

# Wyszukanie użycia metody setArg w plikach gdzie jest wykorzystany model positions.
grep '\->setArg(' $(grep -r -l 'Models\\positions\\positions')

# Wyszukiwanie --include/--exclude/--exclude-dir
grep -rni -E --include="*\.java" --exclude-dir="target" "ZdarzeniaKonfiguracjaModuluInformacyjnego"

# Otworzenie listy plików w Gvim
grep -rl '@author M' | xargs gvim -o1
