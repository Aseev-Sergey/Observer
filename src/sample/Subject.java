package sample;

import sample.observers.Observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {

    private List<Observer> observers = new ArrayList<Observer>();
    private String state;
    private int index;

    public void setState(String nodeName, int posList, double mouseX, double mouseY) {
        state = nodeName;
        index = posList;
        notifyAllObservers(mouseX, mouseY);
    }

    public void attach(Observer observer){
        observers.add(observer);
    }

    public void notifyAllObservers(double mouseX, double mouseY){
        for (Observer observer : observers) {
            observer.update(mouseX, mouseY);
        }
    }

    public String getState() {
        return state;
    }

    public int getIndex(){return index;}
}