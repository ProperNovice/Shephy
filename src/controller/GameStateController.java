package controller;

import enums.GameStateEnum;
import enums.TextEnum;
import gameState.Animating;
import gameState.ResolveAllPurposeSheep;
import gameState.ResolveBeFruitful;
import gameState.ChooseEvent;
import gameState.GameState;
import gameState.ResolveCrowding;
import gameState.ResolveFallingRock;
import gameState.ResolveFillTheEarth;
import gameState.ResolveFlourish;
import gameState.ResolveGoldenHooves;
import gameState.ResolveMeteor;
import gameState.ResolvePlague;
import gameState.ResolvePlanningSheep;
import gameState.ResolveSheepDog;
import gameState.ResolveSlump;
import gameState.ResolveStorm;
import gameState.StartGame;
import gameState.StartNewRound;
import utils.Animation;
import utils.Lock;
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
	private GameState resolveMeteor = new ResolveMeteor();
	private GameState resolvePlague = new ResolvePlague();
	private GameState resolveStorm = new ResolveStorm();
	private GameState resolveBeFruitful = new ResolveBeFruitful();
	private GameState resolveAllPurposeSheep = new ResolveAllPurposeSheep();
	private GameState resolvePlanningSheep = new ResolvePlanningSheep();
	private GameState resolveFillTheEarth = new ResolveFillTheEarth();
	private GameState resolveGoldenHooves = new ResolveGoldenHooves();
	private GameState resolveFlourish = new ResolveFlourish();
	private GameState resolveSlump = new ResolveSlump();

	public GameStateController() {

	}

	public void setGameState(GameStateEnum gameStateEnum) {

		if (Animation.isRunning()
				&& !gameStateEnum.equals(GameStateEnum.ANIMATING))
			Lock.lock();

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

		case RESOLVE_METEOR:
			this.currentGameState = this.resolveMeteor;
			break;

		case RESOLVE_PLAGUE:
			this.currentGameState = this.resolvePlague;
			break;

		case RESOLVE_STORM:
			this.currentGameState = this.resolveStorm;
			break;

		case RESOLVE_BE_FRUITFUL:
			this.currentGameState = this.resolveBeFruitful;
			break;

		case RESOLVE_ALL_PURPOSE_SHEEP:
			this.currentGameState = this.resolveAllPurposeSheep;
			break;

		case RESOLVE_PLANNING_SHEEP:
			this.currentGameState = this.resolvePlanningSheep;
			break;

		case RESOLVE_FILL_THE_EARTH:
			this.currentGameState = this.resolveFillTheEarth;
			break;

		case RESOLVE_GOLDEN_HOOVES:
			this.currentGameState = this.resolveGoldenHooves;
			break;

		case RESOLVE_FLOURISH:
			this.currentGameState = this.resolveFlourish;
			break;

		case RESOLVE_SLUMP:
			this.currentGameState = this.resolveSlump;
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
