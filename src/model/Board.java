package model;

import utils.ArrayList;

import components.CardSheep;

import enums.Coordinates;
import enums.Dimensions;

public class Board {

	private ArrayList<CardSheep> board = new ArrayList<>();

	public Board() {

	}

	public void addCardSheep(CardSheep cardSheep) {

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

		for (int counter = cardSheepIndex; counter <= this.board.size() - 1; counter++)
			this.board.get(counter).animate(
					firstX + counter * Dimensions.CARD_PLUS_GAP.x(), y);

	}

}
