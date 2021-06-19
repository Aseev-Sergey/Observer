package sample.observers;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import sample.Subject;

public class AimingObserver extends Observer {

    private Shape fill;
    private double width;
    private Color color;

    public AimingObserver(Subject subject){

        this.subject = subject;
        fill = (Shape)this.subject.getState();
        width = fill.getStrokeWidth();
        color = (Color) fill.getStroke();
        this.subject.attach(this);
    }

    @Override
    public void update(double startX, double startY) {
        fill.setStrokeWidth(2);
        fill.setStroke(Color.RED);
        fill.toFront();
    }

    @Override
    public void disable() {
        fill.toBack();
    }

    public Shape getFill(){ return fill;}
}
