import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;

public class BookScanner{
	String[] files = {"100k-AnneOfGreenGables.txt", 
			"500k-WarAndPeace.txt",
			"1M-Clarissa.txt"};
	private Scanner scanner;
		
	BookScanner(int i){
		loadFile(i);
	}
	
	public void loadFile(int i) {
		File file = new File(files[i]);
		scanFile(file);
	}
	
	public void scanFile(File file) {
		try {
			this.scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Scanner getScanner() {
		return scanner;
	}
	
}
