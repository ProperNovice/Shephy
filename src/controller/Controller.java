package controller;

import model.Deck;
import instances.Instances;
import utils.Executor;
import enums.GameStateEnum;

public class Controller {

	private GameStateController gameStateController = null;
	private Deck deck = null;

	public Controller() {

		createInstances();

		Executor.runLater(() -> this.gameStateController
				.setGameState(GameStateEnum.START_GAME));

	}

	private void createInstances() {

		Instances.createController(this);
		this.gameStateController = new GameStateController();
		this.deck = new Deck();

	}

	public GameStateController gameStateController() {
		return this.gameStateController;
	}

	public Deck deck() {
		return this.deck;
	}

}
