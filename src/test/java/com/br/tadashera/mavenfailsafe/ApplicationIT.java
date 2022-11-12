package com.br.tadashera.mavenfailsafe;

import org.junit.Test;

public class ApplicationIT {

    @Test
    public void shouldExit() throws InterruptedException {
        Application.main(null);
    }
}
