package algorithm;

import java.util.ArrayList;
import java.util.List;

public class StringStack {

	List<String> stringStack;
	
	public StringStack() {
		stringStack = new ArrayList<String>();
	}
	
	public void offerToStringStack(String input) {
		stringStack.add(input);
	}
	
	public String peekFromStringStack() {
		return stringStack.remove(stringStack.size()-1);
	}
	
	public void printStringStack() {
		System.out.println("Printing StringStack.");
		for(String s : stringStack) {
			System.out.println(s);
		}
		System.out.println("StringStack Printed.");
	}
	
}
