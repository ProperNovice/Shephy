package components;

import utils.EventHandler;
import utils.EventHandler.EventHandlerAble;
import enums.CardEnum;

public class CardSheep extends Card implements EventHandlerAble {

	private int value;

	public CardSheep(CardEnum cardEnum, int value) {

		super(cardEnum);
		this.value = value;
		super.imageView.setOnMousePressed(new EventHandler(this));

	}

	public int getValue() {
		return this.value;
	}

	@Override
	public void handleMouseButtonPrimary() {
		super.controller.gameStateController().handleCardSheepPressed(this);
	}

}
