package pt.ulusofona.lp2.fandeisiaGame;

public class Team {

    private int idEquipe;
    private String nomeEquipe;
    private int pontosEquipe;
    private int moedasEquipe;

    public Team(int idEquipe, String nomeEquipe) {
        this.idEquipe = idEquipe;
        this.nomeEquipe = nomeEquipe;
        this.pontosEquipe = 0;
        this.moedasEquipe = 50;
    }

    public void setPontosEquipe(int pontosEquipe) {
        this.pontosEquipe = pontosEquipe;
    }

    public void setMoedasEquipe(int moedasEquipe) {
        this.moedasEquipe = moedasEquipe;
    }

    public int getIdEquipe() {
        return idEquipe;
    }

    public String getNomeEquipe() {
        return nomeEquipe;
    }

    public int getPontosEquipe() {
        return pontosEquipe;
    }

    public int getMoedasEquipe() {
        return moedasEquipe;
    }

    public void adicionarPontos(int pontos) {
        this.pontosEquipe += pontos;
    }

    public void adicionarMoedas(int moedas) {
        this.moedasEquipe += moedas;
    }

    public void removerMoedas(int moedas) {
        this.moedasEquipe -= moedas;
    }

    @Override
    public String toString() {
        return "> ID: " + idEquipe + " | " + nomeEquipe + " | Pts: " + pontosEquipe + " | " + moedasEquipe + " <";
    }
}
