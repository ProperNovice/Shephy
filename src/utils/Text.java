package utils;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;

public class Text {

	private javafx.scene.text.Text text = null;

	public Text(String text, Parent parent) {

		this.text = new javafx.scene.text.Text(text);
		parent.addNode(this.text);

	}

	public final void setVisible(final boolean value) {
		PlatformFX.runLater(() -> this.text.setVisible(value));
	}

	public void toBack() {
		PlatformFX.runLater(() -> this.text.toBack());
	}

	public void toFront() {
		PlatformFX.runLater(() -> this.text.toFront());
	}

	public final double getLayoutX() {
		return this.text.getLayoutX();
	}

	public final double getLayoutY() {
		return this.text.getLayoutY();
	}

	public double getHeight() {
		return text.minHeight(0);
	}

	public double getWidth() {
		return text.minWidth(0);
	}

	public void setHeight(final double pixels) {

		PlatformFX.runLater(() -> {

			int font = 1;
			setFont(font);

			while (getHeight() <= pixels)
				setFont(++font);

			font--;
			setFont(font);

		});

	}

	public void setWidth(final double pixels) {

		PlatformFX.runLater(() -> {

			int font = 1;
			setFont(font);

			while (getWidth() <= pixels)
				setFont(++font);

			font--;
			setFont(font);

		});

	}

	public void relocate(final double x, final double y) {
		PlatformFX.runLater(() -> this.text.relocate(x, y));
	}

	public final void setOnMouseEntered(EventHandler<? super MouseEvent> value) {
		PlatformFX.runLater(() -> this.text.setOnMouseEntered(value));
	}

	public final void setOnMouseExited(EventHandler<? super MouseEvent> value) {
		PlatformFX.runLater(() -> this.text.setOnMouseExited(value));
	}

	public final void setOnMousePressed(EventHandler<? super MouseEvent> value) {
		PlatformFX.runLater(() -> this.text.setOnMousePressed(value));
	}

	public final void setText(String text) {
		PlatformFX.runLater(() -> this.text.setText(text));
	}

	public final void setFont(final int value) {
		PlatformFX.runLater(() -> this.text.setFont(new Font(value)));
	}

}
