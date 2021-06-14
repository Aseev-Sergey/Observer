package sample.nodes;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class End {

    private Circle outer;
    private Circle inner;
    private Circle filled;


    public End(double startX, double startY, double radius){
        outer = new Circle(startX, startY, radius);
        inner = new Circle(outer.getCenterX(), outer.getCenterY(), outer.getRadius()-5, Color.WHITE);
        filled = new Circle(outer.getCenterX(), outer.getCenterY(), outer.getRadius()-10);
    }

    public Circle getFilled() {
        return filled;
    }

    public Circle getInner() {
        return inner;
    }

    public Circle getOuter() {
        return outer;
    }
}
