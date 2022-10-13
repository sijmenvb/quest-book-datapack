package gui;

import converter.Book;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

public class TextElementSelector extends HBox implements UpdatableGUI {
	private static int SPACING = 5;// how much space is between the different elements.
	private Label pageSeletorLabel;
	private GUITextElementMannager elementMannagerRef;

	private GUIUpdater guiUpdater;
	private GUIPageMannager guiPageMannager;

	public TextElementSelector(GUIPageMannager guiPageMannager, GUIUpdater guiUpdater) {
		this.elementMannagerRef = guiPageMannager.getCurrentElementMannager();
		this.setSpacing(SPACING);
		this.guiPageMannager = guiPageMannager;
		this.guiUpdater = guiUpdater;
		guiUpdater.registerUpdatable(this);
		
		Button previousButton = new Button("previous");
		pageSeletorLabel = new Label(" Element 1 of 1 ");
		pageSeletorLabel.setFont(Font.font(16));
		Button nextButton = new Button("next");
		Button addPageButton = new Button("+");
		Button swapLeftButton = new Button("swap left");
		Button swapRightButton = new Button("swap Right");

		// button functionality
		previousButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				elementMannagerRef.previousTextElement();
			}
		});

		nextButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				elementMannagerRef.nextTextElement();
			}
		});

		addPageButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				elementMannagerRef.addTextElement();
			}
		});

		swapLeftButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				elementMannagerRef.swapLeft();
			}
		});

		swapRightButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				elementMannagerRef.swapRight();
			}
		});

		getChildren().addAll(swapLeftButton, previousButton, pageSeletorLabel, nextButton, addPageButton,
				swapRightButton);
	}

	@Override
	public void update(int currentPage, int noPages, int currentElemnt,int noElements) {
		this.elementMannagerRef = guiPageMannager.getCurrentElementMannager();
		pageSeletorLabel.setText(String.format("Element %d of %d", currentElemnt + 1,noElements));
	}
}
