package model;

import utils.Animation.AnimationSynch;
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

		for (int counter = this.board.size() - 1; counter >= cardSheepIndex; counter--)
			this.board.get(counter).animate(
					firstX + counter * Dimensions.CARD_PLUS_GAP.x(), y,
					AnimationSynch.SYNCHRONOUS);

	}

	private void rearrangeBoard() {

		double endingX = Coordinates.BOARD.x();
		double endingY = Coordinates.BOARD.y();

		for (CardSheep cardSheep : this.board) {

			cardSheep.animate(endingX, endingY, AnimationSynch.SYNCHRONOUS);
			endingX += Dimensions.CARD_PLUS_GAP.x();

		}

	}

	public CardSheep removeHighestSheep() {

		CardSheep cardSheep = this.board.remove(0);
		rearrangeBoard();
		return cardSheep;

	}

}
