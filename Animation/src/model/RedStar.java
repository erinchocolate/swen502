package model;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

public class RedStar extends Planet{
	public RedStar(){
		super();
		setTechLevel(5);
		setSize(15);
	}
	
	@Override
	public void initImage() {
		Image icon = new Image("image/planet.png");
		this.setFill(new ImagePattern(icon));
	}
}
