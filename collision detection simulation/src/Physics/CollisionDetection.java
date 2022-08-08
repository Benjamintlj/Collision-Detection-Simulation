package Physics;

import Entities.Ball;
import java.util.List;

public class CollisionDetection {

    /**
     * Checks if balls are colliding, and runs appropriate measures if they are.
     * @param gameObjects list of Balls.
     */
    public static void checkForCollision(List<Ball> gameObjects) {
        for (int i = 0; i < gameObjects.size(); i++) {
            for (int j = 0; j < gameObjects.size(); j++) {
                if (j == i) continue;
                if (isColliding(gameObjects.get(i), gameObjects.get(j))) {
                    collisionPhysics(gameObjects.get(i), gameObjects.get(j));
                    System.out.println("---------------HIT-----------------------------------");
                }
            }
        }
    }

    /**
     * Checks if balls are colliding.
     * @param ball1 first ball.
     * @param ball2 second ball.
     * @return true if touching.
     */
    private static boolean isColliding(Ball ball1, Ball ball2) {

        double xGap = ball1.getCenterX() - ball2.getCenterX();
        double yGap = ball1.getCenterY() - ball2.getCenterY();

        double gap = Math.sqrt(Math.pow(xGap, 2) + Math.pow(yGap, 2));
        int sumOfRadii = ball1.getRadius() + ball2.getRadius();

        return gap <= sumOfRadii;
    }

    /**
     * Changes balls respective velocities.
     * @param ball1 first ball.
     * @param ball2 second ball.
     */
    private static void collisionPhysics(Ball ball1, Ball ball2) {
        double ball1XVelocity = newXVelocity(ball1, ball2);
        double ball2XVelocity = newXVelocity(ball2, ball1);

        double ball1YVelocity = newYVelocity(ball1, ball2);
        double ball2YVelocity = newYVelocity(ball2, ball1);

        ball1.setVelocityX(ball1XVelocity * ball1.getCollisionElasticity());
        ball2.setVelocityX(ball2XVelocity * ball2.getCollisionElasticity());

        ball1.setVelocityY(ball1YVelocity * ball1.getCollisionElasticity());
        ball2.setVelocityY(ball2YVelocity * ball2.getCollisionElasticity());

        ball1.updateVectors();
        ball2.updateVectors();
    }

    /**
     * Calculates new X velocity for ball1.
     * NOTE: this only calculates the velocity for the first ball, you will have to swap params, to calculate for the second ball.
     * @param ball1 first ball.
     * @param ball2 second ball.
     * @return new X velocity for the first ball.
     */
    private static double newXVelocity(Ball ball1, Ball ball2) {
        return (ball1.getVelocityX() * (ball1.getMass() - ball2.getMass()) + (2 * ball2.getMass() * ball2.getVelocityX())) / (ball1.getMass() + ball2.getMass());
    }

    /**
     * Calculates new Y velocity for ball1.
     * NOTE: this only calculates the velocity for the first ball, you will have to swap params, to calculate for the second ball.
     * @param ball1 first ball.
     * @param ball2 second ball.
     * @return new Y velocity for the first ball.
     */
    private static double newYVelocity(Ball ball1, Ball ball2) {
        return (ball1.getVelocityY() * (ball1.getMass() - ball2.getMass()) + (2 * ball2.getMass() * ball2.getVelocityY())) / (ball1.getMass() + ball2.getMass());
    }
}
