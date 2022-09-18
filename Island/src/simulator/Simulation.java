package simulator;

import island.Island;
/**
* The Simulation class controls the start or pause of the island simulation 
*
* @author  Meiqiao
* 
*/

public class Simulation implements Command{
	private Island island;

	@Override
	public void execute() {
		island.updateAnimals();
		island.updatePlants();
		island.updateWeather();
	}

	@Override
	public void pause() {
		
	}

}
