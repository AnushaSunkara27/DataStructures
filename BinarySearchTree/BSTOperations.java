package BinarySearchTree;

public class BSTOperations {
    Node root;
    
    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // public Node search(int data) {
    //     Node temp = root;
    //     Node result;
    //     if(temp == null) return null;

    //     if(temp.data == data) return temp;
        

    // }
}
