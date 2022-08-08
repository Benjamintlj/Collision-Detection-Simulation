package Game;

import Controller.Input;
import Display.Display;
import Entities.GameObject;
import Entities.Ball;
import Physics.CollisionDetection;
import Physics.Gravity;

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

        gameObjects.add(new Ball(100, 500, 400, 0, 0, 10, 1.0001, true));
        gameObjects.add(new Ball(50, 500, 200, 0.7, 0, 1, 1.0001, false));

        System.out.println(display.getWindowBorderSize());
    }

    /**
     * Method called per update cycle.
     * Used to update status of all game objs.
     */
    public void update() {
        CollisionDetection.checkForCollision(gameObjects);
        Gravity.updateGravitationalAcceleration(gameObjects);
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
