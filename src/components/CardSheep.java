package components;

import enums.CardEnum;

public class CardSheep extends Card {

	private int value;

	public CardSheep(CardEnum cardEnum, int value) {
		super(cardEnum);
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}

}
