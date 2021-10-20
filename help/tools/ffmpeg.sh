ffmpeg -i filename.mp4 filename.mp3
ffmpeg -i video.mp4 -b:a 192K -vn music.mp3

# Konwertowanie plików na mp3 równolegle
find | parallel ffmpeg -i {0} output/{0}.mp3

# Wycicinanie fragmentów z video.
ffmpeg -ss 00:00:00 -t 01:29:10 -i "Grażyna i Artek nagrania.mp4" -acodec copy -vcodec copy Grażyna\ i\ Artek\ nagrania\ PART.mp4
ffmpeg -i largefile.mp4 -t 00:50:00 -c copy smallfile1.mp4 -ss 00:50:00 -c copy smallfile2.mp4

# Podzielenie filmu na częsci
ffmpeg -ss 00:00:00 -t 02:00:00 -i "Studniówka 1992-01-25.mp4" -acodec copy -vcodec copy "Studniówka 1992-01-25 część 1.mp4"
ffmpeg -ss 02:00:00 -t 04:00:00 -i "Studniówka 1992-01-25.mp4" -acodec copy -vcodec copy "Studniówka 1992-01-25 część 2.mp4"

# Łączenie video
ffmpeg -f concat -safe 0 -i files.txt -c copy Grażyna\ i\ Artek\ studniówka.mp4
