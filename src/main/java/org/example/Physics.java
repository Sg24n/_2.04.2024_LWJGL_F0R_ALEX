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

            if(ball.getTop().isBetween(object.getBL(), object.getBR())){System.out.println("Ball Top coll");return true;}
            if(ball.getRight().isBetween(object.getTL(),object.getBL())){System.out.println("Ball Right coll");return true;}
            if(ball.getBottom().isBetween(object.getTL(), object.getTR())){System.out.println("Ball Bottom coll");return true;}
            if (ball.getLeft().isBetween(object.getTR(), object.getBR())){System.out.println("Ball Left coll");return true;}
            return false;

    }


    // Обработка столкновения в зависимости от типа объекта
    public static void ReactOnCollision(Ball ball, Object collObject){
    System.out.println("Какая то коллизия\n__________");
        if (collObject instanceof Racket) {
            Racket racket = (Racket) collObject;
            // Reaction on collision with MiSsLe
                ball.vVelocity.y = -ball.vVelocity.y;

        } else if (collObject instanceof Block) {
            // Reaction on collision with block
            if (Math.abs(ball.vVelocity.y) < 3f) {
                ball.vVelocity.y = -(ball.vVelocity.y * 1.5f);
            } else {
                ball.vVelocity.y = -ball.vVelocity.y;
            }
        }
    }


}




