package gameState;

import utils.Logger;
import components.CardEvent;
import instances.Instances;
import controller.Controller;

public class GameState {

	protected Controller controller = Instances.getControllerInstance();

	public void handleGameStateChange() {

	}

	public void handleCardEventPressed(CardEvent cardEvent) {
		Logger.logNewLine("pressed " + cardEvent.getCardEnum());
	}

}
