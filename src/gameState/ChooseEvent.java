package gameState;

import utils.ArrayList;
import enums.TextEnum;

public class ChooseEvent extends GameState {

	@Override
	public void handleGameStateChange() {

		ArrayList<TextEnum> arrayList = new ArrayList<>();
		arrayList.add(TextEnum.CHOOSE_EVENT);
		arrayList.add(TextEnum.CHOOSE_EVENAT);

		super.controller.textController().showText(arrayList);

	}

}
