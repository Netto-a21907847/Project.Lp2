package pt.ulusofona.lp2.fandeisiaGame;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestProcessTurn {
    @Test
    public void teste3() throws InsufficientCoinsException {
        FandeisiaGameManager teste = new FandeisiaGameManager();
        String anao = "id: 1, type: Anão, teamId: 10, x: 1, y: 1, orientation: Oeste";
        String tesouro = "id: 6, type: gold, x: 1, y: 1";
        String[] conj = {anao, tesouro};
        teste.startGame(conj, 6, 6);
        teste.processTurn();
        List<Creature> criatura7 = teste.getCreatures();
        Creature criatura8 = criatura7.get(0);
        for (Creature creature : criatura7) {
            if (creature.getId() == 1) {
                criatura8 = creature;
            }
        }
        assertEquals("Anão", criatura8.getTipo());
    }

    @Test
    public void testeMoedasIniciais() throws InsufficientCoinsException {
        FandeisiaGameManager testeMoedasInit = new FandeisiaGameManager();
        String tesouro1 = "id: 6, type: gold, x: 5, y: 5";
        String anao2 = "id: 1, type: Anão, teamId: 10, x: 1, y: 1, orientation: Sul";
        String anao22 = "id: 1, type: Anão, teamId: 20, x: 9, y: 9, orientation: Sul";
        String[] conj1 = {tesouro1, anao2, anao22};
        testeMoedasInit.startGame(conj1, 10, 10);
        int esperado = 49;
        int real = testeMoedasInit.ldr.getMoedasEquipe();
        assertEquals(esperado, real);
        esperado = 49;
        real = testeMoedasInit.resistencia.getMoedasEquipe();
        assertEquals(esperado, real);
        testeMoedasInit.processTurn();
        esperado = 50;
        real = testeMoedasInit.ldr.getMoedasEquipe();
        assertEquals(esperado, real);
        esperado = 1;
        real = testeMoedasInit.nrTurnos;
        assertEquals(esperado, real);
        esperado = 1;
        real = testeMoedasInit.nrTurnosSemTesouros;
        assertEquals(esperado, real);
        esperado = 1;
        real = testeMoedasInit.listaTreasures.size();
        assertEquals(esperado, real);
        testeMoedasInit.listaTreasures.remove(testeMoedasInit.listaTreasures.get(0));
        esperado = 0;
        real = testeMoedasInit.listaTreasures.size();
        assertEquals(esperado, real);
        testeMoedasInit.processTurn();
        esperado = 51;
        real = testeMoedasInit.ldr.getMoedasEquipe();
        assertEquals(esperado, real);
        boolean esperado2 = true;
        boolean real2 = testeMoedasInit.gameIsOver();
        assertEquals(esperado2, real2);
        testeMoedasInit.processTurn();
        esperado = 3;
        real = testeMoedasInit.nrTurnosSemTesouros;
        assertEquals(esperado, real);
        testeMoedasInit.processTurn();
        testeMoedasInit.processTurn();
        testeMoedasInit.processTurn();
        testeMoedasInit.processTurn();
        testeMoedasInit.processTurn();
        testeMoedasInit.processTurn();
        testeMoedasInit.processTurn();
        testeMoedasInit.processTurn();
        testeMoedasInit.processTurn();
        testeMoedasInit.processTurn();
        testeMoedasInit.processTurn();
        List<String> teste = new ArrayList<>();
        testeMoedasInit.listaTreasures.add(new Treasure(5, "silver", 0, 0));
        assertEquals(teste, testeMoedasInit.getResults());
        testeMoedasInit.processTurn();
        esperado = 15;
        real = testeMoedasInit.nrTurnosSemTesouros;
        assertEquals(esperado, real);
        testeMoedasInit.listaTreasures.add(new Treasure(5, "silver", 0, 0));
        esperado2 = true;
        real2 = testeMoedasInit.gameIsOver();
        assertEquals(esperado2, real2);
        teste = testeMoedasInit.getResults();
        assertEquals(teste, testeMoedasInit.getResults());
        testeMoedasInit.ldr.adicionarPontos(10);
        teste = testeMoedasInit.getResults();
        assertEquals(teste, testeMoedasInit.getResults());
        testeMoedasInit.resistencia.adicionarPontos(20);
        teste = testeMoedasInit.getResults();
        assertEquals(teste, testeMoedasInit.getResults());
    }
}
