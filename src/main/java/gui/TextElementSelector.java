package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

public class TextElementSelector extends HBox {
	private static int SPACING = 5;// how much space is between the different elements.
	private Label pageSeletorLabel;
	private GUITextElementMannager elementMannagerRef;

	public TextElementSelector(GUIPageMannager guiPageMannager) {
		this.elementMannagerRef = guiPageMannager.getCurrentElementMannager();
		guiPageMannager.setTextElementSelector(this);
		elementMannagerRef.setTextElementSelectorRef(this);

		this.setSpacing(SPACING);

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

	public void updatelabel(int elementIndex, int noElements) {
		pageSeletorLabel.setText(String.format("Element %d of %d", elementIndex, noElements));
	}

	public void setElementMannager(GUITextElementMannager elementMannagerRef) {
		this.elementMannagerRef = elementMannagerRef;
	}
}
