package Entities;

import Controller.Controller;
import Entities.GameObject;
import Controller.Input;
import Controller.PlayerController;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Square extends GameObject {

    private Controller controller;
    private final int speed;

    public Square(Input input) {
        this.controller = new PlayerController(input);
        this.speed = 1;
    }

    @Override
    public void update() {
        int deltaX = 0;
        int deltaY = 0;

        if(controller.isRequestingUp()) deltaY -= speed;
        if(controller.isRequestingDown()) deltaY += speed;
        if(controller.isRequestingLeft()) deltaX -= speed;
        if(controller.isRequestingRight()) deltaX += speed;

        position = new Position(position.getX() + deltaX, position.getY() + deltaY);
    }

    @Override
    public Image getSprite() {
        BufferedImage image = new BufferedImage(size.getWidth(), size.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();

        graphics.setColor(Color.BLUE);
        graphics.fillRect(0, 0, size.getWidth(), size.getHeight());

        graphics.dispose();
        return image;
    }
}
