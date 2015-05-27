package gameState;

import utils.Lock;
import utils.Logger;
import components.CardEvent;
import components.CardSheep;
import enums.CardEnum;
import enums.GameStateEnum;
import enums.TextEnum;

public class ChooseEvent extends GameState {

	@Override
	public void handleGameStateChange() {

		showText();

	}

	@Override
	protected void handleCardEventHandPressed(CardEvent cardEvent) {

		super.controller.gameStateController().setGameState(
				GameStateEnum.ANIMATING);

		super.controller.textController().concealText();

		CardEnum cardEnumPressed = cardEvent.getCardEnum();

		Logger.logNewLine("resolving " + cardEnumPressed);

		switch (cardEnumPressed) {

		case LIGHTNING:
			resolveLightning(cardEvent);
			break;

		default:
			System.out.println("not yet implemented");

		}

	}

	private void showText() {
		super.controller.textController().showText(TextEnum.CHOOSE_EVENT);
	}

	private void resolveLightning(CardEvent cardEvent) {

		CardSheep cardSheep = super.controller.board().removeHighestSheep();

		super.controller.sheepFoundation().addCardSheepAnimate(cardSheep);
		super.removeCardEventFromHandAddToDiscardAnimate(cardEvent);
		Lock.lock();

		super.setGameStateStartNewRound();

	}

}
