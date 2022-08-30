import java.io.File;
import java.util.HashSet;
import java.util.Scanner;

public class HashSetLoader {
	private Scanner scanner;
	private HashSet<String> wordsSet = new HashSet<String>();
	
	HashSetLoader(Scanner scanner){
		setScanner(scanner);
		checkHashSet();
	}
	
	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}
	
	public void loadFileIntoHashSet() {
		while (scanner.hasNext()) {
			String word = scanner.next().trim();
//			if(!wordsSet.contains(word)) {
				wordsSet.add(word);
//			}	
		}
	}
	
	public void checkHashSet() {
		final long startTime = System.currentTimeMillis();
		loadFileIntoHashSet();
		final long endTime = System.currentTimeMillis();
		System.out.println("Total execution time for HashSet: " + (endTime - startTime));
		System.out.println("Total words: " + wordsSet.size());
	}
}
