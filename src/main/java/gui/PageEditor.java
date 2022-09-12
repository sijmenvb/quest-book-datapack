package gui;

import converter.Book;
import converter.Page;
import javafx.scene.layout.HBox;

import javafx.scene.text.Font;
import textElement.PlainTextElement;

public class PageEditor extends HBox {

	// private InlineCssTextArea area;
	private TextElementType type = TextElementType.TEXT;
	private Book book;

	public PageEditor(Book book) {
		this.setSpacing(5);
		PagePreview preview = new PagePreview(book.getPages().getFirst());
		TextInput input = new TextInput(book.getPages().getFirst().getTextElements().getFirst(), preview);

		this.getChildren().addAll(preview, input);

	}

}
