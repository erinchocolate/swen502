package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class HTMLController implements Initializable{
	private WebEngine engine;
	@FXML private WebView webView;
	@FXML private TextArea textArea;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		engine = webView.getEngine();
		
		// Listen for TextField text changes
		textArea.textProperty().addListener(new ChangeListener<String>() {
			public void changed(ObservableValue<? extends String> observable,
					String oldValue, String newValue) {			
				engine.loadContent(textArea.getText());
			}
		});
	}

}
