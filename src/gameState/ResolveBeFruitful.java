package gameState;

import utils.Lock;
import components.CardSheep;
import enums.GameStateEnum;
import enums.TextEnum;

public class ResolveBeFruitful extends GameState {

	@Override
	public void handleGameStateChange() {

		super.controller.textController().showText(
				TextEnum.CHOOSE_SHEEP_TO_DUPLICATE);

	}

	@Override
	public void handleCardSheepPressed(CardSheep cardSheep) {

		super.controller.gameStateController().setGameState(
				GameStateEnum.ANIMATING);

		super.controller.textController().concealText();

		int value = cardSheep.getValue();

		CardSheep cardSheepToAdd = super.controller.sheepFoundation()
				.removeCardSheep(value);

		super.controller.board().addCardSheepAnimateSynchronous(cardSheepToAdd);
		Lock.lock();

		super.controller.gameStateController().setGameState(
				GameStateEnum.START_NEW_ROUND);

	}

}
