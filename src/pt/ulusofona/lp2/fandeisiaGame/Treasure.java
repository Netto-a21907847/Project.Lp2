package pt.ulusofona.lp2.fandeisiaGame;

public class Treasure extends Mapa {

    private int pontos;
    private String tipoTesouro;
    //“id: <id>, type: treasure, x: <x>, y: <y>”
    public Treasure(int id, String tipoTesouro, int x, int y) {
        super(id, x, y);
        this.tipoTesouro = tipoTesouro;
        switch (tipoTesouro) {
            case "gold":
                this.pontos = 3;
                break;
            case "silver":
                this.pontos = 2;
                break;
            case "bronze":
                this.pontos = 1;
                break;
        }
    }

    public int getPontos() {
        return pontos;
    }

    public String getTipoTesouro() {
        return tipoTesouro;
    }
}
