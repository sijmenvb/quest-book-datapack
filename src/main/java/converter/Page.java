package converter;

import java.util.LinkedList;

import textElement.PlainTextElement;
import textElement.TextElement;

public class Page {
	private LinkedList<TextElement> textElements = new LinkedList<TextElement>();
	
	public void addTextElement(TextElement e) {
		textElements.add(e);
	}
	
	public void addNewTextElement() {
		textElements.add(new PlainTextElement());
	}
	
	public void addNewTextElement(int i) {
		textElements.add(i, new PlainTextElement());
	}
	
	
	public LinkedList<TextElement> getTextElements(){
		return textElements;
	}
}
