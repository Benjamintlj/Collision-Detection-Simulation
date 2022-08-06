package Game;

import Game.Game;

public class Launcher {
    public static void main(String[] args) {
        new Thread(new GameLoop(new Game(800, 400))).start();
    }
}
