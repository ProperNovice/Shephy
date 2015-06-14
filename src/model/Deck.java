package model;

import utils.ArrayList;
import utils.ImageView;
import components.CardEvent;
import enums.CardEnum;
import enums.Coordinates;
import enums.Dimensions;

public class Deck {

	private ArrayList<CardEvent> deck = new ArrayList<>();
	private ImageView background = new ImageView("background.png");

	public Deck() {

		this.background.setVisible(false);

		createDeck();
		flipDeck();
		shuffleDeck();
		relocateDeck();

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

		this.deck.get(this.deck.size() - 1).setGoesOutsideOfTheGame();

		this.deck.add(new CardEvent(CardEnum.MULTIPLY));
		this.deck.add(new CardEvent(CardEnum.PLAGUE));
		this.deck.add(new CardEvent(CardEnum.PLANNING_SHEEP));
		this.deck.add(new CardEvent(CardEnum.SHEEP_DOG));
		this.deck.add(new CardEvent(CardEnum.SHEPHION));
		this.deck.add(new CardEvent(CardEnum.SLUMP));
		this.deck.add(new CardEvent(CardEnum.STORM));
		this.deck.add(new CardEvent(CardEnum.WOLVES));

	}

	public void flipDeck() {

		for (CardEvent cardEvent : this.deck)
			cardEvent.flip();

	}

	private void shuffleDeck() {
		this.deck.shuffle();
	}

	private void relocateDeck() {

		for (CardEvent cardEvent : this.deck) {

			cardEvent.relocate(Coordinates.DECK.x(), Coordinates.DECK.y());
			cardEvent.toBack();

		}

	}

	public CardEvent removeFirstCard() {
		return this.deck.removeFirst();
	}

	public void setCardAsFirst(CardEnum cardEnum) {

		CardEvent cardEvent = null;

		for (CardEvent cardEventTemp : this.deck)
			if (cardEventTemp.getCardEnum().equals(cardEnum))
				cardEvent = cardEventTemp;

		this.deck.remove(cardEvent);
		this.deck.add(0, cardEvent);

	}

	public int size() {
		return this.deck.size();
	}

	public void layDownDeck() {

		this.background.toFront();
		this.background.setVisible(true);

		flipDeck();

		int cardsEachRow = 6;
		int totalRows = (int) Math.ceil((double) this.deck.size()
				/ cardsEachRow);

		double topLeftX = Dimensions.FRAME.x() / 2
				- Dimensions.GAP_BETWEEN_CARDS.x() / 2 - 2
				* Dimensions.CARD_PLUS_GAP.x() - Dimensions.CARD.x();

		double totalY = Dimensions.CARD.y() + (totalRows - 1)
				* Dimensions.CARD_PLUS_GAP.y();

		double topLeftY = (Dimensions.FRAME.y() - totalY) / 2;

		int cardsPlaced = 0;

		double x = topLeftX, y = topLeftY;

		for (CardEvent cardEvent : this.deck) {

			cardEvent.animate(x, y);

			cardsPlaced++;

			if (cardsPlaced < cardsEachRow)
				x += Dimensions.CARD_PLUS_GAP.x();

			else {

				cardsPlaced = 0;
				x = topLeftX;
				y += Dimensions.CARD_PLUS_GAP.y();

			}

		}

	}

	public void panelDeckSetVisible(boolean value) {

		this.background.setVisible(value);

		for (CardEvent cardEvent : this.deck)
			cardEvent.setVisible(value);

	}

	public void backGroundSetVisibleFalse() {
		this.background.setVisible(false);
	}

	public boolean contains(CardEvent cardEvent) {
		return this.deck.contains(cardEvent);
	}

	public void remove(CardEvent cardEvent) {
		this.deck.remove(cardEvent);
	}

	public void wrapUpDeckShuffleAnimateSynchronous() {

		for (CardEvent cardEvent : this.deck)
			cardEvent.animate(Coordinates.DECK.x(), Coordinates.DECK.y());

		this.deck.shuffle();

		for (CardEvent cardEvent : this.deck)
			cardEvent.toBack();

	}

}
