package browser;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class Controller {

    WebEngine webEngine;
    Worker<Void> worker;
    Stage primaryStage;

    @FXML
    private WebView browserView;

    @FXML
    private TextField urlField;

    @FXML
    private void loadUrl(KeyEvent event){
        String url = this.urlField.getText();
        if(event.getCode()== KeyCode.ENTER){
            this.webEngine.load(url);
        }
    }

    public void init(){
        this.webEngine = this.browserView.getEngine();
        this.worker = this.webEngine.getLoadWorker();
        this.worker.stateProperty().addListener(new ChangeListener<Worker.State>() {
            public void changed(ObservableValue<? extends Worker.State> observable, Worker.State oldValue, Worker.State newValue) {
                //Controller.this.primaryStage
            }
        });
        //this.webEngine.locationProperty().addListener(ods, oldLocation, newLocation) -> {

       //};
    }

}
