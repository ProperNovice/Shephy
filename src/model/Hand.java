package model;

import components.CardEvent;
import enums.Coordinates;
import enums.Dimensions;
import utils.ArrayList;

public class Hand {

	private ArrayList<CardEvent> hand = new ArrayList<>();
	private final int MAXIMUM_SIZE = 5;

	public Hand() {

	}

	public boolean isMaximumSize() {
		return this.hand.size() == this.MAXIMUM_SIZE;
	}

	public void addCardAnimateSynchronous(CardEvent cardEvent) {

		this.hand.add(cardEvent);

		int cardIndex = this.hand.indexOf(cardEvent);

		double endingX = Coordinates.HAND.x() + cardIndex
				* Dimensions.CARD_PLUS_GAP.x();
		double endingY = Coordinates.HAND.y();

		cardEvent.animate(endingX, endingY);

	}

	public boolean contains(CardEvent cardEvent) {
		return this.hand.contains(cardEvent);
	}

}
