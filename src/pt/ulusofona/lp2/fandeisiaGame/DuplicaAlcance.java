package pt.ulusofona.lp2.fandeisiaGame;


import static pt.ulusofona.lp2.fandeisiaGame.FandeisiaGameManager.*;

public class DuplicaAlcance extends Spell {

    public DuplicaAlcance(String nomeFeitico) {
        super(nomeFeitico);
        this.custoFeitico = 3;
        this.idFeitico = 9;
    }

    @Override
    public boolean aplicaFeitico(Creature criatura) { 
            if (!criatura.temSpell) {
                if (FandeisiaGameManager.equipeAtual.getMoedasEquipe() >= this.custoFeitico) {
                    switch (criatura.getTipo()) {
                        case "Anão":
                            if (!criatura.estaCongelado) {
                                switch (criatura.getOrientacao()) {
                                    case "Norte":
                                        if (confereContemBuraco(criatura.getX(), criatura.getY() - 1) || confereContemBuraco(criatura.getX(), criatura.getY() - 2)) {
                                            return false;
                                        }
                                        if (confereContemCreature(criatura.getX(), criatura.getY() - 1) || confereContemCreature(criatura.getX(), criatura.getY() - 2)) {
                                            return false;
                                        }
                                        if (criatura.getY() > 1) {
                                            criatura.setSpellName(this);
                                            equipeAtual.removerMoedas(this.custoFeitico);
                                            criatura.temSpell = true;
                                            return true;
                                        }
                                        return false;
                                    case "Sul":
                                        if (confereContemBuraco(criatura.getX(), criatura.getY() + 1) || confereContemBuraco(criatura.getX(), criatura.getY() + 2)) {
                                            return false;
                                        }
                                        if (confereContemCreature(criatura.getX(), criatura.getY() + 1) || confereContemCreature(criatura.getX(), criatura.getY() + 2)) {
                                            return false;
                                        }
                                        if (criatura.getY() < FandeisiaGameManager.getROWS() - 2) {
                                            criatura.setSpellName(this);
                                            equipeAtual.removerMoedas(this.custoFeitico);
                                            criatura.temSpell = true;
                                            return true;
                                        }
                                        return false;
                                    case "Este":
                                        if (confereContemBuraco(criatura.getX() + 1, criatura.getY()) || confereContemBuraco(criatura.getX() + 2, criatura.getY())) {
                                            return false;
                                        }
                                        if (confereContemCreature(criatura.getX() + 1, criatura.getY()) || confereContemCreature(criatura.getX() + 2, criatura.getY())) {
                                            return false;
                                        }
                                        if (criatura.getX() < FandeisiaGameManager.getCOLUMNS() - 2) {
                                            criatura.setSpellName(this);
                                            equipeAtual.removerMoedas(this.custoFeitico);
                                            criatura.temSpell = true;
                                            return true;
                                        }
                                        return false;
                                    case "Oeste":
                                        if (confereContemBuraco(criatura.getX() - 1, criatura.getY()) || confereContemBuraco(criatura.getX() - 2, criatura.getY())) {
                                            return false;
                                        }
                                        if (confereContemCreature(criatura.getX() - 1, criatura.getY()) || confereContemCreature(criatura.getX() - 2, criatura.getY())) {
                                            return false;
                                        }
                                        if (criatura.getX() > 1) {
                                            criatura.setSpellName(this);
                                            equipeAtual.removerMoedas(this.custoFeitico);
                                            criatura.temSpell = true;
                                            return true;
                                        }
                                        return false;
                                }
                            }
                            return false;
                        case "Humano":
                            if (!criatura.estaCongelado) {
                                switch (criatura.getOrientacao()) {
                                    case "Norte":
                                        if (confereContemBuraco(criatura.getX(), criatura.getY() - 1) || confereContemBuraco(criatura.getX(), criatura.getY() - 2) ||
                                                confereContemBuraco(criatura.getX(), criatura.getY() - 3) || confereContemBuraco(criatura.getX(), criatura.getY() - 4)) {
                                            return false;
                                        }
                                        if (confereContemCreature(criatura.getX(), criatura.getY() - 1) || confereContemCreature(criatura.getX(), criatura.getY() - 2) ||
                                                confereContemCreature(criatura.getX(), criatura.getY() - 3) || confereContemCreature(criatura.getX(), criatura.getY() - 4)) {
                                            return false;
                                        }
                                        if (criatura.getY() > 3) {
                                            criatura.setSpellName(this);
                                            equipeAtual.removerMoedas(this.custoFeitico);
                                            criatura.temSpell = true;
                                            return true;
                                        }
                                        return false;
                                    case "Sul":
                                        if (confereContemBuraco(criatura.getX(), criatura.getY() + 1) || confereContemBuraco(criatura.getX(), criatura.getY() + 2) ||
                                                confereContemBuraco(criatura.getX(), criatura.getY() + 3) || confereContemBuraco(criatura.getX(), criatura.getY() + 4)) {
                                            return false;
                                        }
                                        if (confereContemCreature(criatura.getX(), criatura.getY() + 1) || confereContemCreature(criatura.getX(), criatura.getY() + 2) ||
                                                confereContemCreature(criatura.getX(), criatura.getY() + 3) || confereContemCreature(criatura.getX(), criatura.getY() + 4)) {
                                            return false;
                                        }
                                        if (criatura.getY() < FandeisiaGameManager.getROWS() - 4) {
                                            criatura.setSpellName(this);
                                            equipeAtual.removerMoedas(this.custoFeitico);
                                            criatura.temSpell = true;
                                            return true;
                                        }
                                        return false;
                                    case "Este":
                                        if (confereContemBuraco(criatura.getX() + 1, criatura.getY()) || confereContemBuraco(criatura.getX() + 2, criatura.getY()) ||
                                                confereContemBuraco(criatura.getX() + 3, criatura.getY()) || confereContemBuraco(criatura.getX() + 4, criatura.getY())) {
                                            return false;
                                        }
                                        if (confereContemCreature(criatura.getX() + 1, criatura.getY()) || confereContemCreature(criatura.getX() + 2, criatura.getY()) ||
                                                confereContemCreature(criatura.getX() + 3, criatura.getY()) || confereContemCreature(criatura.getX() + 4, criatura.getY())) {
                                            return false;
                                        }
                                        if (criatura.getX() < FandeisiaGameManager.getCOLUMNS() - 4) {
                                            criatura.setSpellName(this);
                                            equipeAtual.removerMoedas(this.custoFeitico);
                                            criatura.temSpell = true;
                                            return true;
                                        }
                                        return false;
                                    case "Oeste":
                                        if (confereContemBuraco(criatura.getX() - 1, criatura.getY()) || confereContemBuraco(criatura.getX() - 2, criatura.getY()) ||
                                                confereContemBuraco(criatura.getX() - 3, criatura.getY()) || confereContemBuraco(criatura.getX() - 4, criatura.getY())) {
                                            return false;
                                        }
                                        if (confereContemCreature(criatura.getX() - 1, criatura.getY()) || confereContemCreature(criatura.getX() - 2, criatura.getY()) ||
                                                confereContemCreature(criatura.getX() - 3, criatura.getY()) || confereContemCreature(criatura.getX() - 4, criatura.getY())) {
                                            return false;
                                        }
                                        if (criatura.getX() > 3) {
                                            criatura.setSpellName(this);
                                            equipeAtual.removerMoedas(this.custoFeitico);
                                            criatura.temSpell = true;
                                            return true;
                                        }
                                        return false;
                                }
                            }
                            return false;
                        case "Gigante":
                            if (!criatura.estaCongelado) {
                                switch (criatura.getOrientacao()) {
                                    case "Norte":
                                        if (confereContemBuraco(criatura.getX(), criatura.getY() - 6)) {
                                            return false;
                                        }
                                        if (confereContemCreature(criatura.getX(), criatura.getY() - 6)) {
                                            return false;
                                        }
                                        if (confereContemGigante(criatura.getX(), criatura.getY() - 1) || confereContemGigante(criatura.getX(), criatura.getY() - 2) || confereContemGigante(criatura.getX(), criatura.getY() - 3) ||
                                                confereContemGigante(criatura.getX(), criatura.getY() - 4) || confereContemGigante(criatura.getX(), criatura.getY() - 5)) {
                                            return false;
                                        }
                                        if (criatura.getY() > 5) {
                                            criatura.setSpellName(this);
                                            equipeAtual.removerMoedas(this.custoFeitico);
                                            criatura.temSpell = true;
                                            return true;
                                        }
                                        return false;
                                    case "Sul":
                                        if (confereContemBuraco(criatura.getX(), criatura.getY() + 6)) {
                                            return false;
                                        }
                                        if (confereContemCreature(criatura.getX(), criatura.getY() + 6)) {
                                            return false;
                                        }
                                        if (confereContemGigante(criatura.getX(), criatura.getY() + 1) || confereContemGigante(criatura.getX(), criatura.getY() + 2) || confereContemGigante(criatura.getX(), criatura.getY() + 3) ||
                                                confereContemGigante(criatura.getX(), criatura.getY() + 4) || confereContemGigante(criatura.getX(), criatura.getY() + 5)) {
                                            return false;
                                        }
                                        if (criatura.getY() < FandeisiaGameManager.getROWS() - 6) {
                                            criatura.setSpellName(this);
                                            equipeAtual.removerMoedas(this.custoFeitico);
                                            criatura.temSpell = true;
                                            return true;
                                        }
                                        return false;
                                    case "Este":
                                        if (confereContemBuraco(criatura.getX() + 6, criatura.getY())) {
                                            return false;
                                        }
                                        if (confereContemCreature(criatura.getX() + 6, criatura.getY())) {
                                            return false;
                                        }
                                        if (confereContemGigante(criatura.getX() + 1, criatura.getY()) || confereContemGigante(criatura.getX() + 2, criatura.getY()) || confereContemGigante(criatura.getX() + 3, criatura.getY()) ||
                                                confereContemGigante(criatura.getX() + 4, criatura.getY()) || confereContemGigante(criatura.getX() + 5, criatura.getY())) {
                                            return false;
                                        }
                                        if (criatura.getX() < FandeisiaGameManager.getCOLUMNS() - 6) {
                                            criatura.setSpellName(this);
                                            equipeAtual.removerMoedas(this.custoFeitico);
                                            criatura.temSpell = true;
                                            return true;
                                        }
                                        return false;
                                    case "Oeste":
                                        if (confereContemBuraco(criatura.getX() - 6, criatura.getY())) {
                                            return false;
                                        }
                                        if (confereContemCreature(criatura.getX() - 6, criatura.getY())) {
                                            return false;
                                        }
                                        if (confereContemGigante(criatura.getX() - 1, criatura.getY()) || confereContemGigante(criatura.getX() - 2, criatura.getY()) || confereContemGigante(criatura.getX() - 3, criatura.getY()) ||
                                                confereContemGigante(criatura.getX() - 4, criatura.getY()) || confereContemGigante(criatura.getX() - 5, criatura.getY())) {
                                            return false;
                                        }
                                        if (criatura.getX() > 5) {
                                            criatura.setSpellName(this);
                                            equipeAtual.removerMoedas(this.custoFeitico);
                                            criatura.temSpell = true;
                                            return true;
                                        }
                                        return false;
                                }
                            }
                            return false;
                        case "Dragão":
                            if (!criatura.estaCongelado) {
                                switch (criatura.getOrientacao()) {
                                    case "Norte":
                                        if (confereContemBuraco(criatura.getX(), criatura.getY() - 6)) {
                                            return false;
                                        }
                                        if (confereContemCreature(criatura.getX(), criatura.getY() - 6)) {
                                            return false;
                                        }
                                        if (criatura.getY() > 5) {
                                            criatura.setSpellName(this);
                                            equipeAtual.removerMoedas(this.custoFeitico);
                                            criatura.temSpell = true;
                                            return true;
                                        }
                                        return false;
                                    case "Nordeste":
                                        if (confereContemBuraco(criatura.getX() + 6, criatura.getY() - 6)) {
                                            return false;
                                        }
                                        if (confereContemCreature(criatura.getX() + 6, criatura.getY() - 6)) {
                                            return false;
                                        }
                                        if (criatura.getX() < FandeisiaGameManager.getCOLUMNS() - 6 && criatura.getY() > 5) {
                                            criatura.setSpellName(this);
                                            equipeAtual.removerMoedas(this.custoFeitico);
                                            criatura.temSpell = true;
                                            return true;
                                        }
                                        return false;
                                    case "Este":
                                        if (confereContemBuraco(criatura.getX() + 6, criatura.getY())) {
                                            return false;
                                        }
                                        if (confereContemCreature(criatura.getX() + 6, criatura.getY())) {
                                            return false;
                                        }
                                        if (criatura.getX() < FandeisiaGameManager.getCOLUMNS() - 6) {
                                            criatura.setSpellName(this);
                                            equipeAtual.removerMoedas(this.custoFeitico);
                                            criatura.temSpell = true;
                                            return true;
                                        }
                                        return false;
                                    case "Sudeste":
                                        if (confereContemBuraco(criatura.getX() + 6, criatura.getY() + 6)) {
                                            return false;
                                        }
                                        if (confereContemCreature(criatura.getX() + 6, criatura.getY() + 6)) {
                                            return false;
                                        }
                                        if (criatura.getX() < FandeisiaGameManager.getCOLUMNS() - 6 && criatura.getY() < FandeisiaGameManager.getROWS() - 6) {
                                            criatura.setSpellName(this);
                                            equipeAtual.removerMoedas(this.custoFeitico);
                                            criatura.temSpell = true;
                                            return true;
                                        }
                                        return false;
                                    case "Sul":
                                        if (confereContemBuraco(criatura.getX(), criatura.getY() + 6)) {
                                            return false;
                                        }
                                        if (confereContemCreature(criatura.getX(), criatura.getY() + 6)) {
                                            return false;
                                        }
                                        if (criatura.getY() < FandeisiaGameManager.getROWS() - 6) {
                                            criatura.setSpellName(this);
                                            equipeAtual.removerMoedas(this.custoFeitico);
                                            criatura.temSpell = true;
                                            return true;
                                        }
                                        return false;
                                    case "Sudoeste":
                                        if (confereContemBuraco(criatura.getX() - 6, criatura.getY() + 6)) {
                                            return false;
                                        }
                                        if (confereContemCreature(criatura.getX() - 6, criatura.getY() + 6)) {
                                            return false;
                                        }
                                        if (criatura.getX() > 5 && criatura.getY() < FandeisiaGameManager.getROWS() - 6) {
                                            criatura.setSpellName(this);
                                            equipeAtual.removerMoedas(this.custoFeitico);
                                            criatura.temSpell = true;
                                            return true;
                                        }
                                        return false;
                                    case "Oeste":
                                        if (confereContemBuraco(criatura.getX() - 6, criatura.getY())) {
                                            return false;
                                        }
                                        if (confereContemCreature(criatura.getX() - 6, criatura.getY())) {
                                            return false;
                                        }
                                        if (criatura.getX() > 5) {
                                            criatura.setSpellName(this);
                                            equipeAtual.removerMoedas(this.custoFeitico);
                                            criatura.temSpell = true;
                                            return true;
                                        }
                                        return false;
                                    case "Noroeste":
                                        if (confereContemBuraco(criatura.getX() - 6, criatura.getY() - 6)) {
                                            return false;
                                        }
                                        if (confereContemCreature(criatura.getX() - 6, criatura.getY() - 6)) {
                                            return false;
                                        }
                                        if (criatura.getX() > 5 && criatura.getY() > 5) {
                                            criatura.setSpellName(this);
                                            equipeAtual.removerMoedas(this.custoFeitico);
                                            criatura.temSpell = true;
                                            return true;
                                        }
                                        return false;
                                }
                            }
                            return false;
                        case "Elfo":
                            if (!criatura.estaCongelado) {
                                switch (criatura.getOrientacao()) {
                                    case "Norte":
                                        if (confereContemBuraco(criatura.getX(), criatura.getY() - 4)) {
                                            return false;
                                        }
                                        if (confereContemCreature(criatura.getX(), criatura.getY() - 1) || confereContemCreature(criatura.getX(), criatura.getY() - 2) ||
                                                confereContemCreature(criatura.getX(), criatura.getY() - 3) || confereContemCreature(criatura.getX(), criatura.getY() - 4)) {
                                            return false;
                                        }
                                        if (criatura.getY() > 3) {
                                            criatura.setSpellName(this);
                                            equipeAtual.removerMoedas(this.custoFeitico);
                                            criatura.temSpell = true;
                                            return true;
                                        }
                                        return false;
                                    case "Nordeste":
                                        if (confereContemBuraco(criatura.getX() + 4, criatura.getY() - 4)) {
                                            return false;
                                        }
                                        if (confereContemCreature(criatura.getX() + 1, criatura.getY() - 1) || confereContemCreature(criatura.getX() + 2, criatura.getY() - 2) ||
                                                confereContemCreature(criatura.getX() + 3, criatura.getY() - 3) || confereContemCreature(criatura.getX() + 4, criatura.getY() - 4)) {
                                            return false;
                                        }
                                        if (criatura.getX() < FandeisiaGameManager.getCOLUMNS() - 4 && criatura.getY() > 3) {
                                            criatura.setSpellName(this);
                                            equipeAtual.removerMoedas(this.custoFeitico);
                                            criatura.temSpell = true;
                                            return true;
                                        }
                                        return false;
                                    case "Noroeste":
                                        if (confereContemBuraco(criatura.getX() - 4, criatura.getY() - 4)) {
                                            return false;
                                        }
                                        if (confereContemCreature(criatura.getX() - 1, criatura.getY() - 1) || confereContemCreature(criatura.getX() - 2, criatura.getY() - 2) ||
                                                confereContemCreature(criatura.getX() - 3, criatura.getY() - 3) || confereContemCreature(criatura.getX() - 4, criatura.getY() - 4)) {
                                            return false;
                                        }
                                        if (criatura.getX() > 3 && criatura.getY() > 3) {
                                            criatura.setSpellName(this);
                                            equipeAtual.removerMoedas(this.custoFeitico);
                                            criatura.temSpell = true;
                                            return true;
                                        }
                                        return false;
                                    case "Sul":
                                        if (confereContemBuraco(criatura.getX(), criatura.getY() + 4)) {
                                            return false;
                                        }
                                        if (confereContemCreature(criatura.getX(), criatura.getY() + 1) || confereContemCreature(criatura.getX(), criatura.getY() + 2) ||
                                                confereContemCreature(criatura.getX(), criatura.getY() + 3) || confereContemCreature(criatura.getX(), criatura.getY() + 4)) {
                                            return false;
                                        }
                                        if (criatura.getY() < FandeisiaGameManager.getROWS() - 4) {
                                            criatura.setSpellName(this);
                                            equipeAtual.removerMoedas(this.custoFeitico);
                                            criatura.temSpell = true;
                                            return true;
                                        }
                                        return false;
                                    case "Sudoeste":
                                        if (confereContemBuraco(criatura.getX() - 4, criatura.getY() + 4)) {
                                            return false;
                                        }
                                        if (confereContemCreature(criatura.getX() - 1, criatura.getY() + 1) || confereContemCreature(criatura.getX() - 2, criatura.getY() + 2) ||
                                                confereContemCreature(criatura.getX() - 3, criatura.getY() + 3) || confereContemCreature(criatura.getX() - 4, criatura.getY() + 4)) {
                                            return false;
                                        }
                                        if (criatura.getX() > 3 && criatura.getY() < FandeisiaGameManager.getROWS() - 4) {
                                            criatura.setSpellName(this);
                                            equipeAtual.removerMoedas(this.custoFeitico);
                                            criatura.temSpell = true;
                                            return true;
                                        }
                                        return false;
                                    case "Sudeste":
                                        if (confereContemBuraco(criatura.getX() + 4, criatura.getY() + 4)) {
                                            return false;
                                        }
                                        if (confereContemCreature(criatura.getX() + 1, criatura.getY() + 1) || confereContemCreature(criatura.getX() + 2, criatura.getY() + 2) ||
                                                confereContemCreature(criatura.getX() + 3, criatura.getY() + 3) || confereContemCreature(criatura.getX() + 4, criatura.getY() + 4)) {
                                            return false;
                                        }
                                        if (criatura.getX() < FandeisiaGameManager.getCOLUMNS() - 4 && criatura.getY() < FandeisiaGameManager.getROWS() - 4) {
                                            criatura.setSpellName(this);
                                            equipeAtual.removerMoedas(this.custoFeitico);
                                            criatura.temSpell = true;
                                            return true;
                                        }
                                        return false;
                                    case "Oeste":
                                        if (confereContemBuraco(criatura.getX() - 4, criatura.getY())) {
                                            return false;
                                        }
                                        if (confereContemCreature(criatura.getX() - 1, criatura.getY()) || confereContemCreature(criatura.getX() - 2, criatura.getY()) ||
                                                confereContemCreature(criatura.getX() - 3, criatura.getY()) || confereContemCreature(criatura.getX() - 4, criatura.getY())) {
                                            return false;
                                        }
                                        if (criatura.getX() > 3) {
                                            criatura.setSpellName(this);
                                            equipeAtual.removerMoedas(this.custoFeitico);
                                            criatura.temSpell = true;
                                            return true;
                                        }
                                        return false;
                                    case "Este":
                                        if (confereContemBuraco(criatura.getX() + 4, criatura.getY())) {
                                            return false;
                                        }
                                        if (confereContemCreature(criatura.getX() + 1, criatura.getY()) || confereContemCreature(criatura.getX() + 2, criatura.getY()) ||
                                                confereContemCreature(criatura.getX() + 3, criatura.getY()) || confereContemCreature(criatura.getX() + 4, criatura.getY())) {
                                            return false;
                                        }
                                        if (criatura.getX() < FandeisiaGameManager.getCOLUMNS() - 4) {
                                            criatura.setSpellName(this);
                                            equipeAtual.removerMoedas(this.custoFeitico);
                                            criatura.temSpell = true;
                                            return true;
                                        }
                                        return false;
                                }
                            }
                            return false;
                    }
                }
            }
        return false;
    }
}
