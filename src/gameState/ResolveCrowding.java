package gameState;

import utils.Logger;

import components.CardSheep;

import enums.TextEnum;

public class ResolveCrowding extends GameState {

	@Override
	public void handleGameStateChange() {

		super.controller.textController().showText(
				TextEnum.CHOOSE_SHEEP_TO_RELEASE);

	}

	@Override
	protected void handleCardSheepBoardPressed(CardSheep cardSheep) {

		Logger.logNewLine(cardSheep.getCardEnum() + "");

	}

}
