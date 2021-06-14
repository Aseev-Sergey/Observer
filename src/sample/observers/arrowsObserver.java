package sample.observers;

import sample.Subject;
import sample.nodes.Arrows;

public class arrowsObserver extends Observer {

    private Arrows arrowsL, arrowsR, arrowsC;

    public arrowsObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update(double startX, double startY) {
        switch (subject.getIndex()){
            case 0:
                arrowsC = new Arrows(new double[]{
                        startX-10, startY+40,
                        startX+10, startY+40,
                        startX, startY+50
                }, new double[]{
                        startX, startY+20, startX, startY+40
                }
                );
                break;
            case 1:
                arrowsC = new Arrows(new double[]{
                        startX-10, startY+80,
                        startX+10, startY+80,
                        startX, startY+90
                }, new double[]{
                        startX, startY+60, startX, startY+80
                }
                );
                break;
            case 2:
                arrowsL = new Arrows(new double[]{
                        startX-100.7, startY+90,
                        startX-80.7, startY+90,
                        startX-90.7, startY+100
                }, new double[]{
                        startX-70.7, startY+50, startX-90.7, startY+50,
                        startX-90.7, startY+50, startX-90.7, startY+90
                }
                );
                arrowsR = new Arrows(new double[]{
                        startX+100.7, startY+90,
                        startX+80.7, startY+90,
                        startX+90.7, startY+100
                }, new double[]{
                        startX+70.7, startY+50, startX+90.7, startY+50,
                        startX+90.7, startY+50, startX+90.7, startY+90
                }
                );
                break;
            case 3:
            default:
                break;
        }
    }

    public Arrows getArrowsL() {
        return arrowsL;
    }

    public Arrows getArrowsR() {
        return arrowsR;
    }

    public Arrows getArrowsC() {
        return arrowsC;
    }
}
