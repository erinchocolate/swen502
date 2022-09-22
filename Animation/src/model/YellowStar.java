package model;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

public class YellowStar extends Planet{
	public YellowStar(){
		super();
		setTechLevel(10);
		setSize(20);
	}
	
	@Override
	public void initImage() {
		Image icon = new Image("image/star.png");
		this.setFill(new ImagePattern(icon));
	}
}
