
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class Student {
	private static int studentID = 1000000;
	private int id;
	private String name;	
	private HashMap<String, String> courseGrade = new HashMap<String, String>();
	
	Student(String name){
		studentID ++;
		setName(name); 
		setID(studentID);
	}
	
	public String toString() {
		return "Student name: " + name + "\n"
			+ "Student id: " + id + "\n" +
			"Courses enrolled: " + courseGrade.keySet() + "\n" 
			+ "Grades: " + courseGrade.values() + "\n" ;
			
	}
	
	public void addCourse(Course c) {
		courseGrade.put(c.getName(), null);
	}
	
	public void addCourse(Course c, String grade) {
		courseGrade.put(c.getName(), grade);
	}
	
	public void removeCourse(Course c) {
		courseGrade.remove(c.getName());
	}
	
	public Set<String> getCourse() {
		return courseGrade.keySet();
	}
	
	public Collection<String> getGrade(){
		return courseGrade.values();
	}
	
	public void setID(int id) {
		this.id = id;
	}
	
	public int getID() {
		return id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

}
