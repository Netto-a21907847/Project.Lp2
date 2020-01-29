package pt.ulusofona.lp2.fandeisiaGame;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestDescongela {
    @Test
    public void testSpellDescongela() throws InsufficientCoinsException{
        FandeisiaGameManager testeDescongela = new FandeisiaGameManager();
        String humano = "id: 1, type: Humano, teamId: 10, x: 0, y: 1, orientation: Norte";
        Spell s2 = new Descongela("Descongela");
        String[] conj = {humano};
        testeDescongela.startGame(conj, 7, 7);
        Creature c2 = testeDescongela.getCriaturaPorPosicao(0, 1);
        assert c2 != null;
        testeDescongela.equipeAtual = testeDescongela.ldr;
        int custoesperado = 8;
        assertEquals(custoesperado, s2.custoFeitico);
        c2.temSpell = true;
        boolean esperado = false;
        assertEquals(esperado, s2.aplicaFeitico(c2));
        c2.temSpell = false;
        testeDescongela.ldr.removerMoedas(50);
        assertEquals(esperado, s2.aplicaFeitico(c2));
        testeDescongela.ldr.adicionarMoedas(20);
        c2.estaCongelado = false;
        boolean result = s2.aplicaFeitico(c2);
        assertEquals(esperado, result);
        c2.estaCongelado = true;
        esperado = true;
        result = s2.aplicaFeitico(c2);
        assertEquals(esperado, result);
    }
}
