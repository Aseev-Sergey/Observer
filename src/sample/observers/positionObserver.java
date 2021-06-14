package sample.observers;

import sample.Subject;

public class positionObserver extends Observer {

    private double posX;
    private double posY;

    public positionObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update(double startX, double startY) {
        posX = startX;
        posY = startY;
    }

    public double getPosX() {
        return posX;
    }

    public double getPosY() {
        return posY;
    }
}
