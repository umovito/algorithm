package algorithm;

public class BinaryTree {

	public Node root;
	
	private class Node {
		private Node parent;
		private Node lower;
		private Node higher;
		private int value;
		
		public Node(Node parent, int value) {
			this.parent = parent;
			this.value = value;
		}
	}
	
	public BinaryTree(int rootValue) {
		root = new Node(null, rootValue);
	}
	
	public void add(int value) {
		Node searchNode = find(value, root);
		if (searchNode.value > value) {
			searchNode.lower = new Node(searchNode, value);
		}
		else if (searchNode.value < value) {
			searchNode.higher = new Node(searchNode, value);
		}
		else {
			System.out.println(value + " already exists");
		}
	}
	
	public void remove(int value) {
		Node searchNode = root;
		boolean fin = false;
		while(!fin) {
			if (searchNode.value == value) {
				if (searchNode.lower != null && searchNode.higher != null){
					searchNode.value = findMin(searchNode.higher);
					searchNode = searchNode.higher;
				}
				else if (searchNode.parent.lower == searchNode) {
					searchNode.parent.lower = searchNode.lower != null ? searchNode.lower : searchNode.higher;
					fin = true;
				}
				else if (searchNode.parent.higher == searchNode) {
					searchNode.parent.higher = searchNode.lower != null ? searchNode.lower : searchNode.higher;
					fin = true;
				}
			}
			else if(searchNode.value > value) {
				searchNode = searchNode.lower;
			}
			else {
				searchNode = searchNode.higher;
			}
		}
	}
	
	public Node find(int value, Node from) {
		boolean fin = false;
		Node searchNode = root;
		while(!fin) {
			if (searchNode.value == value) {
				fin = true;
			}
			else if (searchNode.value > value) {
				if(searchNode.lower != null) {
					searchNode = searchNode.lower;
				}
				else {
					fin = true;
				}
			}
			else{
				if(searchNode.higher != null) {
					searchNode = searchNode.higher;
				}
				else {
					fin = true;
				}
			}
		}
		return searchNode;
	}
	
	public int findMin(Node n) {
		while(n.lower != null) {
			n = n.lower;
		}
		return n.value;
	}
	
	public void print(Node n) {
		if (n == null) {
			return;
		}
		print(n.lower);
		System.out.print(n.value + " ");
		print(n.higher);
	}
}
