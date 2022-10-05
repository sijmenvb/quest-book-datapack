package gui;

import converter.Page;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import textElement.PlainTextElement;
import textElement.TextElement;

public class TextInput extends VBox {
	private final int SPACING = 5;// how much space is between the different elements.
	private TextArea input;
	private TextElement currentElement;
	private PagePreview previewRef;
	private GUIPageMannager pageMannagerRef;

	public TextInput(TextElement element, PagePreview previewRef, GUIPageMannager pageMannagerRef) {
		this.previewRef = previewRef;
		this.pageMannagerRef = pageMannagerRef;
		pageMannagerRef.setInputRef(this);
		this.setSpacing(SPACING);// set vertical spacing.

		currentElement = element;

		ChoiceBox<String> typeSelector = new ChoiceBox<>();
		typeSelector.getItems().add("text");
		typeSelector.setValue("text");

		input = new TextArea();

		// add listener that check for updates to the input text field.
		input.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

				inputUpdated(newValue);
			}
		});

		CheckBox bold = new CheckBox("Bold");
		CheckBox italics = new CheckBox("Italic");

		ColorPicker colour = new ColorPicker(Color.BLACK);

		this.getChildren().addAll(typeSelector, input, bold, italics, colour);
	}

	/**
	 * gets called when the text is updated.
	 * 
	 * @param text
	 */
	private void inputUpdated(String text) {
		if (currentElement instanceof PlainTextElement) {
			((PlainTextElement) currentElement).setText(text);
		}

		update();
	}

	public void newPage(Page page) {
		setTextElement(page.getTextElements().getFirst());
		loadText();
	}

	public void setTextElement(TextElement currentElement) {
		this.currentElement = currentElement;
		loadText();
		update();
	}

	/**
	 * loads the text from current text element into input.
	 */
	public void loadText() {
		input.setText(currentElement.getText());
	}

	private void update() {
		previewRef.updatePreview();
	}
}
