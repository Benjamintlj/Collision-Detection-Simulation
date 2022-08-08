package Entities;

import Display.Display;

import java.awt.*;

public abstract class GameObject {

    protected Position position;
    protected Size size;

    protected int diameter;
    protected int radius;

    /**
     * @param diameter diameter of object
     * @param spawnCenterX where the center x of the object will spawn
     * @param spawnCenterY where the center y of the object will spawn
     */
    public GameObject (int diameter, int spawnCenterX, int spawnCenterY) {
        position = new Position(
                (spawnCenterX - diameter / 2),
                (spawnCenterY - diameter / 2)
        );

        size = new Size(diameter);

        this.diameter = diameter;
        this.radius = diameter / 2;
    }

    /**
     * Should update object stats
     * @param display
     */
    public abstract void update(Display display);

    /**
     * @return an image of the object.
     */
    public abstract Image getSprite();

    /**
     * @return position on display.
     */
    public Position getPosition() {
        return position;
    }

    /**
     * @return size of the object.
     */
    public Size getSize() {
        return size;
    }

    /**
     * @return radius of the object.
     */
    public int getRadius() {
        return radius;
    }
}
