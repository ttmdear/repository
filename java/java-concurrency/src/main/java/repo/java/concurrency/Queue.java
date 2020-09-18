package repo.java.concurrency;

import java.util.Collection;
import java.util.List;
import java.util.Vector;

public class Queue {
    private List<String> messages = new Vector<>();

    public synchronized void addMessage(String message) {
        messages.add(message);

        notify();
    }

    public synchronized void addMessage(Collection<? extends String> messages) {
        this.messages.addAll(messages);

        notify();
    }

    public synchronized List<String> getMessages() {
        return messages;
    }
}
