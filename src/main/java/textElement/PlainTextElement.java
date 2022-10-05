package textElement;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class PlainTextElement extends TextElement {

	private String text;


	public String toCommand() {
		return String.format("{\"text\":\"%s\"}", text);
	}

	
	public String toString() {
		return text;
	}
	
	public String getText() {
		return text;
	}

	public void setText(String newText) {
		text = newText;
	}

}
