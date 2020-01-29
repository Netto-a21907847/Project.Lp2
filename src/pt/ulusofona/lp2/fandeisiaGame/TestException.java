package pt.ulusofona.lp2.fandeisiaGame;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestException {
    @Test
    public void testException() {
        FandeisiaGameManager testException = new FandeisiaGameManager();
        String elfo = "id: 1, type: Elfo, teamId: 10, x: 0, y: 1, orientation: Norte";
        String dragao1 = "id: 2, type: Dragão, teamId: 20, x: 1, y: 5, orientation: Nordeste";
        String dragao2 = "id: 2, type: Dragão, teamId: 20, x: 2, y: 5, orientation: Nordeste";
        String dragao3 = "id: 2, type: Dragão, teamId: 20, x: 3, y: 5, orientation: Nordeste";
        String dragao4 = "id: 2, type: Dragão, teamId: 20, x: 4, y: 5, orientation: Nordeste";
        String dragao5 = "id: 2, type: Dragão, teamId: 20, x: 5, y: 5, orientation: Nordeste";
        String dragao6 = "id: 2, type: Dragão, teamId: 20, x: 6, y: 5, orientation: Nordeste";
        String[] conj = {elfo, dragao1, dragao2, dragao3, dragao4, dragao5, dragao6};
        int test = 0;
        try {
            testException.startGame(conj, 20, 20);
        } catch (InsufficientCoinsException e) {
            if (!e.teamRequiresMoreCoins(10) && e.teamRequiresMoreCoins(20)) {
                test = e.getRequiredCoinsForTeam(20);
            }
            assertEquals(54, test);
        }
    }

    @Test
    public void testException2() {
        FandeisiaGameManager testException2 = new FandeisiaGameManager();
        String elfo1 = "id: 1, type: Elfo, teamId: 10, x: 0, y: 1, orientation: Norte";
        String dragao7 = "id: 2, type: Dragão, teamId: 10, x: 1, y: 5, orientation: Nordeste";
        String dragao8 = "id: 2, type: Dragão, teamId: 10, x: 2, y: 5, orientation: Nordeste";
        String dragao9 = "id: 2, type: Dragão, teamId: 10, x: 3, y: 5, orientation: Nordeste";
        String dragao10 = "id: 2, type: Dragão, teamId: 10, x: 4, y: 5, orientation: Nordeste";
        String dragao11 = "id: 2, type: Dragão, teamId: 10, x: 5, y: 5, orientation: Nordeste";
        String dragao12 = "id: 2, type: Dragão, teamId: 10, x: 6, y: 5, orientation: Nordeste";
        String[] conj2 = {elfo1, dragao7, dragao8, dragao9, dragao10, dragao11, dragao12};
        int test = 0;
        try {
            testException2.startGame(conj2, 20, 20);
        } catch (InsufficientCoinsException e) {
            if (e.teamRequiresMoreCoins(10) && !e.teamRequiresMoreCoins(20)) {
                test = e.getRequiredCoinsForTeam(10);
            }
            assertEquals(59, test);
        }
    }

    @Test
    public void testException3() {
        FandeisiaGameManager testException3 = new FandeisiaGameManager();
        String d21 = "id: 2, type: Dragão, teamId: 20, x: 1, y: 5, orientation: Nordeste";
        String d22 = "id: 2, type: Dragão, teamId: 20, x: 2, y: 5, orientation: Nordeste";
        String d23 = "id: 2, type: Dragão, teamId: 20, x: 3, y: 5, orientation: Nordeste";
        String d24 = "id: 2, type: Dragão, teamId: 20, x: 4, y: 5, orientation: Nordeste";
        String d25 = "id: 2, type: Dragão, teamId: 20, x: 5, y: 5, orientation: Nordeste";
        String d26 = "id: 2, type: Dragão, teamId: 20, x: 6, y: 5, orientation: Nordeste";
        String d31 = "id: 2, type: Dragão, teamId: 10, x: 1, y: 6, orientation: Nordeste";
        String d32 = "id: 2, type: Dragão, teamId: 10, x: 2, y: 6, orientation: Nordeste";
        String d33 = "id: 2, type: Dragão, teamId: 10, x: 3, y: 6, orientation: Nordeste";
        String d34 = "id: 2, type: Dragão, teamId: 10, x: 4, y: 6, orientation: Nordeste";
        String d35 = "id: 2, type: Dragão, teamId: 10, x: 5, y: 6, orientation: Nordeste";
        String d36 = "id: 2, type: Dragão, teamId: 10, x: 6, y: 6, orientation: Nordeste";
        String[] conj3 = {d21, d22, d23, d24, d25, d26, d31, d32, d33, d34, d35, d36};
        int test = 0;
        int test2 = 1;
        try {
            testException3.startGame(conj3, 20, 20);
        } catch (InsufficientCoinsException e) {
            test2 = 0;
            if (e.teamRequiresMoreCoins(10) && e.teamRequiresMoreCoins(20)) {
                test = 3;
            }
            assertEquals(3, test);
            assertEquals(0, test2);
        }
    }
}
