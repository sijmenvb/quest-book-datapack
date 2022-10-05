package gui;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

import converter.Book;
import converter.Page;
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
	private TextInput inputRef; // a new textInput will set this value to itself upon creation.
	private PageSelector pageSelectorRef;// a new PageSelector will set this value to itself upon creation.
	private TextElementSelector textElementSelector;// a new PageSelector will set this value to itself upon creation.
	private LinkedList<GUITextElementMannager> elementManagers;

	public GUIPageMannager(Book book, PagePreview preview) {
		super();
		this.book = book;
		this.previewRef = preview;

		// make a element manager for every page in the book.
		elementManagers = new LinkedList<GUITextElementMannager>();
		for (int i = 0; i < book.getPages().size(); i++) {
			elementManagers.add(new GUITextElementMannager(book, this, inputRef, textElementSelector, previewRef));
		}
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
		elementManagers.add(bookIndex,
				new GUITextElementMannager(book, this, inputRef, textElementSelector, previewRef));
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
		textElementSelector.setElementMannager(getCurrentElementMannager());
		pageSelectorRef.updatelabel(bookIndex + 1, book.getPages().size());
		elementManagers.get(bookIndex).showpage();
	}

	public GUITextElementMannager getCurrentElementMannager() {
		return elementManagers.get(bookIndex);
	}

	public int getBookIndex() {
		return bookIndex;
	}

	public void setInputRef(TextInput input) {
		this.inputRef = input;
		for (GUITextElementMannager guiTextElementMannager : elementManagers) {
			guiTextElementMannager.setInputRef(input);
		}
	}

	public void setPageSelectorRef(PageSelector pageSelectorRef) {
		this.pageSelectorRef = pageSelectorRef;
	}

	public void setTextElementSelector(TextElementSelector textElementSelector) {
		this.textElementSelector = textElementSelector;
	}
}
