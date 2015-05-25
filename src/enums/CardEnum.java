package enums;

public enum CardEnum {

	SHEEP_1("front_01", 0, 1),
	SHEEP_3("front_01", 0, 2),
	SHEEP_10("front_01", 0, 3),
	SHEEP_30("front_01", 1, 0),
	SHEEP_100("front_01", 1, 1),
	SHEEP_300("front_01", 1, 2),
	SHEEP_1000("front_01", 1, 3),

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
