package node;

public class NodeLinkedList {


    //default
    NodeLinkedList(){
       Node root = null;
       Node left = null;
       Node right = null;

    }

    public void InsertNode(Node newNode, int NewValue)
    {
        //inserting new node to the left BST order
        if(newNode.getNodeValue() > NewValue)
        {
            if(newNode.getLeft() != null)//check if node is null
            {
                InsertNode(newNode.getLeft(), NewValue);//insert value to the left
            }
            else
            {
                newNode.setLeft(new Node(NewValue));//node on left is null ( newAddInt ) new node
            }
        }

        //inserting new node to the Right BST order
        if(newNode.getNodeValue() < NewValue)
        {
            if(newNode.getLeft() != null)//check if node is null
            {
                InsertNode(newNode.getRight(), NewValue);//insert value to the right
            }
            else
            {
                newNode.setRight(new Node(NewValue));//node on right is null ( newAddInt ) new node
            }
        }

    }
}
