package sample.observers;

import sample.Subject;

public abstract class Observer {
    protected Subject subject;
    public abstract void update(double startX, double startY);
}