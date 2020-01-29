package pt.ulusofona.lp2.fandeisiaGame;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestCongela {
    @Test
    public void testSpellCongela() throws InsufficientCoinsException{
        FandeisiaGameManager testeCongela = new FandeisiaGameManager();
        String humano = "id: 1, type: Humano, teamId: 10, x: 0, y: 1, orientation: Norte";
        Spell s = new Congela("Congela");
        String[] conj = {humano};
        testeCongela.startGame(conj, 7, 7);
        Creature c = testeCongela.getCriaturaPorPosicao(0, 1);
        assert c != null;
        testeCongela.equipeAtual = testeCongela.ldr;
        int custoesperado = 3;
        assertEquals(custoesperado, s.custoFeitico);
        c.temSpell = true;
        boolean esperado = false;
        assertEquals(esperado, s.aplicaFeitico(c));
        c.temSpell = false;
        testeCongela.ldr.removerMoedas(48);
        assertEquals(esperado, s.aplicaFeitico(c));
        testeCongela.ldr.adicionarMoedas(10);
        c.estaCongelado = true;
        assertEquals(esperado, s.aplicaFeitico(c));
        c.estaCongelado = false;
        esperado = true;
        assertEquals(esperado, s.aplicaFeitico(c));
    }
}
