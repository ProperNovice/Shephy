package utils;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;

public class Button {

	private javafx.scene.control.Button button = null;

	public Button(String text, Parent parent) {

		this.button = new javafx.scene.control.Button(text);
		this.button.setFocusTraversable(false);
		parent.addNode(this.button);

	}

	public final void setVisible(final boolean value) {
		this.button.setVisible(value);
	}

	public final double getLayoutX() {
		return this.button.getLayoutX();
	}

	public final double getLayoutY() {
		return this.button.getLayoutY();
	}

	public void toBack() {
		this.button.toBack();
	}

	public void toFront() {
		this.button.toFront();
	}

	public void relocate(final double x, final double y) {
		this.button.relocate(x, y);
	}

	public final void setOnMouseEntered(EventHandler<? super MouseEvent> value) {
		this.button.setOnMouseEntered(value);
	}

	public final void setOnMouseExited(EventHandler<? super MouseEvent> value) {
		this.button.setOnMouseExited(value);
	}

	public final void setOnMousePressed(EventHandler<? super MouseEvent> value) {
		this.button.setOnMousePressed(value);
	}

	public final void setText(String text) {
		this.button.setText(text);
	}

	public final void setFont(int value) {
		this.button.setFont(new Font(value));
	}

	public final void setMinHeight(double value) {
		this.button.setMinHeight(value);
	}

	public void setMinSize(double minWidth, double minHeight) {
		this.button.setMinSize(minWidth, minHeight);
	}

	public final void setMinWidth(double value) {
		this.button.setMinWidth(value);
	}

	public final void setMaxHeight(double value) {
		button.setMaxHeight(value);
	}

	public final void setMaxWidth(double value) {
		button.setMaxWidth(value);
	}

	public void setMaxSize(double maxWidth, double maxHeight) {
		button.setMaxSize(maxWidth, maxHeight);
	}

}
