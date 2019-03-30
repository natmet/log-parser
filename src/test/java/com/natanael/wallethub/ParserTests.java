package com.natanael.wallethub;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ParserTests {

    private Parser parser;

    @Before
    public void init() {
        parser = new Parser();
    }

    @Test
    public void testConvertirString() {
        String cadena = "2017-01-01 00:01:10.315|192.168.14.43|\"GET / HTTP/1.1\"|200|\"Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0)\"";
      // Donde se crea el objeto? 
        LineaArchivo lineaArchivo = parser.convertirString(cadena);
        assertEquals(LocalDateTime.of(2017, 1, 1, 0, 1, 10, 315000000), lineaArchivo.getFecha());
        assertEquals("192.168.14.43", lineaArchivo.getIp());
        assertEquals("GET / HTTP/1.1", lineaArchivo.getMetodoHttp());
        assertEquals(200, lineaArchivo.getCodigoEstatus());
        assertEquals("Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0)", lineaArchivo.getUserAgent());
    }

}
