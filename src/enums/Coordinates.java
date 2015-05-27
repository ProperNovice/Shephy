package enums;

public enum Coordinates {
	
	DISCARD(Dimensions.GAP_BETWEEN_BORDERS.x(), Dimensions.FRAME.y() - Dimensions.GAP_BETWEEN_BORDERS.y() - Dimensions.CARD.y()),
	DECK(DISCARD.x() + Dimensions.CARD_PLUS_GAP.x(), DISCARD.y()),
	HAND(DECK.x() + Dimensions.CARD_PLUS_GAP.x(), Dimensions.FRAME.y() - Dimensions.GAP_BETWEEN_BORDERS.y() - Dimensions.CARD.y()),
	SHEEP_FOUNDATION(Dimensions.GAP_BETWEEN_BORDERS.x(), Dimensions.GAP_BETWEEN_BORDERS.y()),
	BOARD(SHEEP_FOUNDATION.x(), SHEEP_FOUNDATION.y() + Dimensions.CARD_PLUS_GAP.y()),
	TEXT(HAND.x() + 5 * Dimensions.CARD_PLUS_GAP.x() + 6 * Dimensions.GAP_BETWEEN_CARDS.x(), HAND.y()),

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
