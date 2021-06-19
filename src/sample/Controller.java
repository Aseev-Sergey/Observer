package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import sample.observers.AimingObserver;
import sample.observers.MovingObserver;
import sample.observers.PickingObserver;

import java.net.URL;
import java.util.ResourceBundle;
import sample.nodes.Begin;
import sample.nodes.Operation;
import sample.nodes.Solution;

public class Controller implements Initializable {

    public Subject subject = new Subject();
    private MovingObserver move;
    private PickingObserver pick;
    private AimingObserver aim;
    public Pane pane;
    public Begin begin;
    public Operation oper;
    public Solution sol;
    public Node selected;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addNodes();

    }

    public void clickClear(ActionEvent actionEvent) {
       clearPane();
       addNodes();
    }

    private void addNodes(){
        begin = new Begin();
        oper = new Operation();
        sol = new Solution();
        pane.getChildren().addAll(begin, oper, sol);
    }

    public void clickClose(ActionEvent actionEvent) {
        Platform.exit();
    }

    private void clearPane(){
        pane.getChildren().clear();
    }


    public void setOnMouseDragged(MouseEvent mouseEvent) {
        if(selected == null) return;
        subject.setState(mouseEvent.getX(), mouseEvent.getY());
    }

    public void setOnMouseMoved(MouseEvent mouseEvent) {
        for (Node node : pane.getChildren()) {
            if (node.contains(mouseEvent.getX(), mouseEvent.getY())) {
                selected = node;
                subject.setState(selected);
                aim = new AimingObserver(subject);
                subject.setState(mouseEvent.getX(), mouseEvent.getY());
                pane.setCursor(Cursor.HAND);
                break;
            } else {
                selected = null;
                subject.detach(aim);
                pane.setCursor(Cursor.DEFAULT);
            }
        }
    }

    public void setOnMousePressed(MouseEvent mouseEvent) {
        if(selected == null) return;
            subject.setState(selected, mouseEvent.getX(), mouseEvent.getY());
            move = new MovingObserver(subject);
            pick = new PickingObserver(subject);
        }


    public void setOnMouseReleased(MouseEvent mouseEvent) {
        pick.getFill().toBack();
        subject.detach(pick);
        subject.detach(move);
    }



}
