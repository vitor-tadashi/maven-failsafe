package com.br.tadashera.mavenfailsafe;

public class Application2 {
    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Exiting application 2");
        System.exit(0);
    }

    public String getName() {
        return this.getClass().getName();
    }
}
