package algorithm;

import java.util.ArrayList;
import java.util.List;

public class StringQueue {

	List<String> stringQueue;
	
	public StringQueue() {
		stringQueue = new ArrayList<String>();
	}
	
	public void offerToStringQueue(String input) {
		stringQueue.add(input);
	}
	
	public String peekFromStringQueue() {
		return stringQueue.remove(stringQueue.size()-1);
	}
	
	public void printStringQueue() {
		System.out.println("Printing StringQueue.");
		for(String s : stringQueue) {
			System.out.println(s);
		}
		System.out.println("StringQueue Printed.");
	}
	
}
