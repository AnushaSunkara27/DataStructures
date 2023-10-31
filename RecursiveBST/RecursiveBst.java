package RecursiveBST;

public class RecursiveBst {
    Node root;
    
    class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }

    private boolean rContains(Node currentNode, int value) {
        if(currentNode == null) return false;

        if(currentNode.value == value) return true;

        if(value < currentNode.value) {
            return rContains(currentNode.left, value);
        } else {
            return rContains(currentNode.right, value);
        }
    }

    public boolean rContains(int value) {
        return rContains(root, value);
    }


}
