package controller;

import components.RoundController;
import gui.Panel;
import instances.Instances;
import model.Board;
import model.Deck;
import model.Discard;
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
	private Discard discard = null;
	private TextController textController = null;
	private RoundController roundController = null;
	private Panel panel = null;

	public Controller(Panel panel) {

		createInstances();

		this.panel = panel;

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
		this.discard = new Discard();
		this.textController = new TextController();
		this.roundController = new RoundController();

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

	public Discard discard() {
		return this.discard;
	}

	public TextController textController() {
		return this.textController;
	}

	public RoundController roundController() {
		return this.roundController;
	}

	public void restartGame() {
		this.panel.restartGame();
	}

}
