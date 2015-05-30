package gameState;

import utils.Logger;

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

		super.removeCardEventFromHandAddToDiscardAnimateSynchronous(cardEvent);

		CardEnum cardEnumPressed = cardEvent.getCardEnum();

		Logger.logNewLine("resolving " + cardEnumPressed);

		switch (cardEnumPressed) {

		case LIGHTNING:
			super.resolveLightning();
			break;

		case SHEPHION:
			super.resolveShephion();
			break;

		case CROWDING:
			super.resolveCrowding();
			break;

		case FALLING_ROCK:
			super.resolveFallingRock();
			break;

		case MULTIPLY:
			super.resolveMultiply();

		default:
			System.out.println("not yet implemented");

		}

	}

}
