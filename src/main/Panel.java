package main;

import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import utils.ImageView;
import utils.Parent;

public class Panel extends Parent implements EventHandler<MouseEvent> {

	private ImageView background = new ImageView("Background.png", this);

	public Panel() {

		this.background.toBack();
		this.background.setOnMousePressed(this);

	}

	@Override
	public void handle(MouseEvent event) {

		if (!event.getButton().equals(MouseButton.PRIMARY))
			return;

		System.out.println("start");

	}

}
