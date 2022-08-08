package Game;

public class GameLoop implements Runnable {

    private Game game;

    private boolean running;
    private final double updateRate = 1.0d/60.0d;

    private long nextStatTime;
    private int fps, ups;

    /**
     * Constructs a GameLoop obj.
     * @param game the game obj that is desired to be played.
     */
    GameLoop(Game game) {
        this.game = game;
    }

    /**
     * @return returns the game that is currently executing in the game loop
     */
    public Game getGame() {
        return game;
    }

    /**
     * Main executable function, this runs on a new thread.
     * It also manages the frame rate (FPS) and update rate (UPS).
     */
    @Override
    public void run() {
        running = true;
        double accmulator = 0;
        long currentTime, lastUpdate = System.currentTimeMillis();
        nextStatTime = System.currentTimeMillis() + 1000;

        while (running) {
            currentTime = System.currentTimeMillis();
            double lastRenderTimeInSeconds = (currentTime - lastUpdate) / 1000d;
            accmulator += lastRenderTimeInSeconds;
            lastUpdate = currentTime;

            if (accmulator >= updateRate) {
                while (accmulator > updateRate) {
                    update();
                    accmulator -= updateRate;
                }
                render();
            }

            printStats();
        }
    }

    /**
     * System.out the FPS and UPS.
     * (this can be ignored)
     */
    private void printStats() {
        if(System.currentTimeMillis() > nextStatTime) {
            System.out.println(String.format("FPS: %d, UPS: %d", fps, ups));
            fps = 0;
            ups = 0;
            nextStatTime = System.currentTimeMillis() + 1000;
        }
    }

    /**
     * Renders the game.
     */
    private void render() {
        game.render(this);
        fps++;
    }

    /**
     * Updates all game objects.
     */
    private void update() {
        game.update();
        ups++;
    }
}
