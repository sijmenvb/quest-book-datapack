package gui;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import textElement.TextElement;

public class plainTextInput extends VBox {
	
	private TextArea input;
	private TextElement currentElement;
	private PagePreview previewRef;
	
	public plainTextInput(TextElement element,PagePreview previewRef) {
		currentElement = element;		
		this.previewRef = previewRef;
		ChoiceBox<String> typeSelector = new ChoiceBox<>();
		typeSelector.getItems().add("text");
		typeSelector.setValue("text");

		input = new TextArea();
		
		//add listener that check for updates to the input text field.
		input.textProperty().addListener(new ChangeListener<String>() {
		    @Override
		    public void changed(ObservableValue<? extends String> observable,
		            String oldValue, String newValue) {

		    	inputUpdated(newValue);
		    }
		});
		

		CheckBox bold = new CheckBox("Bold");
		CheckBox italics = new CheckBox("Italic");

		ColorPicker colour = new ColorPicker(Color.BLACK);

		this.getChildren().addAll(typeSelector, input, bold, italics, colour);
	}
	
	private void inputUpdated(String text) {
		currentElement.setText(text);
		previewRef.updatePreview();
		
	}
	
}
