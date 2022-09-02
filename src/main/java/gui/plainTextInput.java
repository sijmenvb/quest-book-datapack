package gui;

import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class plainTextInput extends VBox {
	public plainTextInput() {

		ChoiceBox<String> typeSelector = new ChoiceBox<>();
		typeSelector.getItems().add("text");
		typeSelector.setValue("text");

		TextArea input = new TextArea();

		CheckBox bold = new CheckBox("Bold");
		CheckBox italics = new CheckBox("Italic");

		ColorPicker colour = new ColorPicker(Color.BLACK);

		this.getChildren().addAll(typeSelector, input, bold, italics, colour);
	}
}
