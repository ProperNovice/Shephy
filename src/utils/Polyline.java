package utils;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class Polyline {

	private javafx.scene.shape.Polyline polyline = new javafx.scene.shape.Polyline();
	private double topLeftX = 0, topLeftY = 0;
	private double dimensionX, dimensionY;

	public Polyline(double x, Parent parent) {
		this.dimensionX = x;
		this.dimensionY = x;
		createPolyline(parent);
	}

	public Polyline(double x, double y, Parent parent) {
		this.dimensionX = x;
		this.dimensionY = y;
		createPolyline(parent);
	}

	private void createPolyline(Parent parent) {

		this.polyline.getPoints().addAll(0.0, 0.0, this.dimensionX, 0.0,
				this.dimensionX, this.dimensionY, 0.0, this.dimensionY, 0.0,
				0.0);

		parent.addNode(this.polyline);
		this.polyline.setFill(null);
		this.polyline.setStroke(Color.BLACK);

	}

	public boolean contains(double localX, double localY) {

		if (localX < this.topLeftX)
			return false;

		if (localX > this.topLeftX + this.dimensionX)
			return false;

		if (localY < this.topLeftY)
			return false;

		if (localY > this.topLeftY + this.dimensionY)
			return false;

		return true;

	}

	public void relocate(double x, double y) {
		this.topLeftX = x;
		this.topLeftY = y;
		this.polyline.relocate(x, y);
	}

	public final void setFill(Paint value) {
		this.polyline.setFill(value);
	}

	public final void setStroke(Paint value) {
		this.polyline.setStroke(value);
	}

	public final void setOnMouseEntered(EventHandler<? super MouseEvent> value) {
		this.polyline.setOnMouseEntered(value);
	}

	public final void setOnMouseExited(EventHandler<? super MouseEvent> value) {
		this.polyline.setOnMouseExited(value);
	}

	public final void setOnMousePressed(EventHandler<? super MouseEvent> value) {
		this.polyline.setOnMousePressed(value);
	}

	public void toBack() {
		this.polyline.toBack();
	}

	public void toFront() {
		this.polyline.toFront();
	}

	public final void setVisible(boolean visibility) {
		this.polyline.setVisible(visibility);
	}

}
