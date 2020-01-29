package pt.ulusofona.lp2.fandeisiaGame;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestFandeisiaGameManager {
    @Test
    public void testGeral() throws InsufficientCoinsException {
        FandeisiaGameManager testeGeralFG = new FandeisiaGameManager();
        String anao = "id: 1, type: Anão, teamId: 10, x: 1, y: 1, orientation: Oeste";
        String gold = "id: 10, type: gold, x: 2, y: 2";
        String silver = "id: 11, type: silver, x: 5, y: 2";
        String bronze = "id: 12, type: bronze, x: 3, y: 2";
        String dragao = "id: 2, type: Dragão, teamId: 20, x: 3, y: 3, orientation: Norte";
        String buraco = "id: 6, type: hole, x: 2, y: 2";
        String[] conj = {anao, gold, dragao, buraco, silver, bronze};
        testeGeralFG.startGame(conj, 10, 10);
        testeGeralFG.setInitialTeam(10);
        int equipeEsperada = 10;
        assertEquals(equipeEsperada, testeGeralFG.equipeAtual.getIdEquipe());
        testeGeralFG.setInitialTeam(20);
        int equipeEsperada2 = 20;
        assertEquals(equipeEsperada2, testeGeralFG.equipeAtual.getIdEquipe());
        int tamanhoListaTesouro = testeGeralFG.listaTreasures.size();
        int esperado1 = 3;
        assertEquals(esperado1, tamanhoListaTesouro);
        int somaTesouro = testeGeralFG.somaPontosTesouros();
        int esperado = 6;
        assertEquals(esperado, somaTesouro);
        int test1 = testeGeralFG.listaCreatures.get(0).getIdEquipe();
        Team testReal = testeGeralFG.getTeam(test1);
        assertEquals(testeGeralFG.ldr, testReal);
        int rowsEsperado = 10;
        assertEquals(rowsEsperado, testeGeralFG.ROWS);
        int columnsEsperado = 10;
        assertEquals(columnsEsperado, testeGeralFG.COLUMNS);
        boolean result = testeGeralFG.enchant(0,0,"Congela");
        boolean enchantEsperado = false;
        assertEquals(enchantEsperado, result);
        String strEsperada = "Ederzito António Macedo Lopes";
        assertEquals(strEsperada, testeGeralFG.whoIsLordEder());
    }
}
