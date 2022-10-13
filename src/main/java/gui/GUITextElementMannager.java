package gui;

import java.util.Collections;

import converter.Book;
import converter.Page;
import textElement.PlainTextElement;

/**
 * this class manages the selected page.
 * 
 * @author sijmen_v_b
 */
public class GUITextElementMannager {

	private Book book;
	private int textElementIndex = 0;
	private TextElementType type = TextElementType.TEXT;
	private GUIUpdater guiUpdater;

	public GUITextElementMannager(Book book,GUIUpdater guiUpdater) {
		super();
		this.book = book;
		this.guiUpdater = guiUpdater;
	}
	
	public void previousTextElement() {
		if (existPageLeft()) {// if there is a page to the left
			textElementIndex--;
			showpage();
		}
	}

	public void nextTextElement() {

		if (existPageRight()) {// if there is a page to the right
			textElementIndex++;
			showpage();
		}
	}

	public void swapLeft() {
		if (existPageLeft()) {// if there is a page to the left
			Collections.swap(book.getPages(), textElementIndex, textElementIndex - 1);
			textElementIndex--;
			showpage();
		}
	}

	public void swapRight() {
		if (existPageRight()) {// if there is a page to the left
			Collections.swap(book.getPages(), textElementIndex, textElementIndex + 1);
			textElementIndex++;
			showpage();
		}
	}

	public void addTextElement() {
		getCurrentPage().addNewTextElement(textElementIndex + 1);
		textElementIndex++;
		showpage();
	}

	/**
	 * return true if there is a page on the left.
	 * 
	 */
	private boolean existPageLeft() {
		return textElementIndex > 0;
	}

	/**
	 * return true if there exists a page to the right.
	 * 
	 */
	private boolean existPageRight() {
		return textElementIndex < getCurrentPage().getTextElements().size() - 1;
	}

	/**
	 * shows the page at bookIndex
	 * 
	 */
	public void showpage() {
		guiUpdater.setCurrentElement(textElementIndex);
		guiUpdater.updateGUI();
	}
	
	public Page getCurrentPage() {
		return book.getPages().get(guiUpdater.getCurrentPage());
	}
}
