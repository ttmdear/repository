# wifi
wifi-menu

# kabel
dhcpcd enp4s0

# Sprawdzam pingiem czy mam połączenie z internetem.

fdisk /dev/sda

# w trakcie konfiguracji pierwsza partycje ustawiam jako bootable czyli polecenie 'a' i partycja 1.
# druga partycje ustawiam jako swap, czyli opcja 't' i typ 82
# trzeba partycja to home

mkfs.ext4 /dev/sda1;
mkfs.ext4 /dev/sda3;

# montowanie katalogów
mount /dev/sda1 /mnt;
mkdir /mnt/home;
mount /dev/sda3 /mnt/home;

# instalacja systemu
pacstrap -i /mnt base;

# generowanie fstab
genfstab -U -p /mnt >> /mnt/etc/fstab;

# przepiecie sie do systemu
arch-chroot /mnt;

# instalacja podstawowych pakietów
pacman --sync grub-bios linux-headers linux-lts linux-lts-headers wpa_supplicant wireless_tools dialog;

# instalacja xorg xfce
pacman --sync xorg xorg-xinit xfce4;

# ustawienie strefy czasowej
ln -s /usr/share/zoneinfo/Poland /etc/localtime;

# ustawienie zegarka
hwclock --systohc;

# ustawienie locale
# odkomentowanie lini z językiem w /etc/locale.gen
locale-gen

# ustawiam locale na pl_PL, to polecenie ustawia w pliku /etc/locale.conf LANG=en_US.UTF-8
localectl set-locale pl_PL.utf8

# ustawiamy keymap, polecenie ustawia KEYMAP=pl w pliku /etc/vconsole.conf
localectl set-keymap pl

# ustawimy key layout
localectl set-x11-keymap pl

# ustawienie nazwy
echo "thinkpad" > /etc/hostname

# Ustawienie hasła
# passwd

# instalacja grupa
grub-install --target=i386-pc --recheck /dev/sda
grub-mkconfig -o /boot/grub/grub.cfg

# instalacja xorg xfce
pacman --sync xorg xorg-xinit xfce4;
pacman --sync zsh;

# create user
useradd --create-home --home-dir /home/ttmdear --gid users --shell /bin/zsh ttmdear;

sudo cp /etc/X11/xinit/xinitrc /home/ttmdear/.xinitrc;
echo "exec startxfce4" >> /home/guest/.xinitrc;

# mysql
# dbeaver - klient
pacman --sync mariadb dbeaver;
mysql_install_db --user=mysql --basedir=/usr --datadir=/var/lib/mysql;

# httpd, opis instalcji w set apache with php
pacman --sync apache php php-apache;

# instalacja pozostałych pakietów
pacman --sync libreoffice-fresh git rsync cherrytree  ttf-dejavu pulseaudio ttf-liberation zip unzip links sudo xbindkeys nodejs npm pavucontrol smplayer;

# odmontowanie
umount /mnt/home;
umount /mnt;

# uruchomienie ponowne
reboot
