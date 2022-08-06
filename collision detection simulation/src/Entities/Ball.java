package Entities;

import Display.Display;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.math.BigDecimal;

public class Ball extends GameObject {

    private int velocityX;
    private int velocityY;

    private int positionX;
    private int positionY;

    private int prevPositionX;
    private int prevPositionY;

    private int centerX;
    private int centerY;

    private int accelerationX;
    private int accelerationY;


    public Ball(int diameter, int spawnX, int spawnY, int velocityX, int velocityY, int accelerationX, int accelerationY) {
        super(diameter, spawnX, spawnY);

        this.velocityX = velocityX;
        this.velocityY = velocityY;

        this.positionX = spawnX;
        this.positionY = spawnY;

        this.centerX = positionX + diameter / 2;
        this.centerY = positionY + diameter / 2;

        this.accelerationX = accelerationX;
        this.accelerationY = accelerationY;
    }

    @Override
    public void update(Display display) {
        updateVectors();
        checkIfBallIsStill();
        wallIntersection(display);
    }

    private void updateVectors() {
        velocityX = velocityX + accelerationX;
        velocityY = velocityY + accelerationY;

        System.out.println(velocityY);

        prevPositionX = positionX;
        prevPositionY = positionY;

        positionX = positionX + velocityX;
        positionY = positionY + velocityY;

        centerX = positionX + radius;
        centerY = positionY + radius;

        position.setX(positionX);
        position.setY(positionY);
    }

    private void checkIfBallIsStill() {

//        //System.out.println(prevPositionY + " " + positionY);
//        System.out.println(Math.abs(Math.abs(prevPositionY) - Math.abs(positionY)));
//
//        if (Math.abs(Math.abs(prevPositionY) - Math.abs(positionY)) < 0.3) {
//            positionY = Math.abs(positionY);
//            velocityY = 0;
//        }
//
//        if (Math.abs(prevPositionX) + Math.abs(positionX) < 8) {
//            positionX = Math.abs(positionX);
//            velocityX = 0;
//        }
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

    public void ballIntersection() {

    }

    @Override
    public Image getSprite() {
        BufferedImage image = new BufferedImage(size.getRadius(), size.getRadius(), BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();

        graphics.setColor(Color.WHITE);
        //graphics.fillRect(0, 0, size.getWidth(), size.getHeight());
        graphics.drawOval(0,0, size.getRadius(), size.getRadius());

        graphics.dispose();
        return image;
    }
}
