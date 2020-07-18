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
	public void addPoint() {
		points = points + 1;
	}
	public String getName() {
		return name;
	}
	public int getPlayerId() {
		return playerId;
	}
	
	@Override
	public String toString() {
		return "<br>" +name;
	}
}