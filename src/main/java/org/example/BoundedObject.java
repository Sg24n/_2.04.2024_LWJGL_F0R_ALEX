package org.example;
//Получение координат вершин
public interface BoundedObject {
    /*float getVertexLT();
    float getVertexRT();
    float getVertexLB();
    float getRB();*/



    //0 = [x][v1/v2]    1 = [y][v1/v3]
    //x0 y0  v0    v1
    //       v2    v3    x480 y480
    float  [][] getVertices();
}
