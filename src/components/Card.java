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

	public void relocate(double x, double y) {
		this.imageView.relocate(x, y);
	}

	public CardEnum getCardEnum() {
		return this.cardEnum;
	}

	public void animate(double endingX, double endingY,
			AnimationSynch animationSynch) {
		Animation.animate(this.imageView, endingX, endingY, animationSynch);
	}

	public void toBack() {
		this.imageView.toBack();
	}

	public void toFront() {
		this.imageView.toFront();
	}

}
