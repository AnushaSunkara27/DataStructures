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

    // searching for an element in binary search tree
    public Node search(int data) {
        Node temp = root;
        if(temp == null) return null;

        while(temp != null && temp.data != data) {
            if(data < temp.data) {
                temp = temp.left;
            } else if(data > temp.data) {
                temp = temp.right;
            }
        }
        return temp;
    }

    // inserting an element in BST
    public Node insert(int data) {
        Node temp = root;
        Node newNode = new Node(data);

        // edge case
        if(root == null) {
            root = newNode;
        }

        while(temp != null) {
            if(data < temp.data) {
                if(temp.left == null) {
                    temp.left = newNode;
                    return root;
                } else {
                    temp = temp.left;
                }
            } else if(data > temp.data) {
                if(temp.right == null) {
                    temp.right = newNode;
                    return root;
                } else {
                    temp = temp.right;
                }
            }
        }
        return root;
    }


    // Preorder Traversal - root -> left child -> right child
    private void preOrder(Node root) {
        if(root != null) {
            System.out.println(root.data+ " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    // InOrder Traversal - left child -> root -> right child
    private void inOrder(Node root) {
        if(root != null) {
            inOrder(root.left);
            System.out.println(root.data);
            inOrder(root.right);
        }
    }

    // PostOrder Traversal - left child -> right child -> root
    private void postOrder(Node root) {
        if(root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.data);
        }
    }
}
