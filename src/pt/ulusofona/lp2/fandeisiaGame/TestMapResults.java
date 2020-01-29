package pt.ulusofona.lp2.fandeisiaGame;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestMapResults {
    @Test
    public void testResults() throws InsufficientCoinsException {
        FandeisiaGameManager testResultsMap = new FandeisiaGameManager();
        String humano1 = "id: 1, type: Humano, teamId: 10, x: 0, y: 0, orientation: Sul";
        String humano2 = "id: 1, type: Humano, teamId: 10, x: 4, y: 4, orientation: Sul";
        String humano3 = "id: 1, type: Humano, teamId: 20, x: 5, y: 5, orientation: Sul";
        String gold = "id: 10, type: gold, x: 0, y: 2";
        String silver = "id: 11, type: silver, x: 1, y: 1";
        String bronze1 = "id: 12, type: bronze, x: 2, y: 1";
        String bronze2 = "id: 12, type: bronze, x: 2, y: 2";
        String anao1 = "id: 1, type: Anão, teamId: 10, x: 1, y: 0, orientation: Sul";
        String anao2 = "id: 1, type: Anão, teamId: 10, x: 2, y: 0, orientation: Sul";
        String anao3 = "id: 1, type: Anão, teamId: 10, x: 3, y: 0, orientation: Sul";
        String[] conj = {humano1, humano2, humano3, gold, silver, bronze1, bronze2, anao1, anao2, anao3};
        testResultsMap.startGame(conj, 10, 10);
        testResultsMap.enchant(4,4, "EmpurraParaOeste");
        testResultsMap.processTurn();
        testResultsMap.processTurn();
        testResultsMap.processTurn();
        testResultsMap.processTurn();
        testResultsMap.processTurn();
        testResultsMap.processTurn();
        testResultsMap.getStatistics();
        List<String> esperado = new ArrayList<>();
        esperado.add(1 + ":" + 2);
        esperado.add(1 + ":" + 1);
        esperado.add(1 + ":" + 1);
        System.out.println("os3MaisCarregados\n" + esperado);
        assertEquals(esperado, testResultsMap.getStatistics().get("as3MaisCarregadas"));
        esperado = new ArrayList<>();
        esperado.add(1 + ":" + 3 + ":" + 1);
        esperado.add(1 + ":" + 2 + ":" + 1);
        esperado.add(1 + ":" + 2 + ":" + 2);
        esperado.add(1 + ":" + 0 + ":" + 0);
        esperado.add(1 + ":" + 0 + ":" + 0);
        System.out.println("as5MaisRicas\n" + esperado);
        assertEquals(esperado, testResultsMap.getStatistics().get("as5MaisRicas"));
        esperado = new ArrayList<>();
        esperado.add(1 + ":" + 10 + ":" + 1);
        esperado.add(1 + ":" + 10 + ":" + 0);
        esperado.add(1 + ":" + 20 + ":" + 0);
        System.out.println("osAlvosFavoritos\n" + esperado);
        assertEquals(esperado, testResultsMap.getStatistics().get("osAlvosFavoritos"));
        esperado = new ArrayList<>();
        esperado.add(1 + ":" + 8);
        esperado.add(1 + ":" + 8);
        esperado.add(1 + ":" + 9);
        System.out.println("As3MaisViajadas\n" + esperado);
        assertEquals(esperado, testResultsMap.getStatistics().get("as3MaisViajadas"));
        esperado = new ArrayList<>();
        esperado.add("Anão" + ":" + 3 + ":" + 3);
        esperado.add("Humano" + ":" + 3 + ":" + 1);
        esperado.add("Dragão" + ":" + 0 + ":" + -1);
        esperado.add("Elfo" + ":" + 0 + ":" + -1);
        esperado.add("Gigante" + ":" + 0 + ":" + -1);
        System.out.println("tiposDeCriaturasESeusTesouros\n" + esperado);
        assertEquals(esperado, testResultsMap.getStatistics().get("tiposDeCriaturaESeusTesouros"));
    }
}
