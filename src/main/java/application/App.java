package application;

import application.preventSystemExit.PreventSystemExitSecurityManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    public static void main(String[] args) {
        System.setSecurityManager(new PreventSystemExitSecurityManager());
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader
                /* directory: src\main\resources\views\MainMenuView.fxml */
                .load(getClass().getResource("/views/MainMenuView.fxml"));
        primaryStage.setTitle("Apache PDFBox GUI");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

}
