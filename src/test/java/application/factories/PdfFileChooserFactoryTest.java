package application.factories;

import javafx.stage.FileChooser;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PdfFileChooserFactoryTest {

    private FileChooser fileChooser;

    @Before
    public void setUp() {
        fileChooser = PdfFileChooserFactory.createPdfFileChooser();
    }

    @Test
    public void createPdfFileChooser() {
        assertThat(fileChooser).isNotNull();
    }

    @Test
    public void testFileChooserTitle() {
        assertThat(fileChooser)
                .extracting(FileChooser::getTitle)
                .isEqualTo("Select PDF File");
    }

    @Test
    public void testFileChooserExtensionFilters() {
        FileChooser.ExtensionFilter expected = new FileChooser
                .ExtensionFilter("PDF", "*.pdf");
        assertThat(fileChooser.getExtensionFilters()).hasSize(1);
        assertThat(fileChooser.getExtensionFilters().get(0))
                .usingRecursiveComparison()
                .isEqualTo(expected);
    }

}