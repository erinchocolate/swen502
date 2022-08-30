import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ArrayListLoader {
	private Scanner scanner;
	private List<String> wordsList = new ArrayList<String>();
	
	ArrayListLoader(Scanner scanner){
		setScanner(scanner);
		checkArrayList();
		sortByWord();
	}
	
	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}
	
	public void loadFileIntoArrayList() {
		while (scanner.hasNext()) {
			String word = scanner.next().trim();
			if(!wordsList.contains(word)) {
				wordsList.add(word);
			}	
		}
	}
	
	public void checkArrayList() {
		final long startTime = System.currentTimeMillis();
		loadFileIntoArrayList();
		final long endTime = System.currentTimeMillis();
		System.out.println("Total execution time for ArrayList: " + (endTime - startTime));
		System.out.println("Total words: " + wordsList.size());
	}
	
	public void sortByWord() {
		Collections.sort(wordsList);
		for(String s: wordsList) {
			System.out.println(s);
		}	
	}
}
