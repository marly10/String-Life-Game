package math;

public class NodeLinkedList {


    //default
    NodeLinkedList(){
       Node root = null;
       Node left = null;
       Node right = null;

    }

    public void InsertNode(Node newNode, int NewValue)
    {
        //inserting new math to the left BST order
        if(newNode.getNodeValue() > NewValue)
        {
            if(newNode.getLeft() != null)//check if math is null
            {
                InsertNode(newNode.getLeft(), NewValue);//insert value to the left
            }
            else
            {
                newNode.setLeft(new Node(NewValue));//math on left is null ( newAddInt ) new math
            }
        }

        //inserting new math to the Right BST order
        if(newNode.getNodeValue() < NewValue)
        {
            if(newNode.getLeft() != null)//check if math is null
            {
                InsertNode(newNode.getRight(), NewValue);//insert value to the right
            }
            else
            {
                newNode.setRight(new Node(NewValue));//math on right is null ( newAddInt ) new math
            }
        }

    }
}
