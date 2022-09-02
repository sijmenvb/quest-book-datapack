package textElement;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class PlainTextElement extends TextElement {

	private String text;

	@Override
	public String toCommand() {
		return String.format("{\"text\":\"%s\"}", text);
	}

	@Override
	public String toString() {
		return text;
	}

	@Override
	public void setText(String newText) {
		text = newText;
	}

}
