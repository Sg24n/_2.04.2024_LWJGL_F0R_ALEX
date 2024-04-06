package org.example;

public class Physics {

    public boolean checkBlockCollision(Ball ball, Block block){
        float ballLeft = ball.x - ball.radius;
        float ballRight = ball.x + ball.radius;
        float ballTop = ball.y - ball.radius;
        float ballBottom = ball.y + ball.radius;

        float blockLeft = block.x;
        float blockRight = block.x + block.width;
        float blockTop = block.y;
        float blockBottom= block.y + block.height;

        boolean collisionWithBlock = !(ballRight < blockLeft || ballLeft > blockRight || ballBottom < blockTop || ballTop > blockBottom);
        // System.out.println("Check collision");

        return collisionWithBlock;
    }

    public void ReactOnCollision(Ball ball){
            System.out.println("React on collision");
                if (Math.abs(ball.velocityY)<3f){ball.velocityY = -(ball.velocityY*1.5f);
                } else {ball.velocityY = -ball.velocityY;}

        return;
    }


}




