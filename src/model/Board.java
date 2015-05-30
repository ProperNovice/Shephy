package model;

import utils.ArrayList;

import components.CardSheep;

import enums.Coordinates;
import enums.Dimensions;

public class Board {

	private ArrayList<CardSheep> board = new ArrayList<>();
	private final int MAXIMUM_SIZE = 7;

	public Board() {

	}

	public void addCardSheepAnimateSynchronous(CardSheep cardSheep) {

		for (CardSheep cardSheepTemp : this.board) {

			if (cardSheepTemp.getValue() >= cardSheep.getValue())
				continue;

			this.board.add(this.board.indexOf(cardSheepTemp), cardSheep);
			break;

		}

		if (!this.board.contains(cardSheep))
			this.board.add(cardSheep);

		int cardSheepIndex = this.board.indexOf(cardSheep);

		double firstX = Coordinates.BOARD.x();
		double y = Coordinates.BOARD.y();

		for (int counter = this.board.size() - 1; counter >= cardSheepIndex; counter--)
			this.board.get(counter).animate(
					firstX + counter * Dimensions.CARD_PLUS_GAP.x(), y);

	}

	private void rearrangeBoardSynchronous() {

		double endingX = Coordinates.BOARD.x();
		double endingY = Coordinates.BOARD.y();

		for (CardSheep cardSheep : this.board) {

			cardSheep.animate(endingX, endingY);
			endingX += Dimensions.CARD_PLUS_GAP.x();

		}

	}

	public int size() {
		return this.board.size();
	}

	public CardSheep removeHighestSheepRearrangeAsynchronous() {

		CardSheep cardSheep = this.board.remove(0);
		rearrangeBoardSynchronous();
		return cardSheep;

	}

	public ArrayList<CardSheep> removeAllSheep() {

		ArrayList<CardSheep> sheep = this.board.clone();
		this.board.clear();
		return sheep;

	}

	public boolean allCardsAreSameValue() {

		int valueFirstCard = this.board.get(0).getValue();

		for (CardSheep cardSheep : this.board)
			if (cardSheep.getValue() != valueFirstCard)
				return false;

		return true;

	}

	public CardSheep removeLastSheep() {
		return this.board.removeLast();
	}

	public boolean contains(CardSheep cardSheep) {
		return this.board.contains(cardSheep);
	}

	public void removeSheepRearrangeAsynchronous(CardSheep cardSheep) {
		this.board.remove(cardSheep);
		rearrangeBoardSynchronous();
	}

	public boolean isFull() {
		return (this.board.size() == this.MAXIMUM_SIZE);
	}

}
