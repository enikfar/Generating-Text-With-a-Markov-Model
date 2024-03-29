package lab7;

import java.util.HashMap;
import java.util.Random;
import java.util.TreeMap;

public class State {
	String str;
	int counter;
	TreeMap<Character, Integer> suffixes;
	Random rand;

	public State(String s) {
		this.str = s;
		this.counter = 4;
		suffixes = new TreeMap<Character, Integer>();
		rand = new Random();
	}


	public void add(char c) {

		if(suffixes.containsKey(c)) {
			int newvalue = suffixes.get(c) + 1 ;
			suffixes.put(c,newvalue);
			counter++;
			}
		else {
			suffixes.put(c,1);
			counter++;
			}
			
		}
		
		
		// This adds the fact that character c was seen
		// as a followup to this state's string.
		// If c is a key of the suffixes TreeMap get
		// the value associated with it, add 1 to that value,
		// and call suffixes.put(c, newvalue).
		// ID c is not a key just call suffixes.put(c, 1).
		// Either way add 1 to counter.
	

	public char generate() {
		Random rand = new Random();
		int R = rand.nextInt(counter);
		for (Character c: suffixes.keySet() ) {
			int sub = R - c.charValue();
			if( sub < 0) {
				return c;
			}
		}
			 
		// Choose a random number R between 0 and counter-1.
		// Loop through all of suffix's keys. For each key 
		// subtract from R the key's value.
		// /Return the key that makes R become negative.
		return '#';
	}

	public String toString() {
		String s = String.format("%d %s:", counter, str);
		for (Character ch : suffixes.keySet())
			s += String.format(" (%c %d) ", ch, suffixes.get(ch));
		return s;
	}
}
