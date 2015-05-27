package enums;

public enum Dimensions {

	FRAME(1366, 768),
	INSETS(7, 29),
	GAP_BETWEEN_BORDERS(50, 50),
	GAP_BETWEEN_CARDS(5, 10),
	CARD_IMAGE_DIMENSION(496, 686),
	CARD_RATIO(((FRAME.y() - 2 * GAP_BETWEEN_BORDERS.y() - 2 * GAP_BETWEEN_CARDS.y()) / 3) / CARD_IMAGE_DIMENSION.y(), 0),
	CARD(CARD_IMAGE_DIMENSION.x() * CARD_RATIO.x(), CARD_IMAGE_DIMENSION.y() * CARD_RATIO.x()),
	CARD_PLUS_GAP(CARD.x() + GAP_BETWEEN_CARDS.x(), CARD.y() + GAP_BETWEEN_CARDS.y()),

	;

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
