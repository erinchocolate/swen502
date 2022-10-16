package model;

public class Person {
	private String firstName;
	private String lastName;
	private int firstNameLength;
	private int lastNameLength;
	private int age;
	private int id;
	private static int personId = 0;
	
	public Person(String firstName, String lastName, int age){
		setFirstName(firstName);
		setLastName(lastName);
		setAge(age);
		personId ++;
		this.id = personId;
	}
	
	public String toString() {	
		return firstName + " " + lastName + "(" + (String.valueOf(age)) + ")";
	}
	
	public boolean firstNameLongerThanLastName() {
		return firstName.length()>lastName.length();
	}
	
	public int getFirstNameLength() {
		return firstName.length();
	}
	
	public int getLastNameLength() {
		return lastName.length();
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getId() {
		return id;
	}
}
