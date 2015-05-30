package model;

import components.CardEvent;
import enums.Coordinates;
import utils.ArrayList;
import utils.Animation.AnimationSynch;

public class Discard {

	private ArrayList<CardEvent> discard = new ArrayList<>();

	public Discard() {

	}

	public void addCardAnimate(CardEvent cardEvent,
			AnimationSynch animationSynch) {

		this.discard.add(cardEvent);
		cardEvent.animate(Coordinates.DISCARD.x(), Coordinates.DISCARD.y(),
				animationSynch);

	}

}
