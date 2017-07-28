package algorithm;

public class LinkedStringList {
	
	private StringNode head;
	private int size;
	
	private class StringNode {
		
		private String value;
		private StringNode next;
		private StringNode prev;
		
		public StringNode(String value) {
			this.value = value;
		}
		
		public String print() {
			return this.value;
		}
	}
	
	public LinkedStringList() {
		this.size = 0;
	}
	
	public void addToFirst(String value) {
		StringNode newNode = new StringNode(value);
		if(size == 0) {
			head = newNode;
		}
		newNode.next = head;
		head.prev = newNode;
		StringNode searchNode = head;
		for(int i=0; i<size-1; i++) {
			searchNode = searchNode.next;
		}
		searchNode.next = newNode;
		newNode.prev = searchNode;
		head = newNode;
		size++;
	}
	
	public void addTo(int index, String value) {
		if(index > size) {
			System.out.println("couldn't");
		}
		else {
			StringNode newNode = new StringNode(value);
			StringNode searchNode = head;
			if (index == 0) {
				addToFirst(value);
			}
			else {
				for(int i=0; i<index-1; i++) {
					searchNode = searchNode.next;
				}
				searchNode.next.prev = newNode;
				newNode.next = searchNode.next;
				newNode.prev = searchNode;
				searchNode.next = newNode;
				size++;
			}
		}
	}
	
	public String removeFirst() {
		StringNode removingNode = head;
		if (size > 0) {
			head.prev.next = head.next;
			head.next.prev = head.prev;
			head = removingNode.next;
		}
		else {
			head = null;
		}			
		size--;
		return removingNode.value;
	}
	
	public String removeFrom(int index) {
		if(index > size || index < 0) {
			return "nothing to remove";
		}
		else {
			if(index == 0 || size == 0) {
				return removeFirst();
			}
			else {
				StringNode searchNode = head;
				for(int i=0; i<index; i++) {
					searchNode = searchNode.next;
				}
				StringNode removingNode = searchNode;
				searchNode.prev.next = searchNode.next;
				searchNode.next.prev = searchNode.prev;
				size--;
				return removingNode.value;
			}
		}
	}
	
	public void print() {
		StringNode printNode = head;
		for(int i=0; i<size; i++) {
			System.out.println(printNode.value);
			printNode = printNode.next;
		}
	}
}
