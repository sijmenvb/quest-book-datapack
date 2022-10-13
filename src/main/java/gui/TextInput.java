package gui;

import converter.Book;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import textElement.PlainTextElement;
import textElement.TextElement;

public class TextInput extends VBox implements UpdatableGUI {
	private final int SPACING = 5;// how much space is between the different elements.
	private TextArea input;
	private TextElement currentElement;

	private GUIUpdater guiUpdater;
	private Book book;

	public TextInput( Book book, GUIUpdater guiUpdater) {
		this.setSpacing(SPACING);// set vertical spacing.
		this.guiUpdater = guiUpdater;
		this.book = book;
		guiUpdater.registerUpdatable(this);
		currentElement = book.getPages().getFirst().getTextElements().getFirst();

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

		guiUpdater.updateGUI();
	}

	@Override
	public void update(int currentPage, int noPages,int currentElemnt,int noElements) {
		// TODO Auto-generated method stub
		this.currentElement = book.getPages().get(currentPage).getTextElements().get(currentElemnt);
		input.setText(currentElement.getText());
	}

}
