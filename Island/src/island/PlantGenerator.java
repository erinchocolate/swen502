package island;

import java.util.ArrayList;
/**
* The PlantGenerator class creates the certain number of specific plant objects and return a list of them.
*
* @author  Meiqiao
* 
*/

public class PlantGenerator {
	private ArrayList<Plant> plants;
	private Plant plant;
	
	PlantGenerator(String plantSpecies, int plantNum){
		PlantFactory plantFactory = new PlantFactory();
		for(int i = 0; i < plantNum; i++) {
			plant = plantFactory.makePlant(plantSpecies);
			plants.add(plant);
		}
	}
	
	public ArrayList<Plant> getPlants(){
		return plants;
	}
}
