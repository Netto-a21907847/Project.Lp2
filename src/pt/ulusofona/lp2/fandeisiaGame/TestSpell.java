package pt.ulusofona.lp2.fandeisiaGame;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestSpell {
    @Test
    public void testeSpell() {
        Spell s1 = new ReduzAlcance("ReduzAlcance");
        String nomeEsperado = "ReduzAlcance";
        assertEquals(nomeEsperado, s1.getNomeFeitico());
        int custoEsperado = 2;
        int valorEsperado = s1.getCustoFeitico();
        assertEquals(custoEsperado, valorEsperado);
        assertEquals(custoEsperado, s1.custoFeitico);
        custoEsperado = 8;
        valorEsperado = s1.getIdFeitico();
        assertEquals(custoEsperado, valorEsperado);
    }
}
