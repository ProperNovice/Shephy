package utils;

import instances.Instances;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import utils.EventHandler.EventHandlerAble;

public class TextButton extends Text {

	private Polyline polyline = null;

	public TextButton(String text, EventHandlerAble eventHandlerAble,
			Parent parent) {

		super(text, parent);
		createBorder(parent);

		this.polyline.toFront();
		super.text.toFront();

		super.text.setOnMousePressed(new EventHandler(eventHandlerAble));
		this.polyline.setOnMousePressed(new EventHandler(eventHandlerAble));

		setEventHandlers();

	}

	public TextButton(String text, EventHandlerAble eventHandlerAble) {

		super(text, Instances.getPanelGameInstance());
		createBorder(Instances.getPanelGameInstance());

		this.polyline.toFront();
		super.text.toFront();

		super.text.setOnMousePressed(new EventHandler(eventHandlerAble));
		this.polyline.setOnMousePressed(new EventHandler(eventHandlerAble));

		setEventHandlers();

	}

	private void createBorder(Parent parent) {

		this.polyline = new Polyline(super.getWidth(), super.getHeight(),
				parent);
		this.polyline.setStroke(null);
		this.polyline.setFill(Color.WHEAT);

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
			this.polyline.getPoints().clear();
			this.polyline.getPoints().addAll(0.0, 0.0, getWidth(), 0.0,
					getWidth(), getHeight(), 0.0, getHeight(), 0.0, 0.0);
		});
	}

	@Override
	public void relocate(final double x, double y) {

		PlatformFX.runLater(() -> {
			this.text.relocate(x, y);
			this.polyline.relocate(x, y);
		});

	}

	@Override
	public final void setVisible(final boolean value) {

		PlatformFX.runLater(() -> {
			this.text.setVisible(value);
			this.polyline.setVisible(value);
		});

	}

	protected class OnMouseEntered implements
			javafx.event.EventHandler<MouseEvent> {

		@Override
		public void handle(MouseEvent event) {

			polyline.setFill(Color.BLACK);
			text.setFill(Color.WHITE);

		}

	}

	protected class OnMouseExited implements
			javafx.event.EventHandler<MouseEvent> {

		@Override
		public void handle(MouseEvent event) {

			polyline.setFill(Color.WHEAT);
			text.setFill(Color.BLACK);

		}

	}

	private void setEventHandlers() {

		super.text.setOnMouseEntered(new OnMouseEntered());
		this.polyline.setOnMouseEntered(new OnMouseEntered());
		super.text.setOnMouseExited(new OnMouseExited());
		this.polyline.setOnMouseExited(new OnMouseExited());

	}

}
