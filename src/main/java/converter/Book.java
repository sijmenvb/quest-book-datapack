package converter;

import java.util.LinkedList;

import textElement.PlainTextElement;

public class Book {
	private LinkedList<Page> pages = new LinkedList<Page>();
	
	public void addNewPage() {
		pages.add(new Page());
	}
	
	public void addNewPage(int i) {
		pages.add(i, new Page());
	}
	
	public void addPage(Page p) {
		pages.add(p);
	}
	
	public void addPage(int i,Page p) {
		pages.add(i, p);
	}
	
	public LinkedList<Page> getPages() {
		return pages;
	}
}
