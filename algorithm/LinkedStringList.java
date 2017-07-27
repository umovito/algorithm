package algorithm;

public class LinkedStringList {
	
	private StringNode head;
	private StringNode tail;
	private int size;
	
	private class StringNode {
		
		private String value;
		private StringNode next;
		
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
		newNode.next = head;
		head = newNode;
		if(size == 0) {
			tail = head;
		}
		size++;
	}
	
	public void addToLast(String value) {
		StringNode newNode = new StringNode(value);
		if (tail != null) {
			tail.next = newNode;
		}
		tail = newNode;
		if(size == 0) {
			head = tail;
		}
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
			else if (index == size) {
				addToLast(value);
			}
			else {
				for(int i=0; i<index-1; i++) {
					searchNode = searchNode.next;
				}
				newNode.next = searchNode.next;
				searchNode.next = newNode;
				size++;
			}
		}
	}
	
	public String removeFirst() {
		String ret = head.value;
		if (head.next != null) {
			head = head.next;
		}
		else {
			head = null;
			tail = null;
		}
		size--;
		return ret;
	}
	
	public String removeLast() {
		String ret = tail.value;
		StringNode searchNode = head;
		if(searchNode.next == null) {
			tail = null;
			head = null;
		}
		else {
			while(searchNode.next != tail) {
				searchNode = searchNode.next;
			}
			searchNode.next = null;
			tail = searchNode;
		}
		size--;
		return ret;
	}
	
	public String removeFrom(int index) {
		if(index > size) {
			return "nothing to remove";
		}
		else {
			if(index == 0) {
				return removeFirst();
			}
			else if(index == size-1) {
				return removeLast();
			}
			else {
				StringNode searchNode = head;
				for(int i=0; i<index-1; i++) {
					searchNode = searchNode.next;
				}
				StringNode removingNode = searchNode.next;
				String ret = removingNode.value;
				if (removingNode.next != null) {
					searchNode.next = removingNode.next;
				}
				else {
					searchNode.next = null;
				}
				removingNode = null;
				size--;
				return ret;
			}
		}
	}
	
	public void print() {
		StringNode printNode = head;
		while(printNode != null) {
			System.out.println(printNode.print());
			printNode = printNode.next;
		}
	}
}
