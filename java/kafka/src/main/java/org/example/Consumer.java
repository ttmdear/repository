package org.example;

import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.errors.WakeupException;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

public class Consumer {

    public static void main(String[] args) {
        new Consumer().run();
    }

    public void run() {
        Properties properties = new Properties();

        properties.setProperty("bootstrap.servers", "localhost:9092");
        properties.setProperty("key.deserializer", StringDeserializer.class.getName());
        properties.setProperty("value.deserializer", StringDeserializer.class.getName());

        // properties.setProperty("auto.offset.reset", "none/earliest/latest");
        // none - ...
        // earliest - pobranie od ostatnio zatwiedzone offsetu
        // latest - pobranie najnowszych
        properties.setProperty("auto.offset.reset", "earliest");

        properties.setProperty("client.id", UUID.randomUUID().toString());
        properties.setProperty("group.id", "kafka");

        // Przy wyłączonej opcji enable.auto.commit musimy ręcznie wywołać consumer.commitSync() po przetworzeniu wiadomości
        // properties.setProperty("enable.auto.commit", "false");

        // Jeśli opcja jest ustawiona na true wtedy za pomocą parametru auto.commit.interval.ms ustawiamy czas po którym offset zostanie
        // zawierdzony
        // properties.setProperty("auto.commit.interval.ms", "5000");

        // Thread thread = Thread.currentThread();

        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties);
        consumer.subscribe(List.of("invoice"));

        Thread mainThread = Thread.currentThread();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            consumer.wakeup();

            try {
                mainThread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }));

        try {
            while (true) {
                // W moim przypadku ten czas musiał byś ustawony na 5 sekund. Przy mniejszym czasie z jakiegoś powodu konsument nie mógł
                // poprawnie nawiązać połączenia.
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(5000));

                if (!records.isEmpty()) {
                    AsciiTable table = new AsciiTable();
                    table.addRule();
                    table.addRow("topic", "partition", "key", "offset", "timestamp", "value");
                    table.addRule();

                    for (ConsumerRecord<String, String> record : records) {
                        table.addRow(record.topic(), record.partition(), record.key(), record.offset(), record.timestamp(), record.value());
                        // table.addRule();

                        table.setTextAlignment(TextAlignment.CENTER);
                    }

                    table.addRule();

                    System.out.println(table.render());
                }

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (WakeupException e) {
            // Metoda consumer.wakeup() powoduje, że metoda poll generuje wyjątek.
        } catch (Exception e) {

        } finally {
            consumer.close();
        }
    }
}