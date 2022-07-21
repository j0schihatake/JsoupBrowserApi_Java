package browser;

import com.sun.webkit.dom.HTMLInputElementImpl;
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

import java.io.IOException;

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
    private void loadUrl(KeyEvent event) throws IOException {
        clickOnElement("input");
        if(event.getCode()== ENTER){

        }
    }

    public String loadUrl(TextField field){
        String text = field.getText();
        if(text == null || text.equals(""))
            text = "https://www.google.ru/";
        this.webEngine.load(loadUrl(this.urlField));
        this.webEngine.getDocument();
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

    /**
     * Кликнуть на элемент на странице по :
     * @param id
     */
    public void clickOnElement(String id) throws IOException {

        String buttonurl = JsoupTest.start();
        this.webEngine.load(buttonurl);

        //HTMLInputElementImpl element2 = (HTMLInputElementImpl) browserView.getEngine().getDocument().getElementsByTagName("input").item(0);
        //element2.click();

        /*
        NodeList doc = browserView.getEngine().getDocument().getElementsByTagName("a");
        for(int i = 0; i < doc.getLength(); i++){
            Node n = doc.item(i);
            String name = n.getNodeName();
            String localName = n.getLocalName();
            String value = n.getNodeValue();

            StringBuilder info = new StringBuilder();
            info.append("Найден элемент: name = " + name + ", localName = " + localName + " его value - " + value + ", у элемента имеются следующие аттрибуты: \n");

            NamedNodeMap attributes = n.getAttributes();
            for(int j = 0; j < attributes.getLength(); j++ ){
                Node n2 = attributes.item(j);
                String name2 = n2.getNodeName();
                String localName2 = n2.getLocalName();
                String value2 = n2.getNodeValue();
                info.append("name = " + name2 + ", localName = " + localName2 + " иххначение - " + value2 +"; \n");
            }
            n.toString();
            System.out.println(info.toString());

        }
        HTMLInputElement element = (HTMLInputElement)browserView.getEngine().getDocument().getElementsByTagName("input").item(0);
        element.click();
        */

        //String email  =  "document.getElementsByName('email')[0].value='MY_EMAIL';";
        //webEngine.executeScript(email);

        browserView.getEngine().executeScript("alert('testing')");

        //HTMLInputElementImpl element = (HTMLInputElementImpl) browserView.getEngine().getDocument().getElementsByTagName("a").item(3);
        //element.click();

        //Node n = findElement("a","id=\"gb_70\"");
        //if(n!=null){
        //    HTMLInputElement element2 = (HTMLInputElementImpl) n;
        //    element2.click();
        //}


    }

    /**
     * Поиск элемента
     */
    public Node findElement(String tag, String attribute){

        Node result = null;

        // class="gb_4 gb_5 gb_le gb_7c"

        String[] attributeValue = attribute.split("=");
        String findAttributeName = attributeValue[0];
        String findValueAttribute = attributeValue[1].replaceAll("\"", "");

        NodeList doc = browserView.getEngine().getDocument().getElementsByTagName(tag);

        for(int i = 0; i < doc.getLength(); i++){
            Node n = doc.item(i);
            String name = n.getNodeName();
            String localName = n.getLocalName();
            String value = n.getNodeValue();

            StringBuilder info = new StringBuilder();
            info.append("Найден элемент: name = " + name + ", localName = " + localName + " его value - " + value + ", у элемента имеются следующие аттрибуты: \n");

            NamedNodeMap attributes = n.getAttributes();
            for(int j = 0; j < attributes.getLength(); j++ ){
                Node n2 = attributes.item(j);
                String name2 = n2.getNodeName();
                String localName2 = n2.getLocalName();
                String value2 = n2.getNodeValue();
                info.append("name = " + name2 + ", localName = " + localName2 + " иххначение - " + value2 +"; \n");

                //if(name2.equals(findAttributeName) && value2.equals(findValueAttribute)) {
                 //   System.out.println(info.toString());
                 //   return n;
                //}
            }
            System.out.println(info.toString());
        }
        return result;
    }

}
