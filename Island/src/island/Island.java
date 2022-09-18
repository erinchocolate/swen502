package island;

import java.util.ArrayList;

import simulator.SimulationCommand;

/**
* The island class models the island. When an island is created, it includes:
* - certain numbers of creatures - animals and plants
* - certain area of water
* - certain area of grass
* - different weather
* 
* The island provides methods to simulate interactions among animals, plants and geographical features for each turn
* - animals search for what they need and move toward to it
* - animals eat,drink or mate with partners
* - plants grow or shrink
* - animals or plants die 
*
* @author  Meiqiao
* 
*/

public class Island implements SimulationCommand{
	private Weather weather;
	private ArrayList<Water> streams;
	private ArrayList<Plant> grass;
	private ArrayList<Plant> plants;
	private ArrayList<Animal> animals;

	public void setWeather(Weather weather) {
		// TODO Auto-generated method stub
		this.weather = weather;
	}

	public void setStream(ArrayList<Water> streams) {
		// TODO Auto-generated method stub
		this.streams = streams;
	}

	public void setGrass(ArrayList<Plant> grass) {
		// TODO Auto-generated method stub
		this.grass = grass;
	}

	public void setPlants(ArrayList<Plant> plants) {
		// TODO Auto-generated method stub
		this.plants = plants;
	}

	public void setAnimals(ArrayList<Animal> animals) {
		// TODO Auto-generated method stub
		this.animals = animals;
	}
	
	public Weather getWeather() {
		return weather;
	}

	public ArrayList<Water> getStreams() {
		return streams;
	}

	public ArrayList<Plant> getGrass() {
		return grass;
	}

	public ArrayList<Plant> getPlants() {
		return plants;
	}

	public ArrayList<Animal> getAnimals() {
		return animals;
	}
	/**
	 * This method is used to change the weather of the island,
	 * animal and plants will get influenced by the weather change
	 */
	public void updateWeather() {
//		weather.change();
	}
	
	/**
	 * This method is used to simulate the animal's activity each turn
	 * The animal can eat, drink, mate with other animals or move towards to food, water or partners
	 * The animal that doesn't do the above activities will move randomly
	 * Animals that can't get enough food(energy level is 0) or water(water level is 0) will die and be removed from the island
	 */
	public void updateAnimals() {
//		for(Animal a:animals) {
//			if() {
//				a.searchForFood();
//				a.move();
//			}
//			else if(){
//				a.searchForWater();
//				a.move();
//			}	
//			else if(){
//				a.searchForPartner();
//				a.move();
//			}
//			else if(){
//				a.move();
//			}
//			else if(){
//				a.eat();
//			}		
//			else if(){
//				a.drink();
//			}	
//			else if() {
//				animals.remove(a);
//			}
//		}
	}
	/**
	 * This method is used to simulate the plant's activity each turn
	 * The plant can grow or shrink(if eaten by animal)
	 * Plants whose size shrinks to 0 will die and be removed from the island
	 */
	public void updatePlants() {
//		for(Plant p:plants) {
//			if() {
//				p.grow();
//			}
//			else(){
//				p.shrink();
//			}
//			if() {
//				plants.remove(p);
//			}
//		}
	}
	
}
