package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Person;
import model.PersonGenerator;

public class PersonViewController implements ControllerClass{
	private Scene scene;
	private Stage stage;
	private Parent root;
	private Person person;
	private Person newPerson;
	private PersonGenerator pg;
	@FXML private TextField firstNameTextField;
	@FXML private TextField lastNameTextField;
	@FXML private TextField ageTextField;

	public void cancelButtonPushed(ActionEvent event) throws IOException{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Data.fxml"));
		root = loader.load();
		DataController dc = loader.getController();
		dc.setup(pg);
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);	
		stage.setScene(scene);
		stage.show();
	}
	
	public void saveButtonPushed(ActionEvent event) throws IOException {
		updatePerson();		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Data.fxml"));
		root = loader.load();
		DataController dc = loader.getController();
		dc.setup(pg);
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);	
		stage.setScene(scene);
		stage.show();
	}
	
	public void updatePerson() throws IOException {		
	     person.setFirstName(firstNameTextField.getText());
	     person.setLastName(lastNameTextField.getText());
	     person.setAge(Integer.valueOf(ageTextField.getText())); 	     
	     pg.updateTree(person);
	}
	
	public void display() {
      this.firstNameTextField.setText(person.getFirstName());
      this.lastNameTextField.setText(person.getLastName());
      this.ageTextField.setText(Integer.toString(person.getAge()));
	}
	
	@Override
	public void preloadData(Person person, PersonGenerator pg) {
		this.person = person;
		this.pg = pg;
	}
}
