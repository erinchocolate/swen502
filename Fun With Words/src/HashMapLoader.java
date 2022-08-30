import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

public class HashMapLoader{
	String[] files = {"100k-AnneOfGreenGables.txt", 
			"500k-WarAndPeace.txt",
			"1M-Clarissa.txt"};
	private HashMap<String, Integer> wordsMap = new HashMap<String, Integer>();
	private Scanner scanner;
	
	
	HashMapLoader(Scanner scanner){
		setScanner(scanner);
		loadFileIntoHashMap();
		printHashMap(sortByValue(wordsMap));
	}

	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}
	
	public void loadFileIntoHashMap() {	
		while (scanner.hasNext()) {
			String word = scanner.next().trim();
			if(wordsMap.containsKey(word)) {
				wordsMap.put(word,wordsMap.get(word) + 1);
			}	
			else{
				wordsMap.put(word,1);
			}
		}
	}
	
	public void printHashMap(HashMap<String, Integer> hm) {
		String destination = "file1.txt";

        try(PrintStream ps = new PrintStream(destination)){
        	for (Entry<String, Integer> entry : hm.entrySet()) {
        	    String key = entry.getKey();
        	    Integer value = entry.getValue();
        	    ps.println("Word: " + key);
        	    ps.println("Count: " + value);
        	}      
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
	}
	
	public HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm) {
		List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(hm.entrySet());
		Collections.sort(list, new CountComparator());
		HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
	}
}
