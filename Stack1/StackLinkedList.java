package Stack1;

public class StackLinkedList {
    public Node top = null;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public StackLinkedList(int data) {
        Node newNode = new Node(data);
        top = newNode;
    }

    // print
    public void printStack() {
        Node temp = top;

        while(temp.next != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
        System.out.println("");
    }

    // push
    public void push(int data) {
        Node newNode = new Node(data);

        if(top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
    }

    //pop
    public Node pop() {
        Node element = top;
        top = top.next;
        return element;
    }

    public static void main(String[] args) {
        StackLinkedList  stack = new StackLinkedList(0);

        stack.push(1);
        stack.push(2);
        stack.push(3);

        stack.printStack();
        
    }



}
