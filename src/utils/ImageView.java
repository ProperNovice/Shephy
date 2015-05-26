package utils;

import instances.Instances;
import gui.PanelGame;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;

public class ImageView implements Node {

	private javafx.scene.image.ImageView imageView = null;
	private double scale = 1;

	public ImageView(String path) {

		String finalPath = "/images/" + path;
		this.imageView = new javafx.scene.image.ImageView(finalPath);

		PanelGame panelGame = Instances.getPanelGameInstance();
		addNode(panelGame);

	}

	public ImageView(Image image) {

		this.imageView = new javafx.scene.image.ImageView(image);

		PanelGame panelGame = Instances.getPanelGameInstance();
		addNode(panelGame);

	}

	private void addNode(Parent parent) {
		PlatformFX.runLater(() -> parent.addNode(this.imageView));
	}

	public final void setVisible(final boolean value) {
		PlatformFX.runLater(() -> this.imageView.setVisible(value));
	}

	public void toBack() {
		PlatformFX.runLater(() -> this.imageView.toBack());
	}

	@Override
	public void toFront() {
		PlatformFX.runLater(() -> this.imageView.toFront());
	}

	@Override
	public final double getLayoutX() {
		return this.imageView.getLayoutX();
	}

	@Override
	public final double getLayoutY() {
		return this.imageView.getLayoutY();
	}

	@Override
	public void relocate(final double x, final double y) {
		PlatformFX.runLater(() -> this.imageView.relocate(x, y));
	}

	public final void setViewport(double x, double y, double width,
			double height) {

		Rectangle2D rectangle2d = new Rectangle2D(x, y, width, height);

		PlatformFX.runLater(() -> this.imageView.setViewport(rectangle2d));

	}

	public final void setClip(double x, double y, double width, double height) {

		Rectangle rectangle = new Rectangle(x, y, width, height);

		PlatformFX.runLater(() -> this.imageView.setClip(rectangle));
	}

	public final void setRotate(double value) {
		PlatformFX.runLater(() -> this.imageView.setRotate(value));
	}

	public final void setOnMouseEntered(EventHandler<? super MouseEvent> value) {
		PlatformFX.runLater(() -> this.imageView.setOnMouseEntered(value));
	}

	public final void setOnMouseExited(EventHandler<? super MouseEvent> value) {
		PlatformFX.runLater(() -> this.imageView.setOnMouseExited(value));
	}

	public final void setOnMousePressed(EventHandler<? super MouseEvent> value) {
		PlatformFX.runLater(() -> this.imageView.setOnMousePressed(value));
	}

	public final void setImage(final Image image) {
		PlatformFX.runLater(() -> this.imageView.setImage(image));
	}

	public final Image getImage() {
		return this.imageView.getImage();
	}

	public final void setScale(double scale) {

		PlatformFX.runLater(() -> {

			this.scale = scale;

			this.imageView.setScaleX(this.scale);
			this.imageView.setScaleY(this.scale);

			double widthTotal = this.imageView.minWidth(0);
			double heightTotal = this.imageView.minHeight(0);

			double widthNew = this.scale * widthTotal;
			double heightNew = this.scale * heightTotal;

			double translateX = (widthNew - widthTotal) / 2;
			double translateY = (heightNew - heightTotal) / 2;

			this.imageView.setTranslateX(translateX);
			this.imageView.setTranslateY(translateY);

		});

	}

	public void setWidth(double width) {

		double scale = width / this.imageView.minWidth(0);
		setScale(scale);

	}

	public void setHeight(double height) {

		double scale = height / this.imageView.minHeight(0);
		setScale(scale);

	}

	public double getWidth() {
		return this.imageView.minWidth(0) * this.scale;
	}

	public double getHeight() {
		return this.imageView.minHeight(0) * this.scale;
	}

	public double getScale() {
		return this.scale;
	}

}
