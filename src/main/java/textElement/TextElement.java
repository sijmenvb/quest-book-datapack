package textElement;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public abstract class TextElement {
	protected boolean bold = false;
	protected boolean italics = false;
	protected Paint textColour = Color.BLACK;

	public abstract String toCommand();

	public abstract String toString();

	public boolean isBold() {
		return bold;
	}

	public boolean isItalics() {
		return italics;
	}

	public Paint getColour() {
		return textColour;
	}
	
	public abstract void setText(String newText);

}
