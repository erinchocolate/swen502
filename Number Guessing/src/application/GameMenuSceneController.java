package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.stage.Stage;
import model.NumberGame;

public class GameMenuSceneController implements Initializable{
	@FXML private Button startButton;
	@FXML private Label numberLabel;
	@FXML private Label errorLabel;
	@FXML private Slider numberSlider;
	private int number;
	private String numberChoice;
	private Stage stage;
	private Parent root;
	private Scene scene;	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		errorLabel.setVisible(false);
		numberSlider.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {	
					//Display the number the user chooses from slider
					number = (int)numberSlider.getValue();
					numberChoice = Integer.toString(number);
					errorLabel.setVisible(false);
					numberLabel.setText(numberChoice);
			}			
		});
		
	}
	
	public void startGame(ActionEvent event) throws IOException{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("GameScene.fxml"));
		root = loader.load();
		GameSceneController gameController = loader.getController();
		try {
			gameController.displayNumber(numberChoice);
			NumberGame game = new NumberGame(number);
			gameController.setupGame(game);
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);	
			stage.setScene(scene);
			stage.show();
		}
		catch(Exception e){
			errorLabel.setVisible(true);
		}
		
	}
}
