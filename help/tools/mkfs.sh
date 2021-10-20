# Utworzenie systemu plików FAT z etykietą
mkfs.fat -n 'Handy' -v /dev/sdc1

# Lub
mkfs.vfat /dev/sdb1
mkfs.ext4 /dev/sdb1