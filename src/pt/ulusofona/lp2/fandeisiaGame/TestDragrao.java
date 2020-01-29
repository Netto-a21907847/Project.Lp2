package pt.ulusofona.lp2.fandeisiaGame;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestDragrao {
    @Test
    public void TestDragaoMove() throws InsufficientCoinsException {
        FandeisiaGameManager testeDragao = new FandeisiaGameManager();
        String elfo = "id: 1, type: Elfo, teamId: 10, x: 4, y: 3, orientation: Norte";
        String gold = "id: 10, type: gold, x: 2, y: 2";
        String silver = "id: 11, type: silver, x: 3, y: 2";
        String bronze = "id: 12, type: bronze, x: 1, y: 2";
        String buraco = "id: 6, type: hole, x: 3, y: 3";
        String bronze2 = "id: 12, type: bronze, x: 4, y: 4";
        String bronze3 = "id: 12, type: bronze, x: 5, y: 1";
        String bronze4 = "id: 12, type: bronze, x: 1, y: 4";
        String bronze5 = "id: 12, type: bronze, x: 0, y: 6";
        String bronze6 = "id: 12, type: bronze, x: 6, y: 6";
        String dragao = "id: 2, type: Dragão, teamId: 20, x: 2, y: 0, orientation: Norte";
        String[] conj = {elfo, gold, bronze5, bronze6, buraco, bronze3, bronze4, silver, bronze, bronze2, dragao};
        testeDragao.startGame(conj, 7, 8);
        Creature acriaturaTestada = testeDragao.getCriaturaPorPosicao(2, 0);
        assert acriaturaTestada != null;
        acriaturaTestada.estaCongelado = true;
        acriaturaTestada.moveCriatura();
        int xEsperado = 2;
        int pontosEsperado = 0;
        assertEquals(pontosEsperado, acriaturaTestada.getNrTesouros());
        assertEquals(xEsperado, acriaturaTestada.getX());
        acriaturaTestada.estaCongelado = false;
        acriaturaTestada.moveCriatura();
        assertEquals(xEsperado, acriaturaTestada.getX());
        acriaturaTestada.setOrientacao("Norte"); // Conferir Norte
        acriaturaTestada.setImagemCriatura("Norte");
        acriaturaTestada.x = 1;
        acriaturaTestada.y = 5;
        int yEsperado = 2;
        pontosEsperado = 1;
        acriaturaTestada.moveCriatura();
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
        acriaturaTestada.y = 6;
        yEsperado = 6;
        String oriEsperada = "Nordeste";
        String imgEsperada = "d_ne.png";
        acriaturaTestada.moveCriatura();
        assertEquals(yEsperado, acriaturaTestada.getY());
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
        yEsperado = 0;
        acriaturaTestada.moveCriatura();
        assertEquals(yEsperado, acriaturaTestada.getY());
        acriaturaTestada.setOrientacao("Sul");
        acriaturaTestada.setImagemCriatura("Sul");
        acriaturaTestada.x = 4;
        acriaturaTestada.y = 0;
        xEsperado = 4;
        acriaturaTestada.moveCriatura();
        assertEquals(xEsperado, acriaturaTestada.getX());
        acriaturaTestada.setOrientacao("Sul");
        acriaturaTestada.setImagemCriatura("Sul");
        acriaturaTestada.x = 6;
        acriaturaTestada.y = 3;
        xEsperado = 6;
        acriaturaTestada.moveCriatura();
        assertEquals(xEsperado, acriaturaTestada.getX());
        acriaturaTestada.setOrientacao("Este"); // Conferir Este
        acriaturaTestada.setImagemCriatura("Este");
        acriaturaTestada.x = 1;
        acriaturaTestada.y = 3;
        xEsperado = 1;
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
        acriaturaTestada.x = 0;
        acriaturaTestada.y = 3;
        xEsperado = 0;
        acriaturaTestada.moveCriatura();
        assertEquals(xEsperado, acriaturaTestada.getX());
        acriaturaTestada.setOrientacao("Este");
        acriaturaTestada.setImagemCriatura("Este");
        acriaturaTestada.x = 0;
        acriaturaTestada.y = 2;
        xEsperado = 3;
        acriaturaTestada.moveCriatura();
        assertEquals(xEsperado, acriaturaTestada.getX());
        acriaturaTestada.setOrientacao("Este");
        acriaturaTestada.setImagemCriatura("Este");
        acriaturaTestada.x = 2;
        acriaturaTestada.y = 3;
        xEsperado = 5;
        acriaturaTestada.moveCriatura();
        assertEquals(xEsperado, acriaturaTestada.getX());
        acriaturaTestada.setOrientacao("Oeste"); // Conferir Oeste
        acriaturaTestada.setImagemCriatura("Oeste");
        acriaturaTestada.x = 3;
        acriaturaTestada.y = 6;
        xEsperado = 0;
        acriaturaTestada.moveCriatura();
        assertEquals(xEsperado, acriaturaTestada.getX());
        acriaturaTestada.x = 7;
        acriaturaTestada.y = 3;
        xEsperado = 7;
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
        acriaturaTestada.x = 6;
        acriaturaTestada.y = 3;
        xEsperado = 6;
        acriaturaTestada.moveCriatura();
        assertEquals(xEsperado, acriaturaTestada.getX());
        acriaturaTestada.setOrientacao("Nordeste"); // conferir nordeste
        acriaturaTestada.setImagemCriatura("Nordeste");
        acriaturaTestada.x = 0;
        acriaturaTestada.y = 3;
        xEsperado = 3;
        acriaturaTestada.moveCriatura();
        assertEquals(xEsperado, acriaturaTestada.getX());
        acriaturaTestada.x = 0;
        acriaturaTestada.y = 6;
        xEsperado = 0;
        acriaturaTestada.moveCriatura();
        assertEquals(xEsperado, acriaturaTestada.getX());
        acriaturaTestada.setOrientacao("Nordeste");
        acriaturaTestada.setImagemCriatura("Nordeste");
        acriaturaTestada.x = 1;
        acriaturaTestada.y = 6;
        xEsperado = 1;
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
        xEsperado = 0;
        acriaturaTestada.moveCriatura();
        assertEquals(xEsperado, acriaturaTestada.getX());
        acriaturaTestada.x = 6;
        acriaturaTestada.y = 6;
        xEsperado = 6;
        acriaturaTestada.moveCriatura();
        assertEquals(xEsperado, acriaturaTestada.getX());
        acriaturaTestada.setOrientacao("Noroeste");
        acriaturaTestada.setImagemCriatura("Noroeste");
        acriaturaTestada.x = 7;
        acriaturaTestada.y = 6;
        xEsperado = 7;
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
        acriaturaTestada.x = 0;
        acriaturaTestada.y = 0;
        xEsperado = 0;
        acriaturaTestada.moveCriatura();
        assertEquals(xEsperado, acriaturaTestada.getX());
        acriaturaTestada.setOrientacao("Sudeste");
        acriaturaTestada.setImagemCriatura("Sudeste");
        acriaturaTestada.x = 1;
        acriaturaTestada.y = 0;
        xEsperado = 1;
        acriaturaTestada.moveCriatura();
        assertEquals(xEsperado, acriaturaTestada.getX());
        acriaturaTestada.setOrientacao("Sudeste");
        acriaturaTestada.setImagemCriatura("Sudeste");
        acriaturaTestada.x = 6;
        acriaturaTestada.y = 3;
        xEsperado = 6;
        acriaturaTestada.moveCriatura();
        assertEquals(xEsperado, acriaturaTestada.getX());
        acriaturaTestada.setOrientacao("Sudeste");
        acriaturaTestada.setImagemCriatura("Sudeste");
        acriaturaTestada.x = 0;
        acriaturaTestada.y = 1;
        xEsperado = 3;
        acriaturaTestada.moveCriatura();
        assertEquals(xEsperado, acriaturaTestada.getX());
        acriaturaTestada.setOrientacao("Sudoeste"); // conferir Sudoeste
        acriaturaTestada.setImagemCriatura("Sudoeste");
        acriaturaTestada.x = 6;
        acriaturaTestada.y = 0;
        xEsperado = 6;
        acriaturaTestada.moveCriatura();
        assertEquals(xEsperado, acriaturaTestada.getX());
        acriaturaTestada.setOrientacao("Sudoeste");
        acriaturaTestada.setImagemCriatura("Sudoeste");
        acriaturaTestada.x = 7;
        acriaturaTestada.y = 0;
        xEsperado = 7;
        acriaturaTestada.moveCriatura();
        assertEquals(xEsperado, acriaturaTestada.getX());
        acriaturaTestada.setOrientacao("Sudoeste");
        acriaturaTestada.setImagemCriatura("Sudoeste");
        acriaturaTestada.x = 0;
        acriaturaTestada.y = 3;
        xEsperado = 0;
        acriaturaTestada.moveCriatura();
        assertEquals(xEsperado, acriaturaTestada.getX());
        acriaturaTestada.setOrientacao("Sudoeste");
        acriaturaTestada.setImagemCriatura("Sudoeste");
        acriaturaTestada.x = 7;
        acriaturaTestada.y = 2;
        xEsperado = 4;
        acriaturaTestada.moveCriatura();
        assertEquals(xEsperado, acriaturaTestada.getX());
    }
}
