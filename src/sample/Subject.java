package sample;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import sample.observers.Observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {

    private List<Observer> observers = new ArrayList<Observer>();
    private Node state;


    public void attach(Observer observer){
        observers.add(observer);
    }

    public void detach(Observer observer){
        observers.remove(observer);
    }

    public void notifyAllObservers(double mouseX, double mouseY){
        for (Observer observer : observers) {
            observer.update(mouseX, mouseY);
        }
    }

    public Node getState() {
        return state;
    }

    public void setState(Node node){
        state = node;
    }

    public void setState(Node node, double mouseX, double mouseY) {
        state = node;
        notifyAllObservers(mouseX, mouseY);
    }

    public void setState(double mouseX, double mouseY){
        notifyAllObservers(mouseX, mouseY);
    }



}