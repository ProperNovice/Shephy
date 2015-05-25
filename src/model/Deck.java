package model;

import utils.ArrayList;

import components.CardEvent;

import enums.CardEnum;

public class Deck {

	private ArrayList<CardEvent> deck = new ArrayList<>();

	public Deck() {

		createDeck();

	}

	private void createDeck() {

		this.deck.add(new CardEvent(CardEnum.ALL_PURPOSE_SHEEP));
		this.deck.add(new CardEvent(CardEnum.BE_FRUITFUL));
		this.deck.add(new CardEvent(CardEnum.BE_FRUITFUL));
		this.deck.add(new CardEvent(CardEnum.BE_FRUITFUL));
		this.deck.add(new CardEvent(CardEnum.CROWDING));
		this.deck.add(new CardEvent(CardEnum.DOMINION));
		this.deck.add(new CardEvent(CardEnum.DOMINION));
		this.deck.add(new CardEvent(CardEnum.FALLING_ROCK));
		this.deck.add(new CardEvent(CardEnum.FILL_THE_EARTH));
		this.deck.add(new CardEvent(CardEnum.FLOURISH));
		this.deck.add(new CardEvent(CardEnum.GOLDEN_HOOVES));
		this.deck.add(new CardEvent(CardEnum.INSPIRATION));
		this.deck.add(new CardEvent(CardEnum.LIGHTNING));
		this.deck.add(new CardEvent(CardEnum.METEOR));
		this.deck.add(new CardEvent(CardEnum.MULTIPLY));
		this.deck.add(new CardEvent(CardEnum.PLAGUE));
		this.deck.add(new CardEvent(CardEnum.PLANNING_SHEEP));
		this.deck.add(new CardEvent(CardEnum.SHEEP_DOG));
		this.deck.add(new CardEvent(CardEnum.SHEPHION));
		this.deck.add(new CardEvent(CardEnum.SLUMP));
		this.deck.add(new CardEvent(CardEnum.STORM));
		this.deck.add(new CardEvent(CardEnum.WOLVES));

	}

}
