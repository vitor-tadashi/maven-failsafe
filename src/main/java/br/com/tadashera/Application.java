package br.com.tadashera;

public class Application {
    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Exiting application");
    }

    public String getName() {
        return this.getClass().getName();
    }
}
