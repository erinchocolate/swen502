package island;
/**
* The ConcreteIslandBuilder class that assembles the parts of the finished island object 
*
* @author  Meiqiao
* 
*/
public class ConcreteIslandBuilder implements IslandBuilder{
	private Island island;
	
	public ConcreteIslandBuilder() {
		this.island = new Island();	
	}

	@Override
	public Island getIsland() {
		return island;
	}
	
	/**
	 * This method is used to initialize weather for island,
	 */
	@Override
	public void generateIslandWeather() {
		//Weather weather = new Weather();
		//island.setWeather(weather);
	}
	/**
	 * This method is used to initialize stream for the island
	 */
	@Override
	public void generateIslandStream() {
		// TODO Auto-generated method stub
		//streamGenerator stream = new streamGenerator();
		//island.setStream(stream.getStreams());
	}
	/**
	 * This method is used to initialize grass area for the island 
	 */
	@Override
	public void generateIslandGrass() {
		// TODO Auto-generated method stub
		PlantGenerator grass = new PlantGenerator("Grass", 10);
		island.setGrass(grass.getPlants());	
	}
	/**
	 * This method is used to initialize animals for the island
	 */
	@Override
	public void generateIslandAnimals() {
		// TODO Auto-generated method stub
		AnimalGenerator animal = new AnimalGenerator("Rabbit", 10);
		island.setAnimals(animal.getAnimals());
	}
	/**
	 * This method is used to initialize plants for the island
	 */
	@Override
	public void generateIslandPlants() {
		// TODO Auto-generated method stub
		PlantGenerator plant = new PlantGenerator("Apple tree", 10);
		island.setPlants(plant.getPlants());	
	}
	
}
