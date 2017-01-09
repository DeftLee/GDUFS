package graduate;

public class Player {
	private String id;
	private String name;
	private String teamName;
	private String grade;
	private String depart;
	private String position;
	private int number;
	private String role;  //Role in team, team member or caption
	public Player(String id,String name,String teamName,String grade,String depart,String position,int number,String role) {
		super();
		this.id = id;
		this.name = name;
		this.teamName = teamName;
		this.grade = grade;
		this.depart = depart;
		this.position = position;
		this.number = number;
		this.role = role;
	}
	public String getId() {
		return id;
	}
	public String getDepart() {
		return depart;
	}
	public void setDepart(String depart) {
		this.depart = depart;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getRole() {
		return this.role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}
