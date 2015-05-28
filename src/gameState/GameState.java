package gameState;

import instances.Instances;
import utils.Logger;
import components.CardEvent;
import components.CardSheep;
import controller.Controller;
import enums.GameStateEnum;
import enums.TextEnum;

public class GameState {

	protected Controller controller = Instances.getControllerInstance();

	public void handleGameStateChange() {

	}

	public void handleCardEventPressed(CardEvent cardEvent) {

		if (this.controller.hand().contains(cardEvent))
			handleCardEventHandPressed(cardEvent);

	}

	protected void handleCardEventHandPressed(CardEvent cardEvent) {

	}

	public void handleCardSheepPressed(CardSheep cardSheep) {
		Logger.logNewLine("" + cardSheep.getCardEnum());
	}

	public void handleTextOptionPressed(TextEnum textEnum) {
		Logger.logNewLine("" + textEnum);
	}

	protected void setGameStateStartNewRound() {
		this.controller.gameStateController().setGameState(
				GameStateEnum.START_NEW_ROUND);
	}

	protected void removeCardEventFromHandAddToDiscardAnimateSynchronous(
			CardEvent cardEvent) {

		this.controller.hand()
				.removeCardShiftHandAnimateAsynchronous(cardEvent);
		this.controller.discard().addCardAnimateSynchronous(cardEvent);

	}

}
