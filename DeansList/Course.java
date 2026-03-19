import java.util.ArrayList;

public class Course {

	// Instance fields
    private ArrayList<Student> roster; 

    // Default constructor
    public Course() {
        roster = new ArrayList<Student>();
    }

    // Getter
    // Task: Return an ArrayList of all Students with a GPA of at least 3.5
    public ArrayList<Student> getDeansList() {
        ArrayList<Student> deansList = new ArrayList<Student>();

        /* TODO: Implement filtering logic here */
        for (int i = 0; i < roster.size() ; ++i) {
        	if (roster.get(i).getGPA() >= 3.5) {
        		deansList.add(roster.get(i));
        	}
        }

        return deansList;
    }

    // Setter
    public void addStudent(Student s) {
        roster.add(s);
    }

    public static void main(String args[]) {
        Course course = new Course();

        /* TODO: Create Student objects and add them to 'course' */
        Student s1 = new Student("Henry", "Nguyen", 3.5);
        Student s2 = new Student("Brenda", "Stern", 2.0);
        Student s3 = new Student("Lynda", "Robison", 3.2);
        Student s4 = new Student("Sonya", "King", 3.9);
        
        course.addStudent(s1);
        course.addStudent(s2);
        course.addStudent(s3);
        course.addStudent(s4);

        ArrayList<Student> deanList = course.getDeansList();

        System.out.println("Dean's list:");
        for (Student student : deanList) {
            System.out.println(student); 
        }
    }
}