package spring5kafkanotifier.listeners;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import static java.lang.String.format;

@Component
public class UserListener {

    @KafkaListener(topics = "UserEntity")
    public void onUser(String message) {
        System.out.println(format("Message: %s", message));
    }
}
