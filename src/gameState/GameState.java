package gameState;

import instances.Instances;
import utils.ArrayList;
import utils.Lock;
import utils.Logger;

import components.CardEvent;
import components.CardSheep;

import controller.Controller;
import enums.GameStateEnum;
import enums.TextEnum;

public class GameState {

	protected Controller controller = Instances.getControllerInstance();

	public void handleGameStateChange() {

	}

	public void handleCardEventPressed(CardEvent cardEvent) {

		if (this.controller.hand().contains(cardEvent))
			handleCardEventHandPressed(cardEvent);

	}

	protected void handleCardEventHandPressed(CardEvent cardEvent) {

	}

	public void handleCardSheepPressed(CardSheep cardSheep) {

		if (this.controller.board().contains(cardSheep))
			handleCardSheepBoardPressed(cardSheep);

	}

	protected void handleCardSheepBoardPressed(CardSheep cardSheep) {

	}

	public void handleTextOptionPressed(TextEnum textEnum) {
		Logger.logNewLine("" + textEnum);
	}

	protected void removeCardEventFromHandHandleAnimateSynchronous(
			CardEvent cardEvent) {

		this.controller.hand().removeCardShiftHandAnimateSynchronous(cardEvent);

		if (cardEvent.goesToDiscardPile())
			this.controller.discard().addCardAnimateSynchronous(cardEvent);
		else
			cardEvent.setVisibleFalse();

	}

	protected void resolveLightning() {

		CardSheep cardSheep = this.controller.board()
				.removeHighestSheepRearrangeSynchronous();

		this.controller.sheepFoundation().addCardSheepAnimateSynchronous(
				cardSheep);

		Lock.lock();

		this.controller.gameStateController().setGameState(
				GameStateEnum.START_NEW_ROUND);

	}

	protected void resolveShephion() {

		ArrayList<CardSheep> sheep = this.controller.board().removeAllSheep();
		this.controller.sheepFoundation().addCardSheepAnimateSynchronous(sheep);

		Lock.lock();

		this.controller.gameStateController().setGameState(
				GameStateEnum.START_NEW_ROUND);

	}

	protected void resolveCrowding() {

		if (this.controller.board().size() <= 2) {

			Lock.lock();

			this.controller.gameStateController().setGameState(
					GameStateEnum.START_NEW_ROUND);
			return;

		}

		if (this.controller.board().allCardsAreSameValue()) {

			ArrayList<CardSheep> sheep = new ArrayList<>();

			while (this.controller.board().size() > 2)
				sheep.add(this.controller.board().removeLastSheep());

			sheep.reverse();

			this.controller.sheepFoundation().addCardSheepAnimateSynchronous(
					sheep);

			Lock.lock();

			this.controller.gameStateController().setGameState(
					GameStateEnum.START_NEW_ROUND);
			return;

		}

		Lock.lock();

		this.controller.gameStateController().setGameState(
				GameStateEnum.RESOLVE_CROWDING);

	}

	protected void resolveFallingRock() {

		if (this.controller.board().size() == 1
				|| this.controller.board().allCardsAreSameValue()) {

			CardSheep cardSheep = this.controller.board().removeLastSheep();
			this.controller.sheepFoundation().addCardSheepAnimateSynchronous(
					cardSheep);

			Lock.lock();

			this.controller.gameStateController().setGameState(
					GameStateEnum.START_NEW_ROUND);
			return;

		}

		Lock.lock();

		this.controller.gameStateController().setGameState(
				GameStateEnum.RESOLVE_FALLING_ROCK);

	}

	protected void resolveMultiply() {

		Logger.logNewLine("resolving multiply");

		if (this.controller.board().isFull()) {

			Lock.lock();
			this.controller.gameStateController().setGameState(
					GameStateEnum.START_NEW_ROUND);
			return;

		}

		CardSheep cardSheep = this.controller.sheepFoundation().getCardSheep(3);

		this.controller.board().addCardSheepAnimateSynchronous(cardSheep);

		Lock.lock();

		this.controller.gameStateController().setGameState(
				GameStateEnum.START_NEW_ROUND);

	}

	protected void resolveSheepDog() {

		if (this.controller.hand().isEmpty()) {

			Lock.lock();

			this.controller.gameStateController().setGameState(
					GameStateEnum.START_NEW_ROUND);
			return;
		}

		if (this.controller.hand().size() == 1) {

			CardEvent cardEvent = this.controller.hand().removeSoleCard();
			this.controller.discard().addCardAnimateSynchronous(cardEvent);

			Lock.lock();

			this.controller.gameStateController().setGameState(
					GameStateEnum.START_NEW_ROUND);
			return;

		}

		Lock.lock();

		this.controller.gameStateController().setGameState(
				GameStateEnum.RESOLVE_SHEEP_DOG);

	}

	protected void resolveMeteor() {

		if (this.controller.board().size() <= 3
				|| this.controller.board().allCardsAreSameValue()) {

			int sheepCardsToDiscard = (int) Math.min(this.controller.board()
					.size(), 3);

			for (int counter = 1; counter <= sheepCardsToDiscard; counter++) {

				CardSheep cardSheep = this.controller.board()
						.removeHighestSheepRearrangeSynchronous();

				this.controller.sheepFoundation()
						.addCardSheepAnimateSynchronous(cardSheep);

			}

			Lock.lock();

			this.controller.gameStateController().setGameState(
					GameStateEnum.START_NEW_ROUND);

		}

	}

}
