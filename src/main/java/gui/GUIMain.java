package gui;

import java.util.Collections;

import converter.Book;
import converter.Page;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import textElement.PlainTextElement;
/**this class houses all the aspects of the GUI
 * 
 * @author sijmen_v_b
 *
 */
public class GUIMain extends HBox {
	private final int SPACING = 5;
	private Book book;
	private TextInput input;
	private GUIPageMannager guiPageMannager;
	
	public GUIMain(Book book) {
		this.book = book;
		this.setSpacing(5);
		
		PagePreview preview = new PagePreview(book.getPages().getFirst());
		
		
		guiPageMannager = new GUIPageMannager(book,preview);
		
		//page preview
		PageSelector pageSelector = new PageSelector(guiPageMannager);
		VBox pageView = new VBox(SPACING, pageSelector, preview);//have the page selector above the page.
		
		//text input
		TextElementSelector elementSelector = new TextElementSelector(guiPageMannager);
		input = new TextInput(book.getPages().getFirst().getTextElements().getFirst(), preview, guiPageMannager);
		
		VBox InputArea = new VBox(SPACING, elementSelector, input);//have the page selector above the page.
		this.getChildren().addAll(pageView, InputArea);
		
		
	}


}
