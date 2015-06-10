package gameState;

import utils.Logger;
import components.CardSheep;
import enums.TextEnum;

public class ResolveFillTheEarth extends GameState {

	@Override
	public void handleGameStateChange() {

		super.controller.textController().showText(
				TextEnum.CHOOSE_1_VALUE_SHEEP_TO_ADD);

	}

	@Override
	protected void handleCardSheepFoundationPressed(CardSheep cardSheep) {

		Logger.logNewLine("sheep value " + cardSheep.getValue() + " pressed");

		if (cardSheep.getValue() != 1)
			return;

		System.out.println("passed");

	}

}
