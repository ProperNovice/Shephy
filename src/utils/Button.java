package utils;

import gui.PanelGame;
import instances.Instances;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;

public class Button implements Node {

	private javafx.scene.control.Button button = null;

	public Button(String text, Parent parent) {

		this.button = new javafx.scene.control.Button(text);
		PlatformFX.runLater(() -> this.button.setFocusTraversable(false));
		parent.addNode(this.button);

	}

	public Button(String text) {

		this.button = new javafx.scene.control.Button(text);
		PlatformFX.runLater(() -> this.button.setFocusTraversable(false));

		PanelGame panelGame = Instances.getPanelGameInstance();
		panelGame.addNode(this.button);

	}

	public final void setVisible(final boolean value) {
		PlatformFX.runLater(() -> this.button.setVisible(value));
	}

	@Override
	public final double getLayoutX() {
		return this.button.getLayoutX();
	}

	@Override
	public final double getLayoutY() {
		return this.button.getLayoutY();
	}

	public void toBack() {
		PlatformFX.runLater(() -> this.button.toBack());
	}

	@Override
	public void toFront() {
		PlatformFX.runLater(() -> this.button.toFront());
	}

	@Override
	public void relocate(final double x, final double y) {
		PlatformFX.runLater(() -> this.button.relocate(x, y));
	}

	public final void setOnMouseEntered(EventHandler<? super MouseEvent> value) {
		PlatformFX.runLater(() -> this.button.setOnMouseEntered(value));
	}

	public final void setOnMouseExited(EventHandler<? super MouseEvent> value) {
		PlatformFX.runLater(() -> this.button.setOnMouseExited(value));
	}

	public final void setOnMousePressed(EventHandler<? super MouseEvent> value) {
		PlatformFX.runLater(() -> this.button.setOnMousePressed(value));
	}

	public final void setText(String text) {
		PlatformFX.runLater(() -> this.button.setText(text));
	}

	public final void setFont(int value) {
		PlatformFX.runLater(() -> this.button.setFont(new Font(value)));
	}

	public void setSize(double width, double height) {

		PlatformFX.runLater(() -> {

			this.button.setMinSize(width, height);
			this.button.setMaxSize(width, height);

		});

	}

	public final void setHeight(double value) {

		PlatformFX.runLater(() -> {

			this.button.setMinHeight(value);
			this.button.setMaxHeight(value);

		});

	}

	public final void setWidth(double value) {

		PlatformFX.runLater(() -> {

			this.button.setMinWidth(value);
			this.button.setMaxWidth(value);

		});

	}

}
