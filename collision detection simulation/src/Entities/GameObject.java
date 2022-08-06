package Entities;

import Display.Display;

import java.awt.*;

public abstract class GameObject {

    protected Position position;
    protected Size size;

    protected int diameter;
    protected int radius;

    public GameObject (int diameter, int spawnX, int spawnY) {
        position = new Position(spawnX, spawnY);
        size = new Size(diameter);

        this.diameter = diameter;
        this.radius = diameter / 2;
    }

    public abstract void update(Display display);

    public abstract Image getSprite();

    public Position getPosition() {
        return position;
    }

    public Size getSize() {
        return size;
    }
}
