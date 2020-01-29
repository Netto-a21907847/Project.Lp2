package pt.ulusofona.lp2.fandeisiaGame;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestTeam {
    @Test
    public void testTeam() throws InsufficientCoinsException {
        FandeisiaGameManager testeTeam = new FandeisiaGameManager();
        String anao = "id: 1, type: Anão, teamId: 10, x: 0, y: 0, orientation: Norte";
        String gold = "id: 10, type: gold, x: 2, y: 2";
        String silver = "id: 11, type: silver, x: 3, y: 2";
        String bronze = "id: 12, type: bronze, x: 1, y: 2";
        String buraco = "id: 6, type: hole, x: 3, y: 3";
        String bronze2 = "id: 12, type: bronze, x: 4, y: 4";
        String dragao = "id: 2, type: Dragão, teamId: 20, x: 5, y: 5, orientation: Nordeste";
        String[] conj = {anao, gold, buraco, silver, bronze, bronze2, dragao};
        testeTeam.startGame(conj, 10,10);
        String nomeEsperado = "LDR";
        String result = testeTeam.ldr.getNomeEquipe();
        assertEquals(nomeEsperado, result);
        int valorEsperado = 10;
        int result2 = testeTeam.ldr.getIdEquipe();
        assertEquals(valorEsperado, result2);
        valorEsperado = 0;
        result2 = testeTeam.ldr.getPontosEquipe();
        assertEquals(valorEsperado, result2);
        valorEsperado = 49;
        result2 = testeTeam.ldr.getMoedasEquipe();
        assertEquals(valorEsperado, result2);
        valorEsperado = 15;
        testeTeam.ldr.adicionarPontos(15);
        result2 = testeTeam.ldr.getPontosEquipe();
        assertEquals(valorEsperado, result2);
        valorEsperado = 100;
        testeTeam.ldr.adicionarMoedas(51);
        result2 = testeTeam.ldr.getMoedasEquipe();
        assertEquals(valorEsperado, result2);
        valorEsperado = 90;
        testeTeam.ldr.removerMoedas(10);
        result2 = testeTeam.ldr.getMoedasEquipe();
        assertEquals(valorEsperado, result2);
        String strEsperada = "> ID: 10 | LDR | Pts: 15 | 90 <";
        String strOriginal = testeTeam.ldr.toString();
        assertEquals(strEsperada, strOriginal);
    }
}
