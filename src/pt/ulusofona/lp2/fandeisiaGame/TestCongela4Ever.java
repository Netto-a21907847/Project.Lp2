package pt.ulusofona.lp2.fandeisiaGame;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestCongela4Ever {
    @Test
    public void testSpellCongela4Ever() throws InsufficientCoinsException{
        FandeisiaGameManager testeCongela4Ever = new FandeisiaGameManager();
        String humano = "id: 1, type: Humano, teamId: 10, x: 0, y: 1, orientation: Norte";
        Spell s1 = new Congela4Ever("Congela4Ever");
        String[] conj = {humano};
        testeCongela4Ever.startGame(conj, 7, 7);
        Creature c1 = testeCongela4Ever.getCriaturaPorPosicao(0, 1);
        assert c1 != null;
        testeCongela4Ever.equipeAtual = testeCongela4Ever.ldr;
        int custoesperado = 10;
        assertEquals(custoesperado, s1.custoFeitico);
        c1.temSpell = true;
        boolean esperado = false;
        assertEquals(esperado, s1.aplicaFeitico(c1));
        c1.temSpell = false;
        testeCongela4Ever.ldr.removerMoedas(48);
        assertEquals(esperado, s1.aplicaFeitico(c1));
        testeCongela4Ever.ldr.adicionarMoedas(20);
        c1.estaCongelado = true;
        assertEquals(esperado, s1.aplicaFeitico(c1));
        c1.estaCongelado = false;
        esperado = true;
        assertEquals(esperado, s1.aplicaFeitico(c1));
    }
}
