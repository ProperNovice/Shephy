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
		addCardSheepToBoard(100);

		setCardAsFirst(CardEnum.DOMINION);
		setCardAsFirst(CardEnum.FLOURISH);
		setCardAsFirst(CardEnum.GOLDEN_HOOVES);
		setCardAsFirst(CardEnum.INSPIRATION);
		setCardAsFirst(CardEnum.WOLVES);

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
	// FLOURISH("flourish"),
	// GOLDEN_HOOVES("golden_hooves"),
	// INSPIRATION("inspiration"),
	// SLUMP("slump"),
	// WOLVES("wolves"),

	// ALL_PURPOSE_SHEEP("all-purpose_sheep"),
	// BE_FRUITFUL("be_fruitful"),
	// CROWDING("crowding"),
	// FALLING_ROCK("falling_rock"),
	// FILL_THE_EARTH("fill_the_earth"),
	// LIGHTNING("lightning"),
	// METEOR("meteor"),
	// MULTIPLY("multiply"),
	// PLAGUE("plague"),
	// PLANNING_SHEEP("planning_sheep"),
	// SHEEP_DOG("sheep_dog"),
	// SHEPHION("shephion"),
	// STORM("storm"),

	// Merge controller with gameStateController, TestFX text controller

}
