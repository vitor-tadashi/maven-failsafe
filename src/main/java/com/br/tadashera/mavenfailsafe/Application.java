package com.br.tadashera.mavenfailsafe;

public class Application {
    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Exiting application");
        //System.exit(0);
    }

    public String getName() {
        return this.getClass().getName();
    }
}
