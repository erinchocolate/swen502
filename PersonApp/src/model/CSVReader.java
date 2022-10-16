package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
	String path = "./data/names.csv";
	private List<String> record = new ArrayList<>();
	private String line = "";
	private String fullName = "";
	
	public void read() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			while((line = br.readLine()) != null) {
				String[] values = line.split(" ");
				fullName = values[0] + " " + values[1];
				record.add(fullName);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<String> getData(){
		return record;
	}
}
