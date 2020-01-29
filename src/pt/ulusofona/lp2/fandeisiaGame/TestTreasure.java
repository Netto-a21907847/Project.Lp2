package pt.ulusofona.lp2.fandeisiaGame;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestTreasure {
    @Test
    public void testTreasure() {
        Treasure t1 = new Treasure(1, "bronze", 0, 0);
        Treasure t2 = new Treasure(1, "silver", 0, 0);
        Treasure t3 = new Treasure(1, "gold", 0, 0);
        int pontosEsperado = 1;
        assertEquals(pontosEsperado, t1.getPontos());
        int pontosEsperado2 = 2;
        assertEquals(pontosEsperado2, t2.getPontos());
        int pontosEsperado3 = 3;
        assertEquals(pontosEsperado3, t3.getPontos());
    }
}
