package model;

public class Player {
	
	private String name;
	private int age;
	private String team;
	private double pointsPerGame;
	private double reboundsPerGame;
	private double assistsPerGame;
	private double robberiesByGames;
	private double blockingByGames;

	public Player(String name, int age, String team, double pointsPerGame, double reboundsPerGame, double assistsPerGame,
			double robberiesByGames, double blockingByGames) {
		this.name = name;
		this.age = age;
		this.team = team;
		this.pointsPerGame = pointsPerGame;
		this.reboundsPerGame = reboundsPerGame;
		this.assistsPerGame = assistsPerGame;
		this.robberiesByGames = robberiesByGames;
		this.blockingByGames = blockingByGames;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public double getPointsPerGame() {
		return pointsPerGame;
	}

	public void setPointsPerGame(double pointsPerGame) {
		this.pointsPerGame = pointsPerGame;
	}

	public double getReboundsPerGame() {
		return reboundsPerGame;
	}

	public void setReboundsPerGame(double reboundsPerGame) {
		this.reboundsPerGame = reboundsPerGame;
	}

	public double getAssistsPerGame() {
		return assistsPerGame;
	}

	public void setAssistsPerGame(double assistsPerGame) {
		this.assistsPerGame = assistsPerGame;
	}

	public double getRobberiesByGames() {
		return robberiesByGames;
	}

	public void setRobberiesByGames(double robberiesByGames) {
		this.robberiesByGames = robberiesByGames;
	}

	public double getBlockingByGames() {
		return blockingByGames;
	}

	public void setBlockingByGames(double blockingByGames) {
		this.blockingByGames = blockingByGames;
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", age=" + age + ", team=" + team + ", pointsPerGame=" + pointsPerGame
				+ ", reboundsPerGame=" + reboundsPerGame + ", assistsPerGame=" + assistsPerGame + ", robberiesByGames="
				+ robberiesByGames + ", blockingByGames=" + blockingByGames + "]";
	}
}
