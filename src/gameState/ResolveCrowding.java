package gameState;

import utils.Animation.AnimationSynch;
import utils.Logger;

import components.CardSheep;

import enums.GameStateEnum;
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

		super.controller.gameStateController().setGameState(
				GameStateEnum.ANIMATING);

		super.controller.board().removeSheepRearrangeAsynchronous(cardSheep);
		super.controller.sheepFoundation().addCardSheepAnimate(cardSheep,
				AnimationSynch.ASYNCHRONOUS);

		if (super.controller.board().size() == 2) {

			super.controller.textController().concealText();
			super.controller.gameStateController().setGameState(
					GameStateEnum.START_NEW_ROUND);

		} else if (super.controller.board().size() > 2)
			super.controller.gameStateController().setGameState(
					GameStateEnum.RESOLVE_CROWDING);

	}

}
