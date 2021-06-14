package sample;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import sample.observers.arrowsObserver;
import sample.observers.nameObserver;
import sample.observers.positionObserver;
import java.net.URL;
import java.util.ResourceBundle;
import sample.nodes.Begin;
import sample.nodes.Operation;
import sample.nodes.Solution;
import sample.nodes.End;

public class Controller implements Initializable {

    public Subject subject = new Subject();
    private arrowsObserver arrows = new arrowsObserver(subject);
    private nameObserver name = new nameObserver(subject);
    private positionObserver pos = new positionObserver(subject);
    public Pane pane;
    public ListView<String> list;
    public ObservableList<String> items;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        items = FXCollections.observableArrayList("Начальный узел", "Узел управления",
                "Узел решения", "Финальный узел");
        list.setItems(items);
        list.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }

    public void addNode(MouseEvent mouseEvent) {

        int index = list.getSelectionModel().getSelectedIndex();
        clearPane();
        list.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        if ((index >= 0) && (index < list.getItems().size())) {
            subject.setState(items.get(index), index , mouseEvent.getX(), mouseEvent.getY());
            drawFigure(index);
        } else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Ошибка");
            alert.setHeaderText(null);
            alert.setContentText("Не выбран узел из списка");
            alert.showAndWait();
        }
    }

    public void clickClear(ActionEvent actionEvent) {
       clearPane();
    }

    public void clickClose(ActionEvent actionEvent) {
        Platform.exit();
    }

    private void clearPane(){
        pane.getChildren().clear();
    }

    private void drawFigure(int index){
        switch (index){
            case 0:
                Begin begin;
                begin = new Begin(pos.getPosX(), pos.getPosY(), 20);
                pane.getChildren().addAll(begin.getBegin(),name.getText(),arrows.getArrowsC().getArrow());
                for (int i = 0; i < arrows.getArrowsC().getArrayLine().length; i++){
                    pane.getChildren().add(arrows.getArrowsC().getArrowLine(i));
                }
                break;
            case 1:
                Operation operation;
                operation = new Operation(pos.getPosX(), pos.getPosY(), 120, 60);
                pane.getChildren().addAll(operation.getOperation(), name.getText(), arrows.getArrowsC().getArrow());
                for (int i = 0; i < arrows.getArrowsC().getArrayLine().length; i++){
                    pane.getChildren().add(arrows.getArrowsC().getArrowLine(i));
                }
                break;
            case 2:
                Solution solution;
                solution = new Solution(pos.getPosX(), pos.getPosY(), 100);
                pane.getChildren().addAll(solution.getSolution(), name.getText(),
                        arrows.getArrowsL().getArrow(), arrows.getArrowsR().getArrow());
                for (int i = 0; i < arrows.getArrowsL().getArrayLine().length; i++){
                    pane.getChildren().add(arrows.getArrowsL().getArrowLine(i));
                }
                for (int i = 0; i < arrows.getArrowsR().getArrayLine().length; i++){
                    pane.getChildren().add(arrows.getArrowsR().getArrowLine(i));
                }
                break;
            case 3:
                End end;
                end = new End(pos.getPosX(), pos.getPosY(), 20);
                pane.getChildren().addAll(end.getOuter(), end.getInner(), end.getFilled(), name.getText());
                break;

        }
    }
}
