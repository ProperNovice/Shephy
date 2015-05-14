package gui;

import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import utils.ImageView;
import utils.Parent;
import utils.ShutDown;

public class Panel extends Parent implements EventHandler<MouseEvent> {

	private ImageView background = new ImageView("Background.png", this);
	private PanelGame panelGame = new PanelGame();

	public Panel() {

		this.background.toBack();
		this.background.setOnMousePressed(this);

		this.getChildren().add(this.panelGame);

	}

	@Override
	public void handle(MouseEvent event) {

		if (!event.getButton().equals(MouseButton.PRIMARY))
			return;

		ShutDown.execute();

	}

}
