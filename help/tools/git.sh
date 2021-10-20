# Konfiguracja
# --------------------------
git config --system zmienna wartosc - ustawienia dla kazdego projektu
git config --global zmienna wartosc - ustawienia dla kazdego projektu
git config zmienna wartosc - ustawienia dla aktualnego proejktu
git config --list - odczyt ustawień wszystckich
git config --list --system - odczyt ustawień --system
git config --list --global - odczyt ustawień --global

# Rewizje
# --------------------------
git show
git rev-parse --short HEAD # Hasha skrócony ostatniej rewizji
git rev-parse HEAD # Hash ostatniej rewizji

# Gałęzie
# --------------------------
git branch --show-current # Nazwa gałęzi

# DIFF
# --------------------------
git diff SHA1 SHA2 # Porównanie określonych rewizji
git diff --name-only SHA1 SHA2 # Wyświetlenie tylko plików
git diff kart-3-1 # Porównanie aktualnej wersji z gałęzią
git diff-tree --no-commit-id --name-only -r a5a8c021 # Wyświetlenie naz plików

# Usunięcie pliku z repozytorium Gita, ale nie fizycznie.
git rm --cached pentaid-frontend/idwall/package-lock.json

# Wyświetlenie drzewa rewizji
git log --oneline --decorate --all --graph
git log --graph --oneline

# Utworzenie aliasu
git config --global alias.tree "log --oneline --decorate --all --graph"
git tree

# Kod rewizji

# Pozostałe polecenia
Praca lokalna:
git init - tworzy puste repo w bieżącym katalogu
git commit [-m 'komunikat commita']- commit poczekalni
git commit -a [-m 'komunikat commita']- commit śledzonych
git commit --amend- cofnięcie ostatniej rewizji i jej ponowny    commit - opis + poczekalnia
git status- informacje o nieskomitowanych zmianach
git diff- co zmieniłeś, ale nie dodałeś do poczekalni
git diff --staged- co zmieniłeś w poczekalni w stosunku do    ostatniego commita
git checkout -- <plik>- rezygnuje z wszelkich zmian w pliku od jego    ostatniego commita

# Praca na poczekalni:
git add <plik>- dodawanie plików do śledzenia i jednocześnie    do przechowalni
git add .- dodaje wszystko
git rm <plik>- usuwa plik z katalogu i z repo (w poczekalni)
git rm -f <plik>- usuwa plik z katalogu i z repo (w poczekalni),    jeżeli został zmieniony
git rm –staged | --cached <plik>- usuwa plik tylko z poczekalni i przestaje go śledzić
git reset HEAD <plik>- usuwa plik tylko z poczekalni
git config --global alias.unstage 'reset HEAD –'- przykład: stworzenie globalnego aliasu
git mv <file_from> <file_to>- zmienia nazwę pliku

# Praca na lokalnych gałęziach:
git branch [-v]- wyświetla wszystkie gałęzie aktualnego repo
git branch --merged | --no-merged- filtr
git branch gałąź- rozgałęzienie - dodawanie gałęzi z bieżącej
git checkout gałąź- przełączanie się na gałąź + podmiana plików    roboczych
git checkout -b gałąź- rozgałęzienie i przełączenie się na nową gałąź
git merge gałąź- łączy podaną gałąź do bieżącej
git branch -d gałąź- usuwa głąź
git branch -D gałąź- naprawdę usuwa gałąź

# Przegląd logów:
git log- podstawowy przegląd logów
git log -p- pokazuje dodatkowo różnice w liniach plików
git config --global alias.last 'log -1 HEAD'- przykład: stworzenie globalnego aliasu
git log -numer- pokazuje tyle ostatnich rewizji
git log --since=od [--until=do]- pokazuje rewizje z przedziału czasowego
git log [--author=autor] [--committer=ktos] [--grep=w_notatkach] [--all-match]

# - szukanie w autorach, komitujących i/lub w opisach commitów
git log --stat- dodaje skrócone statystyki zmian
git log --pretty=oneline|short|full|fuller|format- formatowanie logu, opcje dla format:

# %H  - Suma kontrolna zmiany
# %h  - Skrócona suma kontrolna zmiany
# %T  - Suma kontrolna drzewa
# %t  - Skrócona suma kontrolna drzewa
# %P  - Sumy kontrolne rodziców
# %p  - Skrócone sumy kontrolne rodziców
# %an - Nazwisko autora
# %ae - Adres e-mail autora
# %ad - Data autora (format respektuje opcję -date=)
# %ar - Względna data autora
# %cn - Nazwisko zatwierdzającego zmiany
# %ce - Adres e-mail zatwierdzającego zmiany
# %cd - Data zatwierdzającego zmiany
# %cr - Data zatwierdzającego zmiany, względna
# %s  - Temat
git log [--pretty=opcja] --graph- formatowanie z graficzną reprezentacją gałęzi

# Praca zdalna:
git clone git://serwer/git.git [nazwa_katalogu]- klonuje zdalne repo do bieżącego katalogu,    tworzy katalog z nazwą repo
git clone ssh://user@serwer/git.git [nazwa_kat]- to samo, tylko, że przez ssh
git remote [-v]- pokazuje zdalne serwery bieżącego repo
git remote show nazwa_serwera- pokazuje informacje o podanym zdalnym    serwerze bieżącego repo
git remote add nazwa_serwera git://serwer/git.git- dodaje serwer zdalny do bieżacego repo
git remote rename nazwa_from nazwa_to- zmienia nazwę aliasu serwera zdalnego
git remote set-url nazwa_serwera ssh://nowy_url/repo.git- zmienia url, kryjący się pod    daną nazwą serwera
git remote rm|remove nazwa_serwera- usuwa z bieżącego repo zdalny serwer
git fetch nazwa_serwera - pobiera najnowsze inform. z podanego serwera
git checkout -b gałąź_lokalna nazwa_serwera/gałąź_zdalna- tworzy gałąź lokalną ze zdalnej
git checkout --track nazwa_serwera/gałąź_zdalna- to samo co wyżej
git push [nazwa_serwera [gałąź_lokalna[:gałąź_zdalna]]]- aktualizuje/dodaje podaną/bieżącą gałąź na podanym serwerze
git pull [nazwa_serwera [gałąź]]- pobiera informacje i aktualizuje    podaną/bieżącą gałąź
git merge nazwa_serwera/gałąź- łączy zdalną gałąź do bieżącej gałęzi lokalnej
git push nazwa_serwera :gałąź- usuwa zdalną gałąź
git branch -r- listuje zdalne gałęzie

# Tagowanie:
git tag- wyświetla wszystkie tagi
git tag -l 'wzór*'- filtr
git tag nazwa- dodaje lekki tag
git tag -a nazwa_tagu [-m 'krótki opis']- dodaje tag z ewentualnym opisem
git tag -s nazwa_tagu [-m 'krótki opis']- dodaje tag z ewentualnym opisem i go    podpisuje kluczem GPG
git tag -v nazwa_tagu - weryfikuje podpis GPG tagu
git show nazwa_tagu- wyświetla informacje o tagu wraz z rewizjami
git tag -a nazwa_tagu rewizja- taguje rewizję
git push nazwa_serwera --tags- wypycha wszystkie tagi na podany serwer

