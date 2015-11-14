package ge.edu.sangu.sangu2015.achelashvili.ExcelReader;

public class StudentsBase implements Comparable<StudentsBase> {
	
		private String name;
		private String surname;
		private String id;
		private String day;
		private String subject;
		private String room;
		private String lecturer;
		private int hour; 
		
		public StudentsBase(String name, String surname, String id, String day,
				String subject, String room, String leqtoure,int hour) {
			this.name = name + "\t";
			this.surname = surname+ "\t";
			this.id = id+ "\t";
			this.day = day+ "\t";
			this.subject=subject+ "\t";
			this.room = room+ "\t";
			this.lecturer = leqtoure+ "\t";
			this.hour = hour;
		}

		@Override
		public int compareTo(StudentsBase sb) {
			
			if (!this.surname.equals(sb.getSurname())){
				return this.surname.compareTo(sb.getSurname());
			}
			
			if (!this.day.equals(sb.getDay())){
				return this.day.compareTo(sb.getDay());
			}
			
			if (!this.room.equals(sb.getRoom())){
				return this.day.compareTo(sb.getRoom());
			}
			
			if (!this.name.equals(sb.getName())){
				return this.name.compareTo(sb.getName());
			}
			
			if (!this.id.equals(sb.getId())){
				return this.id.compareTo(sb.getId());
			}	
			
			return sb.getHour() - hour;
		}
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getSurname() {
			return surname;
		}
		public void setSurname(String surname) {
			this.surname = surname;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getDay() {
			return day;
		}
		public void setDay(String day) {
			this.day = day;
		}
		public String getSubject() {
			return subject;
		}
		public void setSubject(String subject) {
			this.subject = subject;
		}
		public String getRoom() {
			return room;
		}
		public void setRoom(String room) {
			this.room = room;
		}
		public String getLecturer() {
			return lecturer;
		}
		public void setLeqtoure(String leqtoure) {

			this.lecturer = leqtoure;
		}

		public int getHour() {
			return hour;
		}

		public void setHour(int hour) {
			this.hour = hour;
		}


}
