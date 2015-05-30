package controller;

import enums.GameStateEnum;
import enums.TextEnum;
import gameState.Animating;
import gameState.ChooseEvent;
import gameState.GameState;
import gameState.ResolveCrowding;
import gameState.ResolveFallingRock;
import gameState.ResolveSheepDog;
import gameState.StartGame;
import gameState.StartNewRound;
import utils.Logger;
import components.CardEvent;
import components.CardSheep;

public class GameStateController {

	private GameState currentGameState = null;
	private GameState startGame = new StartGame();
	private GameState startNewRound = new StartNewRound();
	private GameState chooseEvent = new ChooseEvent();
	private GameState animating = new Animating();
	private GameState resolveCrowding = new ResolveCrowding();
	private GameState resolveFallingRock = new ResolveFallingRock();
	private GameState resolveSheepDog = new ResolveSheepDog();

	public GameStateController() {

	}

	public void setGameState(GameStateEnum gameStateEnum) {

		switch (gameStateEnum) {

		case START_GAME:
			this.currentGameState = this.startGame;
			break;

		case START_NEW_ROUND:
			this.currentGameState = this.startNewRound;
			break;

		case CHOOSE_EVENT:
			this.currentGameState = this.chooseEvent;
			break;

		case ANIMATING:
			this.currentGameState = this.animating;
			break;

		case RESOLVE_CROWDING:
			this.currentGameState = this.resolveCrowding;
			break;

		case RESOLVE_FALLING_ROCK:
			this.currentGameState = this.resolveFallingRock;
			break;

		case RESOLVE_SHEEP_DOG:
			this.currentGameState = this.resolveSheepDog;
			break;

		}

		Logger.log("changing gameState");
		Logger.logNewLine(gameStateEnum.text());

		this.currentGameState.handleGameStateChange();

	}

	public void handleCardEventPressed(CardEvent cardEvent) {
		this.currentGameState.handleCardEventPressed(cardEvent);
	}

	public void handleCardSheepPressed(CardSheep cardSheep) {
		this.currentGameState.handleCardSheepPressed(cardSheep);
	}

	public void handleTextOptionPressed(TextEnum textEnum) {
		this.currentGameState.handleTextOptionPressed(textEnum);
	}

}
