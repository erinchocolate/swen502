package model;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

public class Monster extends Alien{
	public Monster(){
		super();
		setTechLevel(10);
		setSize(25);
		setSpeed(5);
	}
	
	@Override
	public void initImage() {
		Image icon = new Image("image/monster.png");
		this.setFill(new ImagePattern(icon));
	}
}
