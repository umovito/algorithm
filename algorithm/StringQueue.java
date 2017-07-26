package algorithm;

import java.util.ArrayList;
import java.util.List;

public class StringQueue {

	List<String> stringQueue;
	
	public StringQueue() {
		stringQueue = new ArrayList<String>();
	}
	
	public void pushToStringQueue(String input) {
		stringQueue.add(input);
	}
	
	public String popFromStringQueue() {
		return stringQueue.remove(0);
	}
	
	public void printStringQueue() {
		System.out.println("Printing StringQueue.");
		for(String s : stringQueue) {
			System.out.println(s);
		}
		System.out.println("StringQueue Printed.");
	}
}
