
# Listowanie topików
kafka-topics.sh --zookeeper 172.18.0.2:2181 --list

# Tworzenie topików
kafka-topics.sh --create --zookeeper 172.18.0.2:2181 --replication-factor 1 --partitions 1 --topic UserEntity
kafka-topics.sh --create --zookeeper 172.18.0.2:2181 --replication-factor 1 --partitions 1 --topic mytopic

# Wyświetlanie zawartości strumieni
kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic UserEntity --from-beginning
kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic test --from-beginning --max-messages 10
kafka-console-consumer.sh --bootstrap-server BROKERS --topic TOPIC_NAME
kafka-console-consumer.sh --zookeeper zk01.example.com:2181 --topic t1

# Wysyłanie wiadomości do topiku
kafka-console-producer --broker-list kafka02.example.com:9092,kafka03.example.com:9092 --topic t1

