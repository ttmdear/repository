find -iname "*.tpl";
# Lub z uwzględnieniem wielkości liter

find -name "*.tpl";

# Symbol ; kończy polecenie, czasami musi ono zostać poprzedzone \;
# ponieważ może zostać zinterpretowane przez shella.
find -name "*.tpl" -exec grep "saveItem" {} \;

# Polecenie można wywołać również tak, w takiej sytuacji wszystkie pliki są
# przekierowane do jednego wejscia polecenie. Jest to znacznie szybsze, ale wyście
# jest mniej czytelne.
find -name "*.tpl" -exec grep "saveItem" {} +

# Wyszukiwanie w całej ścieżce.
find -path './Sites/MatrixNewUI/*.php' -exec cat {} \; > tags-cat
find -path './Models*.php' -exec cat {} \; >> tags-cat

# Z uwzględnieniem operatora OR
find -iname "*.php" -o -iname "*.js" -exec cat {} \; >> tags-cat

# Wszykanie w plikach .tpl słowa saveItem i przeliczenie wyników.
find -name "*.tpl" -exec grep "saveItem" {} \; | wc

# Otworzenie plików w gvimie w jednej zakładce.
find -name "*.tpl" -exec grep -l "saveItem" {} \; | xargs gvim -o1

# Znalezienie dowiązań symbolicznych i wyświetlenie informacji o nich
sudo find -type l -exec ls -l {} \; | gvim -

# Wyszukanie dowiazań
find . -type l -ls

# Wyszukiwanie dowiazania ze specyficzna nazwa; Nazwa może zawierać wyrażenia regularne
find . -lname link_target

# Wyszukanie uszkodzonych dowiazań
find -L . -type l -ls

# Wyszukiwanie i utworzenie nowego
find -L . -type l -delete -exec ln -s new_target {} \;

# Wyszukiwanie słowa "namespace" w plikach php.
find -name "*.php" -exec grep -H namespace {} \;

# Wyszukiwanie z określoną głębokościa
find . -maxdepth 1 -type f -name '*.md'

# Policzenie plików, w tym celu wykorzystywane jest polecenie wc (word count)
find . -type f -not -path '*/\.*' |wc -l

# Wyszukanie danych katalogów oraz wylistowanie zawartości tych katalogów.
find . -iname doc -exec echo -e \\n{} \; -exec ls -lh {} \;

# Podmiana topi na elusim w plikach.
find src -type f -exec sed -i -e 's/topi/elusim/g' {} \;

# Zmiana uprawnień i własności
sudo find . -print -exec chown serge:family {} \;

# Find empty files
find . -type f -name *.bib -size 0

# Find and delete empty files
find . -type f -name *.bib -size 0 -delete

# Find symbolic links
find . -type ljj

# Detailed listing of what find found
# Continuing from the previous example:
find . -type l -ls

# This will print all details about the found symbolic links, including their target.
# Find symbolic links to a specific target
find . -lname link_target

# Note that link_target may contain wildcard characters.
Find broken symbolic links
find -L . -type l -ls

# Find & replace broken symbolic links
find -L . -type l -delete -exec ln -s new_target {} \;

# List the character encoding of text files
find . -type f -iname *.txt -exec file -i {} \;

# Usuniecie plików
find -iname "*.drop" -exec rm -r {} \;
find -iname "*.drop" -exec rm -r {} +

# Regex
find . -regex '^.*topi.*.scss$'