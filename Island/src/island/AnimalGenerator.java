package island;

import java.util.ArrayList;
/**
* The AnimalGenerator class creates the certain number of specific animal objects and return a list of them.
*
* @author  Meiqiao
* 
*/

public class AnimalGenerator {
	private ArrayList<Animal> animals;
	private Animal animal;
	
	AnimalGenerator(String animalSpecies, int animalNum){
		AnimalFactory animalFactory = new AnimalFactory();
		for(int i = 0; i < animalNum; i++) {
			animal = animalFactory.makeAnimal(animalSpecies);
			animals.add(animal);
		}
	}
	
	public ArrayList<Animal> getAnimals(){
		return animals;
	}
	
}
