package gameState;

import utils.Lock;
import utils.Animation.AnimationSynch;
import components.CardEvent;
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
		super.controller.hand().removeCardShiftHandAnimateAsynchronous(
				cardEvent);
		super.controller.discard().addCardAnimate(cardEvent,
				AnimationSynch.SYNCHRONOUS);
		Lock.lock();

		super.setGameStateStartNewRound();

	}

}
