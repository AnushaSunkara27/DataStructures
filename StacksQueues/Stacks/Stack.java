package StacksQueues.Stacks;

public class Stack {
    private int height;
    private Node top;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public Stack(int value) {
        Node newNode = new Node(value);
        top = newNode;
        height = 1;
    }

    public void printAll() {
        Node temp = top;
        if(height == 0) {
            System.out.println("Top is "+ null);
        } else {
            System.out.println("\n");
            while(temp != null) {
                System.out.println(temp.value);
                temp = temp.next;
            }
        }
    }

    public void push(int value) {
        Node newNode = new Node(value);
        if(height == 0) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        height++;
    }

    public Node pop() {
        Node temp = top;
        if(height == 0) return null;
        top = top.next;
        temp.next = null;
        height--;
        return temp;
    }


    public static void main(String[] args) {
        Stack stack = new Stack(1);
        stack.printAll();
        stack.push(2);
        stack.printAll();
        stack.pop();
        stack.printAll();
    }
}
