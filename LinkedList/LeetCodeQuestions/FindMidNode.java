package LinkedList.LeetCodeQuestions;

public class FindMidNode {
    private static Node head;
    private Node tail;
    private static int length;
    
    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public FindMidNode(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if(length == 0)
        {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++; 
    }

    public static Node findMiddleNode() {
        Node temp = head;
        if(length == 0) return null;
        int midNodeIndex = length/2;

        int count = 0;
        while(count < midNodeIndex) {
            temp = temp.next;
            count = count+1;
        }
        return temp;
    }

    // Floyd's tortoise or Hare algorithm
    public static Node findMiddle() {
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next !=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        FindMidNode myLinkedList = new FindMidNode(1);

        myLinkedList.append(2);
        myLinkedList.append(3);
        myLinkedList.append(4);
        myLinkedList.append(5);

        System.out.println("1 -> 2 -> 3 -> 4 -> 5");
        System.out.println("Middle Node: "+ findMiddleNode().value);
        System.out.println("Middle Node: "+ findMiddle().value);

        myLinkedList.append(6);
        
        
        System.out.println("===========================");
        System.out.println("1 -> 2 -> 3 -> 4 -> 5 -> 6");
        System.out.println( "Middle Node: "+ findMiddleNode().value);
        System.out.println("Middle Node: "+ findMiddle().value);

    }

}
