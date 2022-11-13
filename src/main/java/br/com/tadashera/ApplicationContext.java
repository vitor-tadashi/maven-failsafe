package br.com.tadashera;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class ApplicationContext {

    private final Queue<String> information;
    private final AtomicInteger messagesSent;
    private final AtomicInteger messagesReceived;

    public ApplicationContext() {
        this.information = new ConcurrentLinkedQueue<>();
        this.messagesSent = new AtomicInteger(0);
        this.messagesReceived = new AtomicInteger(0);
    }

    public Queue<String> getInformation() {
        return information;
    }

    public AtomicInteger getMessagesSent() {
        return messagesSent;
    }

    public AtomicInteger getMessagesReceived() {
        return messagesReceived;
    }
}
