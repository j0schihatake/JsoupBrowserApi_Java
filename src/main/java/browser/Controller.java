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
import org.w3c.dom.*;
import org.w3c.dom.html.HTMLInputElement;

import static javafx.scene.input.KeyCode.ENTER;

public class Controller {

    WebEngine webEngine;
    Worker<Void> worker;
    Stage primaryStage;

    String sberInvestorUrl = "https://www.sberbank.ru/ru/person/investments/sbinvestor";
    String sberInvestorUrl2 = "https://online.sberbank.ru/CSAFront/index.do#/service?srvUrl=/sbtsbol/private/brokerage%23/management&from=websbinvestor%26_ga=2.165425279.1115496698.1606129540-1447269435.1606129540%26_gac=1.27435342.1606129568.CjwKCAiA2O39BRBjEiwApB2IkmgD5wkiSpcoGZXhI3aQ-d5Npd-qLuplBXONZ6eW7sRckPkiXphS7RoCHXEQAvD_BwE";

    @FXML
    private WebView browserView;

    @FXML
    private TextField urlField;

    @FXML
    private void loadUrl(KeyEvent event){
        clickOnElement("input");
        if(event.getCode()== ENTER){

        }
    }

    public String loadUrl(TextField field){
        String text = field.getText();
        if(text == null || text.equals(""))
            text = "https://www.google.ru/";
        this.webEngine.load(loadUrl(this.urlField));
        return text;
    }

    public void init(){
        this.webEngine = this.browserView.getEngine();
        this.worker = this.webEngine.getLoadWorker();
        webEngine.setJavaScriptEnabled(true);
        this.webEngine.load("https://www.google.ru/");
        //loadUrl(this.urlField);

    }

    public boolean setText(String findParam){
        boolean result = false;

        Document doc = webEngine.getDocument();
        Element element = doc.getElementById("");
        element.setTextContent("test");

        return result;
    }

    public void clickOnElement(String id){
        NodeList doc = browserView.getEngine().getDocument().getElementsByTagName("input");
        for(int i = 0; i < doc.getLength(); i++){
            Node n = doc.item(i);
            String name = n.getNodeName();
            String localName = n.getLocalName();
            NamedNodeMap attributes = n.getAttributes();
            for(int j = 0; i < attributes.getLength(); j++ ){
                Node n2 = attributes.item(j);
                String name2 = n2.getNodeName();
                String localName2 = n2.getLocalName();
            }
            n.toString();
        }
        HTMLInputElement element = (HTMLInputElement)browserView.getEngine().getDocument().getElementsByTagName("input").item(0);
        element.click();
    }

}
