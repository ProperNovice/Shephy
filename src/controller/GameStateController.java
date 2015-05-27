package controller;

import enums.GameStateEnum;
import enums.TextEnum;
import gameState.Animating;
import gameState.ChooseEvent;
import gameState.GameState;
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
