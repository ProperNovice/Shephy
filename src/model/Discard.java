package model;

import utils.ArrayList;

import components.CardEvent;

import enums.Coordinates;

public class Discard {

	private ArrayList<CardEvent> discard = new ArrayList<>();

	public Discard() {

	}

	public void addCardAnimateSynchronous(CardEvent cardEvent) {

		this.discard.add(cardEvent);
		cardEvent.animate(Coordinates.DISCARD.x(), Coordinates.DISCARD.y());

	}

}
