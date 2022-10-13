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
	private int pageIndex = 0;
	private LinkedList<GUITextElementMannager> elementManagers;
	private GUIUpdater guiUpdater;

	public GUIPageMannager(Book book, GUIUpdater guiUpdater) {
		super();
		this.book = book;
		this.guiUpdater = guiUpdater;

		// make a element manager for every page in the book.
		elementManagers = new LinkedList<GUITextElementMannager>();
		for (int i = 0; i < book.getPages().size(); i++) {
			elementManagers.add(new GUITextElementMannager(book, guiUpdater));
		}
	}

	public void previousPage() {
		if (existPageLeft()) {// if there is a page to the left
			pageIndex--;
			showpage();
		}
	}

	public void nextPage() {

		if (existPageRight()) {// if there is a page to the right
			pageIndex++;
			showpage();
		}
	}

	public void swapLeft() {
		if (existPageLeft()) {// if there is a page to the left
			Collections.swap(book.getPages(), pageIndex, pageIndex - 1);
			pageIndex--;
			showpage();
		}
	}

	public void swapRight() {
		if (existPageRight()) {// if there is a page to the left
			Collections.swap(book.getPages(), pageIndex, pageIndex + 1);
			pageIndex++;
			showpage();
		}
	}

	public void addPage() {
		book.addNewPage(pageIndex + 1);
		pageIndex++;
		book.getPages().get(pageIndex).addTextElement(new PlainTextElement());
		elementManagers.add(pageIndex, new GUITextElementMannager(book, guiUpdater));
		showpage();
	}

	/**
	 * return true if there is a page on the left.
	 */
	private boolean existPageLeft() {
		return pageIndex > 0;
	}

	/**
	 * return true if there exists a page to the right.
	 */
	private boolean existPageRight() {
		return pageIndex < book.getPages().size() - 1;
	}

	/**
	 * shows the page at bookIndex
	 */
	public void showpage() {
		guiUpdater.setCurrentPage(pageIndex);
		elementManagers.get(pageIndex).showpage();//will set the element index and calls guiUpdater.updateGUI()
	}

	public GUITextElementMannager getCurrentElementMannager() {
		return elementManagers.get(pageIndex);
	}

	public int getBookIndex() {
		return pageIndex;
	}
}
