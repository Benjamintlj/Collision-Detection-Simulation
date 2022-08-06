package Game;

import Controller.Input;
import Display.Display;
import Entities.GameObject;
import Entities.Square;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private Display display;
    private List<GameObject> gameObjects;
    private Input input;

    public Game(int width, int height) {
        input = new Input();
        display = new Display(width, height, input);
        gameObjects = new ArrayList<>();
        gameObjects.add(new Square(input));
    }

    public void update() {
        gameObjects.forEach(gameObject -> gameObject.update());
    }

    public void render(GameLoop gameLoop) {
        display.render(gameLoop.getGame());
    }

    public List<GameObject> getGameObjects() {
        return gameObjects;
    }
}
