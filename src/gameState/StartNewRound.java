package gameState;

import utils.Lock;
import utils.Logger;

import components.CardEvent;

import enums.GameStateEnum;

public class StartNewRound extends GameState {

	@Override
	public void handleGameStateChange() {

		if (!super.controller.hand().isMaximumSize()) {

			fillHand();
			Lock.lock();

		}

		super.controller.gameStateController().setGameState(
				GameStateEnum.CHOOSE_EVENT);

	}

	private void fillHand() {

		Logger.logNewLine("refilling hand");

		while (!super.controller.hand().isMaximumSize()) {

			CardEvent cardEvent = super.controller.deck().removeFirstCard();
			cardEvent.flip();
			super.controller.hand().addCardAnimateSynchronous(cardEvent);

		}
	}

}
