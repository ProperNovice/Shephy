package enums;

public enum Dimensions {

	FRAME(800, 600), INSETS(7, 29), GAP(10, 10);

	private double x = -1, y = -1;

	private Dimensions(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double x() {
		return x;
	}

	public double y() {
		return y;
	}

}
