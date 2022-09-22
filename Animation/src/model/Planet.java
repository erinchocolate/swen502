package model;

import java.util.ArrayList;
import java.util.Random;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class Planet extends Rectangle{
	private double size;
	private double posX;
	private double posY;
	private Random rand;
	private int techLevel;
	ArrayList<Planet> planets;
	private Space space;
	
	public Planet() {
		setSize(20);
		setWidth(size);
		setHeight(size);	
		setTechLevel(2);
		initImage();
	}
	
	public void initImage() {
		Image icon = new Image("image/saturn.png");
		this.setFill(new ImagePattern(icon));
	}
	
	public void initPos() {
		generateRandomPosX();
		generateRandomPosY();
		checkPos();
		setX(posX);
		setY(posY);
	}
	
	public void setSize(double size) {
		this.size = size;
	}
	
	public void checkPos() {
		planets = space.getPlanet();
		for(Planet p:planets) {
			if(checkCollision(p)) {
				initPos();
			}
		}
	}
	
	public void generateRandomPosX() {
		rand = new Random();
		posX = rand.nextDouble(400);
	}
	
	public void generateRandomPosY() {
		rand = new Random();
		posY = rand.nextDouble(400);
	}
	
	public void setSpace(Space space) {
		this.space = space;
	}
	
	public void setTechLevel(int techLevel) {
		this.techLevel = techLevel;
	}
	
	public int getTechLevel() {
		return techLevel;
	}
	
	public boolean checkCollision(Rectangle sprite) {
		return(collideTopLeftCorner(sprite)||
			collideTopRightCorner(sprite)||
			collideBottomRightCorner(sprite)||
			collideBottomLeftCorner(sprite));
	}
	
	public boolean collideTopLeftCorner(Rectangle sprite) {
		return (sprite.getX() <= posX && 
				sprite.getY() <= posY && 
				sprite.getX() + sprite.getWidth() >= posX && 
				sprite.getY() + sprite.getHeight()>= posY);
	}
	
	public boolean collideTopRightCorner(Rectangle sprite) {
		return (sprite.getX() <= posX + size && 
				sprite.getY() <= posY && 
				sprite.getX() + sprite.getWidth() >= posX + size && 
				sprite.getY() + sprite.getHeight()>= posY);
	}
	
	public boolean collideBottomRightCorner(Rectangle sprite) {
		return (sprite.getX() <= posX && 
				sprite.getY() <= posY + size && 
				sprite.getX() + sprite.getWidth() >= posX && 
				sprite.getY() + sprite.getHeight()>= posY + size);
	}
	
	public boolean collideBottomLeftCorner(Rectangle sprite) {
		return (sprite.getX() <= posX + size&& 
				sprite.getY() <= posY + size && 
				sprite.getX() + sprite.getWidth() >= posX + size&& 
				sprite.getY() + sprite.getHeight()>= posY + size);
	}
	
}
