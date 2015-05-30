package gameState;

import utils.Lock;
import components.CardEvent;
import enums.GameStateEnum;
import enums.TextEnum;

public class ResolveSheepDog extends GameState {

	@Override
	public void handleGameStateChange() {

		super.controller.textController().showText(
				TextEnum.CHOOSE_EVENT_TO_DISCARD);

	}

	@Override
	protected void handleCardEventHandPressed(CardEvent cardEvent) {

		super.controller.textController().concealText();
		super.controller.hand()
				.removeCardShiftHandAnimateSynchronous(cardEvent);

		super.controller.discard().addCardAnimateSynchronous(cardEvent);
		Lock.lock();

		super.controller.gameStateController().setGameState(
				GameStateEnum.START_NEW_ROUND);

	}

}
