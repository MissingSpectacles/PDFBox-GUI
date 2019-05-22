package application.controllers;

import application.factories.PdfFileChooserFactory;
import application.preventSystemExit.PreventSystemExitException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.apache.pdfbox.tools.PDFBox;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Optional;

public class ExtractImagesController {

    private File inputFile;

    @FXML
    private TextField passwordField;

    @FXML
    private Label filenameLabel;

    @FXML
    void initialize() {
        filenameLabel.setText("");
    }

    //region Functions
    @FXML
    void choosePdfFile() {
        getFileFromFileChooser().ifPresent(file -> {
            filenameLabel.setText("Filename: " + file.getName());
            inputFile = file;
        });
    }

    private Optional<File> getFileFromFileChooser() {
        File file = PdfFileChooserFactory.createPdfFileChooser()
                .showOpenDialog(new Stage());
        return Optional.ofNullable(file);
    }

    @FXML
    void beginExtraction() throws Exception {
        if (inputFile != null) {
            try {
                ArrayDeque<String> args = new ArrayDeque<>();
                prepareArgs(args);
                PDFBox.main(args.toArray(new String[0]));
            } catch (PreventSystemExitException e) {
                new Alert(Alert.AlertType.INFORMATION,
                        "Images successfully extracted.").show();
                filenameLabel.setText("");
            }
        }
    }

    private void prepareArgs(ArrayDeque<String> args) {
        args.addAll(Arrays.asList("ExtractImages", "-directJPEG"));
        addPasswordArgumentIfNotNullAndNotEmpty(args);
        args.add(inputFile.getAbsolutePath().trim());
    }

    private void addPasswordArgumentIfNotNullAndNotEmpty(
            ArrayDeque<String> args) {
        String password = passwordField.getText();
        if (password != null && !password.isEmpty()) {
            args.add("-password");
            args.add(password.trim());
        }
    }
    //endregion

}
