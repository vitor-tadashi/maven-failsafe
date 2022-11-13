package br.com.tadashera;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ApplicationTest {

    @Test
    public void shouldGetName() {
        Application application = new Application();
        assertEquals("br.com.tadashera.Application", application.getName());
    }
}
