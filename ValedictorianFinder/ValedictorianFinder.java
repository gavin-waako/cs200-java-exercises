
public class ValedictorianFinder {

	public static void main(String[] args) {
		
		// Course object
		Course course = new Course("Advanced Java");
		
		// Student object
		Student s1 = new Student("Alice", 3.5);
		Student s2 = new Student("Bob", 3.9);
		Student s3 = new Student("Charlie", 3.7);
		Student s4 = new Student("Diana", 3.95);
		Student s5 = new Student("Lora", 4.0);
		
		// Enroll students into the course
		course.addStudent(s1);
		course.addStudent(s2);
		course.addStudent(s3);
		course.addStudent(s4);
		course.addStudent(s5);
		
		Student valedictorian = course.getTopStudent();
		
		if (valedictorian != null) {
			System.out.println("The valedictorian is: " + valedictorian.toString());
		}
	}
}
