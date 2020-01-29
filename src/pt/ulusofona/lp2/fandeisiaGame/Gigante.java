package pt.ulusofona.lp2.fandeisiaGame;

import static pt.ulusofona.lp2.fandeisiaGame.FandeisiaGameManager.*;

public class Gigante extends Creature {
    public Gigante(int id, String tipo, int idEquipa, int x, int y, String orientacao) {
        super(id, tipo, idEquipa, x, y, orientacao);
        setImagemCriatura(this.orientacao);
        this.custo = 5;
    }

    @Override
    public void setImagemCriatura(String orientacao) {
        if (this.idEquipe == 10) {
            switch (orientacao) {
                case "Norte":
                    imagemCriatura = "rainha_n.png";
                    break;
                case "Sul":
                    imagemCriatura = "rainha_s.png";
                    break;
                case "Oeste":
                    imagemCriatura = "rainha_o.png";
                    break;
                case "Este":
                    imagemCriatura = "rainha_e.png";
                    break;
            }
        } else {
            switch (orientacao) {
                case "Norte":
                    imagemCriatura = "g_n.png";
                    break;
                case "Sul":
                    imagemCriatura = "g_s.png";
                    break;
                case "Oeste":
                    imagemCriatura = "g_o.png";
                    break;
                case "Este":
                    imagemCriatura = "g_e.png";
                    break;
            }
        }
    }

    @Override
    public void moveCriatura() {
        if (!estaCongelado) {
            switch (orientacao) {
                case "Norte":
                    if (confereContemBuraco(this.x, this.y - 3)) {
                        setOrientacao("Este");
                        setImagemCriatura(getOrientacao());
                        break;
                    }
                    if (confereContemCreature(this.x, this.y - 3)) {
                        setOrientacao("Este");
                        setImagemCriatura(getOrientacao());
                        break;
                    }
                    if (confereContemGigante(this.x, this.y - 1) || confereContemGigante(this.x, this.y - 2)) {
                        setOrientacao("Este");
                        setImagemCriatura(getOrientacao());
                        break;
                    }
                    if (this.y > 2) {
                        this.y -= 3;
                        kmPercorrido += 3;
                        confereContemTesouro(this, this.x, this.y);
                    } else {
                        setOrientacao("Este");
                        setImagemCriatura(getOrientacao());
                    }
                    break;

                case "Sul":
                    if (confereContemBuraco(this.x, this.y + 3)) {
                        setOrientacao("Oeste");
                        setImagemCriatura(getOrientacao());
                        break;
                    }
                    if (confereContemCreature(this.x, this.y + 3)) {
                        setOrientacao("Oeste");
                        setImagemCriatura(getOrientacao());
                        break;
                    }
                    if (confereContemGigante(this.x, this.y + 1) || confereContemGigante(this.x, this.y + 2)) {
                        setOrientacao("Oeste");
                        setImagemCriatura(getOrientacao());
                        break;
                    }
                    if (this.y < FandeisiaGameManager.getROWS() - 3) {
                        this.y += 3;
                        kmPercorrido += 3;
                        confereContemTesouro(this, this.x, this.y);
                    } else {
                        setOrientacao("Oeste");
                        setImagemCriatura(getOrientacao());
                    }
                    break;

                case "Este":
                    if (confereContemBuraco(this.x + 3, this.y)) {
                        setOrientacao("Sul");
                        setImagemCriatura(getOrientacao());
                        break;
                    }
                    if (confereContemCreature(this.x + 3, this.y)) {
                        setOrientacao("Sul");
                        setImagemCriatura(getOrientacao());
                        break;
                    }
                    if (confereContemGigante(this.x + 1, this.y) || confereContemGigante(this.x + 2, this.y)) {
                        setOrientacao("Sul");
                        setImagemCriatura(getOrientacao());
                        break;
                    }
                    if (this.x < FandeisiaGameManager.getCOLUMNS() - 3) {
                        this.x += 3;
                        kmPercorrido += 3;
                        confereContemTesouro(this, this.x, this.y);
                    } else {
                        setOrientacao("Sul");
                        setImagemCriatura(getOrientacao());
                    }
                    break;

                case "Oeste":
                    if (confereContemBuraco(this.x - 3, this.y)) {
                        setOrientacao("Norte");
                        setImagemCriatura(getOrientacao());
                        break;
                    }
                    if (confereContemCreature(this.x - 3, this.y)) {
                        setOrientacao("Norte");
                        setImagemCriatura(getOrientacao());
                        break;
                    }
                    if (confereContemGigante(this.x - 1, this.y) || confereContemGigante(this.x - 2, this.y)) {
                        setOrientacao("Norte");
                        setImagemCriatura(getOrientacao());
                        break;
                    }
                    if (this.x > 2) {
                        this.x -= 3;
                        kmPercorrido += 3;
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
