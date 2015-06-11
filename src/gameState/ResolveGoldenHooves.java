package gameState;

import utils.ArrayList;
import utils.Lock;
import components.CardSheep;
import enums.GameStateEnum;
import enums.TextEnum;

public class ResolveGoldenHooves extends GameState {

	private boolean runsForFirstTime = true;
	private ArrayList<CardSheep> cardsSheepThatHaveBeenRaised = new ArrayList<>();

	@Override
	public void handleGameStateChange() {

		createText();

	}

	@Override
	public void handleTextOptionPressed(TextEnum textEnum) {

	}

	@Override
	protected void handleCardSheepBoardPressed(CardSheep cardSheep) {

		int highestCardValueBoard = super.controller.board()
				.getHighestCardValue();
		int cardSheepValue = cardSheep.getValue();

		if (highestCardValueBoard == cardSheepValue)
			return;

		if (this.cardsSheepThatHaveBeenRaised.contains(cardSheep))
			return;

		super.controller.gameStateController().setGameState(
				GameStateEnum.ANIMATING);

		super.controller.textController().concealText();

		this.cardsSheepThatHaveBeenRaised.add(cardSheep);

		super.controller.board().removeSheepRearrangeSynchronous(cardSheep);
		super.controller.sheepFoundation().addCardSheepAnimateSynchronous(
				cardSheep);
		Lock.lock();

		int higherValue = getHigherValue(cardSheepValue);
		CardSheep cardSheepToAdd = super.controller.sheepFoundation()
				.removeCardSheep(higherValue);
		this.cardsSheepThatHaveBeenRaised.add(cardSheepToAdd);

		super.controller.board().addCardSheepAnimateSynchronous(cardSheepToAdd);
		Lock.lock();

	}

	private void createText() {

		ArrayList<TextEnum> list = new ArrayList<>();

		list.add(TextEnum.CHOOSE_SHEEP_TO_RAISE_THE_RANK);
		list.add(TextEnum.RAISE_THE_RANK_OF_ALL_SHEEP);
		list.add(TextEnum.CONTINUE);

		super.controller.textController().showText(list);

	}

	private int getHigherValue(int value) {

		if (value == 1)
			return 3;
		else if (value == 3)
			return 10;
		else if (value == 10)
			return 30;
		else if (value == 30)
			return 100;
		else if (value == 100)
			return 300;
		else if (value == 300)
			return 1000;

		return -1;

	}

}
