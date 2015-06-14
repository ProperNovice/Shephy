package gameState;

import utils.ArrayList;
import enums.TextEnum;

public class HandleEndGame extends GameState {

	@Override
	public void handleGameStateChange() {

		if (super.controller.board().isEmpty())
			setText(TextEnum.YOU_LOST);
		else if (super.controller.board().getHighestCardValue() != 1000)
			setText(TextEnum.YOU_LOST);
		else
			setText(TextEnum.YOU_WON);

	}

	@Override
	public void handleTextOptionPressed(TextEnum textEnum) {

		super.controller.textController().concealText();

	}

	private void setText(TextEnum textEnum) {

		ArrayList<TextEnum> arrayList = new ArrayList<>();

		arrayList.add(textEnum);
		arrayList.add(TextEnum.CONTINUE);

		super.controller.textController().showText(arrayList);

	}

}
