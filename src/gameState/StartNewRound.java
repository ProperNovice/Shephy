package gameState;

import utils.Lock;
import utils.Logger;
import components.CardEvent;

public class StartNewRound extends GameState {

	@Override
	public void handleGameStateChange() {

		fillHand();

		Lock.lock();

	}

	private void fillHand() {

		Logger.logNewLine("refilling hand");

		while (!super.controller.hand().isMaximumSize()) {

			CardEvent cardEvent = super.controller.deck().removeFirstCard();
			cardEvent.flip();
			super.controller.hand().addCardAnimateSynchronous(cardEvent);
			cardEvent.toBack();

		}

		super.controller.deck().toBack();

	}

}
