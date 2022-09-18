package island;

import java.util.Random;
/**
* The Grass class models the grass on the island. 
* 
*
* @author  Meiqiao
* 
*/
public class Grass extends Plant{
	
	Grass(int width, int height){
		this.setPositionX(generateX(width));
		this.setPositionY(generateY(height));
		this.setGrowSpeed(5);
	}
	
	public int generateX(int width) {
		Random rand = new Random();
		return rand.nextInt(width);
	}
	
	public int generateY(int height) {
		Random rand = new Random();
		return rand.nextInt(height);
	}

	@Override
	public void grow() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void shrink() {
		// TODO Auto-generated method stub
		
	}

}
