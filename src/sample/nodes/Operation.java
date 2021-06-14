package sample.nodes;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Operation {

    private Rectangle operation;

    public Operation(double startX, double startY, double width, double height){
        operation = new Rectangle(width, height, Color.LIGHTGREY);
        operation.setArcHeight(50);
        operation.setArcWidth(50);
        operation.setX(startX-width / 2.0);
        operation.setY(startY);
    }

    public Rectangle getOperation() {
        return operation;
    }
}
