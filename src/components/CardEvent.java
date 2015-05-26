package components;

import javafx.scene.image.Image;
import utils.EventHandler;
import utils.EventHandler.EventHandlerAble;
import enums.CardEnum;

public class CardEvent extends Card implements EventHandlerAble {

	protected Image back = null;
	private boolean isFrontSide = true;

	public CardEvent(CardEnum cardEnum) {

		super(cardEnum);
		super.imageView.setOnMousePressed(new EventHandler(this));

		this.back = new Image("/images/cards/back_02.png");

	}

	@Override
	public void handleMouseButtonPrimary() {
		super.controller.gameStateController().handleCardEventPressed(this);
	}

	public void flip() {

		if (this.isFrontSide) {

			this.isFrontSide = false;
			super.imageView.setImage(this.back);

		} else if (!this.isFrontSide) {

			this.isFrontSide = true;
			super.imageView.setImage(this.front);

		}

	}

}
