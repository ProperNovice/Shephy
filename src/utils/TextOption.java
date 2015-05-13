package utils;

import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import utils.EventHandler.EventHandlerAble;

public class TextOption extends Text {

	private Polyline border = null;

	public TextOption(String text, EventHandlerAble eventHandlerAble,
			Parent parent) {

		super(text, parent);
		createBorder(parent);

		this.border.toFront();
		super.text.toFront();

		super.text.setOnMousePressed(new EventHandler(eventHandlerAble));
		this.border.setOnMousePressed(new EventHandler(eventHandlerAble));

		setEventHandlers();

	}

	private void createBorder(Parent parent) {

		this.border = new Polyline(super.getWidth(), super.getHeight(), parent);
		this.border.setStroke(null);
		this.border.setFill(Color.WHEAT);

	}

	@Override
	public void setWidth(final double pixels) {

		PlatformFX.runLater(() -> {

			int font = 1;
			setFont(font);

			while (getWidth() <= pixels)
				setFont(++font);

			font--;
			setFont(font);

			resizePolyLine();

		});

	}

	@Override
	public void setHeight(final double pixels) {

		PlatformFX.runLater(() -> {

			int font = 1;
			setFont(font);

			while (getHeight() <= pixels)
				setFont(++font);

			font--;
			setFont(font);

			resizePolyLine();

		});

	}

	private void resizePolyLine() {

		PlatformFX.runLater(() -> {
			this.border.getPoints().clear();
			this.border.getPoints().addAll(0.0, 0.0, getWidth(), 0.0,
					getWidth(), getHeight(), 0.0, getHeight(), 0.0, 0.0);
		});
	}

	@Override
	public void relocate(final double x, double y) {

		PlatformFX.runLater(() -> {
			this.text.relocate(x, y);
			this.border.relocate(x, y);
		});

	}

	@Override
	public final void setVisible(final boolean value) {

		PlatformFX.runLater(() -> {
			this.text.setVisible(value);
			this.border.setVisible(value);
		});

	}

	protected class OnMouseEntered implements
			javafx.event.EventHandler<MouseEvent> {

		@Override
		public void handle(MouseEvent event) {

			border.setFill(Color.BLACK);
			text.setFill(Color.WHITE);

		}

	}

	protected class OnMouseExited implements
			javafx.event.EventHandler<MouseEvent> {

		@Override
		public void handle(MouseEvent event) {

			border.setFill(Color.WHEAT);
			text.setFill(Color.BLACK);

		}

	}

	private void setEventHandlers() {

		super.text.setOnMouseEntered(new OnMouseEntered());
		this.border.setOnMouseEntered(new OnMouseEntered());
		super.text.setOnMouseExited(new OnMouseExited());
		this.border.setOnMouseExited(new OnMouseExited());

	}

}
