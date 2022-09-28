package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

public class PageSelector extends HBox {
	private static int SPACING = 5;// how much space is between the different elements.
	private Label pageSeletorLabel;
	private GUIPageMannager pageMannagerRef;

	public PageSelector(GUIPageMannager pageMannager) {
		this.pageMannagerRef = pageMannager;
		pageMannager.setPageSelectorRef(this);
		
		this.setSpacing(SPACING);

		Button previousButton = new Button("previous");
		pageSeletorLabel = new Label(" page 1 of 1 ");
		pageSeletorLabel.setFont(Font.font(16));
		Button nextButton = new Button("next");
		Button addPageButton = new Button("+");
		Button swapLeftButton = new Button("swap left");
		Button swapRightButton = new Button("swap Right");

		// button functionality
		previousButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				pageMannagerRef.previousPage();
			}
		});

		nextButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				pageMannagerRef.nextPage();
			}
		});

		addPageButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				pageMannagerRef.addPage();
			}
		});

		swapLeftButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				pageMannagerRef.swapLeft();
			}
		});

		swapRightButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				pageMannagerRef.swapRight();
			}
		});

		getChildren().addAll(swapLeftButton, previousButton, pageSeletorLabel, nextButton, addPageButton,
				swapRightButton);
	}

	public void updatelabel(int pagenumber, int noPages) {
		pageSeletorLabel.setText(String.format("page %d of %d", pagenumber, noPages));
	}
}
