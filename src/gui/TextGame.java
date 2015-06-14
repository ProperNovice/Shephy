package gui;

import instances.Instances;
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

		if (this.textEnum.string().contains("\n"))
			this.text.setHeight(2 * Dimensions.TEXT.y());
		else
			this.text.setHeight(Dimensions.TEXT.y());

		this.text.setVisible(false);

	}

	@Override
	public void handleMouseButtonPrimary() {
		Instances.getControllerInstance().gameStateController()
				.handleTextOptionPressed(this.textEnum);
	}

	public void relocate(double x, double y) {
		this.text.relocate(x, y);
	}

	public void toFront() {
		this.text.toFront();
	}

	public void setVisible(boolean value) {
		this.text.setVisible(value);
	}

	public TextEnum getTextEnum() {
		return this.textEnum;
	}

}
