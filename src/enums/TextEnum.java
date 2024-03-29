package enums;

public enum TextEnum {

	CHOOSE_EVENT("Choose event", TextTypeEnum.INDICATOR),
	CHOOSE_SHEEP_TO_RELEASE("Choose sheep\nto release", TextTypeEnum.INDICATOR),
	CHOOSE_EVENT_TO_DISCARD("Choose event\nto discard", TextTypeEnum.INDICATOR),
	CHOOSE_SHEEP_TO_DUPLICATE("Choose sheep\nto duplicate", TextTypeEnum.INDICATOR),
	CHOOSE_EVENT_TO_PLAY("Choose event\nto play", TextTypeEnum.INDICATOR),
	CHOOSE_EVENT_TO_REMOVE("Choose event\nto remove", TextTypeEnum.INDICATOR),
	ADD_1_VALUE_SHEEP("Add 1 value\nsheep", TextTypeEnum.OPTION),
	CONTINUE("Continue", TextTypeEnum.OPTION),
	FILL_THE_BOARD("Fill the board", TextTypeEnum.OPTION),
	CHOOSE_SHEEP_TO_RAISE_THE_RANK("Choose sheep to\nraise the rank", TextTypeEnum.INDICATOR),
	RAISE_THE_RANK_OF_ALL_SHEEP("Raise the rank\nof all sheep", TextTypeEnum.OPTION),
	CHOOSE_SHEEP("Choose sheep", TextTypeEnum.INDICATOR),
	RELEASE_AUTO("Release auto", TextTypeEnum.OPTION),
	SHOW_BOARD("Show board", TextTypeEnum.OPTION),
	SHOW_DECK("Show deck", TextTypeEnum.OPTION),
	ROUND_1("Round 1", TextTypeEnum.INDICATOR),
	ROUND_2("Round 2", TextTypeEnum.INDICATOR),
	ROUND_3("Round 3", TextTypeEnum.INDICATOR),
	END_GAME("End game", TextTypeEnum.INDICATOR),
	YOU_LOST("You lost", TextTypeEnum.INDICATOR),
	YOU_WON("You won", TextTypeEnum.INDICATOR),
	RESTART("Restart", TextTypeEnum.OPTION),

	;

	private String string = null;
	private TextTypeEnum textTypeEnum = null;

	private TextEnum(String string, TextTypeEnum textTypeEnum) {
		this.string = string;
		this.textTypeEnum = textTypeEnum;
	}

	public String string() {
		return this.string;
	}

	public TextTypeEnum textTypeEnum() {
		return this.textTypeEnum;
	}

}
