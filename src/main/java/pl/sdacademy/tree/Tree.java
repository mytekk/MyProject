package pl.sdacademy.tree;

public class Tree {

	Node root;
	List<Node> nodes = new ArrayList();

	public Tree() {
		// TODO Auto-generated constructor stub
	}

	public void insert(String value) {
		root = insert(root, value);
	}

	Node insert(Node node, int value
}
