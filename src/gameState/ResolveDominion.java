package gameState;

import utils.ArrayList;
import utils.Lock;
import components.CardSheep;
import enums.GameStateEnum;
import enums.TextEnum;

public class ResolveDominion extends GameState {

	private int totalSheepValueReleased = 0;

	@Override
	public void handleGameStateChange() {

		ArrayList<TextEnum> list = new ArrayList<>();

		list.add(TextEnum.CHOOSE_SHEEP_TO_RELEASE);

		if (this.totalSheepValueReleased > 0)
			list.add(TextEnum.CONTINUE);

		super.controller.textController().showText(list);

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

		this.totalSheepValueReleased += cardSheep.getValue();

		if (super.controller.board().size() > 0)
			super.controller.gameStateController().setGameState(
					GameStateEnum.RESOLVE_DOMINION);
		else
			handleResolve();

	}

	@Override
	public void handleTextOptionPressed(TextEnum textEnum) {
		handleResolve();
	}

	private void handleResolve() {

		int sheepValueToAdd = -1;

		if (this.totalSheepValueReleased >= 1000)
			sheepValueToAdd = 1000;
		else if (this.totalSheepValueReleased >= 300)
			sheepValueToAdd = 300;
		else if (this.totalSheepValueReleased >= 100)
			sheepValueToAdd = 100;
		else if (this.totalSheepValueReleased >= 30)
			sheepValueToAdd = 30;
		else if (this.totalSheepValueReleased >= 10)
			sheepValueToAdd = 10;
		else if (this.totalSheepValueReleased >= 3)
			sheepValueToAdd = 3;
		else if (this.totalSheepValueReleased >= 1)
			sheepValueToAdd = 1;

		CardSheep cardSheep = super.controller.sheepFoundation()
				.removeCardSheep(sheepValueToAdd);

		super.controller.board().addCardSheepAnimateSynchronous(cardSheep);
		Lock.lock();

		this.totalSheepValueReleased = 0;
		super.controller.gameStateController().setGameState(
				GameStateEnum.START_NEW_ROUND);

	}

}
