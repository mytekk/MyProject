package pl.sdacademy.tree;

public class Node {

    Node parent;
    Node left;
    Node right;
    int value;

    public Node(int data) {
	setValue(data);
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

    public int getValue() {
	return value;
    }

    public void setValue(int value) {
	this.value = value;
    }

}