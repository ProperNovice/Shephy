package utils;

import gui.PanelGame;
import instances.Instances;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class Polyline implements Node {

	private javafx.scene.shape.Polyline polyline = new javafx.scene.shape.Polyline();
	private double topLeftX = 0, topLeftY = 0;
	private double dimensionX, dimensionY;

	public Polyline(double x, Parent parent) {
		this.dimensionX = x;
		this.dimensionY = x;
		createPolyline(parent);
	}

	public Polyline(double x) {

		this.dimensionX = x;
		this.dimensionY = x;

		PanelGame panelGame = Instances.getPanelGameInstance();
		createPolyline(panelGame);

	}

	public Polyline(double x, double y, Parent parent) {

		this.dimensionX = x;
		this.dimensionY = y;
		createPolyline(parent);

	}

	public Polyline(double x, double y) {

		this.dimensionX = x;
		this.dimensionY = y;

		PanelGame panelGame = Instances.getPanelGameInstance();
		createPolyline(panelGame);

	}

	public Polyline(Parent parent, double... points) {

		PlatformFX.runLater(() -> {

			Double[] list = new Double[points.length];

			for (int counter = 0; counter < points.length; counter++)
				list[counter] = points[counter];

			this.polyline.getPoints().addAll(list);
			this.polyline.setFill(null);
			this.polyline.setStroke(Color.BLACK);
			parent.addNode(this.polyline);

		});
	}

	public Polyline(double... points) {

		PlatformFX.runLater(() -> {

			Double[] list = new Double[points.length];

			for (int counter = 0; counter < points.length; counter++)
				list[counter] = points[counter];

			this.polyline.getPoints().addAll(list);
			this.polyline.setFill(null);
			this.polyline.setStroke(Color.BLACK);

			PanelGame panelGame = Instances.getPanelGameInstance();
			panelGame.addNode(this.polyline);

		});
	}

	private void createPolyline(Parent parent) {

		PlatformFX.runLater(() -> {

			this.polyline.getPoints().addAll(0.0, 0.0, this.dimensionX, 0.0,
					this.dimensionX, this.dimensionY, 0.0, this.dimensionY,
					0.0, 0.0);

			parent.addNode(this.polyline);
			this.polyline.setFill(null);
			this.polyline.setStroke(Color.BLACK);

		});

	}

	public final ObservableList<Double> getPoints() {
		return polyline.getPoints();
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

	@Override
	public void relocate(double x, double y) {
		this.topLeftX = x;
		this.topLeftY = y;
		PlatformFX.runLater(() -> this.polyline.relocate(x, y));
	}

	public final void setFill(Paint value) {
		PlatformFX.runLater(() -> this.polyline.setFill(value));
	}

	public final void setStroke(Paint value) {
		PlatformFX.runLater(() -> this.polyline.setStroke(value));
	}

	public final void setOnMouseEntered(EventHandler<? super MouseEvent> value) {
		PlatformFX.runLater(() -> this.polyline.setOnMouseEntered(value));
	}

	public final void setOnMouseExited(EventHandler<? super MouseEvent> value) {
		PlatformFX.runLater(() -> this.polyline.setOnMouseExited(value));
	}

	public final void setOnMousePressed(EventHandler<? super MouseEvent> value) {
		PlatformFX.runLater(() -> this.polyline.setOnMousePressed(value));
	}

	public void toBack() {
		PlatformFX.runLater(() -> this.polyline.toBack());
	}

	@Override
	public void toFront() {
		PlatformFX.runLater(() -> this.polyline.toFront());
	}

	public final void setVisible(boolean visibility) {
		PlatformFX.runLater(() -> this.polyline.setVisible(visibility));
	}

	@Override
	public double getLayoutX() {
		return this.polyline.getLayoutX();
	}

	@Override
	public double getLayoutY() {
		return this.polyline.getLayoutY();
	}

}
