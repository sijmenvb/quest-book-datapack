package gui;

import java.util.Collections;

import converter.Book;
import textElement.PlainTextElement;

/**
 * this class manages the selected page.
 * 
 * @author sijmen_v_b
 */
public class GUIPageMannager {

	private Book book;
	private int bookIndex = 0;
	private PagePreview previewRef;
	private TextInput inputRef; //a new textInput will set this value to itself upon creation.
	private PageSelector pageSelectorRef;//a new PageSelector will set this value to itself upon creation.
	
	public GUIPageMannager(Book book,PagePreview preview) {
		super();
		this.book = book;
		this.previewRef = preview;
	}
	

	public void previousPage() {
		if (existPageLeft()) {// if there is a page to the left
			bookIndex--;
			showpage();
		}
	}

	public void nextPage() {

		if (existPageRight()) {// if there is a page to the right
			bookIndex++;
			showpage();
		}
	}

	public void swapLeft() {
		if (existPageLeft()) {// if there is a page to the left
			Collections.swap(book.getPages(), bookIndex, bookIndex - 1);
			bookIndex--;
			showpage();
		}
	}

	public void swapRight() {
		if (existPageRight()) {// if there is a page to the left
			Collections.swap(book.getPages(), bookIndex, bookIndex + 1);
			bookIndex++;
			showpage();
		}
	}

	public void addPage() {
		book.addNewPage(bookIndex + 1);
		bookIndex++;
		book.getPages().get(bookIndex).addTextElement(new PlainTextElement());
		showpage();
	}

	/**
	 * return true if there is a page on the left.
	 * 
	 */
	private boolean existPageLeft() {
		return bookIndex > 0;
	}

	/**
	 * return true if there exists a page to the right.
	 * 
	 */
	private boolean existPageRight() {
		return bookIndex < book.getPages().size() - 1;
	}

	/**
	 * shows the page at bookIndex
	 * 
	 */
	public void showpage() {
		previewRef.setPage(book.getPages().get(bookIndex));
		inputRef.newPage(book.getPages().get(bookIndex));
		pageSelectorRef.updatelabel(bookIndex+1, book.getPages().size());
	}



	public void setInputRef(TextInput input) {
		this.inputRef = input;
	}


	public void setPageSelectorRef(PageSelector pageSelectorRef) {
		this.pageSelectorRef = pageSelectorRef;
	}
	
	
}
