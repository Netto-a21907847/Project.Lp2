package pt.ulusofona.lp2.fandeisiaGame;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestDuplicaAlcance {
    @Test
    public void testSpellDuplicaAlcance() throws InsufficientCoinsException {
        FandeisiaGameManager testeDuplicaAlcance = new FandeisiaGameManager();
        String humano = "id: 1, type: Humano, teamId: 10, x: 0, y: 1, orientation: Norte";
        Spell s3 = new DuplicaAlcance("DuplicaAlcance");
        String[] conj = {humano};
        testeDuplicaAlcance.startGame(conj, 7, 7);
        testeDuplicaAlcance.equipeAtual = testeDuplicaAlcance.ldr;
        Creature c3 = testeDuplicaAlcance.getCriaturaPorPosicao(0, 1);
        assert c3 != null;
        int custoesperado = 3;
        assertEquals(custoesperado, s3.custoFeitico);
        c3.temSpell = true;
        boolean esperado = false;
        assertEquals(esperado, s3.aplicaFeitico(c3));
        c3.temSpell = false;
        testeDuplicaAlcance.ldr.removerMoedas(48);
        assertEquals(esperado, s3.aplicaFeitico(c3));
        testeDuplicaAlcance.ldr.adicionarMoedas(20);
        c3.estaCongelado = true;
        assertEquals(esperado, s3.aplicaFeitico(c3));
        c3.estaCongelado = false;
        esperado = false;
        assertEquals(esperado, s3.aplicaFeitico(c3));
    }
}
