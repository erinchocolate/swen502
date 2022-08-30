package bugworld;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Random;

public class Bug{
	private String[] names = {"Buzz", "Lucky", "Happy", "Fly", "Honey"};
	private Integer[] energyLevel = {40, 80, 100, 50, 90};	
	private String[] directions = {"N", "S", "E", "W"};
	private String species;
	private String name;
	private String direction;
	private char symbol;
	private int posX;
	private int posY;
	private int posXBeforeMove;
	private int posYBeforeMove;
	private int energy;
	private int id;
	private int width;
	private int height;
	private Point2D posCord;
	private Plant targetFood;
	
	private ArrayList<Plant> plants;
	private ArrayList<Bug> bugs;
	private ArrayList<Obstacle> obstacles;
	
	private ArrayList<Point2D> bugsPositions;
	private ArrayList<Point2D> plantsPositions;
	private ArrayList<Point2D> obstaclesPositions;
	
	private ArrayList<Plant> foodList;
	
	private World world;
	private static int bugID = 0;
	
	public Bug(String species, int width, int height, char symbol) {
		this.species = species;	
		this.width = width;
		this.height = height;
		generateName();
		generateEnergy();		
		generatePosX();
		generatePosY();
		setSymbol(symbol);
		this.direction = null;
		bugID++;
		this.id = bugID;
	}
	
	public void setWorld(World world) {
		this.world = world;
	}
	
	public void updateWorld() {
		setBugsPositions(); 
		setPlantsPositions();
		setObstaclesPositions();
//		setPlants();
//		setObstacles();
//		setBugs();
	}
	
	public void setPlants() {
		this.plants = world.getPlants();
	}
	
	public void setObstacles() {
		this.obstacles = world.getObstacles();
	}
	
	public void setBugs() {
		this.bugs = world.getBugs();
	}
	
	public void setBugsPositions() {
		this.bugsPositions = world.getBugsPosition();
	}
	
	public void setPlantsPositions() {
		this.plantsPositions = world.getPlantsPosition();
	}
	
	public void setObstaclesPositions() {
		this.obstaclesPositions = world.getObstaclesPosition();
	}
	
	public void generateName() {
		int index = (int) (Math.random() * names.length);   
		this.name = names[index];
	}
	
	public void generateEnergy() {
		int index = (int) (Math.random() * energyLevel.length);   
		this.energy = energyLevel[index];
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
		//Check if the bug is on the plant or obstacle
		//If so, generate a new position for the bug
		while(isPositionOccupied()) {
			generatePosX();
			generatePosY();
			generateCord();
		}
	}
	
	public void generateRandomDirection() {
		int index = (int) (Math.random() * directions.length);   
		this.direction = directions[index];
	}
	
	public void generateFoodDirection() {
		if(targetFood.getPosX() > posX) {
			this.direction = "E";
		}
		else if(targetFood.getPosX() == posX) {
			if(targetFood.getPosY() > posY) {
				this.direction = "S";
			}
			else if(targetFood.getPosY() < posY) {
				this.direction = "N";
			}
		}
		else {
			this.direction = "W";
		}
		
	}
	
	public void generatePosition() {
		switch(this.direction) {
		  case "N":
			this.posY --; 
			break;
		  case "S":
			this.posY ++; 	
			break;
		  case "W":
			this.posX --; 
			break;
		  case "E":
			this.posX ++; 
			break;
		}
	}
	
	public void move() {
		if(foodList == null) {
			randomMove();
		}
		else {
			moveTowardsFood();
		}
	}
	
	public void moveTowardsFood() {
		targetFood();
		savePosBeforeMove();
		generateFoodDirection();
		generatePosition();
		generateCord();	
	}
	
	public void targetFood() {
		targetFood = foodList.get(0);
	}
	
	public void randomMove() {
		savePosBeforeMove();
		generateRandomDirection();
		generatePosition();
		generateCord();		
	}
	
	public void checkMove() {
		//Check the bug's next move is outside of the world, collide the obstacle or other bug
		//If so, bug goes back the previous position and move again
		while(isPositionOutofWorld()||isPositionOccupied()) {
			resetToPosBeforeMove();
			move();
		}
	}
	
	public boolean isPositionOutofWorld() {
		return (getPosX()>=this.width || getPosY()>=this.height);
	}
	
	public boolean isPositionOccupied() {
		if(plantsPositions==null) {
			return (isThereABug()||isThereAnObstacle());
		}
		if(bugsPositions==null) {
			return (isThereAPlant()||isThereAnObstacle());
		}
		if(obstaclesPositions==null) {
			return (isThereABug()||isThereAPlant());
		}
		return (isThereAPlant()||isThereAnObstacle()||isThereABug());
	}
	
	public boolean isThereAPlant() {
		//check this position already has plant or not
		return plantsPositions.contains(posCord);
	}
	
	public boolean isThereAnObstacle() {
		//check this position already has obstacle or not		
		return obstaclesPositions.contains(posCord);
	}
	
	public boolean isThereABug() {
		//check this position already has obstacle or not		
		return bugsPositions.contains(posCord);
	}	
	
	public void savePosBeforeMove() {
		posXBeforeMove = this.posX;
		posYBeforeMove = this.posY;
	}
	
	public void resetToPosBeforeMove() {
		this.posX = posXBeforeMove;
		this.posY = posYBeforeMove;
	}
	
	public void smellFood() {
		for(Plant p: plants) {
			if(p.getPosX()-posX <= 3 && p.getPosY()-posY <= 3) {
				foodList.add(p);
			}
		}
	}
	
	public String toString() {
		return "This bug's id is " + this.id + " and its name is " + this.name + " and it's a " + this.species + ".";
	}
	
	public String toText() {
		return "Bug's id: " + this.id + "\n" +
				"Bug's name: " + this.name + "\n" +
				"Bug's species: " + this.species + "\n" +
				"Bug's position: " + this.posX + " and " + this.posY + "\n" +
				"Bug's energy: " + this.energy + "\n" +
				"Bug's symbol: " + this.symbol;
	}
	
	public void setSpecies(String species) {
		this.species = species;
	}
	
	public String getSpecies() {
		return species;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
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
	
	public void setEnergy(int energy) {
		this.energy = energy;
	}

	public int getEnergy() {
		return energy;
	}
	
	public int getID() {
		return id;
	}

}
