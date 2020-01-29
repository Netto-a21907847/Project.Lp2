package pt.ulusofona.lp2.fandeisiaGame;

public class ResultsCreature {
    private String tipo;
    private long qtTipo;
    private int pontos;

    public ResultsCreature(String tipo, long qtTipo, int pontos) {
        this.tipo = tipo;
        this.qtTipo = qtTipo;
        this.pontos = pontos;
    }

    public String getTipo() {
        return tipo;
    }

    public long getQtTipo() {
        return qtTipo;
    }

    public int getPontos() {
        return pontos;
    }
}
