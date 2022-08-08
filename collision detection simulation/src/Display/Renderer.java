package Display;

import Game.Game;

import java.awt.*;

public class Renderer {

    /**
     * renders all game objects.
     * @param game game to be rendered.
     * @param graphics graphics to be rendered.
     */
    public void render(Game game, Graphics graphics) {
        game.getGameObjects().forEach(gameObject -> {
            gameObject.getSprite(graphics);

        });
    }
}

//graphics.drawImage(
//        gameObject.getSprite(),
//        gameObject.getPosition().getX(),
//        gameObject.getPosition().getY(),
//        null
//        )
