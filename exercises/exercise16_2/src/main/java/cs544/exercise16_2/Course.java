package cs544.exercise16_2;

public class Course {
	private long coursenumber;
	private String name;
	private String grade;

	public Course(long coursenumber, String name, String grade) {
		this.coursenumber = coursenumber;
		this.name = name;
		this.grade = grade;
	}

	public Course() {
	}

	public long getCoursenumber() {
		return coursenumber;
	}

	public void setCoursenumber(long coursenumber) {
		this.coursenumber = coursenumber;
	}

	public String getName() {
		return name;
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

}
