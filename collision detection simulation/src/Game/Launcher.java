package Game;

public class Launcher {
    /**
     * Starts the program.
     *
     * @param args ignores all args.
     */
    // 800, 400
    public static void main(String[] args) {
        new Thread(new GameLoop(new Game(1000, 1000))).start();
    }
}
