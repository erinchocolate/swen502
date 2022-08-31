import java.util.Arrays;
import java.util.Scanner;

public class UI {
	private Scanner userScan;
	private String userInput;
	private String[] validInput = {"1", "2", "3", "4", "5", 
			"6", "7", "8", "9", "10","Q"};
	private StudentSystem s;
	
	UI(){
		s = new StudentSystem();
		startMenu();
		while(userInput!="Q") {
			askForInput();
			checkInput();
		}	
	}
	
	public void startMenu() {
		System.out.println("Welcome to student system.");
		System.out.println("1: display course list");
		System.out.println("2: display student list");
		System.out.println("3: search student by name");
		System.out.println("4: search student by id");
		System.out.println("5: search course by name");
		System.out.println("6: create course");
		System.out.println("7: add student");
		System.out.println("8: enroll student to course");
		System.out.println("9: assign grade to student");
		System.out.println("10: unenroll student");
		System.out.println("Q: Exit");
	}
	
	public void askForInput() {
		userScan = new Scanner(System.in);
		System.out.println("Choose what you want to proceed: ");
		userInput = userScan.nextLine();
		while(!Arrays.asList(validInput).contains(userInput)) {
			System.out.println("Please enter a valid option: ");
			userInput = userScan.nextLine();
		}
	}
	
	public void checkInput() {
		switch(userInput) {
		case "1":
			System.out.println(s.getCourseList());
			break;
		case "2":
			System.out.println(s.getStudentList());
			break;
		case "3":
			searchStudentByName();
			break;	
		case "4":
			searchStudentByID();
			break;
		case "5":
			searchCourseByName();
			break;
		case "6":
			addCourse();
			break;
		case "7":
			addStudent();
			break;
		case "8":
			enrollStudent();
			break;
		case "9":
			assignGrade();
			break;
		case "10":
			unenrollStudent();
			break;
		case "Q":
			System.out.println("Exit the program.");
			System.exit(0);
			break;
		}			
	}
	
	public void searchStudentByName() {
		userScan = new Scanner(System.in);
		System.out.println("Please enter the student name you want to search for:");
		userInput = userScan.nextLine();
		if(s.searchStudentByName(userInput) == null) {
			System.out.println("Sorry, the student you search for doesn't exsit.");
		}
		else {
			System.out.println(s.searchStudentByName(userInput));
		}	
	}
	
	public void searchStudentByID() {
		userScan = new Scanner(System.in);
		System.out.println("Please enter the student ID you want to search for:");
		userInput = userScan.nextLine();
		int id = Integer.parseInt(userInput);
		if(s.searchStudentByID(id) == null) {
			System.out.println("Sorry, the student you search for doesn't exsit.");
		}
		else {
			System.out.println(s.searchStudentByID(id));
		}	
	}
	
	public void searchCourseByName() {
		userScan = new Scanner(System.in);
		System.out.println("Please enter the course name you want to search for:");
		userInput = userScan.nextLine();
		if(s.searchCourseByName(userInput) == null) {
			System.out.println("Sorry, the course you search for doesn't exsit.");
		}
		else {
			System.out.println(s.searchCourseByName(userInput));
		}	
	}
	
	public void addCourse() {
		userScan = new Scanner(System.in);
		System.out.println("Please enter the course name you want to add:");
		userInput = userScan.nextLine();
		if(s.searchCourseByName(userInput) != null) {
			System.out.println("Sorry, the course you want to add already exsits.");
		}
		else {
			s.addCourse(userInput);
		}	
	}
	
	public void addStudent() {
		userScan = new Scanner(System.in);
		System.out.println("Please enter the student name you want to add:");
		userInput = userScan.nextLine();
		if(s.searchStudentByName(userInput) != null) {
			System.out.println("Sorry, the student you want to add already exsits.");
		}
		else {
			s.addStudent(userInput);
		}	
	}
	
	public void enrollStudent() {
		userScan = new Scanner(System.in);
		System.out.println("Please enter the student name:");
		String studentName = userScan.nextLine();
		System.out.println("Please enter the course name:");
		String courseName = userScan.nextLine();
		if(s.searchStudentByName(studentName) == null) {
			System.out.println("The student doesn't exsit.");
			System.out.println("Please add the student first.");
		}
		else if(s.searchCourseByName(courseName) == null) {
			System.out.println("The course doesn't exsit.");
			System.out.println("Please add the course first.");
		}
		else {
			Student student = s.searchStudentByName(studentName);
			Course course = s.searchCourseByName(courseName);
			s.addStudentToCourse(student, course);
			System.out.println(studentName + " is enrolled to " + courseName + ".");
		}	
	}
	
	public void assignGrade() {
		userScan = new Scanner(System.in);
		System.out.println("Please enter the student name:");
		String studentName = userScan.nextLine();
		System.out.println("Please enter the course name:");
		String courseName = userScan.nextLine();
		System.out.println("Please enter the grade:");
		String grade = userScan.nextLine();
		if(s.searchStudentByName(studentName) == null) {
			System.out.println("The student doesn't exsit.");
			System.out.println("Please add the student first.");
		}
		else if(s.searchCourseByName(courseName) == null) {
			System.out.println("The course doesn't exsit.");
			System.out.println("Please add the course first.");
		}
		else {
			Student student = s.searchStudentByName(studentName);
			Course course = s.searchCourseByName(courseName);
			s.addStudentGrade(student, course, grade);
			System.out.println(studentName + "'s grade is assigned to " + courseName + ".");
		}	
	}
	
	public void unenrollStudent() {
		userScan = new Scanner(System.in);
		System.out.println("Please enter the student name:");
		String studentName = userScan.nextLine();
		System.out.println("Please enter the course name:");
		String courseName = userScan.nextLine();
		if(s.searchStudentByName(studentName) == null) {
			System.out.println("The student doesn't exsit.");
			System.out.println("Please add the student first.");
		}
		else if(s.searchCourseByName(courseName) == null) {
			System.out.println("The course doesn't exsit.");
			System.out.println("Please add the course first.");
		}
		else {
			Student student = s.searchStudentByName(studentName);
			Course course = s.searchCourseByName(courseName);
			s.unenrollStudentFromCourse(student, course);
			System.out.println(studentName + " is unenrolled from " + courseName + ".");
		}	
	}
	
}
