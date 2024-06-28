package org.example;

public class Physics {
    long lastFrameTime = System.nanoTime(); // Init LFT

    public float deltaTime(){
        long currentFrameTime = System.nanoTime();
        float deltaTime = (currentFrameTime - lastFrameTime) / 1_000_000_000.0f; // Расчет deltaTime in seconds
        lastFrameTime = currentFrameTime;
        return deltaTime;
    }
    public static boolean checkCollision(Ball ball, BoundedObject object) {
        float ballLeft = ball.position.x - ball.radius;
        float ballRight = ball.position.x + ball.radius;
        float ballTop = ball.position.y - ball.radius;
        float ballBottom = ball.position.y + ball.radius;

        float objectLeft = object.getLeft();
        float objectRight = object.getRight();
        float objectTop = object.getTop();
        float objectBottom = object.getBottom();

        return !(ballRight < objectLeft || ballLeft > objectRight || ballBottom < objectTop || ballTop > objectBottom);
    }


    // Обработка столкновения в зависимости от типа объекта
    public void ReactOnCollision(Ball ball, Object collObject){

        if (collObject instanceof Racket) {
            Racket racket = (Racket) collObject;
            // Reaction on collision with MiSsLe
            // Reaction on collision with block
            if (Math.abs(ball.vVelocity.y) < 3f) {
                ball.vVelocity.y = -ball.vVelocity.y;
            } else {
                ball.vVelocity.y = -ball.vVelocity.y;
            }

        } else if (collObject instanceof Block) {
            // Reaction on collision with block
            if (Math.abs(ball.vVelocity.y) < 3f) {
                ball.vVelocity.y = -(ball.vVelocity.y * 1.5f);
            } else {
                ball.vVelocity.y = -ball.vVelocity.y;
            }
        }
        return;
    }


}




