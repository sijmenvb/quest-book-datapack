package converter;

import java.util.LinkedList;

import textElement.TextElement;

public class Page {
	private LinkedList<TextElement> textElements = new LinkedList<TextElement>();
	
	public void addTextElement(TextElement e) {
		textElements.add(e);
	}
	
	public LinkedList<TextElement> getTextElements(){
		return textElements;
	}
}
