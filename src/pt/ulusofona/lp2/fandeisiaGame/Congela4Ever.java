package pt.ulusofona.lp2.fandeisiaGame;

public class Congela4Ever extends Spell {

    public Congela4Ever(String nomeFeitico) {
        super(nomeFeitico);
        this.custoFeitico = 10;
        this.idFeitico = 2;
    }

    @Override
    public boolean aplicaFeitico(Creature criatura) {
        if (!criatura.temSpell) {
            if (FandeisiaGameManager.equipeAtual.getMoedasEquipe() >= this.custoFeitico) {
                if (!criatura.estaCongelado) {
                    criatura.setSpellName(this);
                    FandeisiaGameManager.equipeAtual.removerMoedas(this.custoFeitico);
                    criatura.temSpell = true;
                    return true;
                }
            }
        }
        return false;
    }
}
