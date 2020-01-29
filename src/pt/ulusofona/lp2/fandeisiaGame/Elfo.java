package pt.ulusofona.lp2.fandeisiaGame;

import static pt.ulusofona.lp2.fandeisiaGame.FandeisiaGameManager.*;

public class Elfo extends Creature {
    public Elfo(int id, String tipo, int idEquipa, int x, int y, String orientacao) {
        super(id, tipo, idEquipa, x, y, orientacao);
        setImagemCriatura(this.orientacao);
        this.custo = 5;
    }

    @Override
    public void setImagemCriatura(String orientacao) {
        if (this.idEquipe == 10) {
            switch (orientacao) {
                case "Norte":
                    imagemCriatura = "chapeleiro_n.png";
                    break;
                case "Sul":
                    imagemCriatura = "chapeleiro_s.png";
                    break;
                case "Oeste":
                    imagemCriatura = "chapeleiro_o.png";
                    break;
                case "Este":
                    imagemCriatura = "chapeleiro_e.png";
                    break;
                case "Nordeste":
                    imagemCriatura = "chapeleiro_ne.png";
                    break;
                case "Noroeste":
                    imagemCriatura = "chapeleiro_no.png";
                    break;
                case "Sudeste":
                    imagemCriatura = "chapeleiro_se.png";
                    break;
                case "Sudoeste":
                    imagemCriatura = "chapeleiro_so.png";
                    break;
            }
        } else {
            switch (orientacao) {
                case "Norte":
                    imagemCriatura = "e_n.png";
                    break;
                case "Sul":
                    imagemCriatura = "e_s.png";
                    break;
                case "Oeste":
                    imagemCriatura = "e_o.png";
                    break;
                case "Este":
                    imagemCriatura = "e_e.png";
                    break;
                case "Nordeste":
                    imagemCriatura = "e_ne.png";
                    break;
                case "Noroeste":
                    imagemCriatura = "e_no.png";
                    break;
                case "Sudeste":
                    imagemCriatura = "e_se.png";
                    break;
                case "Sudoeste":
                    imagemCriatura = "e_so.png";
                    break;
            }
        }
    }

    @Override
    public void moveCriatura() {
        if (!estaCongelado) {
            switch (orientacao) {
                case "Norte":
                    if (confereContemBuraco(this.x, this.y - 2)) {
                        setOrientacao("Nordeste");
                        setImagemCriatura(getOrientacao());
                        break;
                    }
                    if (confereContemCreature(this.x, this.y - 1) || confereContemCreature(this.x, this.y - 2)) {
                        setOrientacao("Nordeste");
                        setImagemCriatura(getOrientacao());
                        break;
                    }
                    if (this.y > 1) {
                        this.y -= 2;
                        kmPercorrido += 2;
                        confereContemTesouro(this, this.x, this.y);
                    } else {
                        setOrientacao("Nordeste");
                        setImagemCriatura(getOrientacao());
                    }
                    break;

                case "Nordeste":
                    if (confereContemBuraco(this.x + 2, this.y - 2)) {
                        setOrientacao("Este");
                        setImagemCriatura(getOrientacao());
                        break;
                    }
                    if (confereContemCreature(this.x + 1, this.y - 1) || confereContemCreature(this.x + 2, this.y - 2)) {
                        setOrientacao("Este");
                        setImagemCriatura(getOrientacao());
                        break;
                    }
                    if (this.x < FandeisiaGameManager.getCOLUMNS() - 2 && this.y > 1) {
                        this.x += 2;
                        this.y -= 2;
                        kmPercorrido += 2;
                        confereContemTesouro(this, this.x, this.y);
                    } else {
                        setOrientacao("Este");
                        setImagemCriatura(getOrientacao());
                    }
                    break;

                case "Noroeste":
                    if (confereContemBuraco(this.x - 2, this.y - 2)) {
                        setOrientacao("Norte");
                        setImagemCriatura(getOrientacao());
                        break;
                    }
                    if (confereContemCreature(this.x - 1, this.y - 1) || confereContemCreature(this.x - 2, this.y - 2)) {
                        setOrientacao("Norte");
                        setImagemCriatura(getOrientacao());
                        break;
                    }
                    if (this.x > 1 && this.y > 1) {
                        this.x -= 2;
                        this.y -= 2;
                        kmPercorrido += 2;
                        confereContemTesouro(this, this.x, this.y);
                    } else {
                        setOrientacao("Norte");
                        setImagemCriatura(getOrientacao());
                    }
                    break;

                case "Sul":
                    if (confereContemBuraco(this.x, this.y + 2)) {
                        setOrientacao("Sudoeste");
                        setImagemCriatura(getOrientacao());
                        break;
                    }
                    if (confereContemCreature(this.x, this.y + 1) || confereContemCreature(this.x, this.y + 2)) {
                        setOrientacao("Sudoeste");
                        setImagemCriatura(getOrientacao());
                        break;
                    }
                    if (this.y < FandeisiaGameManager.getROWS() - 2) {
                        this.y += 2;
                        kmPercorrido += 2;
                        confereContemTesouro(this, this.x, this.y);
                    } else {
                        setOrientacao("Sudoeste");
                        setImagemCriatura(getOrientacao());
                    }
                    break;

                case "Sudoeste":
                    if (confereContemBuraco(this.x - 2, this.y + 2)) {
                        setOrientacao("Oeste");
                        setImagemCriatura(getOrientacao());
                        break;
                    }
                    if (confereContemCreature(this.x - 1, this.y + 1) || confereContemCreature(this.x - 2, this.y + 2)) {
                        setOrientacao("Oeste");
                        setImagemCriatura(getOrientacao());
                        break;
                    }
                    if (this.x > 1 && this.y < FandeisiaGameManager.getROWS() - 2) {
                        this.x -= 2;
                        this.y += 2;
                        kmPercorrido += 2;
                        confereContemTesouro(this, this.x, this.y);
                    } else {
                        setOrientacao("Oeste");
                        setImagemCriatura(getOrientacao());
                    }
                    break;

                case "Sudeste":
                    if (confereContemBuraco(this.x + 2, this.y + 2)) {
                        setOrientacao("Sul");
                        setImagemCriatura(getOrientacao());
                        break;
                    }
                    if (confereContemCreature(this.x + 1, this.y + 1) || confereContemCreature(this.x + 2, this.y + 2)) {
                        setOrientacao("Sul");
                        setImagemCriatura(getOrientacao());
                        break;
                    }
                    if (this.x < FandeisiaGameManager.getCOLUMNS() - 2 && this.y < FandeisiaGameManager.getROWS() - 2) {
                        this.x += 2;
                        this.y += 2;
                        kmPercorrido += 2;
                        confereContemTesouro(this, this.x, this.y);
                    } else {
                        setOrientacao("Sul");
                        setImagemCriatura(getOrientacao());
                    }
                    break;

                case "Oeste":
                    if (confereContemBuraco(this.x - 2, this.y)) {
                        setOrientacao("Noroeste");
                        setImagemCriatura(getOrientacao());
                        break;
                    }
                    if (confereContemCreature(this.x - 1, this.y) || confereContemCreature(this.x - 2, this.y)) {
                        setOrientacao("Noroeste");
                        setImagemCriatura(getOrientacao());
                        break;
                    }
                    if (this.x > 1) {
                        this.x -= 2;
                        kmPercorrido += 2;
                        confereContemTesouro(this, this.x, this.y);
                    } else {
                        setOrientacao("Noroeste");
                        setImagemCriatura(getOrientacao());
                    }
                    break;

                case "Este":
                    if (confereContemBuraco(this.x + 2, this.y)) {
                        setOrientacao("Sudeste");
                        setImagemCriatura(getOrientacao());
                        break;
                    }
                    if (confereContemCreature(this.x + 1, this.y) || confereContemCreature(this.x + 2, this.y)) {
                        setOrientacao("Sudeste");
                        setImagemCriatura(getOrientacao());
                        break;
                    }
                    if (this.x < FandeisiaGameManager.getCOLUMNS() - 2) {
                        this.x += 2;
                        kmPercorrido += 2;
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
