package pt.ulusofona.lp2.fandeisiaGame;

import static pt.ulusofona.lp2.fandeisiaGame.FandeisiaGameManager.*;

public class EmpurraParaOeste extends Spell {

    public EmpurraParaOeste(String nomeFeitico) {
        super(nomeFeitico);
        this.custoFeitico = 1;
        this.idFeitico = 4;
    }

    @Override
    public boolean aplicaFeitico(Creature criatura) {
        if (!criatura.temSpell) {
            if (equipeAtual.getMoedasEquipe() >= this.custoFeitico) {
                if (!criatura.estaCongelado) {
                    if (confereContemBuraco(criatura.getX() - 1, criatura.getY())) {
                        return false;
                    }
                    if (confereContemCreature(criatura.getX() - 1, criatura.getY())) {
                        return false;
                    }
                    if (criatura.getX() > 0) {
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
