package gui;

import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedList;

import javax.lang.model.element.Element;

import converter.Book;
import converter.Page;
import javafx.geometry.Insets;
import javafx.scene.CacheHint;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
	private double fontSize = 30;
	
	private Book book;
	private GUIUpdater guiUpdater;
	
	private Font normalFont;
	private Font italicFont;
	private Font boldFont;
	private Font italicBoldFont;

	public PagePreview(Book book,GUIUpdater guiUpdater) {
		//enable cashing for preview.
		setCache(true);
		setCacheShape(true);
		setCacheHint(CacheHint.SPEED);
		this.guiUpdater = guiUpdater;
		this.book = book;
		// TODO: figure out a good font using System.out.println(Font.getFamilies());
		ClassLoader classLoader = getClass().getClassLoader();
		InputStream inputStream = classLoader.getResourceAsStream("gui/page.png");
		Image image = new Image(inputStream); 
		ImageView imageView = new ImageView(image);

		guiUpdater.registerUpdatable(this);
		
		textFlow.setLayoutX(40);
		textFlow.setLayoutY(40);
		textFlow.setPrefWidth(400);
		
		//fonts source: https://www.fontspace.com/minecraft-font-f28180
		InputStream normalFontInputStream = classLoader.getResourceAsStream("fonts/MinecraftRegular-Bmg3.otf");
		normalFont = Font.loadFont(normalFontInputStream, fontSize);
		InputStream italicFontInputStream = classLoader.getResourceAsStream("fonts/MinecraftItalic-R8Mo.otf");
		italicFont = Font.loadFont(italicFontInputStream, fontSize);
		InputStream boldFontInputStream = classLoader.getResourceAsStream("fonts/MinecraftBold-nMK1.otf");
		boldFont = Font.loadFont(boldFontInputStream, fontSize);
		InputStream italicBoldFontInputStream = classLoader.getResourceAsStream("fonts/MinecraftBoldItalic-1y1e");
		italicBoldFont = Font.loadFont(italicBoldFontInputStream, fontSize);
		
		
		// some hard coded sample data.
		Text text1 = new Text("Hello i am very important that's why i am long!!!!");
		//text1.setFont(Font.font(fontFamily, fontSize));
		text1.setFont(normalFont);
		text1.setFill(Color.GREEN);
		text1.setStrokeWidth(fontSize / 3);
		text1.setStrokeType(StrokeType.OUTSIDE);
		text1.setStroke(Color.YELLOW);

		Text text2 = new Text("Bold");
		text2.setFont(normalFont);
		Text text3 = new Text(" World");
		text3.setFont(normalFont);
		textFlow.getChildren().addAll(text1, text2, text3);
		
		textFlow.setPadding(new Insets(40, 50, 0, 45));
		textFlow.setLineSpacing(-4.0);

		this.getChildren().addAll(imageView,textFlow);
	}

	private boolean dumbHack = true;
	
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
		

		
		// a dumb hack to force the ui to update by resizing the window by a tiny fraction.
		if (dumbHack) {
			textFlow.getScene().getWindow().setHeight(textFlow.getScene().getWindow().getHeight() + 1);//force the preview to update.
		} else {
			textFlow.getScene().getWindow().setHeight(textFlow.getScene().getWindow().getHeight() - 1);//force the preview to update.
		}
		dumbHack = !dumbHack;
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

		//TODO: add different font types here
		text.setFont(normalFont);

		if (selected) {
			text.setStrokeWidth(fontSize/3);
			//text.setStrokeType(StrokeType.OUTSIDE); //looks better but is really slow
			text.setStroke(Color.color(1.0, 1.0, 0.0, 0.25));//yellow with 25% opacity so you can see the text behind the highlight.
		}

		textFlow.getChildren().add(text);

	}


	
}
