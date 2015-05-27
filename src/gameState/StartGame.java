package gameState;

import components.CardSheep;

import enums.GameStateEnum;

public class StartGame extends GameState {

	@Override
	public void handleGameStateChange() {

		CardSheep cardSheep = super.controller.sheepFoundation().getCardSheep(1);
		super.controller.board().addCardSheep(cardSheep);

		super.controller.gameStateController().setGameState(
				GameStateEnum.START_NEW_ROUND);

	}

}
