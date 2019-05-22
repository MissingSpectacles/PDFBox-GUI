package application.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static java.lang.String.format;

public class MainMenuController {

    @FXML
    void extractImages() throws IOException {
        showNewStageFromFxml("ExtractImagesView",
                "ExtractImages");
    }

    private void showNewStageFromFxml(String viewName, String stageTitle)
            throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(
                /* directory: src\main\resources\views\*.fxml */
                getClass().getResource(format("/views/%s.fxml", viewName)));
        stage.setTitle(stageTitle);
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    void mergePdfs() throws IOException {
        showNewStageFromFxml("MergePdfsView", "Merge PDFs");
    }

}
