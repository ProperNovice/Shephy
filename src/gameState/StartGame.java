package gameState;

import components.CardSheep;
import enums.CardEnum;
import enums.GameStateEnum;

public class StartGame extends GameState {

	@Override
	public void handleGameStateChange() {

		addCardSheepToBoard(1);
		addCardSheepToBoard(1);
		addCardSheepToBoard(1);
		addCardSheepToBoard(3);
		addCardSheepToBoard(3);
		addCardSheepToBoard(100);
		addCardSheepToBoard(100);

		setCardAsFirst(CardEnum.DOMINION);
		setCardAsFirst(CardEnum.INSPIRATION);

		super.controller.gameStateController().setGameState(
				GameStateEnum.START_NEW_ROUND);

	}

	private void addCardSheepToBoard(int value) {

		CardSheep cardSheep = super.controller.sheepFoundation()
				.removeCardSheep(value);
		super.controller.board().addCardSheepAnimateSynchronous(cardSheep);

	}

	private void setCardAsFirst(CardEnum cardEnum) {
		super.controller.deck().setCardAsFirst(cardEnum);
	}

	// DOMINION("dominion"),
	// INSPIRATION("inspiration"),

	// ALL_PURPOSE_SHEEP("all-purpose_sheep"),
	// BE_FRUITFUL("be_fruitful"),
	// CROWDING("crowding"),
	// FALLING_ROCK("falling_rock"),
	// FILL_THE_EARTH("fill_the_earth"),
	// FLOURISH("flourish"),
	// GOLDEN_HOOVES("golden_hooves"),
	// LIGHTNING("lightning"),
	// METEOR("meteor"),
	// MULTIPLY("multiply"),
	// PLAGUE("plague"),
	// PLANNING_SHEEP("planning_sheep"),
	// SHEEP_DOG("sheep_dog"),
	// SHEPHION("shephion"),
	// SLUMP("slump"),
	// STORM("storm"),
	// WOLVES("wolves"),

	// TestFX text controller, anadiarthrosh sto show text ena ena na ta bazei
	// se sosth seira

}
