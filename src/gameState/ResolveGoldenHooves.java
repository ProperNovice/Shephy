package gameState;

import utils.ArrayList;
import components.CardSheep;
import enums.TextEnum;

public class ResolveGoldenHooves extends GameState {

	@Override
	public void handleGameStateChange() {

		ArrayList<TextEnum> list = new ArrayList<>();

		list.add(TextEnum.CHOOSE_SHEEP_TO_RAISE_THE_RANK);
		list.add(TextEnum.RAISE_THE_RANK_OF_ALL_SHEEP);
		list.add(TextEnum.CONTINUE);

		super.controller.textController().showText(list);

	}

	@Override
	protected void handleCardSheepBoardPressed(CardSheep cardSheep) {

	}

}
