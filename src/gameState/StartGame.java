package gameState;

import utils.PlatformFX;

import components.CardEvent;

import enums.CardEnum;

public class StartGame extends GameState {

	@Override
	public void handleGameStateChange() {

		PlatformFX.runLater(() -> new CardEvent(CardEnum.SHEPHION));

	}

}
