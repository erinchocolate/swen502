import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class StudentSystem {
	String fileName = "data.txt";
	private Scanner scanner;
	private Course course;
	private Student student;
	
	private HashMap<String, Student> studentByName = new HashMap<String, Student>();
	private HashMap<String, Course> courseByName = new HashMap<String, Course>();
	private HashMap<Integer, Student> studentByID = new HashMap<Integer, Student>();
	
	StudentSystem(){
		loadData();
		readData();
	}
	
	public void loadData() {
		File file = new File(fileName);
		try {
			this.scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void readData() {
		while (scanner.hasNext()) {
			String entry = scanner.nextLine().trim();
			Scanner entryScan = new Scanner(entry);
			while(entryScan.hasNext()) {
				String courseName = entryScan.next();
				String grade = entryScan.next();
				String firstName = entryScan.next();
				String lastName = entryScan.next();
				String studentName = firstName + " " + lastName;
				addCourse(courseName);
				addStudent(studentName);		
				course.addStudent(student, grade);
				student.addCourse(course, grade);			
			}
		}	
	}
	
	public void addCourse(String name) {
		if(courseByName.containsKey(name)) {
			course = courseByName.get(name);
		}
		else {
			course = new Course(name);
			courseByName.put(name, course);
		}	
	}
	
	public void addStudent(String name) {
		if (studentByName.containsKey(name)) {
			student = studentByName.get(name);									
		}
		else {
			student = new Student(name);
			studentByName.put(name, student);
			studentByID.put(student.getID(), student);
		}
	}
	
	public void addStudentToCourse(Student s, Course c) {
		c.addStudent(s);
		s.addCourse(c);	
	}
	
	public void addStudentGrade(Student s, Course c, String grade) {
		s.addCourse(c, grade);
		c.addStudent(s, grade);
	}
	
	public void unenrollStudentFromCourse(Student s, Course c) {
		s.removeCourse(c);
		c.removeStudent(s);
	}
	
	public Student searchStudentByName(String name) {
		return studentByName.get(name);
	}
	
	public Student searchStudentByID(int id) {
		return studentByID.get(id);
	}
	
	public Course searchCourseByName(String name) {
		return courseByName.get(name);
	}
	
	public Set<String> getCourseList(){
		return courseByName.keySet();
	}
	
	public Set<String> getStudentList(){
		return studentByName.keySet();
	}
}
