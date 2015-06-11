package gameState;

import utils.ArrayList;
import utils.Lock;
import utils.Logger;
import components.CardSheep;
import enums.GameStateEnum;
import enums.TextEnum;

public class ResolveFillTheEarth extends GameState {

	@Override
	public void handleGameStateChange() {

		ArrayList<TextEnum> list = new ArrayList<>();

		list.add(TextEnum.ADD_1_VALUE_SHEEP);
		list.add(TextEnum.FILL_THE_BOARD);
		list.add(TextEnum.CONTINUE);

		super.controller.textController().showText(list);

	}

	@Override
	public void handleTextOptionPressed(TextEnum textEnum) {

		Logger.logNewLine("" + textEnum);

		super.controller.gameStateController().setGameState(
				GameStateEnum.ANIMATING);

		super.controller.textController().concealText();

		switch (textEnum) {

		case ADD_1_VALUE_SHEEP:
			handleAdd1ValueSheep();
			break;

		case FILL_THE_BOARD:
			handleFillTheBoard();
			break;

		case CONTINUE:
			handleContinue();
			break;

		default:
			break;

		}

	}

	private void handleAdd1ValueSheep() {

		CardSheep cardSheep = super.controller.sheepFoundation()
				.removeCardSheep(1);

		super.controller.board().addCardSheepAnimateSynchronous(cardSheep);
		Lock.lock();

		if (!super.controller.board().isFull())
			super.controller.gameStateController().setGameState(
					GameStateEnum.RESOLVE_FILL_THE_EARTH);
		else
			handleContinue();

	}

	private void handleFillTheBoard() {

		while (!super.controller.board().isFull()) {

			CardSheep cardSheep = super.controller.sheepFoundation()
					.removeCardSheep(1);

			super.controller.board().addCardSheepAnimateSynchronous(cardSheep);

		}

		Lock.lock();

		handleContinue();

	}

	private void handleContinue() {

		super.controller.gameStateController().setGameState(
				GameStateEnum.START_NEW_ROUND);

	}

}
