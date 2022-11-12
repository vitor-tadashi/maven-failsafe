package com.br.tadashera.mavenfailsafe;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ApplicationTest {

    @Test
    public void shouldGetName() {
        Application application = new Application();
        assertEquals("com.br.tadashera.mavenfailsafe.Application", application.getName());
    }
}
