package Game;

public class Launcher {
    /**
     * Starts the program.
     *
     * @param args ignores all args.
     */
    public static void main(String[] args) {
        new Thread(new GameLoop(new Game(800, 400))).start();
    }
}
