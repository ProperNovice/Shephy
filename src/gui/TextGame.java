package gui;

import utils.EventHandler.EventHandlerAble;
import utils.Text;
import utils.TextButton;
import enums.Dimensions;
import enums.TextEnum;

public class TextGame implements EventHandlerAble {

	private TextEnum textEnum = null;
	private Text text = null;

	public TextGame(TextEnum textEnum) {

		this.textEnum = textEnum;
		createText();

	}

	private void createText() {

		String text = this.textEnum.string();

		switch (this.textEnum.textTypeEnum()) {

		case INDICATOR:
			this.text = new Text(text);
			break;

		case OPTION:
			this.text = new TextButton(text, this);
			break;

		}

		this.text.setHeight(Dimensions.TEXT.y());
		this.text.setVisible(false);

	}

	@Override
	public void handleMouseButtonPrimary() {

		System.out.println("pressed");

	}

	public void relocate(double x, double y) {
		this.text.relocate(x, y);
	}

	public void setVisible(boolean value) {
		this.text.setVisible(value);
	}

	public TextEnum getTextEnum() {
		return this.textEnum;
	}

}
