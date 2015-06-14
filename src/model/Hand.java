package model;

import utils.ArrayList;

import components.CardEvent;

import enums.Coordinates;
import enums.Dimensions;

public class Hand {

	private ArrayList<CardEvent> hand = new ArrayList<>();
	private final int MAXIMUM_SIZE = 5;

	public Hand() {

	}

	public boolean isMaximumSize() {
		return this.hand.size() == this.MAXIMUM_SIZE;
	}

	public boolean isEmpty() {
		return this.hand.size() == 0;
	}

	public void addCardAnimateSynchronous(CardEvent cardEvent) {

		this.hand.addFirst(cardEvent);

		if (hand.size() < this.MAXIMUM_SIZE)
			return;

		shiftHand();

	}

	public void addCard(CardEvent cardEvent) {
		this.hand.addFirst(cardEvent);
	}

	public void shiftHand() {

		double endingX = Coordinates.HAND.x() + 4
				* Dimensions.CARD_PLUS_GAP.x();
		double endingY = Coordinates.HAND.y();

		for (int counter = this.hand.size() - 1; counter >= 0; counter--) {

			this.hand.get(counter).animate(endingX, endingY);
			endingX -= Dimensions.CARD_PLUS_GAP.x();

		}

		for (CardEvent cardEvent : this.hand)
			cardEvent.toFront();

	}

	public boolean contains(CardEvent cardEvent) {
		return this.hand.contains(cardEvent);
	}

	public void removeCardShiftHandAnimateSynchronous(CardEvent cardEvent) {

		this.hand.remove(cardEvent);
		shiftHand();

	}

	public CardEvent peekSoleCard() {
		return this.hand.get(0);
	}

	public int size() {
		return this.hand.size();
	}

	public CardEvent removeSoleCard() {
		return this.hand.removeFirst();
	}

}
