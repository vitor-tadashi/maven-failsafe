package br.com.tadashera;

import br.com.tadashera.inbound.InboundAgent;
import br.com.tadashera.outbound.OutboundAgent;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Application {

    private static final String STARTING_LOG = "Starting multi thread application";
    private static InboundAgent inboundAgent;
    private static OutboundAgent outboundAgent;
    private static final ApplicationContext applicationContext = new ApplicationContext();

    public static void main(String[] args) throws InterruptedException {
        System.out.println(STARTING_LOG);

        try {
            inboundAgent = new InboundAgent(applicationContext);
            outboundAgent = new OutboundAgent(applicationContext);

            outboundAgent.start();
            inboundAgent.start();
        } finally {
            SECONDS.sleep(5);
            inboundAgent.stop();
            outboundAgent.stop();
        }
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }
}
