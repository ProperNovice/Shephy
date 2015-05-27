package controller;

import enums.Coordinates;
import enums.Dimensions;
import enums.TextEnum;
import gui.TextGame;
import utils.ArrayList;

public class TextController {

	private ArrayList<TextGame> texts = new ArrayList<>();
	private ArrayList<TextGame> textsShowing = new ArrayList<>();

	public TextController() {
		createTexts();
	}

	private void createTexts() {

		for (TextEnum textEnum : TextEnum.values())
			this.texts.add(new TextGame(textEnum));

	}

	public void showText(TextEnum textEnum) {

		ArrayList<TextEnum> arrayList = new ArrayList<>();
		arrayList.add(textEnum);
		showText(arrayList);

	}

	public void showText(ArrayList<TextEnum> arrayList) {

		while (!arrayList.isEmpty()) {

			TextEnum textEnum = arrayList.removeFirst();

			for (TextGame textGame : this.texts) {

				if (!textGame.getTextEnum().equals(textEnum))
					continue;

				this.textsShowing.add(textGame);
				textGame.setVisible(true);

				double x = Coordinates.TEXT.x();
				double y = Coordinates.TEXT.y()
						+ this.textsShowing.indexOf(textGame)
						* Dimensions.TEXT.y();

				textGame.relocate(x, y);

			}
		}
	}

	public void concealText() {

		for (TextGame textGame : this.textsShowing)
			textGame.setVisible(false);

		this.textsShowing.clear();

	}

}
