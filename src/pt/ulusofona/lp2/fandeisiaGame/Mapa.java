package pt.ulusofona.lp2.fandeisiaGame;

public abstract class Mapa {

    protected int id;
    protected int x;
    protected int y;

    public Mapa(int iD, int x, int y) {
        this.id = iD;
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getId() {
        return id;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
