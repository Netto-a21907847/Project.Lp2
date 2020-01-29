package pt.ulusofona.lp2.fandeisiaGame;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestEmpurraParaNorte {
    @Test
    public void testSpellEmpurraParaNorte() throws InsufficientCoinsException{
        FandeisiaGameManager testeEmpurraParaNorte = new FandeisiaGameManager();
        String humano = "id: 1, type: Humano, teamId: 10, x: 0, y: 1, orientation: Norte";
        String buraco = "id: 6, type: hole, x: 3, y: 3";
        String gigante = "id: 1, type: Gigante, teamId: 10, x: 5, y: 2, orientation: Norte";
        Spell s6 = new EmpurraParaNorte("EmpurraParaNorte");
        String[] conj = {humano, buraco, gigante};
        testeEmpurraParaNorte.startGame(conj, 7, 7);
        Creature c6 = testeEmpurraParaNorte.getCriaturaPorPosicao(0, 1);
        assert c6 != null;
        testeEmpurraParaNorte.equipeAtual = testeEmpurraParaNorte.ldr;
        int custoesperado = 1;
        assertEquals(custoesperado, s6.custoFeitico);
        c6.temSpell = true;
        boolean esperado = false;
        assertEquals(esperado, s6.aplicaFeitico(c6));
        c6.temSpell = false;
        testeEmpurraParaNorte.ldr.removerMoedas(48);
        assertEquals(esperado, s6.aplicaFeitico(c6));
        testeEmpurraParaNorte.ldr.adicionarMoedas(20);
        c6.estaCongelado = true;
        assertEquals(esperado, s6.aplicaFeitico(c6));
        c6.estaCongelado = false;
        boolean confereBuraco = testeEmpurraParaNorte.confereContemBuraco(c6.x, c6.y - 1);
        boolean confereCreature = testeEmpurraParaNorte.confereContemCreature(c6.x, c6.y - 1);
        boolean buracoEsperado =  false;
        boolean criaturaEsperado = false;
        assertEquals(buracoEsperado, confereBuraco);
        assertEquals(criaturaEsperado, confereCreature);
        esperado = true;
        assertEquals(esperado, s6.aplicaFeitico(c6));
        esperado = false;
        buracoEsperado = true;
        c6.x = 3;
        c6.y = 4;
        int yEsperado = 4;
        assertEquals(yEsperado, c6.getY());
        confereBuraco = testeEmpurraParaNorte.confereContemBuraco(c6.x , c6.y - 1);
        assertEquals(esperado, s6.aplicaFeitico(c6));
        assertEquals(buracoEsperado, confereBuraco);
        criaturaEsperado = true;
        c6.x = 5;
        c6.y = 3;
        yEsperado = 3;
        assertEquals(yEsperado, c6.getY());
        confereCreature = testeEmpurraParaNorte.confereContemCreature(c6.x , c6.y - 1);
        assertEquals(esperado, s6.aplicaFeitico(c6));
        assertEquals(criaturaEsperado, confereCreature);
    }
}
