package components;

import controller.Controller;
import instances.Instances;
import utils.ImageView;
import enums.CardEnum;
import enums.Dimensions;
import gui.PanelGame;

public class Card {

	protected ImageView imageView = null;
	protected CardEnum cardEnum = null;
	protected Controller controller = Instances.getControllerInstance();

	public Card(CardEnum cardEnum) {

		this.cardEnum = cardEnum;
		createImageview();

	}

	private void createImageview() {

		double topLeftX = Dimensions.CARD_IMAGE_TOP_LEFT.x();
		double topLeftY = Dimensions.CARD_IMAGE_TOP_LEFT.y();
		double width = Dimensions.CARD_IMAGE_DIMENSION.x();
		double height = Dimensions.CARD_IMAGE_DIMENSION.y();

		topLeftX += this.cardEnum.column() * width;
		topLeftY += this.cardEnum.row() * height;

		PanelGame panelGame = Instances.getPanelGameInstance();

		String path = "/cards/" + this.cardEnum.filename() + ".png";

		this.imageView = new ImageView(path, panelGame);
		this.imageView.setViewport(topLeftX, topLeftY, width, height);
		this.imageView.relocate(50, 50);
		
		this.imageView.setWidth(Dimensions.CARD.x());

	}

	public void relocate(double x, double y) {
		this.imageView.relocate(x, y);
	}

	public CardEnum getCardEnum() {
		return this.cardEnum;
	}

}
