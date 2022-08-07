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

    public Game(int width, int height) {
        input = new Input();
        display = new Display(width, height, input);
        gameObjects = new ArrayList<>();

        gameObjects.add(new Ball(50, 50, 350, 3, 0, 0, 0, 150));
        gameObjects.add(new Ball(100, 300, 350, 1, 0, 0, 0, 1));

        System.out.println(display.getWindowBorderSize());
    }

    public void update() {
        CollisionDetection.checkForCollision(gameObjects);
        gameObjects.forEach(gameObject -> gameObject.update(display));
    }

    public void render(GameLoop gameLoop) {
        display.render(gameLoop.getGame());
    }

    public List<Ball> getGameObjects() {
        return gameObjects;
    }
}
