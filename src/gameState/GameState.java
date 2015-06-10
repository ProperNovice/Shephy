package gameState;

import instances.Instances;
import utils.ArrayList;
import utils.Lock;
import utils.Logger;
import components.CardEvent;
import components.CardSheep;
import controller.Controller;
import enums.CardEnum;
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
		else if (this.controller.sheepFoundation().containsSheep(cardSheep))
			handleCardSheepFoundationPressed(cardSheep);

	}

	protected void handleCardSheepBoardPressed(CardSheep cardSheep) {

	}

	protected void handleCardSheepFoundationPressed(CardSheep cardSheep) {

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

	protected void resolveCardEvent(CardEnum cardEnumPressed) {

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

		case FALLING_ROCK:
			resolveFallingRock();
			break;

		case MULTIPLY:
			resolveMultiply();
			break;

		case SHEEP_DOG:
			resolveSheepDog();
			break;

		case METEOR:
			resolveMeteor();
			break;

		case PLAGUE:
			resolvePlague();
			break;

		case STORM:
			resolveStorm();
			break;

		case BE_FRUITFUL:
			resolveBeFruitful();
			break;

		case ALL_PURPOSE_SHEEP:
			resolveAllPurposeSheep();
			break;

		case PLANNING_SHEEP:
			resolvePlanningSheep();
			break;

		case FILL_THE_EARTH:
			resolveFillTheEarth();
			break;

		default:
			System.out.println("not yet implemented");

		}

	}

	private void resolveLightning() {

		CardSheep cardSheep = this.controller.board()
				.removeHighestSheepRearrangeSynchronous();

		this.controller.sheepFoundation().addCardSheepAnimateSynchronous(
				cardSheep);

		Lock.lock();

		this.controller.gameStateController().setGameState(
				GameStateEnum.START_NEW_ROUND);

	}

	private void resolveShephion() {

		ArrayList<CardSheep> sheep = this.controller.board().removeAllSheep();
		this.controller.sheepFoundation().addCardSheepAnimateSynchronous(sheep);

		Lock.lock();

		this.controller.gameStateController().setGameState(
				GameStateEnum.START_NEW_ROUND);

	}

	private void resolveCrowding() {

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

	private void resolveFallingRock() {

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

	private void resolveMultiply() {

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

	private void resolveSheepDog() {

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

	private void resolveMeteor() {

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

		} else
			this.controller.gameStateController().setGameState(
					GameStateEnum.RESOLVE_METEOR);

	}

	private void resolvePlague() {

		if (this.controller.board().allCardsAreSameValue()) {

			ArrayList<CardSheep> board = this.controller.board()
					.removeAllSheep();

			this.controller.sheepFoundation().addCardSheepAnimateSynchronous(
					board);
			Lock.lock();

			this.controller.gameStateController().setGameState(
					GameStateEnum.START_NEW_ROUND);

		} else {

			Lock.lock();

			this.controller.gameStateController().setGameState(
					GameStateEnum.RESOLVE_PLAGUE);

		}

	}

	private void resolveStorm() {

		if (this.controller.board().size() <= 2
				|| this.controller.board().allCardsAreSameValue()) {

			int sheepCardsToDiscard = (int) Math.min(this.controller.board()
					.size(), 2);

			for (int counter = 1; counter <= sheepCardsToDiscard; counter++) {

				CardSheep cardSheep = this.controller.board()
						.removeHighestSheepRearrangeSynchronous();

				this.controller.sheepFoundation()
						.addCardSheepAnimateSynchronous(cardSheep);

			}

			this.controller.gameStateController().setGameState(
					GameStateEnum.START_NEW_ROUND);

		} else {

			Lock.lock();

			this.controller.gameStateController().setGameState(
					GameStateEnum.RESOLVE_STORM);

		}
	}

	private void resolveBeFruitful() {

		if (this.controller.board().isFull()) {

			Lock.lock();

			this.controller.gameStateController().setGameState(
					GameStateEnum.START_NEW_ROUND);

		} else if (this.controller.board().allCardsAreSameValue()) {

			int value = this.controller.board().getHighestCardValue();
			CardSheep cardSheep = this.controller.sheepFoundation()
					.getCardSheep(value);

			this.controller.board().addCardSheepAnimateSynchronous(cardSheep);
			Lock.lock();

			this.controller.gameStateController().setGameState(
					GameStateEnum.START_NEW_ROUND);

		} else {

			Lock.lock();

			this.controller.gameStateController().setGameState(
					GameStateEnum.RESOLVE_BE_FRUITFUL);

		}

	}

	private void resolveAllPurposeSheep() {

		Lock.lock();

		if (this.controller.hand().isEmpty()) {

			this.controller.gameStateController().setGameState(
					GameStateEnum.START_NEW_ROUND);
			return;

		} else
			this.controller.gameStateController().setGameState(
					GameStateEnum.RESOLVE_ALL_PURPOSE_SHEEP);

	}

	private void resolvePlanningSheep() {

		Lock.lock();

		if (this.controller.hand().isEmpty())
			this.controller.gameStateController().setGameState(
					GameStateEnum.START_NEW_ROUND);

		else
			this.controller.gameStateController().setGameState(
					GameStateEnum.RESOLVE_PLANNING_SHEEP);

	}

	private void resolveFillTheEarth() {

		Lock.lock();

		if (this.controller.board().isFull())
			this.controller.gameStateController().setGameState(
					GameStateEnum.START_NEW_ROUND);
		else
			this.controller.gameStateController().setGameState(
					GameStateEnum.RESOLVE_FILL_THE_EARTH);

	}

}
