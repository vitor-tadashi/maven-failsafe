package br.com.tadashera.outbound;

import br.com.tadashera.ApplicationContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OutboundAgentTest {

    private ApplicationContext applicationContext;
    private OutboundAgent agent;

    @Before
    public void start() {
        this.applicationContext = new ApplicationContext();
    }

    @After
    public void stop() {
        if (this.agent != null) {
            this.agent.stop();
        }
    }

    @Test
    public void start_agent() {
        this.agent = new OutboundAgent(this.applicationContext);
        this.agent.start();

        assertTrue(this.agent.isRunning());
        assertNotNull(this.agent.getThread());
    }

    @Test
    public void stop_agent() {
        this.agent = new OutboundAgent(this.applicationContext);
        this.agent.start();
        this.agent.stop();

        assertFalse(this.agent.isRunning());
    }

    @Test()
    public void throw_interrupted_exception() {
        this.agent = new OutboundAgent(this.applicationContext);

        assertThrows(InterruptedException.class, () -> {
            this.agent.work();
        });
    }
}
