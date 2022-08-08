package Physics;

import Entities.Ball;

import java.util.List;

public class Gravity {

    private static final double gravitationalConstant = 10;

    /**
     * Updates the objects acceleration due to gravity.
     * NOTE: this will override any acceleration set beforehand.
     * @param gameObjects list of balls to be updated.
     */
    public static void updateGravitationalAcceleration(List<Ball> gameObjects) {

        gameObjects.forEach(gameObject -> {
            gameObject.setAccelerationX(0);
            gameObject.setAccelerationY(0);
        });

        for (int i = 0; i < gameObjects.size(); i++) {
            for (int j = 0; j < gameObjects.size(); j++) {
                if (j == i) continue;
                applyNewGravitationalAcceleration(gameObjects.get(i), gameObjects.get(j));
            }
        }
    }


    /**
     * Applies the gravitational effect on Ball2.
     * @param ball1 first ball.
     * @param ball2 second ball.
     */
    private static void applyNewGravitationalAcceleration(Ball ball1, Ball ball2) {
        double xDistance = ball1.getCenterX() - ball2.getCenterX();
        double yDistance = ball1.getCenterY() - ball2.getCenterY();

        double distance = Math.sqrt(Math.pow(xDistance, 2) + Math.pow(yDistance, 2));

        double acceleration = gravitationalConstant * (ball1.getMass() / Math.pow(distance, 2));

        final double hypotenuseDistance = (Math.abs(xDistance) + Math.abs(yDistance));
        ball2.setAccelerationX(acceleration * (xDistance / hypotenuseDistance));
        ball2.setAccelerationY(acceleration * (yDistance / hypotenuseDistance));
    }
}
