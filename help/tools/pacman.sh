# Aktualizacja informacji o pakietach
pacman -Syy
pacman --sync -yy
pacman --sync -refresh

# Szukanie paczki w podanej nazwie
pacman --sync --list | grep go

# There is also option --search, but out put can contains a lot of other.
sudo pacman --sync --search go

# View informations about package
pacman --sync --info go

# Remove package and dependencies not required by other packages
pacman --remove --recursive

# Remove a package from the system.
pacman --remove go

# Lis of packages to upgrade
pacman --query --upgrades