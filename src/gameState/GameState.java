package gameState;

import instances.Instances;
import utils.Animation.AnimationSynch;
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

	protected void setGameStateStartNewRound() {
		this.controller.gameStateController().setGameState(
				GameStateEnum.START_NEW_ROUND);
	}

	protected void removeCardEventFromHandAddToDiscardAnimateAsynchronous(
			CardEvent cardEvent) {

		this.controller.hand()
				.removeCardShiftHandAnimateAsynchronous(cardEvent);
		this.controller.discard().addCardAnimate(cardEvent,
				AnimationSynch.ASYNCHRONOUS);

	}

	protected void resolveLightning() {

		CardSheep cardSheep = this.controller.board()
				.removeHighestSheepRearrangeAsynchronous();

		this.controller.sheepFoundation().addCardSheepAnimate(cardSheep,
				AnimationSynch.ASYNCHRONOUS);

		this.setGameStateStartNewRound();

	}

	protected void resolveShephion() {

		ArrayList<CardSheep> sheep = this.controller.board().removeAllSheep();
		this.controller.sheepFoundation().addCardSheepAnimate(sheep,
				AnimationSynch.ASYNCHRONOUS);

		this.setGameStateStartNewRound();

	}

	protected void resolveCrowding() {

		int boardSize = this.controller.board().size();

		if (boardSize <= 2) {

			this.setGameStateStartNewRound();
			return;

		}

		if (this.controller.board().allCardsAreSameValue()) {

			ArrayList<CardSheep> sheep = new ArrayList<>();

			while (boardSize > 2) {
				sheep.add(this.controller.board().removeLastSheep());
				boardSize--;
			}

			sheep.reverse();

			this.controller.sheepFoundation().addCardSheepAnimate(sheep,
					AnimationSynch.SYNCHRONOUS);
			Lock.lock();

			this.setGameStateStartNewRound();
			return;

		}

		this.controller.gameStateController().setGameState(
				GameStateEnum.RESOLVE_CROWDING);

	}

	protected void resolveFallingRock() {

		if (this.controller.board().size() == 1
				|| this.controller.board().allCardsAreSameValue()) {

			CardSheep cardSheep = this.controller.board().removeLastSheep();
			this.controller.sheepFoundation().addCardSheepAnimate(cardSheep,
					AnimationSynch.ASYNCHRONOUS);

			this.setGameStateStartNewRound();
			return;

		}

		this.controller.gameStateController().setGameState(
				GameStateEnum.RESOLVE_FALLING_ROCK);

	}

	protected void resolveMultiply() {

		Logger.logNewLine("resolving multiply");

		if (this.controller.board().isFull()) {
			this.setGameStateStartNewRound();
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

			this.controller.gameStateController().setGameState(
					GameStateEnum.START_NEW_ROUND);
			return;
		}

		if (this.controller.hand().size() == 1) {

			CardEvent cardEvent = this.controller.hand().removeSoleCard();
			this.controller.discard().addCardAnimate(cardEvent,
					AnimationSynch.SYNCHRONOUS);
			Lock.lock();

			this.controller.gameStateController().setGameState(
					GameStateEnum.START_NEW_ROUND);
			return;

		}

		this.controller.gameStateController().setGameState(
				GameStateEnum.RESOLVE_SHEEP_DOG);

	}

}
