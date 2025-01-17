package browser;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Browser extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        // Настройка для возможности авторизации в google:
        System.setProperty("sun.net.http.allowRestrictedHeaders", "true");

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Browser.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("FXBrowser");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
        Controller controller = (Controller)loader.getController();
        controller.init();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
