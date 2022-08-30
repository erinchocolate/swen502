package bugworld;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Random;

public class Obstacle {
	private char symbol;
	private int posX;
	private int posY;
	private int width;
	private int height;
	private Point2D posCord;
	private World world;
	
	private ArrayList<Point2D> obstaclesPositions;
	private ArrayList<Point2D> plantsPositions;
	
	
	Obstacle(int width, int height, char symbol){
		this.width = width;
		this.height = height;
		generatePosX();
		generatePosY();
		setSymbol(symbol);	
	}
	
	public void setWorld(World world) {
		this.world = world;
	}
	
	public void setPlantsPositions() {
		this.plantsPositions = world.getPlantsPosition();
	}
	
	public void setObstaclesPositions() {
		this.obstaclesPositions = world.getObstaclesPosition();
	}
	
	public void generatePosX() {
		Random rand = new Random();
		this.posX = rand.nextInt(this.width);
	}
	
	public void generatePosY() {
		Random rand = new Random();
		this.posY = rand.nextInt(this.height);
	}
	
	public void generateCord() {		
		double x = (double)this.posX;
		double y = (double)this.posY;
		posCord = new Point2D.Double(x, y);
	}
	
	public Point2D getCord() {		
		return posCord;
	}
	
	public void checkCord() {
		//Check if the obstacle is on the plant
		//If so, generate a new position for the obstacle
		while(isThereAPlant()||isThereAnObstacle()) {
			generatePosX();
			generatePosY();
			generateCord();
		}
	}
	
	public boolean isThereAPlant() {
		//check this position already has plant or not
		return plantsPositions.contains(posCord);
	}
	
	public boolean isThereAnObstacle() {
		//check this position already has plant or not
		if(obstaclesPositions == null) {
			return true;
		}
		return plantsPositions.contains(posCord);
	}
	
	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}
	
	public char getSymbol() {
		return symbol;
	}
	
	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosX() {
		return posX;
	}
	
	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getPosY() {
		return posY;
	}
}
