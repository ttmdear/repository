# Jest to narzędzie głównie wykorzystywane do kopiowania całych partycji.
# Możemy kopiować jedną partycje na drugą lub partychę do obrazu a potem z
# obrazu dla partycje.

# Kopiowanie obrazu na parcyję
dd if=2020-08-20-raspios-buster-armhf-full.img of=/dev/mmcblk0p1

# Kopiowanie jednej partycji na drugą
dd if=/dev/sda of=/dev/sdb

# Kopiowanie partycji do obrazu
dd if=/dev/sda of=/home/username/sdadisk.img

# Kopiowanie obrazu na parcyje z ustaloną prędkością
dd if=/dev/sda2 of=/home/username/partition2.img bs=4096

# Kopiowanie i zapisanie w archiwum
ssh username@54.98.132.10 "dd if=/dev/sda | gzip -1 -" | dd of=backup.gz

# Usuwanie danych i wypełnienie ich losowymi wartościami
dd if=/dev/zero of=/dev/sda1
dd if=/dev/urandom of=/dev/sda1

# Obserwowanie postępów
dd if=/dev/urandom | pv | dd of=/dev/sda1
