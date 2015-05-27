package enums;

public enum GameStateEnum {

	START_GAME("start game"),
	START_NEW_ROUND("start new round"),
	CHOOSE_EVENT("choose event"),

	;

	private String text = null;

	private GameStateEnum(String text) {
		this.text = text;
	}

	public String text() {
		return this.text;
	}

}
