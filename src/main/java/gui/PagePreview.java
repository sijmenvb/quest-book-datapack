package gui;

import java.util.Iterator;
import java.util.LinkedList;

import javax.lang.model.element.Element;

import converter.Book;
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

public class PagePreview extends StackPane implements UpdatableGUI {
	private TextFlow textFlow = new TextFlow();

	// font settings
	private String fontFamily = "Helvetica";
	private double fontSize = 20;
	
	private Book book;
	private GUIUpdater guiUpdater;

	public PagePreview(Book book,GUIUpdater guiUpdater) {
		//enable cashing for preview.
		setCache(true);
		setCacheShape(true);
		setCacheHint(CacheHint.SPEED);
		this.guiUpdater = guiUpdater;
		this.book = book;
		// TODO: figure out a good font using System.out.println(Font.getFamilies());

		guiUpdater.registerUpdatable(this);
		
		textFlow.setLayoutX(40);
		textFlow.setLayoutY(40);
		textFlow.setPrefWidth(400);

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

	
	@Override
	public void update(int currentPage, int noPages,int currentElemnt,int noElements) {
		// TODO Auto-generated method stub
		Page page = book.getPages().get(currentPage);
		textFlow.getChildren().clear();
		LinkedList<TextElement> elements = page.getTextElements();
		
		
		for (int i = 0; i < noElements; i++) {
			TextElement t = elements.get(i);
			addText(t,i==currentElemnt);
		}
	}
	
	/**
	 * add a TextElement to the page preview.
	 */
	private void addText(TextElement element,boolean selected) {
		
		if(element.toString() == null) {//don't try to draw empty elements.
			return;
		}
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

		if (selected) {
			text.setStrokeWidth(fontSize/3);
			//text.setStrokeType(StrokeType.OUTSIDE); //looks better but is really slow
			text.setStroke(Color.color(1.0, 1.0, 0.0, 0.25));//yellow with 25% opacity so you can see the text behind the highlight.
		}

		textFlow.getChildren().add(text);

	}


	
}
