package Physics;

import Entities.Ball;
import java.util.List;

public class CollisionDetection {

    public static void checkForCollision(List<Ball> gameObjects) {
        for (int i = 0; i < gameObjects.size(); i++) {
            for (int j = 0; j < gameObjects.size(); j++) {
                if (j == i) continue;
                if (isColliding(gameObjects.get(i), gameObjects.get(j))) {
                    collisionPhysics(gameObjects.get(i), gameObjects.get(j));
                }
            }
        }
    }

    private static boolean isColliding(Ball ball1, Ball ball2) {

        double xGap = ball1.getCenterX() - ball2.getCenterX();
        double yGap = ball1.getCenterY() - ball2.getCenterY();

        double gap = Math.sqrt(Math.pow(xGap, 2) + Math.pow(yGap, 2));
        int sumOfRadii = ball1.getRadius() + ball2.getRadius();

        return gap <= sumOfRadii;
    }

    private static void collisionPhysics(Ball ball1, Ball ball2) {
        double ball1XVelocity = newXVelocity(ball1, ball2);
        double ball2XVelocity = newXVelocity(ball2, ball1);

        double ball1YVelocity = newYVelocity(ball1, ball2);
        double ball2YVelocity = newYVelocity(ball2, ball1);

        ball1.setVelocityX(ball1XVelocity);
        ball2.setVelocityX(ball2XVelocity);

        ball1.setVelocityY(ball1YVelocity);
        ball2.setVelocityY(ball2YVelocity);

        ball1.updateVectors();
        ball2.updateVectors();
    }

    private static double newXVelocity(Ball ball1, Ball ball2) {
        return (ball1.getVelocityX() * (ball1.getMass() - ball2.getMass()) + (2 * ball2.getMass() * ball2.getVelocityX())) / (ball1.getMass() + ball2.getMass());
    }

    private static double newYVelocity(Ball ball1, Ball ball2) {
        return (ball1.getVelocityY() * (ball1.getMass() - ball2.getMass()) + (2 * ball2.getMass() * ball2.getVelocityY())) / (ball1.getMass() + ball2.getMass());
    }
}
