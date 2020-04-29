

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;

public class layoutcontroller {

    @FXML // fx:id="imageView"
    private ImageView imageView; // Value injected by FXMLLoader

    @FXML // fx:id="caption"
    private TextField caption; // Value injected by FXMLLoader

    @FXML // fx:id="datePicker"
    private DatePicker datePicker; // Value injected by FXMLLoader

    @FXML // fx:id="radioButtonColor"
    private RadioButton radioButtonColor; // Value injected by FXMLLoader

    @FXML // fx:id="rendition"
    private ToggleGroup rendition; // Value injected by FXMLLoader

    @FXML // fx:id="radioButtonGrayscale"
    private RadioButton radioButtonGrayscale; // Value injected by FXMLLoader

    @FXML // fx:id="checkBoxEnhancedView"
    private CheckBox checkBoxEnhancedView; // Value injected by FXMLLoader

    @FXML
    void switchToColor(ActionEvent event) {

    }

    @FXML
    void switchToGrayscale(ActionEvent event) {

    }

    @FXML
    void toggleEnhancedView(ActionEvent event) {

    }

    @FXML
    void updateImageView(ActionEvent event) {

    }

}
