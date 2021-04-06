package repo.spring5iocbeanfactory.services;

import java.util.UUID;

import org.springframework.context.annotation.Scope;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import repo.spring5iocbeanfactory.UserCreatedEvent;

@Service
public class NotificationService {
    private String id = UUID.randomUUID().toString();
    private String group;

    public String getId() {
        return id;
    }

    @EventListener
    public void onUserCreatedEvent(UserCreatedEvent event) {
        System.out.println(String.format("onUserCreatedEvent, group: %s, id:%s", group, id));
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
