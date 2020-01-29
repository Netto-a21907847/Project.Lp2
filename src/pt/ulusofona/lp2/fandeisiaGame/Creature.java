package pt.ulusofona.lp2.fandeisiaGame;

import static pt.ulusofona.lp2.fandeisiaGame.FandeisiaGameManager.*;

public abstract class Creature extends Mapa {

    protected String tipo;
    protected int idEquipe;
    protected int nrTesouros;
    protected int custo;
    protected String imagemCriatura;
    protected String orientacao;
    protected boolean estaCongelado;
    protected boolean temSpell;
    protected String spellName;
    protected int goldQtd;
    protected int silverQtd;
    protected int bronzeQtd;
    public Team teamCriatura;
    protected int nrPontos;
    protected int nrFeiticosSofrido;
    protected int kmPercorrido;

    public Creature(int id, String tipo, int idEquipe, int x, int y, String orientacao) {
        super(id, x, y);
        this.tipo = tipo;
        this.orientacao = orientacao;
        this.nrTesouros = 0;
        this.goldQtd = 0;
        this.silverQtd = 0;
        this.bronzeQtd = 0;
        this.estaCongelado = false;
        this.temSpell = false;
        this.spellName = "";
        this.idEquipe = idEquipe;
        this.nrPontos = 0;
        this.nrFeiticosSofrido = 0;
        this.teamCriatura = new Team(0, "Sem Equipe");
        this.kmPercorrido = 0;
    }

    public int getKmPercorrido() {
        return kmPercorrido;
    }

    public int getNrFeiticosSofrido() {
        return nrFeiticosSofrido;
    }

    public int getNrPontos() {
        return nrPontos;
    }

    public int getIdEquipe() {
        return idEquipe;
    }

    public int getNrTesouros() {
        return nrTesouros;
    }

    public int getCusto() {
        return custo;
    }

    public int getGoldQtd() {
        return goldQtd;
    }

    public int getSilverQtd() {
        return silverQtd;
    }

    public int getBronzeQtd() {
        return bronzeQtd;
    }

    public Team getTeamCriatura() {
        return teamCriatura;
    }

    public String getOrientacao() {
        return orientacao;
    }

    public String getImagePNG() {
        return this.imagemCriatura;
    }

    public String getTipo() {
        return tipo;
    }

    public String getSpellName() {
        return this.spellName;
    }

    public String getEstaCongelado() {
        if (estaCongelado) {
            return "true";
        }
        return "false";
    }

    public String getTemSpell() {
        if (temSpell) {
            return "true";
        }
        return "false";
    }

    public void adicionarPontos(int pontosTesouro) {
        this.nrTesouros += pontosTesouro;
    }

    public void setOrientacao(String orientacao) {
        this.orientacao = orientacao;
    }

    public void setSpellName(Spell feitico) {
        this.spellName = feitico.getNomeFeitico();
    }

    public void confereContemTesouro(Creature criatura, int x, int y) {
        for (Treasure treasureEncontrado : listaTreasures) {
            if (treasureEncontrado.x == x && treasureEncontrado.y == y) {
                if (treasureEncontrado.x == criatura.x && treasureEncontrado.y == criatura.y) {
                    criatura.getTeamCriatura().adicionarPontos(treasureEncontrado.getPontos());
                    switch (treasureEncontrado.getTipoTesouro()) {
                        case "gold":
                            criatura.goldQtd++;
                            criatura.nrPontos += 3;
                            break;
                        case "silver":
                            criatura.silverQtd++;
                            criatura.nrPontos += 2;
                            break;
                        case "bronze":
                            criatura.bronzeQtd++;
                            criatura.nrPontos += 1;
                            break;
                    }
                    criatura.adicionarPontos(1);
                    listaTreasures.remove(treasureEncontrado);
                    break;
                }
            }
        }
    }

    public void reduzAlcance_moveCriatura() {
        if (getTipo().equals("Humano") || getTipo().equals("Gigante")) {
            if (!estaCongelado) {
                switch (orientacao) {
                    case "Norte":
                        if (confereContemBuraco(this.x, this.y - 1)) {
                            setOrientacao("Este");
                            setImagemCriatura(getOrientacao());
                            break;
                        }
                        if (confereContemCreature(this.x, this.y - 1)) {
                            setOrientacao("Este");
                            setImagemCriatura(getOrientacao());
                            break;
                        }
                        if (this.y > 0) {
                            this.y--;
                            kmPercorrido++;
                            confereContemTesouro(this, this.x, this.y);
                        } else {
                            setOrientacao("Este");
                            setImagemCriatura(getOrientacao());
                        }
                        break;

                    case "Sul":
                        if (confereContemBuraco(this.x, this.y + 1)) {
                            setOrientacao("Oeste");
                            setImagemCriatura(getOrientacao());
                            break;
                        }
                        if (confereContemCreature(this.x, this.y + 1)) {
                            setOrientacao("Oeste");
                            setImagemCriatura(getOrientacao());
                            break;
                        }
                        if (this.y < FandeisiaGameManager.getROWS() - 1) {
                            this.y += 1;
                            kmPercorrido++;
                            confereContemTesouro(this, this.x, this.y);
                        } else {
                            setOrientacao("Oeste");
                            setImagemCriatura(getOrientacao());
                        }
                        break;

                    case "Este":
                        if (confereContemBuraco(this.x + 1, this.y)) {
                            setOrientacao("Sul");
                            setImagemCriatura(getOrientacao());
                            break;
                        }
                        if (confereContemCreature(this.x + 1, this.y)) {
                            setOrientacao("Sul");
                            setImagemCriatura(getOrientacao());
                            break;
                        }
                        if (this.x < FandeisiaGameManager.getCOLUMNS() - 1) {
                            this.x++;
                            kmPercorrido++;
                            confereContemTesouro(this, this.x, this.y);
                        } else {
                            setOrientacao("Sul");
                            setImagemCriatura(getOrientacao());
                        }
                        break;

                    case "Oeste":
                        if (confereContemBuraco(this.x - 1, this.y)) {
                            setOrientacao("Norte");
                            setImagemCriatura(getOrientacao());
                            break;
                        }
                        if (confereContemCreature(this.x - 1, this.y)) {
                            setOrientacao("Norte");
                            setImagemCriatura(getOrientacao());
                            break;
                        }
                        if (this.x > 0) {
                            this.x--;
                            kmPercorrido++;
                            confereContemTesouro(this, this.x, this.y);
                        } else {
                            setOrientacao("Norte");
                            setImagemCriatura(getOrientacao());
                        }
                        break;
                }
            }

        } else if (getTipo().equals("Elfo") || getTipo().equals("Dragão")) {
            if (!estaCongelado) {
                switch (orientacao) {
                    case "Norte":
                        if (confereContemBuraco(this.x, this.y - 1)) {
                            setOrientacao("Nordeste");
                            setImagemCriatura(getOrientacao());
                            break;
                        }
                        if (confereContemCreature(this.x, this.y - 1)) {
                            setOrientacao("Nordeste");
                            setImagemCriatura(getOrientacao());
                            break;
                        }
                        if (this.y > 0) {
                            this.y -= 1;
                            kmPercorrido++;
                            confereContemTesouro(this, this.x, this.y);
                        } else {
                            setOrientacao("Nordeste");
                            setImagemCriatura(getOrientacao());
                        }
                        break;
                    case "Nordeste":
                        if (confereContemBuraco(this.x + 1, this.y - 1)) {
                            setOrientacao("Este");
                            setImagemCriatura(getOrientacao());
                            break;
                        }
                        if (confereContemCreature(this.x + 1, this.y - 1)) {
                            setOrientacao("Este");
                            setImagemCriatura(getOrientacao());
                            break;
                        }
                        if (this.x < FandeisiaGameManager.getCOLUMNS() - 1 && this.y > 0) {
                            this.x += 1;
                            this.y -= 1;
                            kmPercorrido++;
                            confereContemTesouro(this, this.x, this.y);
                        } else {
                            setOrientacao("Este");
                            setImagemCriatura(getOrientacao());
                        }
                        break;

                    case "Noroeste":
                        if (confereContemBuraco(this.x - 1, this.y - 1)) {
                            setOrientacao("Norte");
                            setImagemCriatura(getOrientacao());
                            break;
                        }
                        if (confereContemCreature(this.x - 1, this.y - 1)) {
                            setOrientacao("Norte");
                            setImagemCriatura(getOrientacao());
                            break;
                        }
                        if (this.x > 0 && this.y > 0) {
                            this.x -= 1;
                            this.y -= 1;
                            kmPercorrido++;
                            confereContemTesouro(this, this.x, this.y);
                        } else {
                            setOrientacao("Norte");
                            setImagemCriatura(getOrientacao());
                        }
                        break;

                    case "Sul":
                        if (confereContemBuraco(this.x, this.y + 1)) {
                            setOrientacao("Sudoeste");
                            setImagemCriatura(getOrientacao());
                            break;
                        }
                        if (confereContemCreature(this.x, this.y + 1)) {
                            setOrientacao("Sudoeste");
                            setImagemCriatura(getOrientacao());
                            break;
                        }
                        if (this.y < FandeisiaGameManager.getROWS() - 1) {
                            this.y += 1;
                            kmPercorrido++;
                            confereContemTesouro(this, this.x, this.y);
                        } else {
                            setOrientacao("Sudoeste");
                            setImagemCriatura(getOrientacao());
                        }
                        break;

                    case "Sudoeste":
                        if (confereContemBuraco(this.x - 1, this.y + 1)) {
                            setOrientacao("Oeste");
                            setImagemCriatura(getOrientacao());
                            break;
                        }
                        if (confereContemCreature(this.x - 1, this.y + 1)) {
                            setOrientacao("Oeste");
                            setImagemCriatura(getOrientacao());
                            break;
                        }
                        if (this.x > 0 && this.y < FandeisiaGameManager.getROWS() - 1) {
                            this.x -= 1;
                            this.y += 1;
                            kmPercorrido++;
                            confereContemTesouro(this, this.x, this.y);
                        } else {
                            setOrientacao("Oeste");
                            setImagemCriatura(getOrientacao());
                        }
                        break;

                    case "Sudeste":
                        if (confereContemBuraco(this.x + 1, this.y + 1)) {
                            setOrientacao("Norte");
                            setImagemCriatura(getOrientacao());
                            break;
                        }
                        if (confereContemCreature(this.x + 1, this.y + 1)) {
                            setOrientacao("Norte");
                            setImagemCriatura(getOrientacao());
                            break;
                        }
                        if (this.x < FandeisiaGameManager.getCOLUMNS() - 1 && this.y < FandeisiaGameManager.getROWS() - 1) {
                            this.x += 1;
                            this.y += 1;
                            kmPercorrido++;
                            confereContemTesouro(this, this.x, this.y);
                        } else {
                            setOrientacao("Norte");
                            setImagemCriatura(getOrientacao());
                        }
                        break;

                    case "Oeste":
                        if (confereContemBuraco(this.x - 1, this.y)) {
                            setOrientacao("Noroeste");
                            setImagemCriatura(getOrientacao());
                            break;
                        }
                        if (confereContemCreature(this.x - 1, this.y)) {
                            setOrientacao("Noroeste");
                            setImagemCriatura(getOrientacao());
                            break;
                        }
                        if (this.x > 0) {
                            this.x -= 1;
                            kmPercorrido++;
                            confereContemTesouro(this, this.x, this.y);
                        } else {
                            setOrientacao("Noroeste");
                            setImagemCriatura(getOrientacao());
                        }
                        break;

                    case "Este":
                        if (confereContemBuraco(this.x + 1, this.y)) {
                            setOrientacao("Sudeste");
                            setImagemCriatura(getOrientacao());
                            break;
                        }
                        if (confereContemCreature(this.x + 1, this.y)) {
                            setOrientacao("Sudeste");
                            setImagemCriatura(getOrientacao());
                            break;
                        }
                        if (this.x < FandeisiaGameManager.getCOLUMNS() - 1) {
                            this.x += 1;
                            kmPercorrido++;
                            confereContemTesouro(this, this.x, this.y);
                        } else {
                            setOrientacao("Sudeste");
                            setImagemCriatura(getOrientacao());
                        }
                        break;
                }
            }
        }
    }

    public void duplicaAlcance() {
        switch (this.tipo) {
            case "Anão":
                if (!estaCongelado) {
                    switch (orientacao) {
                        case "Norte":
                            if (confereContemBuraco(this.x, this.y - 1) || confereContemBuraco(this.x, this.y - 2)) {
                                setOrientacao("Este");
                                setImagemCriatura(getOrientacao());
                                break;
                            }
                            if (confereContemCreature(this.x, this.y - 1) || confereContemCreature(this.x, this.y - 2)) {
                                setOrientacao("Este");
                                setImagemCriatura(getOrientacao());
                                break;
                            }
                            if (this.y > 1) {
                                this.y -= 2;
                                kmPercorrido += 2;
                                confereContemTesouro(this, this.x, this.y);
                            } else {
                                setOrientacao("Este");
                                setImagemCriatura(getOrientacao());
                            }
                            break;

                        case "Sul":
                            if (confereContemBuraco(this.x, this.y + 1) || confereContemBuraco(this.x, this.y + 2)) {
                                setOrientacao("Oeste");
                                setImagemCriatura(getOrientacao());
                                break;
                            }
                            if (confereContemCreature(this.x, this.y + 1) || confereContemCreature(this.x, this.y + 2)) {
                                setOrientacao("Oeste");
                                setImagemCriatura(getOrientacao());
                                break;
                            }
                            if (this.y < FandeisiaGameManager.getROWS() - 2) {
                                this.y += 2;
                                kmPercorrido += 2;
                                confereContemTesouro(this, this.x, this.y);
                            } else {
                                setOrientacao("Oeste");
                                setImagemCriatura(getOrientacao());
                            }
                            break;

                        case "Este":
                            if (confereContemBuraco(this.x + 1, this.y) || confereContemBuraco(this.x + 2, this.y)) {
                                setOrientacao("Sul");
                                setImagemCriatura(getOrientacao());
                                break;
                            }
                            if (confereContemCreature(this.x + 1, this.y) || confereContemCreature(this.x + 2, this.y)) {
                                setOrientacao("Sul");
                                setImagemCriatura(getOrientacao());
                                break;
                            }
                            if (this.x < FandeisiaGameManager.getCOLUMNS() - 2) {
                                this.x += 2;
                                kmPercorrido += 2;
                                confereContemTesouro(this, this.x, this.y);
                            } else {
                                setOrientacao("Sul");
                                setImagemCriatura(getOrientacao());
                            }
                            break;

                        case "Oeste":
                            if (confereContemBuraco(this.x - 1, this.y) || confereContemBuraco(this.x - 2, this.y)) {
                                setOrientacao("Norte");
                                setImagemCriatura(getOrientacao());
                                break;
                            }
                            if (confereContemCreature(this.x - 1, this.y) || confereContemCreature(this.x - 2, this.y)) {
                                setOrientacao("Norte");
                                setImagemCriatura(getOrientacao());
                                break;
                            }
                            if (this.x > 1) {
                                this.x -= 2;
                                kmPercorrido += 2;
                                confereContemTesouro(this, this.x, this.y);
                            } else {
                                setOrientacao("Norte");
                                setImagemCriatura(getOrientacao());
                            }
                            break;
                    }
                }
                break;
            case "Humano":
                if (!estaCongelado) {
                    switch (orientacao) {
                        case "Norte":
                            if (confereContemBuraco(this.x, this.y - 1) || confereContemBuraco(this.x, this.y - 2) ||
                                    confereContemBuraco(this.x, this.y - 3) || confereContemBuraco(this.x, this.y - 4)) {
                                setOrientacao("Este");
                                setImagemCriatura(getOrientacao());
                                break;
                            }
                            if (confereContemCreature(this.x, this.y - 1) || confereContemCreature(this.x, this.y - 2) ||
                                    confereContemCreature(this.x, this.y - 3) || confereContemCreature(this.x, this.y - 4)) {
                                setOrientacao("Este");
                                setImagemCriatura(getOrientacao());
                                break;
                            }
                            if (this.y > 3) {
                                this.y -= 4;
                                kmPercorrido += 4;
                                confereContemTesouro(this, this.x, this.y);
                            } else {
                                setOrientacao("Este");
                                setImagemCriatura(getOrientacao());
                            }
                            break;

                        case "Sul":
                            if (confereContemBuraco(this.x, this.y + 1) || confereContemBuraco(this.x, this.y + 2) ||
                                    confereContemBuraco(this.x, this.y + 3) || confereContemBuraco(this.x, this.y + 4)) {
                                setOrientacao("Oeste");
                                setImagemCriatura(getOrientacao());
                                break;
                            }
                            if (confereContemCreature(this.x, this.y + 1) || confereContemCreature(this.x, this.y + 2) ||
                                    confereContemCreature(this.x, this.y + 3) || confereContemCreature(this.x, this.y + 4)) {
                                setOrientacao("Oeste");
                                setImagemCriatura(getOrientacao());
                                break;
                            }
                            if (this.y < FandeisiaGameManager.getROWS() - 4) {
                                this.y += 4;
                                kmPercorrido += 4;
                                confereContemTesouro(this, this.x, this.y);
                            } else {
                                setOrientacao("Oeste");
                                setImagemCriatura(getOrientacao());
                            }
                            break;

                        case "Este":
                            if (confereContemBuraco(this.x + 1, this.y) || confereContemBuraco(this.x + 2, this.y) ||
                                    confereContemBuraco(this.x + 3, this.y) || confereContemBuraco(this.x + 4, this.y)) {
                                setOrientacao("Sul");
                                setImagemCriatura(getOrientacao());
                                break;
                            }
                            if (confereContemCreature(this.x + 1, this.y) || confereContemCreature(this.x + 2, this.y) ||
                                    confereContemCreature(this.x + 3, this.y) || confereContemCreature(this.x + 4, this.y)) {
                                setOrientacao("Sul");
                                setImagemCriatura(getOrientacao());
                                break;
                            }
                            if (this.x < FandeisiaGameManager.getCOLUMNS() - 4) {
                                this.x += 4;
                                kmPercorrido += 4;
                                confereContemTesouro(this, this.x, this.y);
                            } else {
                                setOrientacao("Sul");
                                setImagemCriatura(getOrientacao());
                            }
                            break;

                        case "Oeste":
                            if (confereContemBuraco(this.x - 1, this.y) || confereContemBuraco(this.x - 2, this.y) ||
                                    confereContemBuraco(this.x - 3, this.y) || confereContemBuraco(this.x - 4, this.y)) {
                                setOrientacao("Norte");
                                setImagemCriatura(getOrientacao());
                                break;
                            }
                            if (confereContemCreature(this.x - 1, this.y) || confereContemCreature(this.x - 2, this.y) ||
                                    confereContemCreature(this.x - 3, this.y) || confereContemCreature(this.x - 4, this.y)) {
                                setOrientacao("Norte");
                                setImagemCriatura(getOrientacao());
                                break;
                            }
                            if (this.x > 3) {
                                this.x -= 4;
                                kmPercorrido += 4;
                                confereContemTesouro(this, this.x, this.y);
                            } else {
                                setOrientacao("Norte");
                                setImagemCriatura(getOrientacao());
                            }
                            break;
                    }
                }
                break;
            case "Gigante":
                if (!estaCongelado) {
                    switch (orientacao) {
                        case "Norte":
                            if (confereContemBuraco(this.x, this.y - 6)) {
                                setOrientacao("Este");
                                setImagemCriatura(getOrientacao());
                                break;
                            }
                            if (confereContemCreature(this.x, this.y - 6)) {
                                setOrientacao("Este");
                                setImagemCriatura(getOrientacao());
                                break;
                            }
                            if (confereContemGigante(this.x, this.y - 1) || confereContemGigante(this.x, this.y - 2) || confereContemGigante(this.x, this.y - 3) ||
                                    confereContemGigante(this.x, this.y - 4) || confereContemGigante(this.x, this.y - 5)) {
                                setOrientacao("Este");
                                setImagemCriatura(getOrientacao());
                                break;
                            }
                            if (this.y > 5) {
                                this.y -= 6;
                                kmPercorrido += 6;
                                confereContemTesouro(this, this.x, this.y);
                            } else {
                                setOrientacao("Este");
                                setImagemCriatura(getOrientacao());
                            }
                            break;

                        case "Sul":
                            if (confereContemBuraco(this.x, this.y + 6)) {
                                setOrientacao("Oeste");
                                setImagemCriatura(getOrientacao());
                                break;
                            }
                            if (confereContemCreature(this.x, this.y + 6)) {
                                setOrientacao("Oeste");
                                setImagemCriatura(getOrientacao());
                                break;
                            }
                            if (confereContemGigante(this.x, this.y + 1) || confereContemGigante(this.x, this.y + 2) || confereContemGigante(this.x, this.y + 3) ||
                                    confereContemGigante(this.x, this.y + 4) || confereContemGigante(this.x, this.y + 5)) {
                                setOrientacao("Oeste");
                                setImagemCriatura(getOrientacao());
                                break;
                            }
                            if (this.y < FandeisiaGameManager.getROWS() - 6) {
                                this.y += 6;
                                kmPercorrido += 6;
                                confereContemTesouro(this, this.x, this.y);
                            } else {
                                setOrientacao("Oeste");
                                setImagemCriatura(getOrientacao());
                            }
                            break;

                        case "Este":
                            if (confereContemBuraco(this.x + 6, this.y)) {
                                setOrientacao("Sul");
                                setImagemCriatura(getOrientacao());
                                break;
                            }
                            if (confereContemCreature(this.x + 6, this.y)) {
                                setOrientacao("Sul");
                                setImagemCriatura(getOrientacao());
                                break;
                            }
                            if (confereContemGigante(this.x + 1, this.y) || confereContemGigante(this.x + 2, this.y) || confereContemGigante(this.x + 3, this.y) ||
                                    confereContemGigante(this.x + 4, this.y) || confereContemGigante(this.x + 5, this.y)) {
                                setOrientacao("Sul");
                                setImagemCriatura(getOrientacao());
                                break;
                            }
                            if (this.x < FandeisiaGameManager.getCOLUMNS() - 6) {
                                this.x += 6;
                                kmPercorrido += 6;
                                confereContemTesouro(this, this.x, this.y);
                            } else {
                                setOrientacao("Sul");
                                setImagemCriatura(getOrientacao());
                            }
                            break;

                        case "Oeste":
                            if (confereContemBuraco(this.x - 6, this.y)) {
                                setOrientacao("Norte");
                                setImagemCriatura(getOrientacao());
                                break;
                            }
                            if (confereContemCreature(this.x - 6, this.y)) {
                                setOrientacao("Norte");
                                setImagemCriatura(getOrientacao());
                                break;
                            }
                            if (confereContemGigante(this.x - 1, this.y) || confereContemGigante(this.x - 2, this.y) || confereContemGigante(this.x - 3, this.y) ||
                                    confereContemGigante(this.x - 4, this.y) || confereContemGigante(this.x - 5, this.y)) {
                                setOrientacao("Norte");
                                setImagemCriatura(getOrientacao());
                                break;
                            }
                            if (this.x > 5) {
                                this.x -= 6;
                                kmPercorrido += 6;
                                confereContemTesouro(this, this.x, this.y);
                            } else {
                                setOrientacao("Norte");
                                setImagemCriatura(getOrientacao());
                            }
                            break;
                    }
                }
                break;
            case "Dragão":
                if (!estaCongelado) {
                    switch (orientacao) {
                        case "Norte":
                            if (confereContemBuraco(this.x, this.y - 6)) {
                                setOrientacao("Nordeste");
                                setImagemCriatura(getOrientacao());
                                break;
                            }
                            if (confereContemCreature(this.x, this.y - 6)) {
                                setOrientacao("Nordeste");
                                setImagemCriatura(getOrientacao());
                                break;
                            }
                            if (this.y > 5) {
                                this.y -= 6;
                                kmPercorrido += 6;
                                confereContemTesouro(this, this.x, this.y);
                            } else {
                                setOrientacao("Nordeste");
                                setImagemCriatura(getOrientacao());
                            }
                            break;
                        case "Nordeste":
                            if (confereContemBuraco(this.x + 6, this.y - 6)) {
                                setOrientacao("Este");
                                setImagemCriatura(getOrientacao());
                                break;
                            }
                            if (confereContemCreature(this.x + 6, this.y - 6)) {
                                setOrientacao("Este");
                                setImagemCriatura(getOrientacao());
                                break;
                            }
                            if (this.x < FandeisiaGameManager.getCOLUMNS() - 6 && this.y > 5) {
                                this.x += 6;
                                this.y -= 6;
                                kmPercorrido += 6;
                                confereContemTesouro(this, this.x, this.y);
                            } else {
                                setOrientacao("Este");
                                setImagemCriatura(getOrientacao());
                            }
                            break;
                        case "Este":
                            if (confereContemBuraco(this.x + 6, this.y)) {
                                setOrientacao("Sudeste");
                                setImagemCriatura(getOrientacao());
                                break;
                            }
                            if (confereContemCreature(this.x + 6, this.y)) {
                                setOrientacao("Sudeste");
                                setImagemCriatura(getOrientacao());
                                break;
                            }
                            if (this.x < FandeisiaGameManager.getCOLUMNS() - 6) {
                                this.x += 6;
                                kmPercorrido += 6;
                                confereContemTesouro(this, this.x, this.y);
                            } else {
                                setOrientacao("Sudeste");
                                setImagemCriatura(getOrientacao());
                            }
                            break;
                        case "Sudeste":
                            if (confereContemBuraco(this.x + 6, this.y + 6)) {
                                setOrientacao("Sul");
                                setImagemCriatura(getOrientacao());
                                break;
                            }
                            if (confereContemCreature(this.x + 6, this.y + 6)) {
                                setOrientacao("Sul");
                                setImagemCriatura(getOrientacao());
                                break;
                            }
                            if (this.x < FandeisiaGameManager.getCOLUMNS() - 6 && this.y < FandeisiaGameManager.getROWS() - 6) {
                                this.x += 6;
                                this.y += 6;
                                kmPercorrido += 6;
                                confereContemTesouro(this, this.x, this.y);
                            } else {
                                setOrientacao("Sul");
                                setImagemCriatura(getOrientacao());
                            }
                            break;
                        case "Sul":
                            if (confereContemBuraco(this.x, this.y + 6)) {
                                setOrientacao("Sudoeste");
                                setImagemCriatura(getOrientacao());
                                break;
                            }
                            if (confereContemCreature(this.x, this.y + 6)) {
                                setOrientacao("Sudoeste");
                                setImagemCriatura(getOrientacao());
                                break;
                            }
                            if (this.y < FandeisiaGameManager.getROWS() - 6) {
                                this.y += 6;
                                kmPercorrido += 6;
                                confereContemTesouro(this, this.x, this.y);
                            } else {
                                setOrientacao("Sudoeste");
                                setImagemCriatura(getOrientacao());
                            }
                            break;
                        case "Sudoeste":
                            if (confereContemBuraco(this.x - 6, this.y + 6)) {
                                setOrientacao("Oeste");
                                setImagemCriatura(getOrientacao());
                                break;
                            }
                            if (confereContemCreature(this.x - 6, this.y + 6)) {
                                setOrientacao("Oeste");
                                setImagemCriatura(getOrientacao());
                                break;
                            }
                            if (this.x > 5 && this.y < FandeisiaGameManager.getROWS() - 6) {
                                this.x -= 6;
                                this.y += 6;
                                kmPercorrido += 6;
                                confereContemTesouro(this, this.x, this.y);
                            } else {
                                setOrientacao("Oeste");
                                setImagemCriatura(getOrientacao());
                            }
                            break;
                        case "Oeste":
                            if (confereContemBuraco(this.x - 6, this.y)) {
                                setOrientacao("Noroeste");
                                setImagemCriatura(getOrientacao());
                                break;
                            }
                            if (confereContemCreature(this.x - 6, this.y)) {
                                setOrientacao("Noroeste");
                                setImagemCriatura(getOrientacao());
                                break;
                            }
                            if (this.x > 5) {
                                this.x -= 6;
                                kmPercorrido += 6;
                                confereContemTesouro(this, this.x, this.y);
                            } else {
                                setOrientacao("Noroeste");
                                setImagemCriatura(getOrientacao());
                            }
                            break;
                        case "Noroeste":
                            if (confereContemBuraco(this.x - 6, this.y - 6)) {
                                setOrientacao("Norte");
                                setImagemCriatura(getOrientacao());
                                break;
                            }
                            if (confereContemCreature(this.x - 6, this.y - 6)) {
                                setOrientacao("Norte");
                                setImagemCriatura(getOrientacao());
                                break;
                            }
                            if (this.x > 5 && this.y > 5) {
                                this.x -= 6;
                                this.y -= 6;
                                kmPercorrido += 6;
                                confereContemTesouro(this, this.x, this.y);
                            } else {
                                setOrientacao("Norte");
                                setImagemCriatura(getOrientacao());
                            }
                            break;
                    }
                }
                break;
            case "Elfo":
                if (!estaCongelado) {
                    switch (orientacao) {
                        case "Norte":
                            if (confereContemBuraco(this.x, this.y - 4)) {
                                setOrientacao("Nordeste");
                                setImagemCriatura(getOrientacao());
                                break;
                            }
                            if (confereContemCreature(this.x, this.y - 1) || confereContemCreature(this.x, this.y - 2) ||
                                    confereContemCreature(this.x, this.y - 3) || confereContemCreature(this.x, this.y - 4)) {
                                setOrientacao("Nordeste");
                                setImagemCriatura(getOrientacao());
                                break;
                            }
                            if (this.y > 3) {
                                this.y -= 4;
                                kmPercorrido += 4;
                                confereContemTesouro(this, this.x, this.y);
                            } else {
                                setOrientacao("Nordeste");
                                setImagemCriatura(getOrientacao());
                            }
                            break;

                        case "Nordeste":
                            if (confereContemBuraco(this.x + 4, this.y - 4)) {
                                setOrientacao("Este");
                                setImagemCriatura(getOrientacao());
                                break;
                            }
                            if (confereContemCreature(this.x + 1, this.y - 1) || confereContemCreature(this.x + 2, this.y - 2) ||
                                    confereContemCreature(this.x + 3, this.y - 3) || confereContemCreature(this.x + 4, this.y - 4)) {
                                setOrientacao("Este");
                                setImagemCriatura(getOrientacao());
                                break;
                            }
                            if (this.x < FandeisiaGameManager.getCOLUMNS() - 4 && this.y > 3) {
                                this.x += 4;
                                this.y -= 4;
                                kmPercorrido += 4;
                                confereContemTesouro(this, this.x, this.y);
                            } else {
                                setOrientacao("Este");
                                setImagemCriatura(getOrientacao());
                            }
                            break;

                        case "Noroeste":
                            if (confereContemBuraco(this.x - 4, this.y - 4)) {
                                setOrientacao("Norte");
                                setImagemCriatura(getOrientacao());
                                break;
                            }
                            if (confereContemCreature(this.x - 1, this.y - 1) || confereContemCreature(this.x - 2, this.y - 2) ||
                                    confereContemCreature(this.x - 3, this.y - 3) || confereContemCreature(this.x - 4, this.y - 4)) {
                                setOrientacao("Norte");
                                setImagemCriatura(getOrientacao());
                                break;
                            }
                            if (this.x > 3 && this.y > 3) {
                                this.x -= 4;
                                this.y -= 4;
                                kmPercorrido += 4;
                                confereContemTesouro(this, this.x, this.y);
                            } else {
                                setOrientacao("Norte");
                                setImagemCriatura(getOrientacao());
                            }
                            break;

                        case "Sul":
                            if (confereContemBuraco(this.x, this.y + 4)) {
                                setOrientacao("Sudoeste");
                                setImagemCriatura(getOrientacao());
                                break;
                            }
                            if (confereContemCreature(this.x, this.y + 1) || confereContemCreature(this.x, this.y + 2) ||
                                    confereContemCreature(this.x, this.y + 3) || confereContemCreature(this.x, this.y + 4)) {
                                setOrientacao("Sudoeste");
                                setImagemCriatura(getOrientacao());
                                break;
                            }
                            if (this.y < FandeisiaGameManager.getROWS() - 4) {
                                this.y += 4;
                                kmPercorrido += 4;
                                confereContemTesouro(this, this.x, this.y);
                            } else {
                                setOrientacao("Sudoeste");
                                setImagemCriatura(getOrientacao());
                            }
                            break;

                        case "Sudoeste":
                            if (confereContemBuraco(this.x - 4, this.y + 4)) {
                                setOrientacao("Oeste");
                                setImagemCriatura(getOrientacao());
                                break;
                            }
                            if (confereContemCreature(this.x - 1, this.y + 1) || confereContemCreature(this.x - 2, this.y + 2) ||
                                    confereContemCreature(this.x - 3, this.y + 3) || confereContemCreature(this.x - 4, this.y + 4)) {
                                setOrientacao("Oeste");
                                setImagemCriatura(getOrientacao());
                                break;
                            }
                            if (this.x > 3 && this.y < FandeisiaGameManager.getROWS() - 4) {
                                this.x -= 4;
                                this.y += 4;
                                kmPercorrido += 4;
                                confereContemTesouro(this, this.x, this.y);
                            } else {
                                setOrientacao("Oeste");
                                setImagemCriatura(getOrientacao());
                            }
                            break;

                        case "Sudeste":
                            if (confereContemBuraco(this.x + 4, this.y + 4)) {
                                setOrientacao("Sul");
                                setImagemCriatura(getOrientacao());
                                break;
                            }
                            if (confereContemCreature(this.x + 1, this.y + 1) || confereContemCreature(this.x + 2, this.y + 2) ||
                                    confereContemCreature(this.x + 3, this.y + 3) || confereContemCreature(this.x + 4, this.y + 4)) {
                                setOrientacao("Sul");
                                setImagemCriatura(getOrientacao());
                                break;
                            }
                            if (this.x < FandeisiaGameManager.getCOLUMNS() - 4 && this.y < FandeisiaGameManager.getROWS() - 4) {
                                this.x += 4;
                                this.y += 4;
                                kmPercorrido += 4;
                                confereContemTesouro(this, this.x, this.y);
                            } else {
                                setOrientacao("Sul");
                                setImagemCriatura(getOrientacao());
                            }
                            break;

                        case "Oeste":
                            if (confereContemBuraco(this.x - 4, this.y)) {
                                setOrientacao("Noroeste");
                                setImagemCriatura(getOrientacao());
                                break;
                            }
                            if (confereContemCreature(this.x - 1, this.y) || confereContemCreature(this.x - 2, this.y) ||
                                    confereContemCreature(this.x - 3, this.y) || confereContemCreature(this.x - 4, this.y)) {
                                setOrientacao("Noroeste");
                                setImagemCriatura(getOrientacao());
                                break;
                            }
                            if (this.x > 3) {
                                this.x -= 4;
                                kmPercorrido += 4;
                                confereContemTesouro(this, this.x, this.y);
                            } else {
                                setOrientacao("Noroeste");
                                setImagemCriatura(getOrientacao());
                            }
                            break;

                        case "Este":
                            if (confereContemBuraco(this.x + 4, this.y)) {
                                setOrientacao("Sudeste");
                                setImagemCriatura(getOrientacao());
                                break;
                            }
                            if (confereContemCreature(this.x + 1, this.y) || confereContemCreature(this.x + 2, this.y) ||
                                    confereContemCreature(this.x + 3, this.y) || confereContemCreature(this.x + 4, this.y)) {
                                setOrientacao("Sudeste");
                                setImagemCriatura(getOrientacao());
                                break;
                            }
                            if (this.x < FandeisiaGameManager.getCOLUMNS() - 4) {
                                this.x += 4;
                                kmPercorrido += 4;
                                confereContemTesouro(this, this.x, this.y);
                            } else {
                                setOrientacao("Sudeste");
                                setImagemCriatura(getOrientacao());
                            }
                            break;
                    }
                }
                break;
        }
    }

    public abstract void setImagemCriatura(String orientacao);

    public abstract void moveCriatura();

    @Override
    public String toString() {
        return this.id + " | " + this.tipo + " | " + idEquipe + " | " + this.nrTesouros + " @ (" + this.x + ", " + this.y + ") " + this.orientacao;
    }
}
