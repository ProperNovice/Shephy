package components;

import utils.EventHandler;
import utils.EventHandler.EventHandlerAble;
import enums.CardEnum;

public class CardEvent extends Card implements EventHandlerAble {

	public CardEvent(CardEnum cardEnum) {

		super(cardEnum);
		super.imageView.setOnMousePressed(new EventHandler(this));

	}

	@Override
	public void handleMouseButtonPrimary() {
		super.controller.gameStateController().handleCardEventPressed(this);
	}

}
