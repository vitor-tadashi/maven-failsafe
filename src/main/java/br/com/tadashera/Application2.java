package br.com.tadashera;

public class Application2 {
    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Exiting application 2");
    }

    public String getName() {
        return this.getClass().getName();
    }
}
