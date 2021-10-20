# Konkatenacja dwóch plików do jednego
ls -1 | parallel --max-args=2 cat {1} {2} ">" {1}_{2}.person

# Wykonanie równoległe polecenia echo
ls -1 | parallel --max-args=2 echo
ls -1 | parallel echo

# Uruchomienie konwertera dla wszystkich plików
find . -name "*jpeg" | parallel -I% --max-args 1 convert % %.png

# Konwertowanie plików na mp3 równolegle
find | parallel ffmpeg -i {0} output/{0}.mp3
ls -1 | parallel --max-args=2 ffmpeg -i {1} -i {2} -vcodec copy -acodec copy {1}.mkv

# Uruchomienie kilku poleceń równolegle
# $ cat jobs2run
# bzip2 oldstuff.tar
# oggenc music.flac
# opusenc ambiance.wav
# convert bigfile.tiff small.jpeg
# ffmepg -i foo.avi -v:b 12000k foo.mp4
# xsltproc --output build/tmp.fo style/dm.xsl src/tmp.xml
# bzip2 archive.tar

parallel --jobs 6 < jobs2run

# Wykonanie poleceń równolegle
echo "
ffmpeg -i file-1.flv file-1.mp3
ffmpeg -i file-2.flv file-2.mp3
echo Koniec" | parallel --jobs 3
