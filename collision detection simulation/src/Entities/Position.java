package Entities;

public class Position {

    private int x;
    private int y;

    /**
     * @param x position on display.
     * @param y position on display.
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }


    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
