package pt.ulusofona.lp2.fandeisiaGame;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestEmpurraParaOeste {
    @Test
    public void testSpellEmpurraParaOeste() throws InsufficientCoinsException {
        FandeisiaGameManager testeEmpurraParaOeste = new FandeisiaGameManager();
        String humano = "id: 1, type: Humano, teamId: 10, x: 1, y: 1, orientation: Norte";
        String buraco = "id: 6, type: hole, x: 3, y: 3";
        String gigante = "id: 1, type: Gigante, teamId: 10, x: 5, y: 2, orientation: Norte";
        Spell s9 = new EmpurraParaOeste("EmpurraParaOeste");
        String[] conj = {humano, buraco, gigante};
        testeEmpurraParaOeste.startGame(conj, 7, 7);
        Creature c9 = testeEmpurraParaOeste.getCriaturaPorPosicao(1, 1);
        assert c9 != null;
        testeEmpurraParaOeste.equipeAtual = testeEmpurraParaOeste.ldr;
        int custoesperado = 1;
        assertEquals(custoesperado, s9.custoFeitico);
        c9.temSpell = true;
        boolean esperado = false;
        assertEquals(esperado, s9.aplicaFeitico(c9));
        c9.temSpell = false;
        testeEmpurraParaOeste.ldr.removerMoedas(48);
        assertEquals(esperado, s9.aplicaFeitico(c9));
        testeEmpurraParaOeste.ldr.adicionarMoedas(20);
        c9.estaCongelado = true;
        assertEquals(esperado, s9.aplicaFeitico(c9));
        c9.estaCongelado = false;
        boolean confereBuraco = testeEmpurraParaOeste.confereContemBuraco(c9.x - 1, c9.y);
        boolean confereCreature = testeEmpurraParaOeste.confereContemCreature(c9.x - 1, c9.y);
        boolean buracoEsperado = false;
        boolean criaturaEsperado = false;
        assertEquals(buracoEsperado, confereBuraco);
        assertEquals(criaturaEsperado, confereCreature);
        esperado = true;
        assertEquals(esperado, s9.aplicaFeitico(c9));
        esperado = false;
        buracoEsperado = true;
        c9.x = 4;
        c9.y = 3;
        confereBuraco = testeEmpurraParaOeste.confereContemBuraco(c9.x - 1, c9.y);
        assertEquals(esperado, s9.aplicaFeitico(c9));
        assertEquals(buracoEsperado, confereBuraco);
        criaturaEsperado = true;
        c9.x = 6;
        c9.y = 2;
        confereCreature = testeEmpurraParaOeste.confereContemCreature(c9.x - 1, c9.y);
        assertEquals(esperado, s9.aplicaFeitico(c9));
        assertEquals(criaturaEsperado, confereCreature);
    }
}
