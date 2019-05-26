package application.factories;

import javafx.stage.FileChooser;

public class PdfFileChooserFactory {

    public static FileChooser createPdfFileChooser() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select PDF File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("PDF", "*.pdf"));
        return fileChooser;
    }

}
