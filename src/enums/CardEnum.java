package enums;

public enum CardEnum {

	SHEEP_300("front_02", 1, 2),

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
