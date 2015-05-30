package gameState;

import utils.Lock;
import utils.Logger;
import components.CardSheep;
import enums.GameStateEnum;
import enums.TextEnum;

public class ResolveFallingRock extends GameState {

	@Override
	public void handleGameStateChange() {

		super.controller.textController().showText(
				TextEnum.CHOOSE_SHEEP_TO_RELEASE);

	}

	@Override
	protected void handleCardSheepBoardPressed(CardSheep cardSheep) {

		super.controller.textController().concealText();

		Logger.logNewLine(cardSheep.getCardEnum() + "");

		super.controller.gameStateController().setGameState(
				GameStateEnum.ANIMATING);

		super.controller.board().removeSheepRearrangeSynchronous(cardSheep);
		super.controller.sheepFoundation().addCardSheepAnimateSynchronous(
				cardSheep);

		Lock.lock();

		super.controller.gameStateController().setGameState(
				GameStateEnum.START_NEW_ROUND);

	}

}
