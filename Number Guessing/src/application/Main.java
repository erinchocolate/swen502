package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage stage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("StartScene.fxml"));
			Scene scene = new Scene(root);
			Image icon = new Image("/image/icon.png");
			stage.getIcons().add(icon);
			stage.setTitle("Number Guess");
			stage.setResizable(false);
			stage.setScene(scene);
			stage.show();
			//Triggers alert window when user clicks red X on the program's corner
			stage.setOnCloseRequest(event -> {
			//When user clicks cancel, the program won't close
				event.consume();
				quitGame(stage);
			});
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void quitGame(Stage stage) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Quit");
		alert.setHeaderText("Are you sure you want to quit?");
		alert.setContentText("Sorry to see you go!");
		if(alert.showAndWait().get() == ButtonType.OK) {
			stage.close();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
