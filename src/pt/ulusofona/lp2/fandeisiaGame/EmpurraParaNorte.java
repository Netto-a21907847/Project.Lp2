package pt.ulusofona.lp2.fandeisiaGame;

import static pt.ulusofona.lp2.fandeisiaGame.FandeisiaGameManager.*;

public class EmpurraParaNorte extends Spell {

    public EmpurraParaNorte(String nomeFeitico) {
        super(nomeFeitico);
        this.custoFeitico = 1;
        this.idFeitico = 7;
    }

    @Override
    public boolean aplicaFeitico(Creature criatura) {
        if (!criatura.temSpell) {
            if (equipeAtual.getMoedasEquipe() >= this.custoFeitico) {
                if (!criatura.estaCongelado) {
                    if (confereContemBuraco(criatura.getX(), criatura.getY() - 1)) {
                        return false;
                    }
                    if (confereContemCreature(criatura.getX(), criatura.getY() - 1)) {
                        return false;
                    }
                    if (criatura.getY() > 0) {
                        criatura.setSpellName(this);
                        criatura.temSpell = true;
                        equipeAtual.removerMoedas(this.custoFeitico);
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
