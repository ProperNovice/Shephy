package enums;

public enum CardEnum {

	SHEEP_1("sheep_1"),
	SHEEP_3("sheep_3"),
	SHEEP_10("sheep_10"),
	SHEEP_30("sheep_30"),
	SHEEP_100("sheep_100"),
	SHEEP_300("sheep_300"),
	SHEEP_1000("sheep_1000"),
	ALL_PURPOSE_SHEEP("all-purpose_sheep"),
	BE_FRUITFUL("be_fruitful"),
	CROWDING("crowding"),
	DOMINION("dominion"),
	FALLING_ROCK("falling_rock"),
	FILL_THE_EARTH("fill_the_earth"),
	FLOURISH("flourish"),
	GOLDEN_HOOVES("golden_hooves"),
	INSPIRATION("inspiration"),
	LIGHTNING("lightning"),
	METEOR("meteor"),
	MULTIPLY("multiply"),
	PLAGUE("plague"),
	PLANNING_SHEEP("planning_sheep"),
	SHEEP_DOG("sheep_dog"),
	SHEPHION("shephion"),
	SLUMP("slump"),
	STORM("storm"),
	WOLVES("wolves"),
	BACK_EVENT("back_event"),
	
	;

	private String filename;

	private CardEnum(String filename) {
		this.filename = filename;
	}

	public String filename() {
		return this.filename;
	}

}
