# Tworzenie archiwum
zip -r -v fs.zip /home/projects/fs/web

# Tworzenie archiwum z wykluczeniem określonego katalogu
zip -rv fs.zip /home/projects/fs/web -x '/home/projects/fs/web/Files/*'

# Tworzenie archiwum z wykluczeniem określonego katalogu i plików
alias zipcore='cd ~/repos; zip -r --exclude=*.git* --exclude=*Files* core.zip core; cd ~/repos/core'

# Tworzenie zaszyfrowanego archiwum
zip -r -v --encrypt "$FINANCES_DIR.zip" "$FINANCES_DIR"
