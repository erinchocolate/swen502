package island;

/**
* The islandBuilder interface define methods needed for creating parts for an island 
*
* @author  Meiqiao
* 
*/
public interface IslandBuilder {
	public void generateIslandWeather();
	public void generateIslandStream();
	public void generateIslandGrass();
	public void generateIslandAnimals();
	public void generateIslandPlants();
	public Island getIsland();
}
