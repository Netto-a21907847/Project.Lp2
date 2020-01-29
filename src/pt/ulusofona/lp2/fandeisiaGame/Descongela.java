package pt.ulusofona.lp2.fandeisiaGame;


import static pt.ulusofona.lp2.fandeisiaGame.FandeisiaGameManager.equipeAtual;

public class Descongela extends Spell {

    public Descongela(String nomeFeitico) {
        super(nomeFeitico);
        this.custoFeitico = 8;
        this.idFeitico = 1;
    }

    @Override
    public boolean aplicaFeitico(Creature criatura) {
        if (!criatura.temSpell) {
            if (FandeisiaGameManager.equipeAtual.getMoedasEquipe() >= this.custoFeitico) {
                if (criatura.estaCongelado) {
                    criatura.setSpellName(this);
                    equipeAtual.removerMoedas(this.custoFeitico);
                    criatura.temSpell = true;
                    return true;
                }
            }
        }
        return false;
    }
}
