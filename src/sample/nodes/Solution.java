package sample.nodes;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Solution{

    private Rectangle solution;

    public Solution(double startX, double startY, double width){
        solution = new Rectangle(width, width, Color.LIGHTGREY);
        solution.setRotate(45);
        solution.setX(startX - width / 2.0);
        solution.setY(startY);
    }

    public Rectangle getSolution() {
        return solution;
    }
}
