package controller;

import components.CardEvent;
import components.CardSheep;
import enums.GameStateEnum;
import gameState.GameState;
import gameState.StartGame;
import utils.Logger;

public class GameStateController {

	private GameState currentGameState = null;
	private GameState startGame = new StartGame();

	public GameStateController() {

	}

	public void setGameState(GameStateEnum gameStateEnum) {

		switch (gameStateEnum) {

		case START_GAME:
			this.currentGameState = this.startGame;
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
		Logger.logNewLine("pressed " + cardSheep.getCardEnum());
	}

}
