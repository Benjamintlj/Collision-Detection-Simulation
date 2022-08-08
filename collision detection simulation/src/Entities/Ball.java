package Entities;

import Display.Display;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Ball extends GameObject {

    private double velocityX;
    private double velocityY;

    private double positionX;
    private double positionY;

    private double centerX;
    private double centerY;

    private final double accelerationX;
    private final double accelerationY;

    private final double mass;

    private int timeInWall;


    public Ball(int diameter, int spawnCenterX, int spawnCenterY, double velocityX, double velocityY, double accelerationX, double accelerationY, double mass) {
        super(diameter, spawnCenterX, spawnCenterY);

        this.velocityX = velocityX;
        this.velocityY = velocityY;

        this.positionX = getPosition().getX();
        this.positionY = getPosition().getY();

        this.centerX = spawnCenterX;
        this.centerY = spawnCenterY;

        this.accelerationX = accelerationX;
        this.accelerationY = accelerationY;

        this.mass = mass;

        this.timeInWall = 0;
    }

    /**
     * Updates all factors of the ball.
     * @param display used to get the display dimensions.
     */
    @Override
    public void update(Display display) {
        updateVectors();
        wallIntersection(display);
    }

    /**
     * Updates all vectors related to the ball.
     */
    public void updateVectors() {
        velocityX = velocityX + accelerationX;
        velocityY = velocityY + accelerationY;

        positionX = positionX + velocityX;
        positionY = positionY + velocityY;

        centerX = positionX + radius;
        centerY = positionY + radius;

        position.setX((int) positionX);
        position.setY((int) positionY);
    }

    /**
     * Check to see if the ball has collided with the wall.
     * @param display used to get display dimensions.
     */
    private void wallIntersection(Display display) {

        // hit bottom
        if ( centerY + radius > display.getHeight() - display.getWindowBorderSize()) {
            velocityY += accelerationY;
            velocityY *= -1;

            timeInWall += 1;
            if (timeInWall > 1) {
                timeInWall = 0;
                velocityY = Math.abs(velocityY) * -1;
                updateVectors();
            }
        }

        // hit top
        if (centerY - radius < 0) {
            velocityY *= -1;
            velocityY -= accelerationY;

            timeInWall += 1;
            if (timeInWall > 1) {
                timeInWall = 0;
                velocityY= Math.abs(velocityY);
                updateVectors();
            }
        }

        // hit left
        if (centerX - radius < 0) {
            velocityX *= -1;
            velocityX -= accelerationX;

            timeInWall += 1;
            if (timeInWall > 1) {
                timeInWall = 0;
                velocityX = Math.abs(velocityX);
                updateVectors();
            }
        }

        // hit right
        if (centerX + radius > display.getWidth()) {
            velocityX += accelerationX;
            velocityX *= -1;

            timeInWall += 1;
            if (timeInWall > 1) {
                timeInWall = 0;
                velocityX = Math.abs(velocityX) * -1;
                updateVectors();
            }
        }

    }


    /**
     * How the ball is rendered.
     *
     * Needs improvement:
     *  - When ball images overlap front ball covers/hides the ball behind it.
     *
     * @return returns an image of the ball.
     */
    @Override
    public Image getSprite() {
        BufferedImage image = new BufferedImage(size.getRadius(), size.getRadius(), BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();

        graphics.setColor(Color.WHITE);
        graphics.drawOval(0,0, size.getRadius(), size.getRadius());

        graphics.dispose();
        return image;
    }

    /**
     * @return the x value of the center of the ball.
     */
    public double getCenterX() {
        return centerX;
    }

    /**
     * @return the y value of the center of the ball.
     */
    public double getCenterY() {
        return centerY;
    }

    /**
     * @return the x velocity.
     */
    public double getVelocityX() {
        return velocityX;
    }

    /**
     * @param velocityX new x velocity.
     */
    public void setVelocityX(double velocityX) {
        this.velocityX = velocityX;
    }

    /**
     * @return the y velocity.
     */
    public double getVelocityY() {
        return velocityY;
    }

    /**
     * @param velocityY new y velocity.
     */
    public void setVelocityY(double velocityY) {
        this.velocityY = velocityY;
    }

    /**
     * @return mass of ball.
     */
    public double getMass() {
        return mass;
    }
}
