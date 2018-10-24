package model;

public class Player {
	
	private String name;
	private int age;
	private String team;
	private int pointsPerGame;
	private int reboundsPerGame;
	private int assistsPerGame;
	private int robberiesByGames;
	private int blockingByGames;
	
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

	public int getPointsPerGame() {
		return pointsPerGame;
	}

	public void setPointsPerGame(int pointsPerGame) {
		this.pointsPerGame = pointsPerGame;
	}

	public int getReboundsPerGame() {
		return reboundsPerGame;
	}

	public void setReboundsPerGame(int reboundsPerGame) {
		this.reboundsPerGame = reboundsPerGame;
	}

	public int getAssistsPerGame() {
		return assistsPerGame;
	}

	public void setAssistsPerGame(int assistsPerGame) {
		this.assistsPerGame = assistsPerGame;
	}

	public int getRobberiesByGames() {
		return robberiesByGames;
	}

	public void setRobberiesByGames(int robberiesByGames) {
		this.robberiesByGames = robberiesByGames;
	}

	public int getBlockingByGames() {
		return blockingByGames;
	}

	public void setBlockingByGames(int blockingByGames) {
		this.blockingByGames = blockingByGames;
	}

	public Player(String name, int age, String team, int pointsPerGame, int reboundsPerGame, int assistsPerGame,
			int robberiesByGames, int blockingByGames) {
		super();
		this.name = name;
		this.age = age;
		this.team = team;
		this.pointsPerGame = pointsPerGame;
		this.reboundsPerGame = reboundsPerGame;
		this.assistsPerGame = assistsPerGame;
		this.robberiesByGames = robberiesByGames;
		this.blockingByGames = blockingByGames;
	}
	
	

}
