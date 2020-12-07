zip -r -v fs.zip /home/projects/fs/web

# z wykluczeniem określonego katalogu
zip -rv fs.zip /home/projects/fs/web -x '/home/projects/fs/web/Files/*'

# lub opcja długa
alias zipcore='cd ~/repos; zip -r --exclude=*.git* --exclude=*Files* core.zip core; cd ~/repos/core'

# tworzenie zaszyfrowanego archiwum
zip -r -v --encrypt "$FINANCES_DIR.zip" "$FINANCES_DIR"