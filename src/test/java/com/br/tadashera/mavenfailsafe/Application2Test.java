package com.br.tadashera.mavenfailsafe;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Application2Test {

    @Test
    public void shouldGetName() {
        Application2 application = new Application2();
        assertEquals("com.br.tadashera.mavenfailsafe.Application2", application.getName());
    }
}
