package gui;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import textElement.TextElement;

public class TextInput extends VBox {
	private final int SPACING = 5;// how much space is between the different elements.
	private TextArea input;
	private TextElement currentElement;
	private PagePreview previewRef;
	
	public TextInput(TextElement element,PagePreview previewRef) {
		
		this.setSpacing(SPACING);// set vertical spacing.
		
		Button previousButton = new Button("previous");
		Label pageSeletorLabel = new Label(" page 1 of 1 ");
		pageSeletorLabel.setFont(Font.font(16));
		Button nextButton = new Button("next");
		Button addPageButton = new Button("+");
		Button moveLeftButton = new Button("move left");
		Button moveRightButton = new Button("move Right");
		HBox pageselector = new HBox(SPACING,moveLeftButton,previousButton,pageSeletorLabel,nextButton,addPageButton,moveRightButton);
		
		
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

		this.getChildren().addAll(pageselector,typeSelector, input, bold, italics, colour);
	}
	
	private void inputUpdated(String text) {
		currentElement.setText(text);
		previewRef.updatePreview();
		
	}
	
}