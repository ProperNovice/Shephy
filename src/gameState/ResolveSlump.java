package gameState;

import utils.ArrayList;
import utils.Lock;
import components.CardSheep;
import enums.GameStateEnum;
import enums.TextEnum;

public class ResolveSlump extends GameState {

	private boolean runningForFirstTime = true;
	private int cardsLeftToDiscard;

	@Override
	public void handleGameStateChange() {

		if (!this.runningForFirstTime)
			super.controller.textController().showText(
					TextEnum.CHOOSE_SHEEP_TO_RELEASE);

		else
			handleRunForFirstTime();

	}

	@Override
	protected void handleCardSheepBoardPressed(CardSheep cardSheep) {

		super.controller.gameStateController().setGameState(
				GameStateEnum.ANIMATING);
		super.controller.textController().concealText();

		super.controller.board().removeSheepRearrangeSynchronous(cardSheep);
		super.controller.sheepFoundation().addCardSheepAnimateSynchronous(
				cardSheep);
		Lock.lock();

		this.cardsLeftToDiscard--;

		if (this.cardsLeftToDiscard > 0)
			super.controller.gameStateController().setGameState(
					GameStateEnum.RESOLVE_SLUMP);
		else
			handleEndEvent();

	}

	@Override
	public void handleTextOptionPressed(TextEnum textEnum) {

		super.controller.gameStateController().setGameState(
				GameStateEnum.ANIMATING);
		super.controller.textController().concealText();

		ArrayList<CardSheep> list = new ArrayList<>();

		for (int counter = 1; counter <= this.cardsLeftToDiscard; counter++)
			list.add(super.controller.board().removeLastSheep());

		super.controller.sheepFoundation().addCardSheepAnimateSynchronous(list);
		Lock.lock();

		handleEndEvent();

	}

	private void handleRunForFirstTime() {

		this.runningForFirstTime = false;
		this.cardsLeftToDiscard = super.controller.board().size() / 2;

		ArrayList<TextEnum> list = new ArrayList<>();

		list.add(TextEnum.CHOOSE_SHEEP_TO_RELEASE);
		list.add(TextEnum.RELEASE_AUTO);

		super.controller.textController().showText(list);

	}

	private void handleEndEvent() {

		this.runningForFirstTime = true;
		super.controller.gameStateController().setGameState(
				GameStateEnum.START_NEW_ROUND);

	}

}
