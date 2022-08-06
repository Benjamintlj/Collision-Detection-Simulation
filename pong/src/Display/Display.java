package Display;

import Controller.Input;
import Game.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Display extends JFrame{

    private Canvas canvas;
    private Renderer renderer;

    public Display(int width, int height, Input input) {
        setTitle("P O N G");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        renderer = new Renderer();

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setFocusable(false);
        add(canvas);
        addKeyListener(input);
        pack();

        canvas.createBufferStrategy(3);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void render(Game game) {
        BufferStrategy bufferStrategy = canvas.getBufferStrategy();
        Graphics graphics = bufferStrategy.getDrawGraphics();

        // background
        graphics.setColor(Color.black);
        graphics.fillRect(0,0, canvas.getWidth(), canvas.getHeight());

        renderer.render(game, graphics);

        graphics.dispose();
        bufferStrategy.show();
    }
}
