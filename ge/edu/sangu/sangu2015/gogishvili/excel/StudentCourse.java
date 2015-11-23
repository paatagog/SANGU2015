package ge.edu.sangu.sangu2015.gogishvili.excel;

public class StudentCourse implements Comparable<StudentCourse> {
	private String studentId;
	private String studentName;
	private String studentSecondName;
	private String courseName;
	private int hour;
	private String day;
	private String lecturer;
	private String room;
	
	public String getStudentId() {
		return studentId;
	}
	
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentSecondName() {
		return studentSecondName;
	}

	public void setStudentSecondName(String studentSecondName) {
		this.studentSecondName = studentSecondName;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getLecturer() {
		return lecturer;
	}

	public void setLecturer(String lecturer) {
		this.lecturer = lecturer;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	@Override
	public int compareTo(StudentCourse sc) {
		
		if (!this.getStudentSecondName().equals(sc.getStudentSecondName())) {
			return this.getStudentSecondName().compareTo(sc.getStudentSecondName());
		}
		
		if (!this.getStudentName().equals(sc.getStudentName())) {
			return this.getStudentName().compareTo(sc.getStudentName());
		}
		
		if (!this.getStudentId().equals(sc.getStudentId())) {
			return this.getStudentId().compareTo(sc.getStudentId());
		}
		
		if (!this.getDay().equals(sc.getDay())) {
			return this.getDay().compareTo(sc.getDay());
		}
		
		return this.hour-sc.hour;
	}

}
