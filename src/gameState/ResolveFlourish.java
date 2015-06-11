package gameState;

import utils.Lock;
import components.CardSheep;
import enums.GameStateEnum;
import enums.TextEnum;

public class ResolveFlourish extends GameState {

	@Override
	public void handleGameStateChange() {

		if (super.controller.board().allCardsAreSameValueExceptAces())
			addCardsOfValue(getOneRankLower(super.controller.board()
					.getHighestCardValue()));
		else
			super.controller.textController().showText(TextEnum.CHOOSE_SHEEP);

	}

	@Override
	protected void handleCardSheepBoardPressed(CardSheep cardSheep) {

		int cardSheepValue = cardSheep.getValue();

		if (cardSheepValue == 1)
			return;

		super.controller.textController().concealText();

		addCardsOfValue(getOneRankLower(cardSheepValue));

	}

	private void addCardsOfValue(int valueToAdd) {

		super.controller.gameStateController().setGameState(
				GameStateEnum.ANIMATING);

		int cardsToAdd = (int) Math.min(3, super.controller.board()
				.cardsCanBeAdded());

		for (int counter = 1; counter <= cardsToAdd; counter++) {

			CardSheep cardSheep = super.controller.sheepFoundation()
					.removeCardSheep(valueToAdd);
			super.controller.board().addCardSheepAnimateSynchronous(cardSheep);

		}

		Lock.lock();

		super.controller.gameStateController().setGameState(
				GameStateEnum.START_NEW_ROUND);

	}

	private int getOneRankLower(int value) {

		switch (value) {

		case 3:
			return 1;
		case 10:
			return 3;
		case 30:
			return 10;
		case 100:
			return 30;
		case 300:
			return 100;
		case 1000:
			return 300;

		default:
			return -1;

		}

	}

}
