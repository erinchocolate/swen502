package island;
/**
* The Animal class models the animal on the island. 
* 
* It provides methods for:
* - move towards food(abstract)
* - move towards water(abstract)
* - move towards partner(abstract)
* - eat
* - drink
*
* @author  Meiqiao
* 
*/
public abstract class Animal {
	
	private static int DEFAULT_ENERGY_LEVEL = 10;
	private static int DEFAULT_WATER_LEVEL = 10;
	private static int id = 0;
	private int age;
	private int energy;
	private int water;
	private int vision;
	private int moveSpeed;
	private int positionX;
	private int positionY;
	private String species;	
	private String livingArea;
	private Island island;
	private Parasite parasite;

	
	Animal(){
		this.setEnergy(DEFAULT_ENERGY_LEVEL);	
		this.setWater(DEFAULT_WATER_LEVEL);	
		id++;
	}
	/**
	 * The direction of animal's next move is decided by food direction
	 */
	public abstract void searchForFood(); 
	/**
	 * The direction of animal's next move is decided by water direction
	 */
	public abstract void searchForWater();
	/**
	 * The direction of animal's next move is decided by its partner direction
	 */
	public abstract void searchForPartner();
	/**
	 * The positionX and positionY of the animal object may change after the method
	 */
	public abstract void move();
	/**
	 * Animal produces new animal of its kind
	 * An object of the same animal will be created
	 */
	public abstract void mating();
	
	/**
	 * This method is used to increase animal's energy,
	 * animal will die if the energy becomes 0
	 */
	public void eat() {
		this.energy ++;
	}
	/**
	 * This method is used to increase animal's water level,
	 * animal will die if the water level becomes 0
	 */
	public void drink() {
		this.water ++;
	}

	public static int getId() {
		return id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}

	public int getWater() {
		return water;
	}

	public void setWater(int water) {
		this.water = water;
	}

	public int getVision() {
		return vision;
	}

	public void setVision(int vision) {
		this.vision = vision;
	}

	public int getMoveSpeed() {
		return moveSpeed;
	}

	public void setMoveSpeed(int moveSpeed) {
		this.moveSpeed = moveSpeed;
	}

	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getLivingArea() {
		return livingArea;
	}

	public void setLivingArea(String livingArea) {
		this.livingArea = livingArea;
	}
	
	public Island getIsland() {
		return island;
	}

	public void setIsland(Island theland) {
		this.island = theland;
	}
	
	public void setParasite(Parasite parasite) {
		this.parasite = parasite;
	}
}
