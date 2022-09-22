package application;

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.Alien;
import model.Planet;
import model.Space;

public class Simulator{
	ArrayList<Alien> ufos; 
	ArrayList<Planet> planets;
	KeyFrame keyFrame;
	Timeline timeline;
	Stage stage;
	Scene scene;
	BorderPane layout;
	Space space;
	Button start;
	Button pause;
	Slider slider;
	
	public void init(Stage stage, int alien, int planet){
		this.stage = stage;		
		setupScene();
		addButtons();
		addButtonFunction();
		addSlider();
		addSliderFunction();
		animation(alien, planet);
	}
	
	public void setupScene() {
		layout = new BorderPane();
		scene = new Scene(layout, 500, 500);
		stage.setScene(scene);
		stage.show();
	}
	
	public void addButtons() {
		HBox buttons = new HBox();
		start = new Button("Start");
		pause = new Button("Pause");
		buttons.setSpacing(50);			
		buttons.getChildren().addAll(start,pause);
		buttons.setAlignment(Pos.CENTER);	
		buttons.setPadding(new Insets(20, 20, 20, 20));
		layout.setTop(buttons);
	}
	
	public void addSlider() {
		VBox sliderBox = new VBox();
		slider = new Slider(1, 4, 1);
		slider.setShowTickMarks(true);
		slider.setShowTickLabels(true);
		sliderBox.getChildren().add(slider);
		layout.setBottom(sliderBox);
	}
	
	public void addSliderFunction() {
        slider.valueProperty().addListener(
        new ChangeListener<Number>() {
        	@Override
        	public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
        		int rate = (int)slider.getValue();
        		timeline.setRate(rate);
        	}
        });
	}
	
	public void addButtonFunction() {
		pause.setOnAction((ActionEvent event) ->{
			timeline.pause();
		});
		
		start.setOnAction((ActionEvent event) ->{
			timeline.play();
		});
	}
	
	public void animation(int alienNum, int planetNum) {
		//Add aliens and planets to the scene
		Space space = new Space(alienNum, planetNum);
		ufos = space.getAlien();
		planets = space.getPlanet();
		layout.getChildren().addAll(ufos);
		layout.getChildren().addAll(planets);
		
		timeline = new Timeline();
		keyFrame = new KeyFrame(Duration.millis(100),(ActionEvent event) ->{
			space.moveAlien();	
			layout.getChildren().remove(space.removeAlien());
			layout.getChildren().remove(space.removePlanet());
		});	
		timeline.getKeyFrames().add(keyFrame);
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.setAutoReverse(true);			
	}
}
