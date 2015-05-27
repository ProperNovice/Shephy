package gameState;

import components.CardSheep;

import enums.GameStateEnum;

public class StartGame extends GameState {

	@Override
	public void handleGameStateChange() {

		addCardSheepToBoard(1);
		addCardSheepToBoard(1);
		addCardSheepToBoard(3);
		addCardSheepToBoard(3);
		addCardSheepToBoard(30);

		super.controller.gameStateController().setGameState(
				GameStateEnum.START_NEW_ROUND);

	}

	private void addCardSheepToBoard(int value) {

		CardSheep cardSheep = super.controller.sheepFoundation().getCardSheep(
				value);
		super.controller.board().addCardSheep(cardSheep);

	}

}
