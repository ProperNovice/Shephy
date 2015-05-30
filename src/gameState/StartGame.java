package gameState;

import components.CardSheep;
import enums.CardEnum;
import enums.GameStateEnum;

public class StartGame extends GameState {

	@Override
	public void handleGameStateChange() {

		addCardSheepToBoard(1);
		addCardSheepToBoard(1);
		addCardSheepToBoard(3);
		addCardSheepToBoard(100);
		addCardSheepToBoard(3);

		setCardAsFirst(CardEnum.SHEEP_DOG);

		super.controller.gameStateController().setGameState(
				GameStateEnum.START_NEW_ROUND);

	}

	private void addCardSheepToBoard(int value) {

		CardSheep cardSheep = super.controller.sheepFoundation().getCardSheep(
				value);
		super.controller.board().addCardSheep(cardSheep);

	}

	private void setCardAsFirst(CardEnum cardEnum) {
		super.controller.deck().setCardAsFirst(cardEnum);
	}

	// ALL_PURPOSE_SHEEP("all-purpose_sheep"),
	// BE_FRUITFUL("be_fruitful"),
	// DOMINION("dominion"),
	// FILL_THE_EARTH("fill_the_earth"),
	// FLOURISH("flourish"),
	// GOLDEN_HOOVES("golden_hooves"),
	// INSPIRATION("inspiration"),
	// METEOR("meteor"),
	// PLAGUE("plague"),
	// PLANNING_SHEEP("planning_sheep"),
	// SHEEP_DOG("sheep_dog"),
	// SLUMP("slump"),
	// STORM("storm"),
	// WOLVES("wolves"),
	// BACK_EVENT("back_event"),

	// CROWDING("crowding"),
	// FALLING_ROCK("falling_rock"),
	// LIGHTNING("lightning"),
	// MULTIPLY("multiply"),
	// SHEPHION("shephion"),

}
