package sample.nodes;

import javafx.scene.shape.Circle;

public class Begin  {

    private Circle begin;

    public Begin(double centerX, double centerY, double radius){
        begin = new Circle(centerX, centerY, radius);
    }

    public Circle getBegin() {
        return begin;
    }
}
