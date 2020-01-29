package pt.ulusofona.lp2.fandeisiaGame;

import static pt.ulusofona.lp2.fandeisiaGame.FandeisiaGameManager.equipeAtual;

public class Congela extends Spell {

    public Congela(String nomeFeitico) {
        super(nomeFeitico);
        this.custoFeitico = 3;
        this.idFeitico = 3;
    }

    @Override
    public boolean aplicaFeitico(Creature criatura) {
        if (!criatura.temSpell) {
            if (FandeisiaGameManager.equipeAtual.getMoedasEquipe() >= this.custoFeitico) {
                if (!criatura.estaCongelado) {
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
