package gui;

import javafx.scene.layout.HBox;

import javafx.scene.text.Font;

public class PageEditor extends HBox {
	// private InlineCssTextArea area;
	private TextElementType type = TextElementType.Text;

	public PageEditor() {
		PagePreview preview = new PagePreview();
		plainTextInput input = new plainTextInput();

		this.getChildren().addAll(preview, input);

	}

}
