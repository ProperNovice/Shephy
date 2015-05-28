package gameState;

import utils.ArrayList;
import utils.Lock;
import utils.Logger;
import components.CardEvent;
import components.CardSheep;
import enums.CardEnum;
import enums.GameStateEnum;
import enums.TextEnum;

public class ChooseEvent extends GameState {

	@Override
	public void handleGameStateChange() {

		showText();

	}

	@Override
	protected void handleCardEventHandPressed(CardEvent cardEvent) {

		super.controller.gameStateController().setGameState(
				GameStateEnum.ANIMATING);

		super.controller.textController().concealText();

		super.removeCardEventFromHandAddToDiscardAnimateSynchronous(cardEvent);

		CardEnum cardEnumPressed = cardEvent.getCardEnum();

		Logger.logNewLine("resolving " + cardEnumPressed);

		switch (cardEnumPressed) {

		case LIGHTNING:
			resolveLightning();
			break;

		case SHEPHION:
			resolveShephion();
			break;

		case CROWDING:
			resolveCrowding();
			break;

		default:
			System.out.println("not yet implemented");

		}

	}

	private void showText() {
		super.controller.textController().showText(TextEnum.CHOOSE_EVENT);
	}

	private void resolveLightning() {

		CardSheep cardSheep = super.controller.board().removeHighestSheep();

		super.controller.sheepFoundation().addCardSheepAnimate(cardSheep);
		Lock.lock();

		super.setGameStateStartNewRound();

	}

	private void resolveShephion() {

		ArrayList<CardSheep> sheep = super.controller.board().removeAllSheep();
		super.controller.sheepFoundation().addCardSheepAnimate(sheep);
		Lock.lock();

		super.setGameStateStartNewRound();

	}

	private void resolveCrowding() {

		int boardSize = super.controller.board().size();

		if (boardSize <= 2) {

			Lock.lock();
			super.setGameStateStartNewRound();
			return;

		}

		if (super.controller.board().allCardsAreSameValue()) {

			ArrayList<CardSheep> sheep = new ArrayList<>();

			while (boardSize > 2) {
				sheep.add(super.controller.board().removeLastSheep());
				boardSize--;
			}

			sheep.reverse();

			super.controller.sheepFoundation().addCardSheepAnimate(sheep);
			Lock.lock();
			super.setGameStateStartNewRound();
			return;

		}

		System.out.println("resove");

	}

}
