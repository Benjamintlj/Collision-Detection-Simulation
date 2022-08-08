package Display;

import Controller.Input;
import Game.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Display extends JFrame{

    private Canvas canvas;
    private Renderer renderer;

    private final int windowBorderSize;

    /**
     * Creates the window for the game to be rendered upon.
     * @param width screen width.
     * @param height screen height.
     * @param input input class used to detect user input.
     */
    public Display(int width, int height, Input input) {
        setTitle("B A L L - S I M");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);

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

        this.windowBorderSize = this.getHeight() - height;
    }

    /**
     * Renders the game.
     * @param game game to be rendered.
     */
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

    /**
     * On the device used for testing (Mac OS), the window header takes up space.
     * @return returns the size of the window header.
     */
    public int getWindowBorderSize() {
        return windowBorderSize;
    }
}
