package gameState;

import utils.ArrayList;
import utils.Lock;
import utils.Logger;
import components.CardSheep;
import enums.GameStateEnum;
import enums.TextEnum;

public class ResolvePlague extends GameState {

	@Override
	public void handleGameStateChange() {

		super.controller.textController().showText(
				TextEnum.CHOOSE_SHEEP_TO_RELEASE);

	}

	@Override
	protected void handleCardSheepBoardPressed(CardSheep cardSheep) {

		Logger.logNewLine(cardSheep.getCardEnum() + "");

		super.controller.gameStateController().setGameState(
				GameStateEnum.ANIMATING);

		super.controller.textController().concealText();

		ArrayList<CardSheep> list = super.controller.board()
				.removeAllSheepWithRankRearrangeSynchronous(cardSheep);

		super.controller.sheepFoundation().addCardSheepAnimateSynchronous(list);

		Lock.lock();

		super.controller.gameStateController().setGameState(
				GameStateEnum.START_NEW_ROUND);

	}

}
