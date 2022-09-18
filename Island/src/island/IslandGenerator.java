package island;
/**
* The IslandGenerator class creates an island using the islandBuilder interface that is defined
*
* @author  Meiqiao
* 
*/

public class IslandGenerator {
	private ConcreteIslandBuilder islandBuiler;
	
	public IslandGenerator(ConcreteIslandBuilder islandBuiler) {
		this.islandBuiler = islandBuiler;
	}
	
	public Island getIsland() {
		return this.islandBuiler.getIsland();
	}
	
	public void makeIsland() {
		this.islandBuiler.generateIslandWeather();
		this.islandBuiler.generateIslandStream();
		this.islandBuiler.generateIslandGrass();
		this.islandBuiler.generateIslandAnimals();
		this.islandBuiler.generateIslandPlants();
	}
}
