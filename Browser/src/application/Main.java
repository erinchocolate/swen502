package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	private TabPane pane;
	@Override
	public void start(Stage stage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
			//Add tab that links with root
			Tab browserTab = new Tab("Tab 1", root);
	        Tab addTab = new Tab("+", null);
	        addTab.setClosable(false);        
	        addTab.setOnSelectionChanged(new EventHandler<Event>() {
	            @Override
	            public void handle(Event event) {
	                addTab();
	            }
	        });
	        pane = new TabPane(browserTab, addTab);
	        Scene scene = new Scene(pane);
			stage.setTitle("Web Browser");		
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addTab() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
            int num = pane.getTabs().size();
            Tab browserTab = new Tab("Tab " + String.valueOf(num), root);
            //Add new tab after "+" tab
            pane.getTabs().add(pane.getTabs().size() - 1, browserTab);
            pane.getSelectionModel().select(browserTab);
        } catch (IOException ex) {
            System.out.println("error");
        }
    }
	
	public static void main(String[] args) {
		launch(args);
	}
}
