
/**
 * Sample Skeleton for 'BlueMarble.fxml' Controller Class
 */

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.swing.text.View;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Labeled;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BlueMarbleController {

	BlueMarble bluemarble = new BlueMarble();

	@FXML // fx:id="imageView"
	private ImageView imageView; // Value injected by FXMLLoader

	@FXML // fx:id="caption"
	private TextField caption; // Value injected by FXMLLoader

	@FXML // fx:id="datePicker"
	private DatePicker datePicker; // Value injected by FXMLLoader

	@FXML // fx:id="radioButtonColor"
	private RadioButton radioButtonColor; // Value injected by FXMLLoader

	@FXML // fx:id="colorToggleGroup"
	private ToggleGroup colorToggleGroup; // Value injected by FXMLLoader

	@FXML // fx:id="radioButtonGrayscale"
	private RadioButton radioButtonGrayscale; // Value injected by FXMLLoader

	@FXML // fx:id="checkBoxEnhancedView"
	private CheckBox checkBoxEnhancedView; // Value injected by FXMLLoader

	@FXML
	void colorRadioButtonSelected(ActionEvent event) {
		System.out.println(
				((Labeled) colorToggleGroup.getSelectedToggle()).getText());
	}

	@FXML
	void toggleEnhancedView(ActionEvent event) {
		System.out.println("toggleEnhancedView method");
		System.out.println(checkBoxEnhancedView.isSelected());
		if (checkBoxEnhancedView.isSelected()) {
			bluemarble.setEnhanced(true);
		} else {
			bluemarble.setEnhanced(false);
		}
		Image image = new Image(bluemarble.getImage());
		imageView.setImage(image);
		caption.setText(bluemarble.getCaption());
	}
	
	@FXML
	void updateImageView(ActionEvent event) {
		boolean tryAgain = true;
		while (tryAgain == true) {
			try {
				queryDatePicker();
				tryAgain = false;
			} catch (InvalidDateException msg) {
				System.out.println(msg);
			}
		}
		Image image = new Image(bluemarble.getImage());
		imageView.setImage(image);
		caption.setText(bluemarble.getCaption());
	}

	private void queryDatePicker() throws InvalidDateException {
		System.out.println("updateImageView method");
		bluemarble.setDate(datePicker.getValue()
				.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
		LocalDate now = java.time.LocalDate.now();
		System.out.println(now);
		System.out.println(
				now.compareTo(java.time.LocalDate.parse(bluemarble.getDate())));
		if (now.compareTo(
				java.time.LocalDate.parse(bluemarble.getDate())) <= 0) {
			datePicker.getEditor().clear();
			datePicker.setValue(null);
			caption.setText("Please select a date prior to " + now);
			throw new InvalidDateException(
					"Please select a date prior to " + now);
		}
	}

}

class InvalidDateException extends Exception {
	private static final long serialVersionUID = 1L;

	InvalidDateException(String message) {
		super(message);
	}
}
