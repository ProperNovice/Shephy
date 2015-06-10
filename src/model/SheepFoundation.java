package model;

import utils.ArrayList;
import utils.Logger;

import components.CardSheep;

import enums.CardEnum;
import enums.Coordinates;
import enums.Dimensions;

public class SheepFoundation {

	private ArrayList<SheepList> sheepList = new ArrayList<>();

	public SheepFoundation() {

		createSheepLists();
		populateSheepLists();

	}

	private void createSheepLists() {

		double x = Coordinates.SHEEP_FOUNDATION.x();
		double y = Coordinates.SHEEP_FOUNDATION.y();

		this.sheepList.add(new SheepList(1, x, y));
		x += Dimensions.CARD_PLUS_GAP.x();
		this.sheepList.add(new SheepList(3, x, y));
		x += Dimensions.CARD_PLUS_GAP.x();
		this.sheepList.add(new SheepList(10, x, y));
		x += Dimensions.CARD_PLUS_GAP.x();
		this.sheepList.add(new SheepList(30, x, y));
		x += Dimensions.CARD_PLUS_GAP.x();
		this.sheepList.add(new SheepList(100, x, y));
		x += Dimensions.CARD_PLUS_GAP.x();
		this.sheepList.add(new SheepList(300, x, y));
		x += Dimensions.CARD_PLUS_GAP.x();
		this.sheepList.add(new SheepList(1000, x, y));

	}

	private void populateSheepLists() {

		for (int counter = 1; counter <= 7; counter++) {

			this.sheepList.get(0).addCardRelocate(
					new CardSheep(CardEnum.SHEEP_1, 1));
			this.sheepList.get(1).addCardRelocate(
					new CardSheep(CardEnum.SHEEP_3, 3));
			this.sheepList.get(2).addCardRelocate(
					new CardSheep(CardEnum.SHEEP_10, 10));
			this.sheepList.get(3).addCardRelocate(
					new CardSheep(CardEnum.SHEEP_30, 30));
			this.sheepList.get(4).addCardRelocate(
					new CardSheep(CardEnum.SHEEP_100, 100));
			this.sheepList.get(5).addCardRelocate(
					new CardSheep(CardEnum.SHEEP_300, 300));
			this.sheepList.get(6).addCardRelocate(
					new CardSheep(CardEnum.SHEEP_1000, 1000));

		}

	}

	private class SheepList {

		private ArrayList<CardSheep> sheeps = new ArrayList<>();
		private int value;
		private double topLeftX, topLeftY;

		public SheepList(int value, double topLeftX, double topLeftY) {

			this.value = value;
			this.topLeftX = topLeftX;
			this.topLeftY = topLeftY;

		}

		public void addCardRelocate(CardSheep cardSheep) {
			this.sheeps.add(cardSheep);
			cardSheep.relocate(this.topLeftX, this.topLeftY);
		}

		public void addCardAnimate(CardSheep cardSheep) {
			this.sheeps.addFirst(cardSheep);
			cardSheep.animate(this.topLeftX, this.topLeftY);
		}

		public int getValue() {
			return this.value;
		}

		public CardSheep removeSheep() {
			return this.sheeps.removeFirst();
		}

		public boolean contains(CardSheep cardSheep) {
			return this.sheeps.contains(cardSheep);
		}

	}

	public CardSheep getCardSheep(int value) {

		for (SheepList sheepList : this.sheepList)
			if (sheepList.getValue() == value)
				return sheepList.removeSheep();

		Logger.logNewLine("sheep foundation getSheep() null");
		return null;

	}

	public void addCardSheepAnimateSynchronous(CardSheep cardSheep) {

		for (SheepList sheepList : this.sheepList)
			if (cardSheep.getValue() == sheepList.getValue())
				sheepList.addCardAnimate(cardSheep);

	}

	public void addCardSheepAnimateSynchronous(ArrayList<CardSheep> sheep) {

		for (CardSheep cardSheep : sheep)
			addCardSheepAnimateSynchronous(cardSheep);

	}

	public boolean containsSheep(CardSheep cardSheep) {

		for (SheepList sheepList : this.sheepList)
			if (sheepList.contains(cardSheep))
				return true;

		return false;

	}

}
