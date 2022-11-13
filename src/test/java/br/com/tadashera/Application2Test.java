package br.com.tadashera;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Application2Test {

    @Test
    public void shouldGetName() {
        Application2 application = new Application2();
        assertEquals("br.com.tadashera.Application2", application.getName());
    }
}
