package enums;

public enum Coordinates {
	
	DISCARD(Dimensions.GAP_BETWEEN_BORDERS.x(), Dimensions.FRAME.y() - Dimensions.GAP_BETWEEN_BORDERS.y() - Dimensions.CARD_PLUS_GAP.y()),
	HAND(DISCARD.x() + Dimensions.CARD_PLUS_GAP.x(), DISCARD.y()),
	DECK(HAND.x() + 5 * Dimensions.CARD_PLUS_GAP.x(), DISCARD.y()),
	SHEEP_FOUNDATION(Dimensions.GAP_BETWEEN_BORDERS.x(), Dimensions.GAP_BETWEEN_BORDERS.y()),

	;

	private double x = -1, y = -1;

	private Coordinates(double x, double y) {
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
