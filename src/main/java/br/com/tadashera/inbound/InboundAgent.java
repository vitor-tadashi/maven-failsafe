package br.com.tadashera.inbound;

import br.com.tadashera.ApplicationContext;
import br.com.tadashera.agent.Agent;

import java.time.Instant;
import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class InboundAgent implements Agent {

    private final Queue<String> information;
    private final AtomicInteger messagesSent;

    private Thread inboundThread;
    private boolean running;
    private long enqueuedTimestamp;


    private static final long MESSAGE_INTERVAL_MS = 1000;
    private static final String STARTING_LOG = "Starting inbound agent";
    private static final String STOPPING_LOG = "Stopping inbound agent";

    public InboundAgent(ApplicationContext applicationContext) {
        this.information = applicationContext.getInformation();
        this.messagesSent = applicationContext.getMessagesSent();
    }

    @Override
    public void start() {
        System.out.println(STARTING_LOG);

        this.running = true;
        this.enqueuedTimestamp = Instant.now().toEpochMilli();

        this.inboundThread = new Thread(() -> {
            while (true) {
                try {
                    work();
                } catch (InterruptedException ex) {
                    break;
                }
            }

            System.out.println(STOPPING_LOG);
        });

        this.inboundThread.start();
    }

    @Override
    public void stop() {
        this.running = false;

        if (this.inboundThread != null) {
            this.inboundThread.interrupt();

            try {
                this.inboundThread.join();
            } catch (InterruptedException ignored) {
            }
        }
    }

    @Override
    public void work() throws InterruptedException {
        if (!running) {
            throw new InterruptedException();
        }

        long now = Instant.now().toEpochMilli();

        if ((now - this.enqueuedTimestamp) < MESSAGE_INTERVAL_MS) {
            return;
        }

        String info = UUID.randomUUID().toString();

        if (this.information.offer(info)) {
            this.enqueuedTimestamp = Instant.now().toEpochMilli();
            this.messagesSent.incrementAndGet();
        }
    }

    @Override
    public boolean isRunning() {
        return this.running;
    }

    public Thread getThread() {
        return this.inboundThread;
    }
}
