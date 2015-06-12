package enums;

public enum GameStateEnum {

	START_GAME("start game"),
	START_NEW_ROUND("start new round"),
	CHOOSE_EVENT("choose event"),
	ANIMATING("animating"),
	RESOLVE_CROWDING("resolve crowding"),
	RESOLVE_FALLING_ROCK("resolve falling rock"),
	RESOLVE_SHEEP_DOG("resolve sheep dog"),
	RESOLVE_METEOR("resolve meteor"),
	RESOLVE_PLAGUE("resolve plague"),
	RESOLVE_STORM("resolve storm"),
	RESOLVE_BE_FRUITFUL("resolve be fruitful"),
	RESOLVE_ALL_PURPOSE_SHEEP("resolve all purpose sheep"),
	RESOLVE_PLANNING_SHEEP("resolve planning sheep"),
	RESOLVE_FILL_THE_EARTH("resolve fill the earth"),
	RESOLVE_GOLDEN_HOOVES("resolve golden hooves"),
	RESOLVE_FLOURISH("resolve flourish"),
	RESOLVE_SLUMP("resolve slump"),
	RESOLVE_DOMINION("resolve dominion"),
	RESOLVE_INSPIRATION("resolve inspiration"),

	;

	private String text = null;

	private GameStateEnum(String text) {
		this.text = text;
	}

	public String text() {
		return this.text;
	}

}
