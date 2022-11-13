package br.com.tadashera.outbound;

import br.com.tadashera.ApplicationContext;
import br.com.tadashera.agent.Agent;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

public class OutboundAgent implements Agent {

    private final Queue<String> information;
    private final AtomicInteger messagesReceived;

    private Thread outboundThread;
    private boolean running;

    private static final String STARTING_LOG = "Starting outbound agent";
    private static final String STOPPING_LOG = "Stopping outbound agent";

    public OutboundAgent(ApplicationContext applicationContext) {
        this.information = applicationContext.getInformation();
        this.messagesReceived = applicationContext.getMessagesReceived();
    }

    @Override
    public void start() {
        System.out.println(STARTING_LOG);

        this.running = true;

        this.outboundThread = new Thread(() -> {
            while (true) {
                try {
                    work();
                } catch (InterruptedException e) {
                    break;
                }
            }

            System.out.println(STOPPING_LOG);
        });

        this.outboundThread.start();
    }

    @Override
    public void stop() {
        this.running = false;

        if (this.outboundThread != null) {
            this.outboundThread.interrupt();

            try {
                this.outboundThread.join();
            } catch (InterruptedException ignored) {
            }
        }
    }

    @Override
    public void work() throws InterruptedException {
        if (!running) {
            throw new InterruptedException();
        }

        String info = this.information.poll();

        if (info == null || info.isEmpty()) {
           return;
        }

        this.messagesReceived.incrementAndGet();
        System.out.println(info);
    }

    @Override
    public boolean isRunning() {
        return this.running;
    }

    @Override
    public Thread getThread() {
        return this.outboundThread;
    }

    public void notTestedCode() {
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");

    }
}
