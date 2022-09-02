package gui;

import converter.Book;
import converter.Page;
import javafx.scene.layout.HBox;

import javafx.scene.text.Font;
import textElement.PlainTextElement;

public class PageEditor extends HBox {
	// private InlineCssTextArea area;
	private TextElementType type = TextElementType.Text;
	private Book book;
	
	public PageEditor(Book book) {		
		
		PagePreview preview = new PagePreview(book.getPages().getFirst());
		plainTextInput input = new plainTextInput(book.getPages().getFirst().getTextElements().getFirst(),preview);

		this.getChildren().addAll(preview, input);

	}

}
