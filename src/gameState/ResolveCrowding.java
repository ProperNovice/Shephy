package gameState;

import utils.Lock;
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

		super.controller.board().removeSheepRearrangeSynchronous(cardSheep);
		super.controller.sheepFoundation().addCardSheepAnimateSynchronous(
				cardSheep);

		if (super.controller.board().size() == 2)
			super.controller.textController().concealText();

		Lock.lock();

		if (super.controller.board().size() > 2)
			super.controller.gameStateController().setGameState(
					GameStateEnum.RESOLVE_CROWDING);
		else
			super.controller.gameStateController().setGameState(
					GameStateEnum.START_NEW_ROUND);

	}

}
