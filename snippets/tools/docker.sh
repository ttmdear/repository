# Przekierowanie stdout kontenera na lokalny stdout.
docker attach c040177b9dd2

# Wyświetlenie informacji o kontenerze.
docker container inspect 87ddada0c35b
docker inspect   68aa46f7d2c0 | grep IP

# Wyświetlenie wszystkich kontenerów
docker container ls --all

# Usunięcie kontenerów o określonych ID
docker container rm d818546e9b8d c570c0f2d63d da3136fc674d

# Zatrzymanie kontenerów o określonych ID
docker container stop d818546e9b8d c570c0f2d63d da3136fc674d

# Uruchomienie polecenia na kontenerze
docker exec -it 68aa46f7d2c0 bash
docker exec -it some-mysql bash

# Wyświetlenie obrazów
docker image ls
docker image ls --all
docker images
docker images --all

# Usunięcie obrazów
docker image rm 14e14f585a31 14e14f585a31 883535b5b9b6 db2b37ec6181 db2b37ec6181

# Wyświetlenie informacji o konfiguracji sieci
docker network ls
docker network inspect 75dbf03519f0

# Wyświetlenie aktualnego stanu kontenerów
docker ps
docker ps --all

# Uruchomienie kontenera na postawie obrazu
docker run --name some-mysql -e MYSQL_ROOT_PASSWORD=123 -d mysql:8
docker run -it --network bridge --rm mysql mysql -hsome-mysql -uted -p
docker run -it --network some-network --rm mysql mysql -hsome-mysql -uted -p
docker run -it --rm mysql mysql -h localhost -usome-mysql-user -p
docker run -it --rm mysql mysql -hlocalhost -uexample-user -p
docker run -it --rm mysql mysql -hsome-mysql -uexample-user -p
docker run -it --rm mysql mysql -hsome.mysql.host -usome-mysql-user -p
docker run -it --rm mysql mysql -uexample-user -p
docker run -p 3306:3306 --name wb-db -e MYSQL_ROOT_PASSWORD=wbdb1234 -d wb-db

# Uruchomienie konkretnego kontenera
docker run wb-db

# Uruchomienie środowiska kontenerów
docker-compose.exe build
docker-compose.exe build --no-cache
docker-compose.exe stop
docker-compose.exe up
docker-compose.exe up --build
docker-compose.exe up --build --no-cahce
docker-compose.exe up --force-recreate
docker-compose.exe up --help
docker-compose.exe up -d
docker-compose.exe up -d --force-recreate
docker-compose up -d --build mo-noticegen
