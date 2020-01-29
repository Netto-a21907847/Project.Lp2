package pt.ulusofona.lp2.fandeisiaGame;

import static pt.ulusofona.lp2.fandeisiaGame.FandeisiaGameManager.*;

public class EmpurraParaEste extends Spell {

    public EmpurraParaEste(String nomeFeitico) {
        super(nomeFeitico);
        this.custoFeitico = 1;
        this.idFeitico = 5;
    }

    @Override
    public boolean aplicaFeitico(Creature criatura) {
        if (!criatura.temSpell) {
            if (equipeAtual.getMoedasEquipe() >= this.custoFeitico) {
                if (!criatura.estaCongelado) {
                    if (confereContemBuraco(criatura.getX() + 1, criatura.getY())) {
                        return false;
                    }
                    if (confereContemCreature(criatura.getX() + 1, criatura.getY())) {
                        return false;
                    }
                    if (criatura.getX() < FandeisiaGameManager.getCOLUMNS() - 1) {
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
