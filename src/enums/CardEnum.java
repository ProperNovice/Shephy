package enums;

public enum CardEnum {

	SHEEP_1("01", 0, 1),
	SHEEP_3("01", 0, 2),
	SHEEP_10("01", 0, 3),
	SHEEP_30("01", 1, 0),
	SHEEP_100("01", 1, 1),
	SHEEP_300("01", 1, 2),
	SHEEP_1000("01", 1, 3),
	ALL_PURPOSE_SHEEP("01", 0, 0),
	BE_FRUITFUL("02", 0, 0),
	CROWDING("03", 0, 0),
	DOMINION("04", 0, 0),
	FALLING_ROCK("05", 0, 0),
	FILL_THE_EARTH("06", 0, 0),
	FLOURISH("07", 0, 0),
	GOLDEN_HOOVES("08", 0, 0),
	INSPIRATION("08", 0, 1),
	LIGHTNING("08", 0, 2),
	METEOR("08", 0, 3),
	MULTIPLY("08", 1, 0),
	PLAGUE("08", 1, 1),
	PLANNING_SHEEP("08", 1, 2),
	SHEEP_DOG("08", 1, 3),
	SHEPHION("09", 0, 0),
	SLUMP("09", 0, 1),
	STORM("09", 0, 2),
	WOLVES("09", 0, 3),
	BACK_EVENT("back_01", 0, 3),

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
