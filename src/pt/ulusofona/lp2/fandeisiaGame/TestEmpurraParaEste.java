package pt.ulusofona.lp2.fandeisiaGame;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestEmpurraParaEste {
    @Test
    public void testSpellEmpurraParaEste() throws InsufficientCoinsException {
        FandeisiaGameManager testeEmpurraParaEste = new FandeisiaGameManager();
        String humano = "id: 1, type: Humano, teamId: 10, x: 0, y: 1, orientation: Norte";
        String buraco = "id: 6, type: hole, x: 3, y: 3";
        String gigante = "id: 1, type: Gigante, teamId: 10, x: 5, y: 2, orientation: Norte";
        Spell s5 = new EmpurraParaEste("EmpurraParaEste");
        String[] conj = {humano, buraco, gigante};
        testeEmpurraParaEste.startGame(conj, 7, 7);
        Creature c5 = testeEmpurraParaEste.getCriaturaPorPosicao(0, 1);
        assert c5 != null;
        testeEmpurraParaEste.equipeAtual = testeEmpurraParaEste.ldr;
        int custoesperado = 1;
        assertEquals(custoesperado, s5.custoFeitico);
        c5.temSpell = true;
        boolean esperado = false;
        assertEquals(esperado, s5.aplicaFeitico(c5));
        c5.temSpell = false;
        testeEmpurraParaEste.ldr.removerMoedas(48);
        assertEquals(esperado, s5.aplicaFeitico(c5));
        testeEmpurraParaEste.ldr.adicionarMoedas(20);
        c5.estaCongelado = true;
        assertEquals(esperado, s5.aplicaFeitico(c5));
        c5.estaCongelado = false;
        boolean confereBuraco = testeEmpurraParaEste.confereContemBuraco(c5.x + 1, c5.y);
        boolean confereCreature = testeEmpurraParaEste.confereContemCreature(c5.x + 1, c5.y);
        boolean buracoEsperado = false;
        boolean criaturaEsperado = false;
        assertEquals(buracoEsperado, confereBuraco);
        assertEquals(criaturaEsperado, confereCreature);
        esperado = true;
        assertEquals(esperado, s5.aplicaFeitico(c5));
        esperado = false;
        buracoEsperado = true;
        c5.x = 2;
        c5.y = 3;
        confereBuraco = testeEmpurraParaEste.confereContemBuraco(c5.x + 1, c5.y);
        assertEquals(esperado, s5.aplicaFeitico(c5));
        assertEquals(buracoEsperado, confereBuraco);
        criaturaEsperado = true;
        c5.x = 4;
        c5.y = 2;
        confereCreature = testeEmpurraParaEste.confereContemCreature(c5.x + 1, c5.y);
        assertEquals(esperado, s5.aplicaFeitico(c5));
        assertEquals(criaturaEsperado, confereCreature);
    }
}
