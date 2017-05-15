package pl.sdacademy.tree;

public class Node {

	String value;
	Node parent;
	Node left;
	Node right;

	// konstruktor
	public Node(String data) { // tworzac nowego noda, podajemy jedynie value,
								// reszta wypelnia sie sama
		setValue(data);
	}

	// konstruktor dwuargumentowy
	public Node(String data, Node node) { // tworzac nowego noda, podajemy
											// jedynie value, reszta wypelnia
											// sie sama
		setValue(data);
		setParent(node);
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

}
