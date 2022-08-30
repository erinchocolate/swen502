
public class Main {

	public static void main(String[] args) {
		BookScanner bs1 = new BookScanner(0);
		new HashMapLoader(bs1.getScanner());
		//new ArrayListLoader(bs1.getScanner());
		//BookScanner bs2 = new BookScanner(0);
		//new HashSetLoader(bs2.getScanner());
		
	}

}
