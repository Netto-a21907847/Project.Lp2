package pt.ulusofona.lp2.fandeisiaGame;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestEmpurraParaSul {
    @Test
    public void testSpellEmpurraParaSul() throws InsufficientCoinsException{
        FandeisiaGameManager testeEmpurraParaSul = new FandeisiaGameManager();
        String humano = "id: 1, type: Humano, teamId: 10, x: 0, y: 1, orientation: Norte";
        String buraco = "id: 6, type: hole, x: 3, y: 3";
        String gigante = "id: 1, type: Gigante, teamId: 10, x: 5, y: 2, orientation: Norte";
        Spell s7 = new EmpurraParaSul("EmpurraParaSul");
        String[] conj = {humano, buraco, gigante};
        testeEmpurraParaSul.startGame(conj, 7, 7);
        Creature c7 = testeEmpurraParaSul.getCriaturaPorPosicao(0, 1);
        assert c7 != null;
        testeEmpurraParaSul.equipeAtual = testeEmpurraParaSul.ldr;
        int custoesperado = 1;
        assertEquals(custoesperado, s7.custoFeitico);
        c7.temSpell = true;
        boolean esperado = false;
        assertEquals(esperado, s7.aplicaFeitico(c7));
        c7.temSpell = false;
        testeEmpurraParaSul.ldr.removerMoedas(48);
        assertEquals(esperado, s7.aplicaFeitico(c7));
        testeEmpurraParaSul.ldr.adicionarMoedas(20);
        c7.estaCongelado = true;
        assertEquals(esperado, s7.aplicaFeitico(c7));
        c7.estaCongelado = false;
        boolean confereBuraco = testeEmpurraParaSul.confereContemBuraco(c7.x, c7.y + 1);
        boolean confereCreature = testeEmpurraParaSul.confereContemCreature(c7.x, c7.y + 1);
        boolean buracoEsperado =  false;
        boolean criaturaEsperado = false;
        assertEquals(buracoEsperado, confereBuraco);
        assertEquals(criaturaEsperado, confereCreature);
        esperado = true;
        assertEquals(esperado, s7.aplicaFeitico(c7));
        esperado = false;
        buracoEsperado = true;
        c7.x = 3;
        c7.y = 2;
        int yEsperado = 2;
        assertEquals(yEsperado, c7.getY());
        confereBuraco = testeEmpurraParaSul.confereContemBuraco(c7.x , c7.y + 1);
        assertEquals(esperado, s7.aplicaFeitico(c7));
        assertEquals(buracoEsperado, confereBuraco);
        criaturaEsperado = true;
        c7.x = 5;
        c7.y = 1;
        yEsperado = 1;
        assertEquals(yEsperado, c7.getY());
        confereCreature = testeEmpurraParaSul.confereContemCreature(c7.x , c7.y + 1);
        assertEquals(esperado, s7.aplicaFeitico(c7));
        assertEquals(criaturaEsperado, confereCreature);
    }
}
