
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class Course {
	private String name;
	private HashMap<String, String> studentGrade = new HashMap<String, String>();
	
	Course(String name){
		setName(name); 
	}
	
	public String toString() {
		return "Course name: " + name + "\n"
				+ "Student enrolled: " + studentGrade.keySet() + "\n" 
				+ "Grades: " + studentGrade.values() + "\n" ;
	}
	
	public void addStudent(Student s) {
		studentGrade.put(s.getName(), null);
	}
	
	public void addStudent(Student s, String grade) {
		studentGrade.put(s.getName(), grade);
	}
	
	public void removeStudent(Student s) {
		studentGrade.remove(s.getName());
	}
	
	public Set<String> getStudent() {
		return studentGrade.keySet();
	}
	
	public Collection<String> getGrade() {
		return studentGrade.values();
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
}
