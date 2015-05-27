package controller;

import instances.Instances;
import model.Board;
import model.Deck;
import model.Hand;
import model.SheepFoundation;
import utils.Executor;
import enums.GameStateEnum;

public class Controller {

	private GameStateController gameStateController = null;
	private Deck deck = null;
	private Hand hand = null;
	private SheepFoundation sheepFoundation = null;
	private Board board = null;

	public Controller() {

		createInstances();

		Executor.runLater(() -> this.gameStateController
				.setGameState(GameStateEnum.START_GAME));

	}

	private void createInstances() {

		Instances.createController(this);
		this.gameStateController = new GameStateController();
		this.deck = new Deck();
		this.hand = new Hand();
		this.sheepFoundation = new SheepFoundation();
		this.board = new Board();

	}

	public GameStateController gameStateController() {
		return this.gameStateController;
	}

	public Deck deck() {
		return this.deck;
	}

	public Hand hand() {
		return this.hand;
	}

	public SheepFoundation sheepFoundation() {
		return this.sheepFoundation;
	}

	public Board board() {
		return this.board;
	}

}
