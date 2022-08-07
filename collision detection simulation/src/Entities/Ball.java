package Entities;

import Display.Display;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.math.BigDecimal;

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
    }

    @Override
    public void update(Display display) {
        updateVectors();
        wallIntersection(display);
    }

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

    private void wallIntersection(Display display) {

        // hit bottom
        if ( centerY + radius > display.getHeight() - display.getWindowBorderSize()) {
            velocityY += accelerationY;
            velocityY *= -1;
        }

        // hit top
        if (centerY - radius < 0) {
            velocityY *= -1;
            velocityY -= accelerationY;
        }

        // hit left
        if (centerX - radius < 0) {
            velocityX *= -1;
            velocityX -= accelerationX;
        }

        // hit right
        if (centerX + radius > display.getWidth()) {
            velocityX += accelerationX;
            velocityX *= -1;
        }

    }


    @Override
    public Image getSprite() {
        BufferedImage image = new BufferedImage(size.getRadius(), size.getRadius(), BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();

        graphics.setColor(Color.WHITE);
        graphics.drawOval(0,0, size.getRadius(), size.getRadius());

        graphics.dispose();
        return image;
    }

    public double getCenterX() {
        return centerX;
    }

    public double getCenterY() {
        return centerY;
    }


    public double getVelocityX() {
        return velocityX;
    }

    public void setVelocityX(double velocityX) {
        this.velocityX = velocityX;
    }

    public double getVelocityY() {
        return velocityY;
    }

    public void setVelocityY(double velocityY) {
        this.velocityY = velocityY;
    }

    public double getMass() {
        return mass;
    }
}
