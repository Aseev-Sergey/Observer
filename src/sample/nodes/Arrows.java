package sample.nodes;

import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;

public class Arrows {

    private Polygon arrow;
    private Line[] arrayLine;

    public Arrows(double[] arrowsPoints, double[] arrayPoints){
        arrow = new Polygon(arrowsPoints);
        arrayLine = new Line[arrayPoints.length / 4];
        for (int index = 0, pointIndex = index; index < arrayLine.length; index++){
            arrayLine[index] = new Line(arrayPoints[pointIndex++], arrayPoints[pointIndex++],
                    arrayPoints[pointIndex++], arrayPoints[pointIndex++] );
        }
    }

    public Polygon getArrow() {
        return arrow;
    }

    public Line[] getArrayLine() {
        return arrayLine;
    }

    public Line getArrowLine(int index){return arrayLine[index];}
}
