# Wyszukanie bez wyświetlenie nazw plików.
grep -hr 'params->get'

# Z przekierowaniem go gvim.
grep -hr 'params->get' | gvim -

# Wyszukanie użycia metody setArg w plikach gdzie jest wykorzystany model positions.
grep '\->setArg(' $(grep -r -l 'Models\\positions\\positions')

# Wyszukiwanie --include/--exclude/--exclude-dir
grep -rni -E --include="*\.java" --exclude-dir="target" "ZdarzeniaKonfiguracjaModuluInformacyjnego"