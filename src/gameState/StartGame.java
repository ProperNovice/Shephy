package gameState;

import components.CardSheep;

import enums.GameStateEnum;

public class StartGame extends GameState {

	@Override
	public void handleGameStateChange() {

		addCardSheepToBoard(1);

		super.controller.gameStateController().setGameState(
				GameStateEnum.START_NEW_ROUND);

	}

	private void addCardSheepToBoard(int value) {

		CardSheep cardSheep = super.controller.sheepFoundation()
				.removeCardSheep(value);
		super.controller.board().addCardSheepAnimateSynchronous(cardSheep);

	}

	// private void addCardsFromDeckToDiscardPile(int numberOfCards) {
	//
	// for (int counter = 1; counter <= numberOfCards; counter++) {
	// CardEvent cardEvent = super.controller.deck().removeFirstCard();
	// cardEvent.flip();
	// super.controller.discard().addCardAnimateSynchronous(cardEvent);
	// }
	//
	// }

	// private void setCardAsFirst(CardEnum cardEnum) {
	// super.controller.deck().setCardAsFirst(cardEnum);
	// }

	// TestFX text controller, anadiarthrosh sto show text ena ena na ta bazei
	// se sosth seira

}
