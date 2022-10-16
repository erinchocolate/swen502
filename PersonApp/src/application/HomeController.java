package application;

import java.io.IOException;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.CSVReader;
import model.Person;
import model.PersonGenerator;

public class HomeController {
	private Scene scene;
	private Stage stage;
	private Parent root;
	private int personNum;
	
	@FXML Label warningLabel;
	@FXML TextField userInput;
	@FXML Button submitButton;
	
	public void submit(ActionEvent event) {
		try {
			personNum = Integer.parseInt(userInput.getText());
			if(personNum <= 0) {
				warningLabel.setText("Please enter a positive number!");
			}			
			switchToDataScene(event);	
			
		}
		catch(NumberFormatException e) {
			warningLabel.setText("Please enter a number!");
		}
		catch(Exception e) {			
		}
	}
	
	public void switchToDataScene(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Data.fxml"));
		root = loader.load();
		DataController dc = loader.getController();
		dc.setup(personNum);
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);	
		stage.setScene(scene);
		stage.show();
	}

}
