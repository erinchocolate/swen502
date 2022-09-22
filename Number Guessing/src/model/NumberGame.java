package model;

import java.util.Random;

public class NumberGame {
	private int guessCount;
	private int range;
	private int secrectNumber;
	private String result;
	
	public NumberGame(int range){
		setNumberRange(range);
		generateSecretNumber();
	}
	
	public void setNumberRange(int range) {
		this.range = range;
	}
	
	public void generateSecretNumber() {
		Random rand = new Random();
		//Generate a number between [0 - range].
		secrectNumber = rand.nextInt(range) + 1;
	}
	
	public String compareGuess(int guess) {
		if(guess < secrectNumber) {
			result = "low"; 
			guessCount++;
		}
		else if(guess > secrectNumber) {
			result = "high"; 
			guessCount++;
		}
		else {
			result = "win";
			guessCount++;
		}
		return result;
	}
	
	public int getGuessCount() {
		return guessCount;
	}
}
