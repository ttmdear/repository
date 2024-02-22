package org.example;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.UUID;

public class Producer {

    public static void main(String[] args) {
        new Producer().run();
    }

    public void run() {
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", "localhost:9092");
        properties.setProperty("key.serializer", StringSerializer.class.getName());
        properties.setProperty("value.serializer", StringSerializer.class.getName());

        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);

        String topic = "invoice";
        String key = "2024";
        String value = "Lorem Ipsum %s.".formatted(UUID.randomUUID());

        ProducerRecord<String, String> record = new ProducerRecord<>(topic, key, value);

        producer.send(record, new Callback() {
            @Override
            public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                System.out.println(recordMetadata);
            }
        });

        producer.flush();
        producer.close();
    }
}