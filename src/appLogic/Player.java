package appLogic;

public class Player {
	
	private int playerId;
	private String name;
	private int points;
	
	public Player(String n, int p, int id) {
		name  = n;
		points = p;
		playerId = id;
	}
}