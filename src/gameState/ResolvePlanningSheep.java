package gameState;

import utils.Lock;
import components.CardEvent;
import enums.GameStateEnum;
import enums.TextEnum;

public class ResolvePlanningSheep extends GameState {

	@Override
	public void handleGameStateChange() {

		if (super.controller.hand().size() > 1)
			super.controller.textController().showText(
					TextEnum.CHOOSE_EVENT_TO_REMOVE);
		else
			executeCardEventHandPressed(super.controller.hand().peekSoleCard(),
					false);

	}

	@Override
	protected void handleCardEventHandPressed(CardEvent cardEvent) {

		executeCardEventHandPressed(cardEvent, true);

	}

	private void executeCardEventHandPressed(CardEvent cardEvent, boolean lock) {

		super.controller.gameStateController().setGameState(
				GameStateEnum.ANIMATING);

		super.controller.textController().concealText();

		cardEvent.setVisible(false);

		super.controller.hand()
				.removeCardShiftHandAnimateSynchronous(cardEvent);

		if (lock)
			Lock.lock();

		super.controller.gameStateController().setGameState(
				GameStateEnum.START_NEW_ROUND);

	}

}
