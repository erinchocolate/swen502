package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class JSController implements Initializable{
	@FXML private WebView webView;
	@FXML private TextArea textArea;
	@FXML private Label resultLabel;
	private WebEngine engine;
	
	public void run(ActionEvent e) {
		Object result = engine.executeScript(textArea.getText());
		resultLabel.setText(result.toString());	
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		engine = webView.getEngine();
	}
}
