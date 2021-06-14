package sample.observers;

import javafx.scene.text.Text;
import sample.Subject;

public class nameObserver extends Observer {

   private Text text;

    public nameObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update(double startX, double startY) {
        text = new Text(startX-50, startY-30, subject.getState());
    }

    public Text getText() {
        return text;
    }
}
