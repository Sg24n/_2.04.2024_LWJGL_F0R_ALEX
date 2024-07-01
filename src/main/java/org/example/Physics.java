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

        float [][] ballLocal = ball.getVertices();
        float [][] objLocal = object.getVertices();

        /*
        	1.	Определение координат прямоугольников: Убедитесь, что у каждого прямоугольника есть четыре определенные точки. Обычно для простоты достаточно знать левую верхнюю точку (x1, y1) и правую нижнюю точку (x2, y2).
	2.	Проверка пересечения двух прямоугольников: Чтобы проверить, пересекаются ли два прямоугольника, можно использовать следующую логику:
	•	Прямоугольник A не пересекается с Прямоугольником B, если одно из следующих условий истинно:
	•	Правая сторона A находится левее левой стороны B.
	•	Левая сторона A находится правее правой стороны B.
	•	Нижняя сторона A находится выше верхней стороны B.
	•	Верхняя сторона A находится ниже нижней стороны B.
    В коде это может быть выражено следующим образом:*/

      //  ReactOnCollision(ball, objLocal);

        return !(ballLocal[3][0] < objLocal[0][0] || ballLocal[0][0] > objLocal[3][0] || ballLocal[3][1] < objLocal[0][1] || ballLocal[0][1] > objLocal[3][1]);    }


    // Обработка столкновения в зависимости от типа объекта
    public static void ReactOnCollision(Ball ball, Object collObject){
    System.out.println("Какая то коллизия\n__________");
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
    }


}




