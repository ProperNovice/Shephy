package components;

import instances.Instances;
import javafx.scene.image.Image;
import utils.Animation;
import utils.Animation.AnimationSynch;
import utils.ImageView;
import controller.Controller;
import enums.CardEnum;
import enums.Dimensions;

public class Card {

	protected ImageView imageView = null;
	protected Image front = null;
	protected CardEnum cardEnum = null;
	protected Controller controller = Instances.getControllerInstance();
	private double coordinateX, coordinateY;

	public Card(CardEnum cardEnum) {

		this.cardEnum = cardEnum;
		createImageview();

	}

	protected void createImageview() {

		String path = "/images/cards/" + this.cardEnum.filename() + ".png";
		this.front = new Image(path);

		this.imageView = new ImageView(this.front);

		this.imageView.setWidth(Dimensions.CARD.x());

	}

	private void updateCoordinates(double coordinateX, double coordinateY) {
		this.coordinateX = coordinateX;
		this.coordinateY = coordinateY;
	}

	public void relocate(double x, double y) {
		updateCoordinates(x, y);
		this.imageView.relocate(x, y);
	}

	public CardEnum getCardEnum() {
		return this.cardEnum;
	}

	public void animate(double endingX, double endingY) {
		updateCoordinates(endingX, endingY);
		Animation.animate(this.imageView, endingX, endingY,
				AnimationSynch.SYNCHRONOUS);
	}

	public void toBack() {
		this.imageView.toBack();
	}

	public void toFront() {
		this.imageView.toFront();
	}

	public double getCoordinateX() {
		return this.coordinateX;
	}

	public double getCoordinateY() {
		return this.coordinateY;
	}

}
