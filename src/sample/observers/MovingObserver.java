package sample.observers;

import sample.Subject;

public class MovingObserver extends Observer {

    public MovingObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update(double startX, double startY) {
        subject.getState().relocate(startX, startY);
    }

    @Override
    public void disable() {

    }
}
