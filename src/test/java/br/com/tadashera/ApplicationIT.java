package br.com.tadashera;

import org.junit.Test;

public class ApplicationIT {

    @Test
    public void shouldExit() throws InterruptedException {
        Application.main(null);
    }
}
