package pl.sdacademy.tree;

public class BinaryTree extends Tree {

    public BinaryTree() {
	// TODO Auto-generated constructor stub
    }

    public void add(int value) {
	root = add(root, value);
	System.out.println("");
	print();
    }

    private Node add(Node node, int value) {
	if (node == null) {
	    // zainicjowalismy roota
	    node = new Node(value);
	} else {
	    int nodeValue = node.getValue();
	    if (value < nodeValue) {
		node.setLeft(add(node.getLeft(), value));
	    } else {
		node.setRight(add(node.getRight(), value));
	    }
	}
	// zwrocilismy roota
	return node;
    }

}