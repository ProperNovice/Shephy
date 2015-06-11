package gameState;

import utils.ArrayList;
import utils.Lock;
import components.CardSheep;
import enums.GameStateEnum;
import enums.TextEnum;

public class ResolveGoldenHooves extends GameState {

	private ArrayList<CardSheep> cardsSheepThatHaveBeenRaised = new ArrayList<>();

	@Override
	public void handleGameStateChange() {

		createText();

	}

	@Override
	public void handleTextOptionPressed(TextEnum textEnum) {

		super.controller.textController().concealText();

		super.controller.gameStateController().setGameState(
				GameStateEnum.ANIMATING);

		switch (textEnum) {

		case CONTINUE:
			handleEndGameState();
			break;

		case RAISE_THE_RANK_OF_ALL_SHEEP:
			handleRaiseTheRankOfAllSheep();
			break;

		default:
			break;

		}

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

		addSheepPressedToFoundation(cardSheep);
		Lock.lock();

		int higherValue = getHigherValue(cardSheepValue);

		addNextRankToBoard(higherValue);
		Lock.lock();

		if (super.controller.board().stillLeftSheepToRaiseTheRank(
				this.cardsSheepThatHaveBeenRaised))
			super.controller.gameStateController().setGameState(
					GameStateEnum.RESOLVE_GOLDEN_HOOVES);
		else
			handleEndGameState();

	}

	private void handleRaiseTheRankOfAllSheep() {

		ArrayList<CardSheep> sheepToRaiseTheRank = super.controller.board()
				.removeAllSheepThatHaveNotBeenRaisedRearrangeSynchronous(
						this.cardsSheepThatHaveBeenRaised);

		super.controller.sheepFoundation().addCardSheepAnimateSynchronous(
				sheepToRaiseTheRank);
		Lock.lock();

		ArrayList<Integer> nextRank = new ArrayList<>();

		for (CardSheep cardSheep : sheepToRaiseTheRank)
			nextRank.add(getHigherValue(cardSheep.getValue()));

		ArrayList<CardSheep> cardSheepToAddToBoard = new ArrayList<>();

		for (Integer integer : nextRank)
			cardSheepToAddToBoard.add(super.controller.sheepFoundation()
					.removeCardSheep(integer));

		for (CardSheep cardSheep : cardSheepToAddToBoard)
			super.controller.board().addCardSheepAnimateSynchronous(cardSheep);

		Lock.lock();

		handleEndGameState();

	}

	private void handleEndGameState() {

		this.cardsSheepThatHaveBeenRaised.clear();
		super.controller.gameStateController().setGameState(
				GameStateEnum.START_NEW_ROUND);

	}

	private void addSheepPressedToFoundation(CardSheep cardSheep) {

		this.cardsSheepThatHaveBeenRaised.add(cardSheep);

		super.controller.board().removeSheepRearrangeSynchronous(cardSheep);
		super.controller.sheepFoundation().addCardSheepAnimateSynchronous(
				cardSheep);

	}

	private void addNextRankToBoard(int value) {

		CardSheep cardSheepToAdd = super.controller.sheepFoundation()
				.removeCardSheep(value);
		this.cardsSheepThatHaveBeenRaised.add(cardSheepToAdd);

		super.controller.board().addCardSheepAnimateSynchronous(cardSheepToAdd);

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
