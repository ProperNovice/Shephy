package gameState;

import components.CardEvent;
import enums.GameStateEnum;
import enums.TextEnum;
import utils.ArrayList;
import utils.Lock;

public class ResolveInspiration extends GameState {

	@Override
	public void handleGameStateChange() {

		showPanelDeckOptions();

	}

	@Override
	public void handleTextOptionPressed(TextEnum textEnum) {

		super.controller.textController().concealText();

		switch (textEnum) {

		case SHOW_BOARD:
			showBoardOptions();
			break;

		case SHOW_DECK:
			showPanelDeckOptions();
			break;

		default:
			break;

		}

	}

	@Override
	protected void handleCardEventDeckPressed(CardEvent cardEvent) {

		super.controller.gameStateController().setGameState(
				GameStateEnum.ANIMATING);
		super.controller.textController().concealText();

		super.controller.deck().remove(cardEvent);
		super.controller.deck().backGroundSetVisibleFalse();
		super.controller.deck().flipDeck();

		super.controller.hand().addCardAnimateSynchronous(cardEvent);
		super.controller.deck().wrapUpDeckShuffleAnimateSynchronous();
		Lock.lock();

		super.controller.gameStateController().setGameState(
				GameStateEnum.START_NEW_ROUND);

	}

	private void showPanelDeckOptions() {

		ArrayList<TextEnum> list = new ArrayList<>();

		list.add(TextEnum.SHOW_BOARD);
		list.add(TextEnum.CHOOSE_EVENT);

		super.controller.textController().showText(list);

		super.controller.deck().panelDeckSetVisible(true);

	}

	private void showBoardOptions() {

		super.controller.textController().showText(TextEnum.SHOW_DECK);
		super.controller.deck().panelDeckSetVisible(false);

	}

}
