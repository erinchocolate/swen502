
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Driver {

	ArrayList<WordFrequency> wF = new ArrayList<WordFrequency>(); 
	HashSet<WordFrequency> wFSet = new HashSet<WordFrequency>(); 
	
	private WordFrequency searchInArrayList(String target){
		for(WordFrequency wf : wF){
			if(wf.getWord().equals(target))
				return wf;
		}
		return null;
	}
	
	private WordFrequency searchInHashSet(String target){
		for(WordFrequency wf : wFSet){
			if(wf.getWord().equals(target))
				return wf;
		}
		return null;
	}
	
	
	
	public Driver()
	{
		usingArrayList();	
		usingHashSet();
	}
	
	
	public void usingArrayList()
	{
		long st = System.currentTimeMillis();
		try
		{
			Scanner s = new Scanner (new File("100k-AnneOfGreenGables.txt"));
			while(s.hasNext())
			{
				String w = s.next();		
				WordFrequency found = this.searchInArrayList(w);
				if(found != null)
				{
					found.setFreq(found.getFreq()+1);
				}
				else
				{
					wF.add(new WordFrequency(w, 1));
				}
			}
			
			// printout the result
			
			for(WordFrequency wf : wF)
			{
				//System.out.println(wf);
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		long et = System.currentTimeMillis();
		
		System.out.println("ArrayList Time = " + (et-st));
	}
	
	public void usingHashSet()
	{
		long st = System.currentTimeMillis();
		try
		{
			Scanner s = new Scanner (new File("100k-AnneOfGreenGables.txt"));
			while(s.hasNext())
			{
				String w = s.next();		
				WordFrequency found = this.searchInHashSet(w);
				if(found != null)
				{
					found.setFreq(found.getFreq()+1);
				}
				else
				{
					wFSet.add(new WordFrequency(w, 1));
				}
			}
			
			// printout the result
			
			for(WordFrequency wf : wFSet)
			{
				//System.out.println(wf);
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		long et = System.currentTimeMillis();
		
		System.out.println("HashSet Time = " + (et-st));
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Driver();
	}

}
