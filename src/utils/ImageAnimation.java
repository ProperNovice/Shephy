package utils;

import java.util.ArrayList;

import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ImageAnimation {

	private ArrayList<Rectangle2D> list = new ArrayList<>();
	private int indexShowing = 0;
	private ImageView imageView = new ImageView();

	public ImageAnimation(String path, int cellsRows, int cellsColumns,
			Parent parent) {

		Image image = new Image("/images/" + path);

		double cellWidth = image.getWidth() / cellsColumns;
		double cellHeight = image.getHeight() / cellsRows;

		for (int row = 0; row < cellsRows; row++)
			for (int column = 0; column < cellsColumns; column++)
				this.list.add(new Rectangle2D(column * cellWidth, row
						* cellHeight, cellWidth, cellHeight));

		this.imageView.setImage(image);
		setViewport();

		parent.addNode(this.imageView);

	}

	public final void setVisible(final boolean value) {
		this.imageView.setVisible(value);
	}

	public void toBack() {
		this.imageView.toBack();
	}

	public void toFront() {
		this.imageView.toFront();
	}

	public final double getLayoutX() {
		return this.imageView.getLayoutX();
	}

	public final double getLayoutY() {
		return this.imageView.getLayoutY();
	}

	public void relocate(final double x, final double y) {
		this.imageView.relocate(x, y);
	}

	public final void setOnMouseEntered(EventHandler<? super MouseEvent> value) {
		this.imageView.setOnMouseEntered(value);
	}

	public final void setOnMouseExited(EventHandler<? super MouseEvent> value) {
		this.imageView.setOnMouseExited(value);
	}

	public final void setOnMousePressed(EventHandler<? super MouseEvent> value) {
		this.imageView.setOnMousePressed(value);
	}

	public void showNext() {

		this.indexShowing++;

		if (this.indexShowing > this.list.size() - 1)
			this.indexShowing = 0;

		setViewport();

	}

	public boolean animationEnded() {

		if (this.indexShowing > 0)
			return false;
		else
			return true;

	}

	public void resetAnimation() {

		this.indexShowing = 0;
		setViewport();

	}

	private void setViewport() {
		this.imageView.setViewport(this.list.get(this.indexShowing));
	}

}
