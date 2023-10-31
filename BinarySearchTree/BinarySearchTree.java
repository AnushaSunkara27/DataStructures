package BinarySearchTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    Node root;

    class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }


    public boolean insert(int value) {
        Node newNode = new Node(value);
        if(root == null) {
            root = newNode;
            return true;
        }

        Node temp = root;
        while(true) {
            if(temp.value == newNode.value) return false;

            if(value < temp.value) {
                if(temp.left == null) {
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;
            } else {
                if(temp.right == null) {
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            }
        }
    }

    public boolean contains(int value) {
        Node temp = root;
        while(temp != null) {
            if(temp.value == value) {
                return true;
            } else if(value < temp.value) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        return false;
    }

    public ArrayList<Integer> BFSMethod() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        Node currNode = root;
        queue.add(currNode);

        while(queue.size() > 0) {
            currNode = queue.remove();
            arrayList.add(currNode.value);

            if(currNode.left != null) {
                queue.add(currNode.left);
            }
            if(currNode.right != null) {
                queue.add(currNode.right);
            }
        }
        return arrayList;
    }

    public ArrayList<Integer> DFSPreOrder() {
        ArrayList<Integer> results = new ArrayList<>();

        class Traverse {
            Traverse(Node currNode) {
                results.add(currNode.value);
                if(currNode.left != null) {
                    new Traverse(currNode.left);
                }
                if(currNode.right != null) {
                    new Traverse(currNode.right);
                }
            }
        }

        new Traverse(root);
        return results;
    }

    public ArrayList<Integer> DFSPostOrder() {
        ArrayList<Integer> result = new ArrayList<>();

        class Traverse {
            Traverse(Node currNode) {
                if(currNode.left != null) {
                    new Traverse(currNode.left);
                }
                if(currNode.right != null) {
                    new Traverse(currNode.right);
                }
                result.add(currNode.value);
            }
        }
        new Traverse(root);
        return result;
    }

    public ArrayList<Integer> DFSInOrder() {
        ArrayList<Integer> arrayList = new ArrayList<>();

        class Traverse {
            Traverse(Node currNode) {
                if(currNode.left != null) {
                    new Traverse(currNode.left);
                }
                arrayList.add(currNode.value);
                if(currNode.right != null) {
                    new Traverse(currNode.right);
                }
            }
        }
        new Traverse(root);
        return arrayList;
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        System.out.println(bst.root);

        BinarySearchTree myBST = new BinarySearchTree();

        myBST.insert(2);
        myBST.insert(1);
        myBST.insert(3);
        myBST.insert(47);
        myBST.insert(21);
        myBST.insert(76);
        myBST.insert(18);
        myBST.insert(27);
        myBST.insert(52);
        myBST.insert(82);


        System.out.println("BST Contains 27:");
        System.out.println(myBST.contains(27));

        System.out.println("\nBST Contains 17:");
        System.out.println(myBST.contains(17));

        System.out.println(myBST.BFSMethod());
    }

}
