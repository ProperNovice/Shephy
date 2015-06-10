package gameState;

import utils.Executor;
import utils.Lock;
import components.CardEvent;
import enums.CardEnum;
import enums.Dimensions;
import enums.GameStateEnum;
import enums.TextEnum;

public class ResolveAllPurposeSheep extends GameState {

	@Override
	public void handleGameStateChange() {

		if (super.controller.hand().size() > 1)
			super.controller.textController().showText(
					TextEnum.CHOOSE_EVENT_TO_PLAY);
		else
			handleCardEventHandPressed(super.controller.hand().peekSoleCard());

	}

	@Override
	protected void handleCardEventHandPressed(CardEvent cardEvent) {

		super.controller.gameStateController().setGameState(
				GameStateEnum.ANIMATING);

		super.controller.textController().concealText();

		CardEnum cardEnumPressed = cardEvent.getCardEnum();

		double x = cardEvent.getCoordinateX();
		double y = cardEvent.getCoordinateY();

		cardEvent.animate(x, y - Dimensions.GAP_BETWEEN_CARDS.y() + 1);
		Lock.lock();

		Executor.sleep(150);

		cardEvent.animate(x, y);

		super.resolveCardEvent(cardEnumPressed);

	}

}
