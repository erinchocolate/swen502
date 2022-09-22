package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class StartSceneController {
	@FXML private Button startButton;
	@FXML private Button quitButton;
	@FXML private AnchorPane scenePane;
	private Stage stage;
	private Parent root;
	private Scene scene;
	 
	public void quitGame(ActionEvent event) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Quit");
		alert.setHeaderText("Are you sure you want to quit?");
		alert.setContentText("Sorry to see you go!");
		if(alert.showAndWait().get() == ButtonType.OK) {
			stage = (Stage)scenePane.getScene().getWindow();
			stage.close();
		}
	}
	
	public void startGame(ActionEvent event) throws IOException{
		root = FXMLLoader.load(getClass().getResource("GameMenuScene.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);	
		stage.setScene(scene);
		stage.show();
	}
}
