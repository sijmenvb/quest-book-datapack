package gui;

import java.util.Iterator;

import javax.lang.model.element.Element;

import converter.Page;
import javafx.scene.CacheHint;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import textElement.TextElement;

public class PagePreview extends StackPane {
	private TextFlow textFlow = new TextFlow();

	// font settings
	private String fontFamily = "Helvetica";
	private double fontSize = 20;
	
	private Page page;

	public PagePreview(Page page) {
		
		setCache(true);
		setCacheShape(true);
		setCacheHint(CacheHint.SPEED);
		
		this.page = page;
		// TODO: figure out a good font using System.out.println(Font.getFamilies());

		textFlow.setLayoutX(40);
		textFlow.setLayoutY(40);

		// some hard coded sample data.
		Text text1 = new Text("Hello i am very important that's why i am long!!!!");
		text1.setFont(Font.font(fontFamily, fontSize));
		text1.setFill(Color.GREEN);
		text1.setStrokeWidth(fontSize / 3);
		text1.setStrokeType(StrokeType.OUTSIDE);
		text1.setStroke(Color.YELLOW);

		Text text2 = new Text("Bold");
		text2.setFont(Font.font(fontFamily, FontWeight.BOLD, fontSize));
		Text text3 = new Text(" World");
		text3.setFont(Font.font(fontFamily, FontPosture.ITALIC, fontSize));
		textFlow.getChildren().addAll(text1, text2, text3);

		this.getChildren().add(textFlow);
	}
	
	public void updatePreview() {
		textFlow.getChildren().clear();
		
		for (TextElement t : page.getTextElements()) {
			addText(t);
		}
	}

	/**
	 * add a TextElement to the page preview.
	 */
	private void addText(TextElement element) {
		Text text = new Text(element.toString());

		text.setFill(element.getColour());

		FontWeight weight = FontWeight.NORMAL;

		if (element.isBold()) {
			weight = FontWeight.BOLD;
		}

		FontPosture posture = FontPosture.REGULAR;

		if (element.isItalics()) {
			posture = FontPosture.ITALIC;
		}

		text.setFont(Font.font(fontFamily, weight, posture, fontSize));

		// TODO: figure out what a good way to detect if a current node is selected is.
		if (false) {
			text.setStrokeWidth(fontSize / 3);
			text.setStrokeType(StrokeType.OUTSIDE);
			text.setStroke(Color.YELLOW);
		}

		textFlow.getChildren().add(text);

	}
}
