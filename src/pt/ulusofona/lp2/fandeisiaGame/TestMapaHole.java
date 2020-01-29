package pt.ulusofona.lp2.fandeisiaGame;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestMapaHole {
    @Test
    public void testMapa() {
        Mapa m1 = new Hole(1,0,0);
        int idEsperado = 1;
        assertEquals(idEsperado, m1.getId());
        int xEsperado = 0;
        assertEquals(xEsperado, m1.getX());
        int yEsperado = 0;
        assertEquals(yEsperado, m1.getY());
        int xEsperado1 = 10;
        m1.setX(10);
        assertEquals(xEsperado1, m1.getX());
        int yEsperado2 = 6;
        m1.setY(6);
        assertEquals(yEsperado2, m1.getY());
    }
}
