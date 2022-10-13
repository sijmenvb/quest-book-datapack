package gui;
/* class that updates the different ui elements.
 * stores the current page, number of pages, current element and number of elements.
 */

import java.util.LinkedList;

import converter.Book;

public class GUIUpdater {
	private int currentPage = 0;
	private int currentElement = 0;
	private LinkedList<UpdatableGUI> observers = new LinkedList<UpdatableGUI>();
	private Book book;
	
	public GUIUpdater(Book book) {
		super();
		this.book = book;
	}

	public void updateGUI() {
		int noPages = book.getPages().size();
		int noElements = book.getPages().get(currentPage).getTextElements().size();
		for (UpdatableGUI updatable : observers) {
			updatable.update(currentPage,noPages, currentElement,noElements);
		}
	}

	public void registerUpdatable(UpdatableGUI upd) {
		observers.add(upd);
	}

	public void unRegisterUpdatable(UpdatableGUI upd) {
		observers.remove(upd);
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentElement(int currentElement) {
		this.currentElement = currentElement;
	}


}
