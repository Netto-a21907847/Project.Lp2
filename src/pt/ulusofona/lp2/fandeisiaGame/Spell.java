package pt.ulusofona.lp2.fandeisiaGame;

public abstract class Spell {

    private String nomeFeitico;
    protected int custoFeitico;
    protected int idFeitico;

    public Spell(String nomeFeitico) {
        this.nomeFeitico = nomeFeitico;
    }

    public String getNomeFeitico() {
        return nomeFeitico;
    }

    public int getCustoFeitico() {
        return custoFeitico;
    }

    public int getIdFeitico() {
        return idFeitico;
    }

    public abstract boolean aplicaFeitico(Creature criatura);

    @Override
    public String toString() {
        return "Spell{" + nomeFeitico + ", custoFeitico = " + custoFeitico + ", idFeitico = " + idFeitico + '}';
    }
}
