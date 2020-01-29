package pt.ulusofona.lp2.fandeisiaGame;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestElfo {
    @Test
    public void TestElfoMove() throws InsufficientCoinsException {
        FandeisiaGameManager testeElfo = new FandeisiaGameManager();
        String elfo = "id: 1, type: Elfo, teamId: 10, x: 0, y: 1, orientation: Norte";
        String gold = "id: 10, type: gold, x: 2, y: 2";
        String silver = "id: 11, type: silver, x: 3, y: 2";
        String bronze = "id: 12, type: bronze, x: 1, y: 2";
        String buraco = "id: 6, type: hole, x: 3, y: 3";
        String bronze2 = "id: 12, type: bronze, x: 4, y: 4";
        String bronze3 = "id: 12, type: bronze, x: 5, y: 1";
        String bronze4 = "id: 12, type: bronze, x: 1, y: 4";
        String bronze5 = "id: 12, type: bronze, x: 0, y: 6";
        String bronze6 = "id: 12, type: bronze, x: 6, y: 6";
        String dragao = "id: 2, type: Dragão, teamId: 20, x: 4, y: 5, orientation: Nordeste";
        String[] conj = {elfo, gold, bronze5, bronze6, buraco, bronze3, bronze4, silver, bronze, bronze2, dragao};
        testeElfo.startGame(conj, 7, 7);
        Creature acriaturaTestada = testeElfo.getCriaturaPorPosicao(0, 1);
        assert acriaturaTestada != null;
        acriaturaTestada.estaCongelado = true;
        acriaturaTestada.moveCriatura();
        int xEsperado = 0;
        int pontosEsperado = 0;
        assertEquals(pontosEsperado, acriaturaTestada.getNrTesouros());
        assertEquals(xEsperado, acriaturaTestada.getX());
        acriaturaTestada.estaCongelado = false;
        acriaturaTestada.moveCriatura();
        assertEquals(xEsperado, acriaturaTestada.getX());
        acriaturaTestada.setOrientacao("Norte"); // Conferir Norte
        acriaturaTestada.setImagemCriatura("Norte");
        acriaturaTestada.x = 1;
        acriaturaTestada.y = 6;
        acriaturaTestada.moveCriatura();
        int yEsperado = 4;
        pontosEsperado = 1;
        assertEquals(pontosEsperado, acriaturaTestada.getNrTesouros());
        assertEquals(yEsperado, acriaturaTestada.getY());
        acriaturaTestada.setOrientacao("Norte");
        acriaturaTestada.setImagemCriatura("Norte");
        acriaturaTestada.x = 4;
        acriaturaTestada.y = 6;
        xEsperado = 4;
        acriaturaTestada.moveCriatura();
        assertEquals(xEsperado, acriaturaTestada.getX());
        acriaturaTestada.setOrientacao("Norte");
        acriaturaTestada.setImagemCriatura("Norte");
        acriaturaTestada.x = 3;
        acriaturaTestada.y = 5;
        xEsperado = 3;
        String oriEsperada = "Nordeste";
        String imgEsperada = "chapeleiro_ne.png";
        acriaturaTestada.moveCriatura();
        assertEquals(xEsperado, acriaturaTestada.getX());
        assertEquals(oriEsperada, acriaturaTestada.getOrientacao());
        assertEquals(imgEsperada, acriaturaTestada.getImagePNG());
        acriaturaTestada.setOrientacao("Sul"); // Conferir Sul
        acriaturaTestada.setImagemCriatura("Sul");
        acriaturaTestada.x = 0;
        acriaturaTestada.y = 6;
        xEsperado = 0;
        acriaturaTestada.moveCriatura();
        assertEquals(xEsperado, acriaturaTestada.getX());
        acriaturaTestada.setOrientacao("Sul");
        acriaturaTestada.setImagemCriatura("Sul");
        acriaturaTestada.x = 3;
        acriaturaTestada.y = 0;
        yEsperado = 2;
        acriaturaTestada.moveCriatura();
        assertEquals(yEsperado, acriaturaTestada.getY());
        acriaturaTestada.y = 1;
        yEsperado = 1;
        acriaturaTestada.moveCriatura();
        assertEquals(yEsperado, acriaturaTestada.getY());
        acriaturaTestada.setOrientacao("Sul");
        acriaturaTestada.setImagemCriatura("Sul");
        acriaturaTestada.x = 4;
        acriaturaTestada.y = 3;
        xEsperado = 4;
        acriaturaTestada.moveCriatura();
        assertEquals(xEsperado, acriaturaTestada.getX());
        acriaturaTestada.setOrientacao("Este"); // Conferir Este
        acriaturaTestada.setImagemCriatura("Este");
        acriaturaTestada.x = 3;
        acriaturaTestada.y = 5;
        xEsperado = 3;
        acriaturaTestada.moveCriatura();
        assertEquals(xEsperado, acriaturaTestada.getX());
        acriaturaTestada.setOrientacao("Este");
        acriaturaTestada.setImagemCriatura("Este");
        acriaturaTestada.x = 6;
        acriaturaTestada.y = 5;
        xEsperado = 6;
        acriaturaTestada.moveCriatura();
        assertEquals(xEsperado, acriaturaTestada.getX());
        acriaturaTestada.setOrientacao("Este");
        acriaturaTestada.setImagemCriatura("Este");
        acriaturaTestada.x = 1;
        acriaturaTestada.y = 3;
        xEsperado = 1;
        acriaturaTestada.moveCriatura();
        assertEquals(xEsperado, acriaturaTestada.getX());
        acriaturaTestada.setOrientacao("Este");
        acriaturaTestada.setImagemCriatura("Este");
        acriaturaTestada.x = 0;
        acriaturaTestada.y = 2;
        xEsperado = 2;
        acriaturaTestada.moveCriatura();
        assertEquals(xEsperado, acriaturaTestada.getX());
        acriaturaTestada.setOrientacao("Este");
        acriaturaTestada.setImagemCriatura("Este");
        acriaturaTestada.x = 2;
        acriaturaTestada.y = 3;
        xEsperado = 4;
        acriaturaTestada.moveCriatura();
        assertEquals(xEsperado, acriaturaTestada.getX());
        acriaturaTestada.setOrientacao("Oeste"); // Conferir Oeste
        acriaturaTestada.setImagemCriatura("Oeste");
        acriaturaTestada.x = 6;
        acriaturaTestada.y = 4;
        xEsperado = 4;
        acriaturaTestada.moveCriatura();
        assertEquals(xEsperado, acriaturaTestada.getX());
        acriaturaTestada.x = 6;
        acriaturaTestada.y = 5;
        xEsperado = 6;
        acriaturaTestada.moveCriatura();
        assertEquals(xEsperado, acriaturaTestada.getX());
        acriaturaTestada.setOrientacao("Oeste");
        acriaturaTestada.setImagemCriatura("Oeste");
        acriaturaTestada.x = 1;
        acriaturaTestada.y = 4;
        xEsperado = 1;
        acriaturaTestada.moveCriatura();
        assertEquals(xEsperado, acriaturaTestada.getX());
        acriaturaTestada.setOrientacao("Oeste");
        acriaturaTestada.setImagemCriatura("Oeste");
        acriaturaTestada.x = 5;
        acriaturaTestada.y = 3;
        xEsperado = 5;
        acriaturaTestada.moveCriatura();
        assertEquals(xEsperado, acriaturaTestada.getX());
        acriaturaTestada.setOrientacao("Nordeste"); // conferir nordeste
        acriaturaTestada.setImagemCriatura("Nordeste");
        acriaturaTestada.x = 0;
        acriaturaTestada.y = 3;
        xEsperado = 2;
        acriaturaTestada.moveCriatura();
        assertEquals(xEsperado, acriaturaTestada.getX());
        acriaturaTestada.x = 1;
        acriaturaTestada.y = 5;
        xEsperado = 1;
        acriaturaTestada.moveCriatura();
        assertEquals(xEsperado, acriaturaTestada.getX());
        acriaturaTestada.setOrientacao("Nordeste");
        acriaturaTestada.setImagemCriatura("Nordeste");
        acriaturaTestada.x = 3;
        acriaturaTestada.y = 6;
        xEsperado = 3;
        acriaturaTestada.moveCriatura();
        assertEquals(xEsperado, acriaturaTestada.getX());
        acriaturaTestada.setOrientacao("Nordeste");
        acriaturaTestada.setImagemCriatura("Nordeste");
        acriaturaTestada.x = 6;
        acriaturaTestada.y = 3;
        xEsperado = 6;
        acriaturaTestada.moveCriatura();
        assertEquals(xEsperado, acriaturaTestada.getX());
        acriaturaTestada.setOrientacao("Noroeste"); // conferir Noroeste
        acriaturaTestada.setImagemCriatura("Noroeste");
        acriaturaTestada.x = 3;
        acriaturaTestada.y = 4;
        xEsperado = 1;
        acriaturaTestada.moveCriatura();
        assertEquals(xEsperado, acriaturaTestada.getX());
        acriaturaTestada.x = 5;
        acriaturaTestada.y = 5;
        xEsperado = 5;
        acriaturaTestada.moveCriatura();
        assertEquals(xEsperado, acriaturaTestada.getX());
        acriaturaTestada.setOrientacao("Noroeste");
        acriaturaTestada.setImagemCriatura("Noroeste");
        acriaturaTestada.x = 5;
        acriaturaTestada.y = 6;
        xEsperado = 5;
        acriaturaTestada.moveCriatura();
        assertEquals(xEsperado, acriaturaTestada.getX());
        acriaturaTestada.setOrientacao("Noroeste");
        acriaturaTestada.setImagemCriatura("Noroeste");
        acriaturaTestada.x = 0;
        acriaturaTestada.y = 3;
        xEsperado = 0;
        acriaturaTestada.moveCriatura();
        assertEquals(xEsperado, acriaturaTestada.getX());
        acriaturaTestada.setOrientacao("Sudeste"); // conferir Sudeste
        acriaturaTestada.setImagemCriatura("Sudeste");
        acriaturaTestada.x = 4;
        acriaturaTestada.y = 4;
        xEsperado = 6;
        acriaturaTestada.moveCriatura();
        assertEquals(xEsperado, acriaturaTestada.getX());
        acriaturaTestada.x = 1;
        acriaturaTestada.y = 1;
        xEsperado = 1;
        acriaturaTestada.moveCriatura();
        assertEquals(xEsperado, acriaturaTestada.getX());
        acriaturaTestada.setOrientacao("Sudeste");
        acriaturaTestada.setImagemCriatura("Sudeste");
        acriaturaTestada.x = 3;
        acriaturaTestada.y = 4;
        xEsperado = 3;
        acriaturaTestada.moveCriatura();
        assertEquals(xEsperado, acriaturaTestada.getX());
        acriaturaTestada.setOrientacao("Sudeste");
        acriaturaTestada.setImagemCriatura("Sudeste");
        acriaturaTestada.x = 6;
        acriaturaTestada.y = 3;
        xEsperado = 6;
        acriaturaTestada.moveCriatura();
        assertEquals(xEsperado, acriaturaTestada.getX());
        acriaturaTestada.setOrientacao("Sudoeste"); // conferir Sudoeste
        acriaturaTestada.setImagemCriatura("Sudoeste");
        acriaturaTestada.x = 2;
        acriaturaTestada.y = 4;
        xEsperado = 0;
        acriaturaTestada.moveCriatura();
        assertEquals(xEsperado, acriaturaTestada.getX());
        acriaturaTestada.x = 5;
        acriaturaTestada.y = 1;
        xEsperado = 5;
        acriaturaTestada.moveCriatura();
        assertEquals(xEsperado, acriaturaTestada.getX());
        acriaturaTestada.setOrientacao("Sudoeste");
        acriaturaTestada.setImagemCriatura("Sudoeste");
        acriaturaTestada.x = 5;
        acriaturaTestada.y = 4;
        xEsperado = 5;
        acriaturaTestada.moveCriatura();
        assertEquals(xEsperado, acriaturaTestada.getX());
        acriaturaTestada.setOrientacao("Sudoeste");
        acriaturaTestada.setImagemCriatura("Sudoeste");
        acriaturaTestada.x = 0;
        acriaturaTestada.y = 3;
        xEsperado = 0;
        acriaturaTestada.moveCriatura();
        assertEquals(xEsperado, acriaturaTestada.getX());
    }

    @Test
    public void testElfo2() throws InsufficientCoinsException {
        FandeisiaGameManager testeElfo2 = new FandeisiaGameManager();
        String elfo1 = "id: 1, type: Elfo, teamId: 10, x: 2, y: 0, orientation: Sudoeste";
        String elfo2 = "id: 2, type: Elfo, teamId: 10, x: 9, y: 0, orientation: Sudeste";
        String elfo3 = "id: 3, type: Elfo, teamId: 20, x: 9, y: 9, orientation: Nordeste";
        String elfo4 = "id: 4, type: Elfo, teamId: 20, x: 2, y: 9, orientation: Noroeste";
        String[] conj22 = {elfo1, elfo2, elfo3, elfo4};
        testeElfo2.startGame(conj22, 10, 13);
        Creature e1 = testeElfo2.getCriaturaPorPosicao(2, 0);
        Creature e2 = testeElfo2.getCriaturaPorPosicao(9, 0);
        Creature e3 = testeElfo2.getCriaturaPorPosicao(9, 9);
        Creature e4 = testeElfo2.getCriaturaPorPosicao(2, 9);
        testeElfo2.equipeAtual = testeElfo2.ldr;
        testeElfo2.processTurn();
        assertEquals("Sudoeste", e1.getOrientacao());

        assertEquals(0, e1.getX());

        assertEquals(2, e1.getY());

        assertEquals("Sudeste", e2.getOrientacao());

        assertEquals(11, e2.getX());

        assertEquals(2, e2.getY());

        assertEquals("Nordeste", e3.getOrientacao());

        assertEquals(11, e3.getX());

        assertEquals(7, e3.getY());

        assertEquals("Noroeste", e4.getOrientacao());

        assertEquals(0, e4.getX());

        assertEquals(7, e4.getY());

    }
}
