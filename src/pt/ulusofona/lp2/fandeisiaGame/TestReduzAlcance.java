package pt.ulusofona.lp2.fandeisiaGame;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestReduzAlcance {
    @Test
    public void testSpellReduzAlcance() throws InsufficientCoinsException {
        FandeisiaGameManager testeReduzAlcance = new FandeisiaGameManager();
        String humano = "id: 1, type: Humano, teamId: 10, x: 0, y: 1, orientation: Norte";
        Spell s4 = new ReduzAlcance("ReduzAlcance");
        String[] conj = {humano};
        testeReduzAlcance.startGame(conj, 7, 7);
        Creature c4 = testeReduzAlcance.getCriaturaPorPosicao(0, 1);
        assert c4 != null;
        testeReduzAlcance.equipeAtual = testeReduzAlcance.ldr;
        int custoesperado = 2;
        assertEquals(custoesperado, s4.custoFeitico);
        c4.temSpell = true;
        boolean esperado = false;
        assertEquals(esperado, s4.aplicaFeitico(c4));
        c4.temSpell = false;
        testeReduzAlcance.ldr.removerMoedas(48);
        assertEquals(esperado, s4.aplicaFeitico(c4));
        testeReduzAlcance.ldr.adicionarMoedas(20);
        c4.estaCongelado = true;
        assertEquals(esperado, s4.aplicaFeitico(c4));
        c4.estaCongelado = false;
        if (!c4.getTipo().equals("Anão")) {
            esperado = true;
            assertEquals(esperado, s4.aplicaFeitico(c4));
        }
    }
}
