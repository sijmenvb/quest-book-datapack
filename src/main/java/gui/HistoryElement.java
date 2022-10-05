package gui;

import textElement.PlainTextElement;

public class HistoryElement {
	private PlainTextElement plainText = null;
	
	public PlainTextElement getPlainText() {
		if (plainText == null) {
			plainText = new PlainTextElement();
		}
		return plainText;
	}
}
