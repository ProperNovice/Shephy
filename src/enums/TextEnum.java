package enums;

public enum TextEnum {

	CHOOSE_EVENT("Choose event", TextTypeEnum.INDICATOR),
	CHOOSE_SHEEP_TO_RELEASE("Choose sheep\nto release", TextTypeEnum.INDICATOR),
	CHOOSE_EVENT_TO_DISCARD("Choose event\nto discard", TextTypeEnum.INDICATOR),
	CHOOSE_SHEEP_TO_DUPLICATE("Choose sheep\nto duplicate", TextTypeEnum.INDICATOR),
	CHOOSE_EVENT_TO_PLAY("Choose event\nto play", TextTypeEnum.INDICATOR),
	CHOOSE_EVENT_TO_REMOVE("Choose event\nto remove", TextTypeEnum.INDICATOR),
	CHOOSE_1_VALUE_SHEEP_TO_ADD("Choose 1 value\nsheep to add", TextTypeEnum.INDICATOR),

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
