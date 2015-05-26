package components;

import instances.Instances;
import utils.Animation;
import utils.Animation.AnimationSynch;
import utils.ImageView;
import controller.Controller;
import enums.CardEnum;
import enums.Dimensions;

public class Card {

	protected ImageView imageView = null;
	protected CardEnum cardEnum = null;
	protected Controller controller = Instances.getControllerInstance();

	public Card(CardEnum cardEnum) {

		this.cardEnum = cardEnum;
		createImageview();

	}

	protected void createImageview() {

		double topLeftX = Dimensions.CARD_IMAGE_TOP_LEFT.x();
		double topLeftY = Dimensions.CARD_IMAGE_TOP_LEFT.y();
		double width = Dimensions.CARD_IMAGE_DIMENSION.x();
		double height = Dimensions.CARD_IMAGE_DIMENSION.y();

		topLeftX += this.cardEnum.column() * width;
		topLeftY += this.cardEnum.row() * height;

		String path = "/cards/front_" + this.cardEnum.filename() + ".png";

		this.imageView = new ImageView(path);
		this.imageView.setViewport(topLeftX, topLeftY, width, height);

		this.imageView.setWidth(Dimensions.CARD.x());

	}

	public void relocate(double x, double y) {
		this.imageView.relocate(x, y);
	}

	public CardEnum getCardEnum() {
		return this.cardEnum;
	}

	public void animate(double endingX, double endingY) {
		Animation.animate(this.imageView, endingX, endingY,
				AnimationSynch.SYNCHRONOUS);
	}

}
