package graduate;

public class GameResult {
	private String gameName;
	private String result;
	private String teamA;
	private String teamB;
	private String goalA;
	private String goalB;
	private String pointA;
	private String pointB;
	private String ballA;
	private String ballB;
	private String type;
	private String time;
	public GameResult(String gameName,String result,String teamA,String teamB,String goalA,String goalB,String pointA,String pointB,String ballA,String ballB,String type,String time) {
		super();
		this.gameName = gameName;
		this.result = result;
		this.teamA = teamA;
		this.teamB = teamB;
		this.goalA = goalA;
		this.goalB = goalB;
		this.pointA = pointA;
		this.pointB = pointB;
		this.ballA = ballA;
		this.ballB = ballB;
		this.type = type;
		this.time = time;
	}
	public String getGameName() {
		return gameName;
	}
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getTeamA() {
		return teamA;
	}
	public void setTeamA(String teamA) {
		this.teamA = teamA;
	}
	public String getTeamB() {
		return teamB;
	}
	public void setTeamB(String teamB) {
		this.teamB = teamB;
	}
	public String getGoalA() {
		return goalA;
	}
	public void setGoalA(String goalA) {
		this.goalA = goalA;
	}
	public String getGoalB() {
		return goalB;
	}
	public void setGoalB(String goalB) {
		this.goalB = goalB;
	}
	public String getPointA() {
		return pointA;
	}
	public void setPointA(String pointA) {
		this.pointA = pointA;
	}
	public String getPointB() {
		return pointB;
	}
	public void setPointB(String pointB) {
		this.pointB = pointB;
	}
	public String getBallA() {
		return ballA;
	}
	public void setBallA(String ballA) {
		this.ballA = ballA;
	}
	public String getBallB() {
		return ballB;
	}
	public void setBallB(String ballB) {
		this.ballB = ballB;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
}
