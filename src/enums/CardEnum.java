package enums;

public enum CardEnum {

	SHEEP_1("front_01", 0, 1),
	SHEEP_3("front_01", 0, 2),
	SHEEP_10("front_01", 0, 3),
	SHEEP_30("front_01", 1, 0),
	SHEEP_100("front_01", 1, 1),
	SHEEP_300("front_01", 1, 2),
	SHEEP_1000("front_01", 1, 3),
	ALL_PURPOSE_SHEEP("front_01", 0, 0),
	BE_FRUITFUL("front_02", 0, 0),
	CROWDING("front_03", 0, 0),
	DOMINION("front_04", 0, 0),
	FALLING_ROCK("front_05", 0, 0),
	FILL_THE_EARTH("front_06", 0, 0),
	FLOURISH("front_07", 0, 0),
	GOLDEN_HOOVES("front_08", 0, 0),
	INSPIRATION("front_08", 0, 1),
	LIGHTNING("front_08", 0, 2),
	METEOR("front_08", 0, 3),
	MULTIPLY("front_08", 1, 0),
	PLAGUE("front_08", 1, 1),
	PLANNING_SHEEP("front_08", 1, 2),
	SHEEP_DOG("front_08", 1, 3),
	SHEPHION("front_09", 0, 0),
	SLUMP("front_09", 0, 1),
	STORM("front_09", 0, 2),
	WOLVES("front_09", 0, 3),

	;

	private String filename;
	private int row, column;

	private CardEnum(String filename, int row, int column) {

		this.filename = filename;
		this.row = row;
		this.column = column;

	}

	public String filename() {
		return this.filename;
	}

	public int row() {
		return this.row;
	}

	public int column() {
		return this.column;
	}

}
