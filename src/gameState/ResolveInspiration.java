package gameState;

import components.CardEvent;
import utils.ArrayList;
import utils.ImageView;

public class ResolveInspiration extends GameState {

	private ArrayList<CardEvent> deckClone = null;
	private ImageView background = new ImageView("background.png");

	public ResolveInspiration() {

		this.background.setVisible(false);

	}

	@Override
	public void handleGameStateChange() {

		this.background.toFront();
		this.background.setVisible(true);

		this.deckClone = super.controller.deck().getDeckClone();

		for (int counter = this.deckClone.size() - 1; counter >= 0; counter--) {

			CardEvent cardEvent = this.deckClone.get(counter);
			cardEvent.toFront();
			cardEvent.flip();

		}

		int cardsEachRow = 6;

	}

}
