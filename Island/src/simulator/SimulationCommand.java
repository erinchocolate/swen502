package simulator;
/**
* The SimulationCommand interface define methods needed for updating parts for island each turn 
*
* @author  Meiqiao
* 
*/
public interface SimulationCommand {
	public void updateAnimals();
	public void updatePlants();
	public void updateWeather();
}
