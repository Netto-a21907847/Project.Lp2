package pt.ulusofona.lp2.fandeisiaGame;

import static pt.ulusofona.lp2.fandeisiaGame.FandeisiaGameManager.*;

public class Anao extends Creature {
    public Anao(int id, String tipo, int idEquipa, int x, int y, String orientacao) {
        super(id, tipo, idEquipa, x, y, orientacao);
        setImagemCriatura(this.orientacao);
        this.custo = 1;
    }

    @Override
    public void setImagemCriatura(String orientacao) {
        if (this.idEquipe == 10) {
            switch (orientacao) {
                case "Norte":
                    imagemCriatura = "lagarta_n.png";
                    break;
                case "Sul":
                    imagemCriatura = "lagarta_s.png";
                    break;
                case "Oeste":
                    imagemCriatura = "lagarta_o.png";
                    break;
                case "Este":
                    imagemCriatura = "lagarta_e.png";
                    break;
            }
        } else {
            switch (orientacao) {
                case "Norte":
                    imagemCriatura = "a_n.png";
                    break;
                case "Sul":
                    imagemCriatura = "a_s.png";
                    break;
                case "Oeste":
                    imagemCriatura = "a_o.png";
                    break;
                case "Este":
                    imagemCriatura = "a_e.png";
                    break;
            }
        }
    }

    @Override
    public void moveCriatura() {
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
                        this.y++;
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
    }

}
