package utils;

import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class EventHandler implements javafx.event.EventHandler<MouseEvent> {

	private EventHandlerAble eventHandlerAble = null;

	public interface EventHandlerAble {
		public void handleMouseButtonPrimary();
	}

	public EventHandler(EventHandlerAble eventHandlerAble) {
		this.eventHandlerAble = eventHandlerAble;
	}

	@Override
	public void handle(MouseEvent event) {

		if (event.getEventType().equals(MouseEvent.MOUSE_PRESSED))
			if (!event.getButton().equals(MouseButton.PRIMARY))
				return;

		Executor.runLater(() -> this.eventHandlerAble
				.handleMouseButtonPrimary());

	}

}
