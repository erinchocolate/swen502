package application;
	
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ArrayChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;


public class Main extends Application {


	@Override
	public void start(Stage stage) {
		try {	
			
			//Layout
			BorderPane layout = new BorderPane();
			VBox form = new VBox(10);	
			form.setPadding(new Insets(20, 20, 20, 20));
			form.setSpacing(20);
			form.setAlignment(Pos.CENTER);
			layout.setCenter(form);
			
			//Form		
			Label alienLabel = new Label("Please choose the number of aliens");
			ChoiceBox<Integer> alienNum = new ChoiceBox();
			Label planetLabel = new Label("Please choose the number of planets");
			ChoiceBox<Integer> planetNum = new ChoiceBox();
			Button startButton = new Button("Start Simulation");
			form.getChildren().addAll(alienLabel, 
					alienNum, 
					planetLabel,
					planetNum,
					startButton);
				
			
			//Add numbers to choice box
			List<Integer> range = IntStream.rangeClosed(1, 50)
				    .boxed().collect(Collectors.toList());		
			alienNum.getItems().addAll(range);
			planetNum.getItems().addAll(range);
			
			
			//Start Button function
			startButton.setOnAction(new EventHandler<ActionEvent>() {
			    @Override
			    public void handle(ActionEvent event) {
			    	try {
				    	int alien = alienNum.getValue();
				    	int planet = planetNum.getValue();
						Simulator s = new Simulator();	
				    	s.init(stage, alien, planet);
			    	}
			    	catch(Exception e) {
			    		Label warning = new Label("Please choose numbers!");
			    		layout.getChildren().add(warning);
			    	}	    	
			    }
			});			
						
			//Window setting
			Scene scene = new Scene(layout, 500, 500);
			stage.getIcons().add(new Image("image/rocket.png"));
			stage.setTitle("Space World");
			stage.setResizable(false);
			stage.setScene(scene);			
			stage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
