package model;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

public class Yoda extends Alien{
	public Yoda(){
		super();
		setTechLevel(5);
		setSize(15);
		setSpeed(20);
	}
	
	@Override
	public void initImage() {
		Image icon = new Image("image/space-ship.png");
		this.setFill(new ImagePattern(icon));
	}
}
