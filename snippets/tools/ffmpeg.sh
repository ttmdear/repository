ffmpeg -i filename.mp4 filename.mp3
ffmpeg -i video.mp4 -b:a 192K -vn music.mp3

# Konwertowanie plików na mp3 równolegle
find | parallel ffmpeg -i {0} output/{0}.mp3
