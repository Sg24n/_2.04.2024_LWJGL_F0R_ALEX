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
            //Ещё написать ис ОБЖ бетвин балл топ балл райт, балл райт балл боттом, и тд.д.
            //Ещё надо чтобы он передавал менять х или у велосити
            //Не работает пушо IsBetween не считает по диагонали
            if(object.getTL().isBetweenDiagonal(ball.getRight(),ball.getBottom())){System.out.println("Ball RB coll");ball.vVelocity.x = -Math.abs(ball.vVelocity.x);return true;} //X на лево
            if(object.getTR().isBetweenDiagonal(ball.getLeft(),ball.getBottom())){System.out.println("Ball LB coll");ball.vVelocity.x = Math.abs(ball.vVelocity.x);return true;} //x направо
            if(object.getBL().isBetweenDiagonal(ball.getTop(),ball.getRight())){System.out.println("Ball RT coll");ball.vVelocity.x = -Math.abs(ball.vVelocity.x);return true;} //x налево
            if(object.getBR().isBetweenDiagonal(ball.getTop(),ball.getLeft())){System.out.println("Ball LT coll");ball.vVelocity.x = Math.abs(ball.vVelocity.x);return true;} //x направо
        //Упрощение
            /*if(object.getTL().isBetween(ball.getRight(),ball.getBottom())
            ||object.getTR().isBetween(ball.getLeft(),ball.getBottom())
            ||object.getBL().isBetween(ball.getTop(),ball.getRight())
            ||object.getBR().isBetween(ball.getTop(),ball.getLeft())){
                System.out.println("Ball X coll");
                ball.vVelocity.x = -ball.vVelocity.x;
                return true;
            }*/
            //Collision Ball vertices with OBJ faces
            if(ball.getTop().isBetween(object.getBL(), object.getBR())){System.out.println("Ball Top coll"); ball.vVelocity.y = Math.abs(ball.vVelocity.y); return true;}
            if(ball.getBottom().isBetween(object.getTL(), object.getTR())){System.out.println("Ball Bottom coll");ball.vVelocity.y = -Math.abs(ball.vVelocity.y);return true;}

            if(ball.getRight().isBetween(object.getTL(),object.getBL())){System.out.println("Ball Right coll");ball.vVelocity.x = -ball.vVelocity.x;return true;}
            if (ball.getLeft().isBetween(object.getTR(), object.getBR())){System.out.println("Ball Left coll");ball.vVelocity.x = Math.abs(ball.vVelocity.x);return true;}
           /* if (ball.getTop().isBetween(object.getBL(), object.getBR())
            ||ball.getRight().isBetween(object.getTL(),object.getBL())
            ||ball.getBottom().isBetween(object.getTL(), object.getTR())
            ||ball.getLeft().isBetween(object.getTR(), object.getBR())){
                System.out.println("Ball Y coll");
                ball.vVelocity.y = -ball.vVelocity.y;
                return true;
            }*/
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




