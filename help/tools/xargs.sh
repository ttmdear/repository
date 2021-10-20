seq 1 10 | xargs -n2 bash -c 'touch $1_$0.txt'
echo -e "file1 - file2\nfile3 - file4" | xargs.exe -n1 echo

# Zdefiniowanie placeholdera
grep -rl printedDocuments Models/ | xargs.exe -p -I {v} -n1 echo -e {v}

# Otworzenie gvima
grep -rl printedDocuments Models/ | xargs.exe -n2 gvim -o1

# Usunięcie plików
find /path -type f -print0 | xargs -0 rm

# Konwerowanie na mp3
find | parallel ffmpeg -i {0} output/{0}.mp3
