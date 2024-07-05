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

       // if (ball.getTop().isEqual(object.getBR()) || ball.getTop().isEqual(object.getBL())){}

        if (Math.abs(ball.vVelocity.x)>120){
            if (ball.vVelocity.x<0.0f){
                ball.vVelocity.x = ball.vVelocity.x + 0.25f;
            } else {ball.vVelocity.x = ball.vVelocity.x - 0.25f;
            };
        }


        //Ball basic collision
            if(object.getTL().isBetweenDiagonal(ball.getRight(),ball.getBottom())){System.out.println("Ball RB coll");ball.vVelocity.x = -ball.vVelocity.x;return true;}//X на лево
            if(object.getTR().isBetweenDiagonal(ball.getLeft(),ball.getBottom())){System.out.println("Ball LB coll");ball.vVelocity.x = Math.abs(ball.vVelocity.x);return true;} //x направо
            if(object.getBL().isBetweenDiagonal(ball.getTop(),ball.getRight())){System.out.println("Ball RT coll");ball.vVelocity.x = -ball.vVelocity.x;return true;} //x налево
            if(object.getBR().isBetweenDiagonal(ball.getTop(),ball.getLeft())){System.out.println("Ball LT coll");ball.vVelocity.x = Math.abs(ball.vVelocity.x);return true;} //x направо

            if(ball.getTop().isBetween(object.getBL(), object.getBR())){System.out.println("Ball Top coll"); ball.vVelocity.y = Math.abs(ball.vVelocity.y); return true;}
            if(ball.getBottom().isBetween(object.getTL(), object.getTR())){System.out.println("Ball Bottom coll");ball.vVelocity.y = -Math.abs(ball.vVelocity.y);return true;}


            // TODO Такая же херня должна быть с верхней и нижней точкой
            if(ball.getRight().isBetween(object.getTL(),object.getBL())){System.out.println("Ball Right coll");
                ball.vVelocity.x = -Math.abs(ball.vVelocity.x);
                ReactOnCollision(ball,object);
                return true;}
            if (ball.getLeft().isBetween(object.getTR(), object.getBR())){System.out.println("Ball Left coll");
                ball.vVelocity.x = Math.abs(ball.vVelocity.x);
                ReactOnCollision(ball,object);
                return true;}


            return false;

    }

    /*public static boolean checkCollision(Ball ball, BoundedObject object, BoundedObject object2) {

        if(object.getTL().isBetween(ball.getRight(),ball.getBottom())
                ||object.getTR().isBetween(ball.getLeft(),ball.getBottom())
                ||object.getBL().isBetween(ball.getTop(),ball.getRight())
                ||object.getBR().isBetween(ball.getTop(),ball.getLeft())){
            System.out.println("Ball X coll");
            ball.vVelocity.x = -ball.vVelocity.x;
             return true;
        }

        if (ball.getTop().isBetween(object.getBL(), object.getBR())
                ||ball.getRight().isBetween(object.getTL(),object.getBL())
                ||ball.getBottom().isBetween(object.getTL(), object.getTR())
                ||ball.getLeft().isBetween(object.getTR(), object.getBR())){
            System.out.println("Ball Y coll");
            ball.vVelocity.y = -ball.vVelocity.y;
             return true;
        }
        return false;

    }*/


    // Обработка столкновения в зависимости от типа объекта
    public static void ReactOnCollision(Ball ball, Object collObject){
    System.out.println("Какая то коллизия\n__________");
        if (collObject instanceof Racket) {
            // Если ракетка пнула мяч по х, и скорость ракетки не 0,
            // скорость мяча = скорость мяча + скорость ракетки /2
            float rV = ((Racket) collObject).velocityX;
            if (Math.abs(rV) > 360){
            if ( rV != 0.0f){
                if (rV < 0.0f){ball.vVelocity.x = ball.vVelocity.x - 100;
                }else {ball.vVelocity.x = ball.vVelocity.x + 100;}
            }
            }
        } else if (collObject instanceof Block) {
          //  BlockManager
            // Block Reaction on collision
            if (Math.abs(ball.vVelocity.y) < 3f) {
            } else {
            }
        }
    }


}




