package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.CSVReader;
import model.Person;
import model.PersonGenerator;

public class DataController {
	private Scene scene;
	private Stage stage;
	private Parent root;
	private List<Person> personData = new ArrayList<Person>();	
	private int dataSize;
	private CSVReader reader;
	private PersonGenerator generator;
	private @FXML TextField searchBar;
	private @FXML TextField nameLengthSearchBar;
	private @FXML TableView<Person> tableView;
	private @FXML TableColumn<Person, String> firstNameColumn;
	private @FXML TableColumn<Person, String> lastNameColumn;
	private @FXML TableColumn<Person, Integer> ageColumn;
	private @FXML TableColumn<Person, Integer> idColumn;
	private @FXML Button editButton;
	private @FXML Label warningLabel;
	private @FXML Label balancedLabel;
	
	public void setup(int dataSize){
		this.editButton.setDisable(true);
		this.warningLabel.setVisible(false);
		this.balancedLabel.setVisible(false);
		this.dataSize = dataSize;
		loadData();
		generatePerson();
		display();
	}

	public void setup(PersonGenerator generator) {
		this.editButton.setDisable(true);
		this.warningLabel.setVisible(false);
		this.balancedLabel.setVisible(false);
		this.generator = generator;
		personData = generator.getPersonData();
		display();
	}
	
	public void personSelected() {
		this.editButton.setDisable(false);	
	}
	
	public void checkButtonPushed(ActionEvent event) throws IOException{
		this.balancedLabel.setVisible(true);
		if(generator.isBalanced()) {
			this.balancedLabel.setText("Trees are balanced");
		}
		else{
			this.balancedLabel.setText("Trees are unbalanced");
		}
	}
	
	public void searchButtonForNamePushed(ActionEvent event) throws IOException{
		int input = -1;
		String userInput = nameLengthSearchBar.getText();
		input = Integer.valueOf(userInput);
		if(input <= 0) {
			this.warningLabel.setVisible(true);
			warningLabel.setText("Please enter a positive number!");
		}
		tableView.setItems(getPersonNameLength(input));	
	}
	
	// Find person by its first name, last name or age
	public void searchButtonPushed(ActionEvent event) throws IOException{
		int input = -1;
		String userInput = searchBar.getText();
		if(userInput.matches("-?\\d+")) {
			input = Integer.valueOf(userInput);
			if(input <=0 || input >120) {
				this.warningLabel.setVisible(true);
				warningLabel.setText("Please enter a valid age!");
			}
		}		
		if(getPersonByFirstName(userInput)!=null) {
			tableView.setItems(getPersonByFirstName(userInput));
		}
		else if(getPersonByLastName(userInput)!=null) {
			tableView.setItems(getPersonByLastName(userInput));
		}
		else if(getPersonByAge(input)!=null) {
			tableView.setItems(getPersonByAge(input));
		}
		else {
			tableView.setItems(null);
		}	
	}
	
	// Edit person info and update trees and date stored in generator
	public void editButtonPushed(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("PersonView.fxml"));
		root = loader.load();
		Person person = tableView.getSelectionModel().getSelectedItem();
		PersonViewController pvc = loader.getController();
		generator.deleteOldNode(person);
		pvc.preloadData(person, generator);
		pvc.display();
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);	
		stage.setScene(scene);
		stage.show();
	}
	
	public void loadData() {
		reader = new CSVReader();
		reader.read();
	}
	
	public void generatePerson() {
		generator = new PersonGenerator(dataSize);
		generator.setDatabase(reader.getData());
		generator.generatePerson();
		personData = generator.getPersonData();
	}

	public void display() {
		firstNameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
		lastNameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
		ageColumn.setCellValueFactory(new PropertyValueFactory<Person, Integer>("age"));	
		idColumn.setCellValueFactory(new PropertyValueFactory<Person, Integer>("id"));			
		tableView.setItems(getPerson());
	}
	
	public void sortByAge() {
		tableView.setItems(getPersonSortedByAge());
	}
	
	public void sortByFirstName() {
		tableView.setItems(getPersonSortedByFirstName());
	}
	
	public void sortByLastName() {
		tableView.setItems(getPersonSortedByLastName());	
	}
	
	public ObservableList<Person> getPerson(){
		ObservableList<Person> person = FXCollections.observableArrayList();
		for(Person p: personData) {
			person.add(p);
		}
		return person;
	}
	
	public ObservableList<Person> getPersonSortedByAge(){
		ObservableList<Person> ageData = FXCollections.observableArrayList();
		personData = generator.getPersonSortedByAge();
		for(Person p: personData) {
			ageData.add(p);
		}
		return ageData;
	}
	
	public ObservableList<Person> getPersonSortedByFirstName(){	
		ObservableList<Person> firstNameData = FXCollections.observableArrayList();
		personData = generator.getPersonSortedByFirstName();
		for(Person p: personData) {
			firstNameData.add(p);
		}
		return firstNameData;
	}
	
	public ObservableList<Person> getPersonSortedByLastName(){		
		ObservableList<Person> lastNameData = FXCollections.observableArrayList();
		personData = generator.getPersonSortedByLastName();
		for(Person p: personData) {
			lastNameData.add(p);
		}
		return lastNameData;
	}
	
	public ObservableList<Person> getPersonByFirstName(String name){
		ObservableList<Person> person = FXCollections.observableArrayList();
		if(generator.getPersonByFirstName(name) == null) {
			return null;
		}
		person.setAll(generator.getPersonByFirstName(name));
		return person;
	}
	
	public ObservableList<Person> getPersonByLastName(String name){
		ObservableList<Person> person = FXCollections.observableArrayList();
		if(generator.getPersonByLastName(name) == null) {
			return null;
		}
		person.setAll(generator.getPersonByLastName(name));
		return person;
	}
	
	public ObservableList<Person> getPersonByAge(int age){
		ObservableList<Person> person = FXCollections.observableArrayList();
		if(generator.getPersonByAge(age) == null) {
			return null;
		}
		person.setAll(generator.getPersonByAge(age));
		return person;
	}
	
	public ObservableList<Person> getPersonNameLength(int length){
		ObservableList<Person> person = FXCollections.observableArrayList();
		if(generator.getPersonByNameLength(length) == null) {
			return null;
		}
		person.setAll(generator.getPersonByNameLength(length));
		return person;
	}

}
