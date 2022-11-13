package br.com.tadashera;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.assertEquals;

public class ApplicationIT {

    @Test
    public void should_receive_all_messages() throws InterruptedException {
        Application.main(null);

        AtomicInteger messagesSent = Application.getApplicationContext().getMessagesSent();
        AtomicInteger messagesReceived = Application.getApplicationContext().getMessagesReceived();

        System.out.println("Messages sent: " + messagesSent.get());
        System.out.println("Messages received: " + messagesReceived.get());
        assertEquals(messagesSent.get(), messagesReceived.get());
    }
}
