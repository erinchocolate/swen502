package bugworld;

import java.awt.geom.Point2D;
import java.util.Random;

public class Plant{
	protected String species;
	protected char symbol;
	protected int posX;
	protected int posY;
	protected int size;	
	protected int width;
	protected int height;
	protected Point2D posCord;
	
	Plant(String species, int width, int height){
		this.species = species;	
		this.width = width;
		this.height = height;
		generatePosX();
		generatePosY();
		generateSize();	
	}
	
	public void generatePosX() {
		Random rand = new Random();
		this.posX = rand.nextInt(this.width);
	}
	
	public void generatePosY() {
		Random rand = new Random();
		this.posY = rand.nextInt(this.height);
	}
	
	public void generateCord() {		
		double x = (double)this.posX;
		double y = (double)this.posY;
		this.posCord = new Point2D.Double(x, y);
	}
	
	public Point2D getCord() {		
		return posCord;
	}
	
	public void generateSize() {
		Random rand = new Random();
		this.size = rand.nextInt(9)+1;
	}
	
	public void setSpecies(String species) {
		this.species = species;
	}
	
	public String getSpecies() {
		return species;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosX() {
		return posX;
	}
	
	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getPosY() {
		return posY;
	}
	
	public void setSize(int size) {
		this.size = size;
	}

	public int getSize() {
		return size;
	}	
	
}
