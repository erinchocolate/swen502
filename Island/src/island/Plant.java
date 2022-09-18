package island;
/**
* The Plant class models the plant on the island. 
* 
* It provides methods for:
* - grow(abstract)
* - shrink(abstract)
*
* @author  Meiqiao
* 
*/

public abstract class Plant {
	private static int DEFAULT_SIZE_LEVEL = 10;
	private static int id = 0;
	private int size;
	private int growSpeed;
	private int positionX;
	private int positionY;
	private String species;
	private boolean hasFruit;
	private boolean hasSeed;
	private Island island;
	
	Plant(){
		this.setSize(DEFAULT_SIZE_LEVEL);	
		id++;
	}
	
	public abstract void grow();
	public abstract void shrink();
	public static int getId() {
		return id;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
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

	public boolean hasFruit() {
		return hasFruit;
	}

	public void setHasFruit(boolean hasFruit) {
		this.hasFruit = hasFruit;
	}

	public boolean hasSeed() {
		return hasSeed;
	}

	public void setHasSeed(boolean hasSeed) {
		this.hasSeed = hasSeed;
	}
	
	public Island getIsland() {
		return island;
	}

	public void setIsland(Island theland) {
		this.island = theland;
	}
	
	public int getGrowSpeed() {
		return growSpeed;
	}

	public void setGrowSpeed(int growSpeed) {
		this.growSpeed = growSpeed;
	}
}
