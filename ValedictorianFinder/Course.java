import java.util.ArrayList;

public class Course {
	// Private fields
	 private String courseName;
	 private ArrayList<Student> roster;
	 
	 public Course(String courseName) {
		 this.courseName = courseName;
		 this.roster = new ArrayList<Student>();
	 }
	 
	 // Methods
	 // Adds the student object to the roster
	 public void addStudent(Student s) {
		 this.roster.add(s);
	 }
	 
	 public Student getTopStudent() {
		 
		 // Check if arraylist is empty
		 if (roster.isEmpty()) {
			 return null;
		 }
		 
		 // First student in array list
		 Student topStudent = roster.get(0);
		 
		 for (int i = 1; i < roster.size(); i++) {
			 Student currentStudent = roster.get(i);
			 if (currentStudent.getGPA() > topStudent.getGPA()) {
				 topStudent = currentStudent;
			 }
		 }
		 
		 return topStudent;
	 }
}
