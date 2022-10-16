package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This class is for generating person objects and add them into PersonBST.
 * It also interacts between JavaFX and PersonBST class
 * @author chenm
 *
 */
public class PersonGenerator {
	private int personNum;
	private int dataSize;
	private List<String> data;
	private List<Person> personData = new ArrayList<Person>();
	private List<Person> personNameLength = new ArrayList<Person>();
	private List<Person> personAgeData = new ArrayList<Person>();
	private List<Person> personLastNameData = new ArrayList<Person>();
	private List<Person> personFirstNameData = new ArrayList<Person>();
	private Random rand;
	private PersonBST firstNameBST;
	private PersonBST lastNameBST;
	private PersonBST ageBST;
	
	public PersonGenerator(int personNum){
		setSize(personNum);
		buildTree();
	}
	
	public void setSize(int personNum) {
		this.personNum = personNum; 
	}
	
	public void setDatabase(List<String> data) {
		this.data = data;
		this.dataSize = data.size();
	}
	
	public void buildTree() {
		firstNameBST = new PersonBST(new SortByFirstName());
		lastNameBST = new PersonBST(new SortByLastName());
		ageBST = new PersonBST(new SortByAge());
	}
	
	// Delete the node with person before user edits the person's info
	public void deleteOldNode(Person person) {
		ageBST.delete(person);
		firstNameBST.delete(person);
		lastNameBST.delete(person);
	}
	
	// Add new node with new person info after user edits
	// Updating tree and node by deleting old node and inserting new node
	public void updateTree(Person person) {
		ageBST.add(person);	
		firstNameBST.add(person);
		lastNameBST.add(person);
	}
	
	public void balanceTree() {
		ageBST.balance();
		firstNameBST.balance();
		lastNameBST.balance();
	}
	
	public boolean isBalanced() {
		return (ageBST.isBalanced() &&
		firstNameBST.isBalanced() &&
		lastNameBST.isBalanced());
	}
	
	public void generatePerson(){
		for(int i = 0; i < personNum; i ++) {
			rand = new Random();
			// Generate random name
			int index = rand.nextInt(dataSize);
			String name = data.get(index);		
			// Generate random age
			int age = rand.nextInt(100);		
			String[] values = name.split(" ");
			String firstName = values[0];
			String lastName = values[1];		
			Person p = new Person(firstName, lastName, age);	
			personData.add(p);
			// Add person into different BST
			firstNameBST.add(p);
			lastNameBST.add(p);
			ageBST.add(p);			
		}
	}
	
	// Return a list of person that has certain length of first names
	public List<Person> getPersonByNameLength(int length){
		if(personNameLength != null) {
			personNameLength.clear();
		}		
		firstNameBST.preorderByNameLength(length);		
		personNameLength = firstNameBST.getPersonByNameLength();
		return personNameLength;
	}
	
	public Person getPersonByFirstName(String name){
		return(firstNameBST.searchByFirstName(name));	
	}
	
	public Person getPersonByLastName(String name){
		return(lastNameBST.searchByLastName(name));	
	}
	
	public Person getPersonByAge(int age){
		return(ageBST.searchByAge(age));	
	}
	
	public List<Person> getPersonData(){
		return personData;
	}
	
	public List<Person> getPersonSortedByFirstName(){
		firstNameBST.inorder();
		personFirstNameData = firstNameBST.getSortedData();
		return personFirstNameData;
	}
	
	public List<Person> getPersonSortedByLastName(){
		lastNameBST.inorder();
		personLastNameData = lastNameBST.getSortedData();
		return personLastNameData;
	}
	
	public List<Person> getPersonSortedByAge(){
		ageBST.inorder();		
		personAgeData = ageBST.getSortedData();	
		return personAgeData;
	}
}
