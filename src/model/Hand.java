package model;

import components.CardEvent;
import enums.Coordinates;
import enums.Dimensions;
import utils.Animation.AnimationSynch;
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

		this.hand.add(0, cardEvent);

		if (hand.size() < this.MAXIMUM_SIZE)
			return;

		shiftHand(AnimationSynch.SYNCHRONOUS);

	}

	private void shiftHand(AnimationSynch animationSynch) {

		double endingX = Coordinates.HAND.x() + 4
				* Dimensions.CARD_PLUS_GAP.x();
		double endingY = Coordinates.HAND.y();

		for (int counter = this.hand.size() - 1; counter >= 0; counter--) {

			this.hand.get(counter).animate(endingX, endingY, animationSynch);
			endingX -= Dimensions.CARD_PLUS_GAP.x();

		}

		for (CardEvent cardEvent : this.hand)
			cardEvent.toFront();

	}

	public boolean contains(CardEvent cardEvent) {
		return this.hand.contains(cardEvent);
	}

	public void removeCardShiftHandAnimateAsynchronous(CardEvent cardEvent) {

		this.hand.remove(cardEvent);
		shiftHand(AnimationSynch.ASYNCHRONOUS);

	}

}
