package components;

import enums.Coordinates;
import enums.Dimensions;
import enums.TextEnum;
import gui.TextGame;
import javafx.scene.paint.Color;
import utils.Animation;
import utils.Animation.AnimationSynch;
import utils.ArrayList;
import utils.Polyline;

public class RoundController {

	private ArrayList<TextGame> rounds = new ArrayList<>();
	private Polyline roundIndicator = null;
	private int currentRound = 1;

	public RoundController() {

		createIndicator();
		createRounds();

	}

	private void createIndicator() {

		this.roundIndicator = new Polyline(0.0, 0.0, Dimensions.TEXT.x() / 2,
				Dimensions.TEXT.y() / 4, 0.0, Dimensions.TEXT.y() / 2, 0.0, 0.0);

		this.roundIndicator.relocate(Coordinates.ROUND_INDICATOR.x(),
				Coordinates.ROUND_INDICATOR.y() + Dimensions.TEXT.y() / 4);
		this.roundIndicator.setFill(Color.BLACK);

	}

	private void createRounds() {

		this.rounds.add(new TextGame(TextEnum.ROUND_1));
		this.rounds.add(new TextGame(TextEnum.ROUND_2));
		this.rounds.add(new TextGame(TextEnum.ROUND_3));
		this.rounds.add(new TextGame(TextEnum.END_GAME));

		double x = Coordinates.TEXT_ROUNDS.x();
		double y = Coordinates.TEXT_ROUNDS.y();

		for (TextGame textGame : this.rounds) {

			textGame.setVisible(true);

			textGame.relocate(x, y);

			y += Dimensions.TEXT.y();

		}

	}

	public void proceedToNextRoundAnimateSynchronous() {

		this.currentRound++;

		Animation.animate(this.roundIndicator, Coordinates.ROUND_INDICATOR.x(),
				Coordinates.ROUND_INDICATOR.y() + Dimensions.TEXT.y() / 4
						+ (this.currentRound - 1) * Dimensions.TEXT.y(),
				AnimationSynch.SYNCHRONOUS);

	}

}
