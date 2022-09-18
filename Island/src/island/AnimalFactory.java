package island;
/**
* The AnimalFactory class creates the specific animal object based on animal species and return it. 
*
* @author  Meiqiao
* 
*/
public class AnimalFactory {

	public Animal makeAnimal(String animalSpecies) {
		Animal newAnimal = null;
		switch(animalSpecies) {
		case "Rabbit":
			newAnimal = new Rabbit();
		case "Kiwi":
			newAnimal = new Kiwi();
		case "Cat":
			newAnimal = new Cat();
		case "Sparrow":
			newAnimal = new Sparrow();
		case "Rat":
			newAnimal = new Rat();
		case "Grub":
			newAnimal = new Grub();
		}
		return newAnimal;
		
	}
}
