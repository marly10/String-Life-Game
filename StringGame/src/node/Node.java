package node;

public class Node {

    //member variables
    private int nodeValue;
    private Node right, left;

    //default constructor
    public Node()
    {
        setValue(0);
        right = null;
        left = null;
    }

    public Node(int number)
    {
        nodeValue = number;
        right = null;
        left = null;
    }

    //getters for Nodes & values
    public int getNodeValue() {
        return this.nodeValue;
    }

    public Node getRight() {
        return this.right;
    }

    public Node getLeft() {
        return this.left;
    }

    //setter for Nodes & values
    public void setValue(int value) {
        this.nodeValue = value;
    }

    public void setRight(Node newRight) {
        this.right = newRight;
    }

    public void setLeft(Node newLeft) {
        this.left = newLeft;
    }

}
