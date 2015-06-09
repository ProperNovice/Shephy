package gameState;

import utils.Lock;
import utils.Logger;
import components.CardSheep;
import enums.GameStateEnum;
import enums.TextEnum;

public class ResolveMeteor extends GameState {

	private int cardSheepLeftToDiscard = 3;

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

		super.controller.textController().concealText();

		this.cardSheepLeftToDiscard--;

		super.controller.board().removeSheepRearrangeSynchronous(cardSheep);
		super.controller.sheepFoundation().addCardSheepAnimateSynchronous(
				cardSheep);

		Lock.lock();

		if (this.cardSheepLeftToDiscard > 0)
			super.controller.gameStateController().setGameState(
					GameStateEnum.RESOLVE_METEOR);

		else if (this.cardSheepLeftToDiscard == 0) {

			this.cardSheepLeftToDiscard = 3;
			super.controller.gameStateController().setGameState(
					GameStateEnum.START_NEW_ROUND);

		}

	}

}
