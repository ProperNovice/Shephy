package gameState;

import utils.ArrayList;
import utils.Lock;
import utils.Logger;
import components.CardEvent;
import enums.GameStateEnum;

public class StartNewRound extends GameState {

	@Override
	public void handleGameStateChange() {

		if (super.controller.board().isEmpty()) {

			super.controller.gameStateController().setGameState(
					GameStateEnum.HANDLE_END_GAME);
			return;

		} else if (!super.controller.deck().isEmpty()
				&& !super.controller.hand().isMaximumSize()) {

			Logger.logNewLine("refilling hand");

			fillHand();
			Lock.lock();

			super.controller.gameStateController().setGameState(
					GameStateEnum.CHOOSE_EVENT);

		} else if (super.controller.hand().isEmpty()) {

			super.controller.roundController()
					.proceedToNextRoundAnimateSynchronous();

			if (super.controller.roundController().gameEnded()) {

				Lock.lock();
				super.controller.gameStateController().setGameState(
						GameStateEnum.HANDLE_END_GAME);

			} else {

				shuffleDiscardPileToDeck();
				Lock.lock();

				fillHand();
				Lock.lock();

				super.controller.gameStateController().setGameState(
						GameStateEnum.CHOOSE_EVENT);

			}

		} else
			super.controller.gameStateController().setGameState(
					GameStateEnum.CHOOSE_EVENT);

	}

	private void fillHand() {

		if (super.controller.hand().isMaximumSize())
			return;

		if (super.controller.deck().isEmpty())
			return;

		CardEvent cardEvent = super.controller.deck().removeFirstCard();
		cardEvent.flip();
		super.controller.hand().addCard(cardEvent);
		super.controller.hand().shiftHand();

		fillHand();

	}

	private void shuffleDiscardPileToDeck() {

		ArrayList<CardEvent> discard = super.controller.discard().remove();

		super.controller.deck().addCards(discard);
		super.controller.deck().flipDeck();
		Lock.lock();

		super.controller.deck().wrapUpDeckShuffleAnimateSynchronous();

	}

}
