package pt.ulusofona.lp2.fandeisiaGame;

import static pt.ulusofona.lp2.fandeisiaGame.FandeisiaGameManager.*;

public class Humano extends Creature {
    public Humano(int id, String tipo, int idEquipa, int x, int y, String orientacao) {
        super(id, tipo, idEquipa, x, y, orientacao);
        setImagemCriatura(this.orientacao);
        this.custo = 3;
    }

    @Override
    public void setImagemCriatura(String orientacao) {
        if (this.idEquipe == 10) {
            switch (orientacao) {
                case "Norte":
                    imagemCriatura = "alice_n.png";
                    break;
                case "Sul":
                    imagemCriatura = "alice_s.png";
                    break;
                case "Oeste":
                    imagemCriatura = "alice_o.png";
                    break;
                case "Este":
                    imagemCriatura = "alice_e.png";
                    break;
            }
        } else {
            switch (orientacao) {
                case "Norte":
                    imagemCriatura = "h_n.png";
                    break;
                case "Sul":
                    imagemCriatura = "h_s.png";
                    break;
                case "Oeste":
                    imagemCriatura = "h_o.png";
                    break;
                case "Este":
                    imagemCriatura = "h_e.png";
                    break;
            }
        }
    }

    @Override
    public void moveCriatura() {
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

    }

}