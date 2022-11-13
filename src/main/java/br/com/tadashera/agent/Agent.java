package br.com.tadashera.agent;

public interface Agent {
    void start();
    void stop();
    void work() throws InterruptedException;
    boolean isRunning();
    Thread getThread();
}
