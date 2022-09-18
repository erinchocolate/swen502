package island;
/**
* The PlantFactory class creates the specific plant object based on plant species and return it. 
*
* @author  Meiqiao
* 
*/

public class PlantFactory{
	
	public Plant makePlant(String plantSpecies) {
		Plant newPlant = null;
		
		switch(plantSpecies) {
		case "Grass":
			newPlant = new Grass(10,10);
		case "Apple tree":
			newPlant = new AppleTree();
		case "Pine tree":
			newPlant = new PineTree();
		case "Scrub brush":
			newPlant = new ScrubBrush();
		}
		return newPlant;
	}
}