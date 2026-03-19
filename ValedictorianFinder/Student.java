
public class Student {
	
	// Private fields
	private String name;
	private double gpa;
	
	// Default constructor
	public Student() {
		this.name = "No name entered";
		this.gpa = 0.0;
	}
	
	// Parameterized constructor
	public Student(String name, double gpa) {
		this.name = name;
		this.gpa = gpa;
	}
	
	// Getters
	// Method to return student's name
	public String getName() {
		return name;
	}
	
	// Method to return student's GPA
	public double getGPA() {
		return gpa;
	}
	
	@Override
	public String toString() {
		return "Name: " + "[" + name + "]" + ", " + "GPA: " + "[" + gpa + "]";
	}

}
