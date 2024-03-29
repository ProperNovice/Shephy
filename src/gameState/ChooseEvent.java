package gameState;

import components.CardEvent;

import enums.CardEnum;
import enums.GameStateEnum;
import enums.TextEnum;

public class ChooseEvent extends GameState {

	@Override
	public void handleGameStateChange() {

		super.controller.textController().showText(TextEnum.CHOOSE_EVENT);

	}

	@Override
	protected void handleCardEventHandPressed(CardEvent cardEvent) {

		super.controller.gameStateController().setGameState(
				GameStateEnum.ANIMATING);

		super.controller.textController().concealText();

		super.removeCardEventFromHandHandleAnimateSynchronous(cardEvent);

		CardEnum cardEnumPressed = cardEvent.getCardEnum();

		super.resolveCardEvent(cardEnumPressed);

	}

}
