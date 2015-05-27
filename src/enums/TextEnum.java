package enums;

public enum TextEnum {

	CHOOSE_EVENT("Choose event", TextTypeEnum.INDICATOR),
	CHOOSE_EVENAT("Choose event", TextTypeEnum.OPTION),

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
