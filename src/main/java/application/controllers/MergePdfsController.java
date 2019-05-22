package application.controllers;

import application.preventSystemExit.PreventSystemExitException;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.stage.Stage;
import org.apache.pdfbox.tools.PDFBox;

import java.io.File;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Optional;

import static application.factories.PdfFileChooserFactory.createPdfFileChooser;
import static java.lang.String.format;
import static javafx.collections.FXCollections.observableArrayList;

public class MergePdfsController {

    @FXML
    private ListView<File> pdfsToBeMergedList;

    @FXML
    void initialize() {
        pdfsToBeMergedList.getSelectionModel()
                .setSelectionMode(SelectionMode.MULTIPLE);
    }

    //region Functions
    @FXML
    void addPdfToList() {
        getFilesListFromFileChooser().ifPresent(filesList ->
                pdfsToBeMergedList.setItems(observableArrayList(filesList)));
    }

    private Optional<List<File>> getFilesListFromFileChooser() {
        List<File> filesList = createPdfFileChooser()
                .showOpenMultipleDialog(new Stage());
        return Optional.ofNullable(filesList);
    }

    @FXML
    void beginMergePdfs() throws Exception {
        boolean notEmpty = pdfsToBeMergedList.getItems().size() > 0;
        if (notEmpty) {
            try {
                ArrayDeque<String> args = new ArrayDeque<>();
                preparePdfMergerArgs(args);
                PDFBox.main(args.toArray(new String[0]));
            } catch (PreventSystemExitException e) {
                new Alert(Alert.AlertType.INFORMATION,
                        "PDFs are merged successfully").show();
            }
        }
    }

    private void preparePdfMergerArgs(ArrayDeque<String> args) {
        args.add("PDFMerger");
        prepareAllToBeMergedPdfs(args);
        prepareOutputPdf(args);
    }

    private void prepareAllToBeMergedPdfs(ArrayDeque<String> args) {
        pdfsToBeMergedList.getItems().stream()
                .map(File::getAbsolutePath)
                .map(String::trim)
                .forEach(args::add);
    }

    private void prepareOutputPdf(ArrayDeque<String> args) {
        String parentPath = pdfsToBeMergedList.getItems().get(0).getParent();
        args.add(format("%s\\Merged.pdf", parentPath.trim()));
    }

    @FXML
    void clearPdfsToBeMerged() {
        ObservableList<File> allItems = pdfsToBeMergedList.getItems();
        pdfsToBeMergedList.getItems().removeAll(allItems);
    }

    @FXML
    void removePdfFromList() {
        ObservableList<File> selectedItems = pdfsToBeMergedList
                .selectionModelProperty()
                .get().getSelectedItems();
        pdfsToBeMergedList.getItems().removeAll(selectedItems);
    }
    //endregion

}
