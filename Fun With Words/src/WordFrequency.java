
public class WordFrequency {
	private String word;
	private int freq;
	
	public WordFrequency(String word, int freq)
	{
		this.setWord(word);
		this.setFreq(freq);
	}

	public int getFreq() {
		return freq;
	}

	public void setFreq(int freq) {
		this.freq = freq;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String toString()
	{
		return this.word +" = " + this.freq;
	}
}
