package pt.ulusofona.lp2.fandeisiaGame;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestStartGame {
    @Test
    public void testMethodStartGame() throws InsufficientCoinsException {
        FandeisiaGameManager testeStartGame = new FandeisiaGameManager();
        String anao = "id: 1, type: Anão, teamId: 10, x: 0, y: 0, orientation: Norte";
        String gold = "id: 10, type: gold, x: 2, y: 2";
        String silver = "id: 11, type: silver, x: 3, y: 2";
        String bronze = "id: 12, type: bronze, x: 1, y: 2";
        String buraco = "id: 6, type: hole, x: 3, y: 3";
        String bronze2 = "id: 12, type: bronze, x: 4, y: 4";
        String dragao = "id: 2, type: Dragão, teamId: 20, x: 5, y: 5, orientation: Nordeste";
        String[] conj = {anao, gold, buraco, silver, bronze, bronze2, dragao};
        testeStartGame.startGame(conj, 10, 10); // satartGame 1
        int valorEsperado = 0;
        int result = testeStartGame.nrTurnosSemTesouros;
        assertEquals(valorEsperado, result);
        valorEsperado = 0;
        result = testeStartGame.nrTurnos;
        assertEquals(valorEsperado, result);
        valorEsperado = 0;
        result = testeStartGame.ldr.getPontosEquipe();
        assertEquals(valorEsperado, result);
        valorEsperado = 49;
        result = testeStartGame.ldr.getMoedasEquipe();
        assertEquals(valorEsperado, result);
        valorEsperado = 0;
        result = testeStartGame.resistencia.getPontosEquipe();
        assertEquals(valorEsperado, result);
        valorEsperado = 41;
        result = testeStartGame.resistencia.getMoedasEquipe();
        assertEquals(valorEsperado, result);
        valorEsperado = 2;
        result = testeStartGame.listaCreatures.size();
        assertEquals(valorEsperado, result);
        valorEsperado = 4;
        result = testeStartGame.listaTreasures.size();
        assertEquals(valorEsperado, result);
        valorEsperado = 1;
        result = testeStartGame.listaHoles.size();
        assertEquals(valorEsperado, result);
        valorEsperado = 9;
        result = testeStartGame.listaSpells.size();
        assertEquals(valorEsperado, result);
        valorEsperado = 10;
        result = testeStartGame.ROWS;
        assertEquals(valorEsperado, result);
        valorEsperado = 10;
        result = testeStartGame.COLUMNS;
        assertEquals(valorEsperado, result);
        String anao2 = "id: 1, type: Joao, teamId: 10, x: 0, y: 0, orientation: Norte";
        String gold2 = "id: 10, type: gold, x: 2, y: 2";
        String silver2 = "id: 11, type: silver, x: 3, y: 2";
        String bronze222 = "id: 12, type: bronze, x: 1, y: 2";
        String buraco2 = "id: 6, type: hole, x: 3, y: 3";
        String bronze22 = "id: 12, type: bronze, x: 4, y: 4";
        String dragao222 = "id: 2, type: Dragão, teamId: 20, x: 5, y: 5, orientation: Nordeste";
        String dragao2223 = "id: 2, type: Dragão, teamId: 20, x: 5, y: 5, orientation: Nordeste";
        String[] conj111 = {anao2, dragao2223, gold2, buraco2, silver2, bronze222, bronze22, dragao222};
        testeStartGame.startGame(conj111, 10, 10); // startGame 2
        valorEsperado = 0;
        result = testeStartGame.nrTurnosSemTesouros;
        assertEquals(valorEsperado, result);
        valorEsperado = 0;
        result = testeStartGame.nrTurnos;
        assertEquals(valorEsperado, result);
        valorEsperado = 0;
        result = testeStartGame.ldr.getPontosEquipe();
        assertEquals(valorEsperado, result);
        valorEsperado = 50;
        result = testeStartGame.ldr.getMoedasEquipe();
        assertEquals(valorEsperado, result);
        valorEsperado = 0;
        result = testeStartGame.resistencia.getPontosEquipe();
        assertEquals(valorEsperado, result);
        valorEsperado = 32;
        result = testeStartGame.resistencia.getMoedasEquipe();
        assertEquals(valorEsperado, result);
        valorEsperado = 2;
        result = testeStartGame.listaCreatures.size();
        assertEquals(valorEsperado, result);
        valorEsperado = 4;
        result = testeStartGame.listaTreasures.size();
        assertEquals(valorEsperado, result);
        valorEsperado = 1;
        result = testeStartGame.listaHoles.size();
        assertEquals(valorEsperado, result);
        valorEsperado = 9;
        result = testeStartGame.listaSpells.size();
        assertEquals(valorEsperado, result);
        valorEsperado = 10;
        result = testeStartGame.ROWS;
        assertEquals(valorEsperado, result);
        valorEsperado = 10;
        result = testeStartGame.COLUMNS;
        assertEquals(valorEsperado, result);
    }
}
