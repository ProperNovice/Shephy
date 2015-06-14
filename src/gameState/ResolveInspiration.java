package gameState;

import enums.TextEnum;
import utils.ArrayList;

public class ResolveInspiration extends GameState {

	@Override
	public void handleGameStateChange() {

		ArrayList<TextEnum> list = new ArrayList<>();

		list.add(TextEnum.SHOW_BOARD);
		list.add(TextEnum.CHOOSE_EVENT);

		super.controller.textController().showText(list);

	}

}
