package gui;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import utils.Animation;
import utils.Logger;
import utils.ShutDown;
import enums.Dimensions;

public class Shephy extends Application {

	private Panel panel = null;

	@Override
	public void start(Stage primaryStage) throws Exception {

		Animation.startAnimation();
		Logger.startLogging();

		this.panel = new Panel();

		double width = Dimensions.FRAME.x() + Dimensions.INSETS.x();
		double height = Dimensions.FRAME.y() + Dimensions.INSETS.y();

		primaryStage.setScene(new Scene(this.panel));
		primaryStage.setWidth(width);
		primaryStage.setHeight(height);
		primaryStage.setResizable(false);

		primaryStage.setTitle("Shephy");

		primaryStage
				.setX((Screen.getPrimary().getBounds().getWidth() - width) / 2);
		primaryStage
				.setY((Screen.getPrimary().getBounds().getHeight() - height) / 2);

		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {

			@Override
			public void handle(WindowEvent event) {
				ShutDown.execute();
			}

		});

		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
