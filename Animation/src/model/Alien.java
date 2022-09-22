package model;

import java.util.ArrayList;
import java.util.Random;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class Alien extends Rectangle{
	private double size;
	private double posX;
	private double posY;
	private double preX;
	private double preY;
	private double speed;
	private int techLevel;
	private Random rand;
	private String[] directions = {"N", "S", "E", "W", "NE", "NW", "SE", "SW"};
	private String direction;
	private Space space;
	private Planet colony;
	private Alien removable;	
	ArrayList<Planet> planets;
	ArrayList<Alien> ufos;
	
	public Alien() {
		setSize(20);
		setSpeed(20);
		setTechLevel(0);
		setWidth(size);
		setHeight(size);
		initImage();
	}
	
	public void initImage() {
		Image icon = new Image("image/alien.png");
		this.setFill(new ImagePattern(icon));
	}
	
	public void initPos() {
		generateRandomPosX();
		generateRandomPosY();
		checkPos();
		setX(posX);
		setY(posY);
	}
	
	public void setTechLevel(int techLevel) {
		this.techLevel = techLevel;
	}
	
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
	public void setSize(double size) {
		this.size = size;
	}
	
	public void checkPos() {
		planets = space.getPlanet();
		ufos = space.getAlien();
		for(Planet p:planets) {
			if(checkCollision(p)) {
				initPos();
			}
		}
		for(Alien u:ufos) {
			if(checkCollision(u)) {
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
	
	public void move() {
		setPos();
		savePrePos();
		generateRandomDirection();		
		generateMove();	
		checkMove();
		setX(posX);
		setY(posY);
	}

	
	public void checkMove() {
		if(posX <= 0 || posY <= 0 || posX >= 480 || posY >= 480) {
			resetToPrePos();
			move();
		}
	}
	
	public void resetToPrePos() {
		setX(preX);
		setY(preY);		
	}
	
	public void savePrePos() {
		preX = posX;
		preY = posY;
	}
	
	public void setPos() {
		posX = this.getX();
		posY = this.getY();
	}
	
	public void generateRandomDirection() {
		int index = (int) (Math.random() * directions.length);   
		this.direction = directions[index];
	}
	
	public void generateMove() {
		switch(this.direction) {
		  case "N":
			this.posY -= speed; 
			break;
		  case "S":
			this.posY += speed; 	
			break;
		  case "W":
			this.posX -= speed; 
			break;
		  case "E":
			this.posX += speed; 
			break;
		  case "NE":
			this.posX += speed;  
			this.posY -= speed;
			break;
		  case "SE":
			this.posX += speed; 
			this.posY += speed; 	
			break;
		  case "NW":
			this.posX -= speed; 
			this.posY -= speed;
			break;
		  case "SW":
			this.posX -= speed; 
			this.posY += speed;
			break;
		}
	}
	
	public int getTechLevel() {
		return techLevel;
	}
	
	public Planet colonize() {
		for(Planet p: planets) {
			if(checkCollision(p)) {
				if(p.getTechLevel()<techLevel) {
					this.setTechLevel(techLevel+p.getTechLevel());
						colony = p;
						break;
				}
				else {
					this.techLevel--;
				}
			}
		}
		return colony;
	}
	
	public Alien fight() {	
		for(Alien u:ufos) {
			if(u!=this) {
				if(checkCollision(u)) {
					if(u.getTechLevel()>techLevel) {
						removable = this;
						break;
					}
					else {
						removable = u;
						break;
					}
					
				}
			}
		}
		return removable;
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
