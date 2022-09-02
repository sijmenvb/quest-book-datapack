package converter;

import java.util.LinkedList;

public class Book {
	private LinkedList<Page> pages = new LinkedList<Page>();
	
	
	public void addPage(Page p) {
		pages.add(p);
	}
	
	public LinkedList<Page> getPages() {
		return pages;
	}
}
