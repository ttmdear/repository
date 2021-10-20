# Otworzenie listy plików z grepa.
grep -rl 'name=""' src | xargs gvim -o1