package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.NumberGame;

public class GameSceneController {
	@FXML Label numberLabel;
	@FXML Label negativeLabel;
	@FXML Label countLabel;
	@FXML Label winningText;
	@FXML Label numberText;
	@FXML Button submitButton;
	@FXML Button replayButton;
	@FXML TextField userInput;
	@FXML ImageView resultView;
	@FXML AnchorPane pane;
	private NumberGame game;
	private String result;
	private Image lowImage;
	private Image highImage;
	private Image winImage;
	private Image numberImage;
	private int guess;
	private int guessCount;
	private Stage stage;
	private Parent root;
	private Scene scene;
	
	public void setupGame(NumberGame game) {
		this.game = game;
		setupImage();
		winningText.setVisible(false);
		replayButton.setVisible(false);
		negativeLabel.setVisible(false);
	}
	
	public void setupImage() {
		lowImage = new Image(getClass().getResourceAsStream("/image/low.gif"));
		highImage = new Image(getClass().getResourceAsStream("/image/high.gif"));
		winImage = new Image(getClass().getResourceAsStream("/image/win.gif"));
		numberImage = new Image(getClass().getResourceAsStream("/image/number.gif"));
	}
	
	public void submit(ActionEvent event) {
		try {
			guess = Integer.parseInt(userInput.getText());
			//Display a message when user inputs negative number
			if(guess < 0) {
				negativeLabel.setVisible(true);
			}
			result = game.compareGuess(guess);
			guessCount = game.getGuessCount();
			countLabel.setText(Integer.toString(guessCount));
			displayResult();
		}
		catch (NumberFormatException e) {
			resultView.setImage(numberImage);
		}
	}
	
	public void displayResult() {
		switch(result) {
		case "low":
			resultView.setImage(lowImage);
			break;
		case "high":
			resultView.setImage(highImage);
			negativeLabel.setVisible(false);
			break;
		case "win":
			resultView.setImage(winImage);
			replayButton.setVisible(true);
			winningText.setVisible(true);
			numberText.setVisible(false);
			numberLabel.setVisible(false);
			submitButton.setVisible(false);
			negativeLabel.setVisible(false);
			break;
		}	
	}
	
	public void replay(ActionEvent event)throws IOException {
		root = FXMLLoader.load(getClass().getResource("GameMenuScene.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);	
		stage.setScene(scene);
		stage.show();
	}
	
	public void displayNumber(String numberChoice) {
		numberLabel.setText(numberChoice);
	}
	
}
