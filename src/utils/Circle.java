package utils;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class Circle {

	private javafx.scene.shape.Circle circle = null;
	private double topLeftX = 0, topLeftY = 0;
	private double radius;

	public Circle(double radius, Parent parent) {
		this.radius = radius;
		this.circle = new javafx.scene.shape.Circle(this.radius);
		this.circle.setFill(null);
		this.circle.setStroke(Color.BLACK);
		parent.addNode(this.circle);
	}

	public boolean contains(double localX, double localY) {

		double centerX = this.topLeftX + this.radius;
		double centerY = this.topLeftY + this.radius;
		double differenceX = localX - centerX;
		double differenceY = localY - centerY;
		double distance = Math.sqrt(Math.pow(differenceX, 2)
				+ Math.pow(differenceY, 2));

		if (distance <= this.radius)
			return true;
		else
			return false;

	}

	public void relocate(double x, double y) {
		this.topLeftX = x;
		this.topLeftY = y;
		relocate();
	}

	public void relocateCenter(double x, double y) {
		this.topLeftX = x - this.radius;
		this.topLeftY = y - this.radius;
		relocate();
	}

	private void relocate() {
		this.circle.relocate(this.topLeftX, this.topLeftY);
	}

	public final void setFill(Paint value) {
		this.circle.setFill(value);
	}

	public final void setStroke(Paint value) {
		this.circle.setStroke(value);
	}

	public final void setOnMouseEntered(EventHandler<? super MouseEvent> value) {
		this.circle.setOnMouseEntered(value);
	}

	public final void setOnMouseExited(EventHandler<? super MouseEvent> value) {
		this.circle.setOnMouseExited(value);
	}

	public final void setOnMousePressed(EventHandler<? super MouseEvent> value) {
		this.circle.setOnMousePressed(value);
	}

	public final void setRadius(double radius) {

		double centerX = this.topLeftX + this.radius;
		double centerY = this.topLeftY + this.radius;

		this.radius = radius;

		this.topLeftX = centerX - this.radius;
		this.topLeftY = centerY - this.radius;

		circle.setRadius(radius);
		relocate();
	}

	public void toBack() {
		circle.toBack();
	}

	public void toFront() {
		circle.toFront();
	}

}
