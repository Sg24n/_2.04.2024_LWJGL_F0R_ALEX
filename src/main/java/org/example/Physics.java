package org.example;

public class Physics {
    public ColissionResult checkCollision(){
        boolean colissionX = false;
        boolean colissionY = false;
        return new ColissionResult( colissionX, colissionY);
    }

    public void ReactOnCollision(){
        ColissionResult result = checkCollision();
        if(result.collisionX){}
        if(result.collisionY){}
        return;
    }

    public class ColissionResult{
        public boolean collisionX;
        public boolean collisionY;

        public ColissionResult(boolean collisionX, boolean collisionY){
            this.collisionX= collisionX;
            this.collisionY = collisionY;
        }

    }



}
