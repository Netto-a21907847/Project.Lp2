package pt.ulusofona.lp2.fandeisiaGame;

import static pt.ulusofona.lp2.fandeisiaGame.FandeisiaGameManager.*;

public class ReduzAlcance extends Spell {

    public ReduzAlcance(String nomeFeitico) {
        super(nomeFeitico);
        this.custoFeitico = 2;
        this.idFeitico = 8;
    }

    @Override
    public boolean aplicaFeitico(Creature criatura) {
        if (!criatura.temSpell) {
            if (FandeisiaGameManager.equipeAtual.getMoedasEquipe() >= this.custoFeitico) {
                if (criatura.getTipo().equals("Humano") || criatura.getTipo().equals("Gigante")) {
                    if (!criatura.estaCongelado) {
                        switch (criatura.getOrientacao()) {
                            case "Norte":
                                if (confereContemBuraco(criatura.getX(), criatura.getY() - 1)) {
                                    return false;
                                }
                                if (confereContemCreature(criatura.getX(), criatura.getY() - 1)) {
                                    return false;
                                }
                                if (criatura.getY() > 0) {
                                    criatura.setSpellName(this);
                                    equipeAtual.removerMoedas(this.custoFeitico);
                                    criatura.temSpell = true;
                                    return true;
                                }
                                return false;
                            case "Sul":
                                if (confereContemBuraco(criatura.getX(), criatura.getY() + 1)) {
                                    return false;
                                }
                                if (confereContemCreature(criatura.getX(), criatura.getY() + 1)) {
                                    return false;
                                }
                                if (criatura.getY() < FandeisiaGameManager.getROWS() - 1) {
                                    criatura.setSpellName(this);
                                    equipeAtual.removerMoedas(this.custoFeitico);
                                    criatura.temSpell = true;
                                    return true;
                                }
                                return false;
                            case "Este":
                                if (confereContemBuraco(criatura.getX() + 1, criatura.getY())) {
                                    return false;
                                }
                                if (confereContemCreature(criatura.getX() + 1, criatura.getY())) {
                                    return false;
                                }
                                if (criatura.getX() < FandeisiaGameManager.getCOLUMNS() - 1) {
                                    criatura.setSpellName(this);
                                    equipeAtual.removerMoedas(this.custoFeitico);
                                    criatura.temSpell = true;
                                    return true;
                                }
                                return false;
                            case "Oeste":
                                if (confereContemBuraco(criatura.getX() - 1, criatura.getY())) {
                                    return false;
                                }
                                if (confereContemCreature(criatura.getX() - 1, criatura.getY())) {
                                    return false;
                                }
                                if (criatura.getX() > 0) {
                                    criatura.setSpellName(this);
                                    equipeAtual.removerMoedas(this.custoFeitico);
                                    criatura.temSpell = true;
                                    return true;
                                }
                                return false;
                        }
                    }
                } else if (criatura.getTipo().equals("Elfo") || criatura.getTipo().equals("Dragão")) {
                    if (!criatura.estaCongelado) {
                        switch (criatura.getOrientacao()) {
                            case "Norte":
                                if (confereContemBuraco(criatura.getX(), criatura.getY() - 1)) {
                                    return false;
                                }
                                if (confereContemCreature(criatura.getX(), criatura.getY() - 1)) {
                                    return false;
                                }
                                if (criatura.getY() > 0) {
                                    criatura.setSpellName(this);
                                    equipeAtual.removerMoedas(this.custoFeitico);
                                    criatura.temSpell = true;
                                    return true;
                                }
                                return false;
                            case "Nordeste":
                                if (confereContemBuraco(criatura.getX() + 1, criatura.getY() - 1)) {
                                    return false;
                                }
                                if (confereContemCreature(criatura.getX() + 1, criatura.getY() - 1)) {
                                    return false;
                                }
                                if (criatura.getX() < FandeisiaGameManager.getCOLUMNS() - 1 && criatura.getY() > 0) {
                                    criatura.setSpellName(this);
                                    equipeAtual.removerMoedas(this.custoFeitico);
                                    criatura.temSpell = true;
                                    return true;
                                }
                                return false;
                            case "Noroeste":
                                if (confereContemBuraco(criatura.getX() - 1, criatura.getY() - 1)) {
                                    return false;
                                }
                                if (confereContemCreature(criatura.getX() - 1, criatura.getY() - 1)) {
                                    return false;
                                }
                                if (criatura.getX() > 0 && criatura.getY() > 0) {
                                    criatura.setSpellName(this);
                                    equipeAtual.removerMoedas(this.custoFeitico);
                                    criatura.temSpell = true;
                                    return true;
                                }
                                return false;
                            case "Sul":
                                if (confereContemBuraco(criatura.getX(), criatura.getY() + 1)) {
                                    return false;
                                }
                                if (confereContemCreature(criatura.getX(), criatura.getY() + 1)) {
                                    return false;
                                }
                                if (criatura.getY() < FandeisiaGameManager.getROWS() - 1) {
                                    criatura.setSpellName(this);
                                    equipeAtual.removerMoedas(this.custoFeitico);
                                    criatura.temSpell = true;
                                    return true;
                                }
                                return false;
                            case "Sudoeste":
                                if (confereContemBuraco(criatura.getX() - 1, criatura.getY() + 1)) {
                                    return false;
                                }
                                if (confereContemCreature(criatura.getX() - 1, criatura.getY() + 1)) {
                                    return false;
                                }
                                if (criatura.getX() > 0 && criatura.getY() < FandeisiaGameManager.getROWS() - 1) {
                                    criatura.setSpellName(this);
                                    equipeAtual.removerMoedas(this.custoFeitico);
                                    criatura.temSpell = true;
                                    return true;
                                }
                                return false;
                            case "Sudeste":
                                if (confereContemBuraco(criatura.getX() + 1, criatura.getY() + 1)) {
                                    return false;
                                }
                                if (confereContemCreature(criatura.getX() + 1, criatura.getY() + 1)) {
                                    return false;
                                }
                                if (criatura.getX() < FandeisiaGameManager.getCOLUMNS() - 1 && criatura.getY() < FandeisiaGameManager.getROWS() - 1) {
                                    criatura.setSpellName(this);
                                    equipeAtual.removerMoedas(this.custoFeitico);
                                    criatura.temSpell = true;
                                    return true;
                                }
                                return false;
                            case "Oeste":
                                if (confereContemBuraco(criatura.getX() - 1, criatura.getY())) {
                                    return false;
                                }
                                if (confereContemCreature(criatura.getX() - 1, criatura.getY())) {
                                    return false;
                                }
                                if (criatura.getX() > 0) {
                                    criatura.setSpellName(this);
                                    equipeAtual.removerMoedas(this.custoFeitico);
                                    criatura.temSpell = true;
                                    return true;
                                }
                                return false;
                            case "Este":
                                if (confereContemBuraco(criatura.getX() + 1, criatura.getY())) {
                                    return false;
                                }
                                if (confereContemCreature(criatura.getX() + 1, criatura.getY())) {
                                    return false;
                                }
                                if (criatura.getX() < FandeisiaGameManager.getCOLUMNS() - 1) {
                                    criatura.setSpellName(this);
                                    equipeAtual.removerMoedas(this.custoFeitico);
                                    criatura.temSpell = true;
                                    return true;
                                }
                                return false;
                        }
                    }
                }
            }
        }
        return false;
    }
}
