package bugworld;

import java.awt.geom.Point2D;
import java.util.ArrayList;

public class World {
	private int height;
	private int width;
	private int bugNum;
	private int plantNum;
	private int obstacleNum;
	
	Bug bug;	
	Plant plant;
	Obstacle obstacle;
	
	ArrayList<Bug> bugs = new ArrayList<Bug>();
	ArrayList<Plant> plants = new ArrayList<Plant>();
	ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();
	
	ArrayList<Point2D> plantsPositions = new ArrayList<Point2D>();
	ArrayList<Point2D> bugsPositions = new ArrayList<Point2D>();
	ArrayList<Point2D> obstaclesPositions = new ArrayList<Point2D>();
	
	World(int width, int height, int bugNum, int plantNum, int obstacleNum){
		this.width = width;
		this.height = height;	
		this.bugNum = bugNum;
		this.plantNum = plantNum;
		this.obstacleNum = obstacleNum;
		generatePlant();
		generateObstacle();
		generateBug();	
	}
	
	public void generatePlant() {
		for(int i = 0; i < plantNum; i++) {				
			Plant plant = new Plant("Grass", this.width, this.height);				
			plants.add(plant);
			plant.generateCord();
			plantsPositions.add(plant.getCord());
		}
	}
	
	public void generateObstacle() {
		for(int i = 0; i < obstacleNum; i++) {				
			Obstacle obstacle = new Obstacle(this.width, this.height, '*');		
			obstacles.add(obstacle);
			obstacle.setWorld(this);
			obstacle.setPlantsPositions();
			obstacle.setObstaclesPositions();
			obstacle.generateCord();
			obstacle.checkCord();
			obstaclesPositions.add(obstacle.getCord());
		}
	}
	
	public void generateBug(){
		for(int i = 0; i < bugNum; i++) {	
			Ant ant = new Ant(this.width, this.height);
			bugs.add(ant);
			ant.setWorld(this);
			ant.setPlantsPositions();
			ant.setObstaclesPositions();
			ant.generateCord();
			ant.checkCord();
			bugsPositions.add(ant.getCord());
			ant.updateWorld();
		}
	}	
	
	public ArrayList<Point2D> getBugsPosition() {
		return bugsPositions;
	}
	
	public ArrayList<Point2D> getPlantsPosition() {
		return plantsPositions;
	}
	
	public ArrayList<Point2D> getObstaclesPosition() {
		return obstaclesPositions;
	}
	
	public ArrayList<Plant> getPlants(){
		return plants;
	}
	
	public ArrayList<Obstacle> getObstacles(){
		return obstacles;
	}
	
	public ArrayList<Bug> getBugs(){
		return bugs;
	}
	
	public void drawWorld() {
		 System.out.print('+');
		 for (int i = 0; i < width; i++) {
			 System.out.print('-');
		 }
		 System.out.println('+');
		 
		 for (int y = 0; y < height; y++) {
			 System.out.print('|');
			 for (int x = 0; x < width; x++) {
				 int i;
				 int j;
				 int o;
				 
				 for (i = 0; i < bugs.size(); i++) {
					 bug = bugs.get(i);				 
					 if (bug.getPosX() == x && bug.getPosY() == y) {
						 System.out.print(bug.getSymbol());
						 break;
					 } 
				 }
				 
				 for (j = 0; j < plants.size(); j++) {
					 plant = plants.get(j);
					 if (plant.getPosX() == x && plant.getPosY() == y) {
						 System.out.print(plant.getSize());
						 break;
					 } 
				 }		
				 
				 for (o = 0; o < obstacles.size(); o++) {
					 obstacle = obstacles.get(o);
					 if (obstacle.getPosX() == x && obstacle.getPosY() == y) {
						 System.out.print(obstacle.getSymbol());
						 break;
					 } 
				 }	
				 	
				 if (i == bugs.size() && j == plants.size() && o == obstacles.size()) {
					 System.out.print(' ');
				 }		
			}
			System.out.println('|');
		}
		
		System.out.print('+');
		for (int i = 0; i < width; i++) {
			System.out.print('-');
		}
		
		System.out.println('+');	
	}
	
	public void moveBug() {
		for (int i = 0; i < bugs.size(); i++) {		
			bug = bugs.get(i);
			bug.randomMove();
			bug.checkMove();
			bugsPositions.set(i, bug.getCord());
			bug.updateWorld();
		}
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public int getWidth() {
		return width;
	}
	
}
