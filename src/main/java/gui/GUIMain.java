package gui;

import java.util.Collections;

import converter.Book;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
/**
 * this class houses all the aspects of the GUI
 * 
 * @author sijmen_v_b
 *
 */
public class GUIMain extends HBox {
	private final int SPACING = 5;
	private Book book;
	private TextInput input;
	private GUIPageMannager guiPageMannager;
	private GUIUpdater guiUpdater;

	public GUIMain(Book book) {
		this.book = book;
		this.guiUpdater = new GUIUpdater(book);
		
		HBox main = new HBox();
		main.setSpacing(5);
		
		guiPageMannager = new GUIPageMannager(book, guiUpdater);

		// page preview
		PageSelector pageSelector = new PageSelector(guiPageMannager, guiUpdater);
		PagePreview preview = new PagePreview(book, guiUpdater);
		VBox pageView = new VBox(SPACING, pageSelector, preview);// have the page selector above the page.

		// text input
		TextElementSelector elementSelector = new TextElementSelector(guiPageMannager, guiUpdater);
		input = new TextInput(book, guiUpdater);

		VBox InputArea = new VBox(SPACING, elementSelector, input);// have the page selector above the page.
		main.getChildren().addAll(pageView, InputArea);
		
		//center the main in the window.
		this.setAlignment(Pos.CENTER);
		VBox alignment = new VBox();
		alignment.getChildren().add(main);
		alignment.setAlignment(Pos.CENTER);
		this.getChildren().add(alignment);
	}
}
