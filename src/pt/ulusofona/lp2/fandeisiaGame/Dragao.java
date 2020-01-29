package pt.ulusofona.lp2.fandeisiaGame;

import static pt.ulusofona.lp2.fandeisiaGame.FandeisiaGameManager.*;

public class Dragao extends Creature {
    public Dragao(int id, String tipo, int idEquipa, int x, int y, String orientacao) {
        super(id, tipo, idEquipa, x, y, orientacao);
        setImagemCriatura(this.orientacao);
        this.custo = 9;
    }

    @Override
    public void setImagemCriatura(String orientacao) {
        if (this.idEquipe == 10) {
            switch (orientacao) {
                case "Norte":
                    imagemCriatura = "gato_n.png";
                    break;
                case "Sul":
                    imagemCriatura = "gato_s.png";
                    break;
                case "Oeste":
                    imagemCriatura = "gato_o.png";
                    break;
                case "Este":
                    imagemCriatura = "gato_e.png";
                    break;
                case "Nordeste":
                    imagemCriatura = "gato_ne.png";
                    break;
                case "Noroeste":
                    imagemCriatura = "gato_no.png";
                    break;
                case "Sudeste":
                    imagemCriatura = "gato_se.png";
                    break;
                case "Sudoeste":
                    imagemCriatura = "gato_so.png";
                    break;
            }
        } else {
            switch (orientacao) {
                case "Norte":
                    imagemCriatura = "d_n.png";
                    break;
                case "Sul":
                    imagemCriatura = "d_s.png";
                    break;
                case "Oeste":
                    imagemCriatura = "d_o.png";
                    break;
                case "Este":
                    imagemCriatura = "d_e.png";
                    break;
                case "Nordeste":
                    imagemCriatura = "d_ne.png";
                    break;
                case "Noroeste":
                    imagemCriatura = "d_no.png";
                    break;
                case "Sudeste":
                    imagemCriatura = "d_se.png";
                    break;
                case "Sudoeste":
                    imagemCriatura = "d_so.png";
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
                        setOrientacao("Nordeste");
                        setImagemCriatura(getOrientacao());
                        break;
                    }
                    if (confereContemCreature(this.x, this.y - 3)) {
                        setOrientacao("Nordeste");
                        setImagemCriatura(getOrientacao());
                        break;
                    }
                    if (this.y > 2) {
                        this.y -= 3;
                        kmPercorrido += 3;
                        confereContemTesouro(this, this.x, this.y);
                    } else {
                        setOrientacao("Nordeste");
                        setImagemCriatura(getOrientacao());
                    }
                    break;
                case "Nordeste":
                    if (confereContemBuraco(this.x + 3, this.y - 3)) {
                        setOrientacao("Este");
                        setImagemCriatura(getOrientacao());
                        break;
                    }
                    if (confereContemCreature(this.x + 3, this.y - 3)) {
                        setOrientacao("Este");
                        setImagemCriatura(getOrientacao());
                        break;
                    }
                    if (this.x < FandeisiaGameManager.getCOLUMNS() - 3 && this.y > 2) {
                        this.x += 3;
                        this.y -= 3;
                        kmPercorrido += 3;
                        confereContemTesouro(this, this.x, this.y);
                    } else {
                        setOrientacao("Este");
                        setImagemCriatura(getOrientacao());
                    }
                    break;
                case "Este":
                    if (confereContemBuraco(this.x + 3, this.y)) {
                        setOrientacao("Sudeste");
                        setImagemCriatura(getOrientacao());
                        break;
                    }
                    if (confereContemCreature(this.x + 3, this.y)) {
                        setOrientacao("Sudeste");
                        setImagemCriatura(getOrientacao());
                        break;
                    }
                    if (this.x < FandeisiaGameManager.getCOLUMNS() - 3) {
                        this.x += 3;
                        kmPercorrido += 3;
                        confereContemTesouro(this, this.x, this.y);
                    } else {
                        setOrientacao("Sudeste");
                        setImagemCriatura(getOrientacao());
                    }
                    break;
                case "Sudeste":
                    if (confereContemBuraco(this.x + 3, this.y + 3)) {
                        setOrientacao("Sul");
                        setImagemCriatura(getOrientacao());
                        break;
                    }
                    if (confereContemCreature(this.x + 3, this.y + 3)) {
                        setOrientacao("Sul");
                        setImagemCriatura(getOrientacao());
                        break;
                    }
                    if (this.x < FandeisiaGameManager.getCOLUMNS() - 3 && this.y < FandeisiaGameManager.getROWS() - 3) {
                        this.x += 3;
                        this.y += 3;
                        kmPercorrido += 3;
                        confereContemTesouro(this, this.x, this.y);
                    } else {
                        setOrientacao("Sul");
                        setImagemCriatura(getOrientacao());
                    }
                    break;
                case "Sul":
                    if (confereContemBuraco(this.x, this.y + 3)) {
                        setOrientacao("Sudoeste");
                        setImagemCriatura(getOrientacao());
                        break;
                    }
                    if (confereContemCreature(this.x, this.y + 3)) {
                        setOrientacao("Sudoeste");
                        setImagemCriatura(getOrientacao());
                        break;
                    }
                    if (this.y < FandeisiaGameManager.getROWS() - 3) {
                        this.y += 3;
                        kmPercorrido += 3;
                        confereContemTesouro(this, this.x, this.y);
                    } else {
                        setOrientacao("Sudoeste");
                        setImagemCriatura(getOrientacao());
                    }
                    break;
                case "Sudoeste":
                    if (confereContemBuraco(this.x - 3, this.y + 3)) {
                        setOrientacao("Oeste");
                        setImagemCriatura(getOrientacao());
                        break;
                    }
                    if (confereContemCreature(this.x - 3, this.y + 3)) {
                        setOrientacao("Oeste");
                        setImagemCriatura(getOrientacao());
                        break;
                    }
                    if (this.x > 2 && this.y < FandeisiaGameManager.getROWS() - 3) {
                        this.x -= 3;
                        this.y += 3;
                        kmPercorrido += 3;
                        confereContemTesouro(this, this.x, this.y);
                    } else {
                        setOrientacao("Oeste");
                        setImagemCriatura(getOrientacao());
                    }
                    break;
                case "Oeste":
                    if (confereContemBuraco(this.x - 3, this.y)) {
                        setOrientacao("Noroeste");
                        setImagemCriatura(getOrientacao());
                        break;
                    }
                    if (confereContemCreature(this.x - 3, this.y)) {
                        setOrientacao("Noroeste");
                        setImagemCriatura(getOrientacao());
                        break;
                    }
                    if (this.x > 2) {
                        this.x -= 3;
                        kmPercorrido += 3;
                        confereContemTesouro(this, this.x, this.y);
                    } else {
                        setOrientacao("Noroeste");
                        setImagemCriatura(getOrientacao());
                    }
                    break;
                case "Noroeste":
                    if (confereContemBuraco(this.x - 3, this.y - 3)) {
                        setOrientacao("Norte");
                        setImagemCriatura(getOrientacao());
                        break;
                    }
                    if (confereContemCreature(this.x - 3, this.y - 3)) {
                        setOrientacao("Norte");
                        setImagemCriatura(getOrientacao());
                        break;
                    }
                    if (this.x > 2 && this.y > 2) {
                        this.x -= 3;
                        this.y -= 3;
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
