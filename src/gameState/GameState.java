package gameState;

import instances.Instances;
import utils.Logger;

import components.CardEvent;
import components.CardSheep;

import controller.Controller;

public class GameState {

	protected Controller controller = Instances.getControllerInstance();

	public void handleGameStateChange() {

	}

	public void handleCardEventPressed(CardEvent cardEvent) {

		if (this.controller.hand().contains(cardEvent))
			handleCardEventHandPressed(cardEvent);

	}

	protected void handleCardEventHandPressed(CardEvent cardEvent) {
		Logger.logNewLine("hand " + cardEvent.getCardEnum());
	}

	public void handleCardSheepPressed(CardSheep cardSheep) {
		Logger.logNewLine("" + cardSheep.getCardEnum());
	}

}
