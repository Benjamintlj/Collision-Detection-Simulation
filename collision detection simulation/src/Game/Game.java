package Game;

import Controller.Input;
import Display.Display;
import Entities.GameObject;
import Entities.Ball;
import Physics.CollisionDetection;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private Display display;
    private List<Ball> gameObjects;
    private Input input;

    /**
     * Init game, all objs can be defined here.
     * @param width screen width
     * @param height screen height
     */
    public Game(int width, int height) {
        input = new Input();
        display = new Display(width, height, input);
        gameObjects = new ArrayList<>();


        gameObjects.add(new Ball(50, 50, 350, 3, 1, 0, 0, 2));
        gameObjects.add(new Ball(100, 300, 350, 1, 0, 0, 0, 1));

        System.out.println(display.getWindowBorderSize());
    }

    /**
     * Method called per update cycle.
     * Used to update status of all game objs.
     */
    public void update() {
        CollisionDetection.checkForCollision(gameObjects);
        gameObjects.forEach(gameObject -> gameObject.update(display));
    }

    /**
     * Renders all objects in the game.
     * @param gameLoop
     */
    public void render(GameLoop gameLoop) {
        display.render(gameLoop.getGame());
    }

    /**
     * @return returns all gameObjects
     */
    public List<Ball> getGameObjects() {
        return gameObjects;
    }
}
