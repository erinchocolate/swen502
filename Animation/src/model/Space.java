package model;

import java.util.ArrayList;
import java.util.Random;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;


public class Space {
	private ArrayList<Alien> ufos = new ArrayList<Alien>(); 
	private ArrayList<Planet> planets = new ArrayList<Planet>(); 
	private ArrayList<Alien> deadAliens = new ArrayList<Alien>(); 
	private ArrayList<Planet> deadPlanets = new ArrayList<Planet>(); 
	private int random;
	private Planet planet;
	private Alien ufo;
	private Alien deadAlien;
	private Planet deadPlanet;
	
	public Space(int alienNum, int planetNum){
		for(int i = 0; i<planetNum; i++) {
			generatePlanet();			
		}	
		for(int i = 0; i<alienNum; i++) {
			generateAlien();			
		}	
	}
	
	public void generateRandom() {
		random = (int)(Math.random() * 3);
	}
	
	public void generateAlien() {
		generateRandom();
		if(random == 0) {
			ufo = new Monster();
		}
		else if(random == 1) {
			ufo = new Yoda();
		}
		else {
			ufo = new Alien();
		}		
		ufo.setSpace(this);
		ufo.initPos();
		ufos.add(ufo);
	}
	
	public void generatePlanet() {
		generateRandom();
		if(random == 0) {
			planet = new Planet();
		}
		else if(random == 1) {
			planet = new RedStar();
		}
		else {
			planet = new YellowStar();
		}	
		planet.setSpace(this);
		planet.initPos();
		planets.add(planet);
	}
	
	public ArrayList<Planet> getPlanet(){
		return planets;
	}
	
	public ArrayList<Alien> getAlien(){
		return ufos;
	}
	
	public void moveAlien() {
		for(Alien a: ufos) {
			a.move();
		}		
	}
	
	public Alien removeAlien() {
		for(Alien a: ufos) {
			deadAlien = a.fight();
		}
		return deadAlien;
	}
	
	public Planet removePlanet() {
		for(Alien a: ufos) {
			deadPlanet = a.colonize();
		}
		return deadPlanet;
	}

	
}
