package LinkedList1;

public class LinkedList {
    private LinkedList linkedList;
    private static Node head;

    // Node class
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Constructor
    public LinkedList(int data) {
        Node newNode = new Node(data);
        head = newNode;
    }

    // Print the elements in linked list or Traverse the elements
    public void printElements(Node head) {
        Node temp = head;

        while(temp!=null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
        System.out.println();
    }

    // Insert a node 
    public void insertFirst(int data) {
        Node newNode = new Node(data);

        if(head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void insertLast(int data) {
        Node newNode = new Node(data);
        Node temp = head;

        if(head == null){
            head = newNode;
        } else {
            while(temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public void insertAtIndex(int data, int index) { // 2, 1
        Node newNode = new Node(data);
        Node temp = head;

        for(int i=0; i<index; i++) {
            temp = temp.next;
        }
        Node curr = temp.next;
        temp.next = newNode;
        newNode.next = curr;
    }


    // Delete a node
    public Node deleteFirst() {
        if(head == null) {
            return null;
        }
        Node temp = head;
        head = head.next;
        return temp;
    }

    public Node deleteAtIndex(int index) {
        if(head == null) {
            return null;
        }
        Node temp = head;
        for(int i=0; i<index; i++) {
            temp = temp.next;
        }
        Node element = temp;
        temp.next = temp.next.next;
        return element;
    }


    // Search for an element
    public void searchElement(int data) {
        Node temp = head;

        while(temp.next != null) {
            if(temp.data == data) {
                System.out.println("Found");
                break;
            }
            temp = temp.next;
        }
    }

    // Return the length of linked list

    public int length() {
        Node temp = head;
        int length = 0;
        while(temp != null) {
            length += 1;
            temp = temp.next;
        }
        return length;
    }


    // Reverse the linked list
    public Node reverseLinkedList() {
        Node prev = null;
        Node curr = head;
        Node next = null;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        return head;
    }

    // Deleting a cycle = Detect + remove
    public Node detectCycle() {
        Node slow = head;
        Node fast = head;
        // Detect cycle using Floyd's Tortoise and Hare algorithm
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            // If a cycle is detected, break the loop
            if(slow == fast) {
                removeCycle(head, slow);
                break;
            }
        }
        return head;
    }

    public void removeCycle(Node head, Node intersection) {
        Node ptr1 = head;
        Node ptr2 = intersection;

        while( ptr1.next != ptr2.next) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        ptr2.next = null;
    }


    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(1);

        linkedList.printElements(head);

        linkedList.insertFirst(0);
        linkedList.printElements(head);

        linkedList.insertLast(3);
        linkedList.printElements(head);

        linkedList.insertAtIndex(2,1);
        linkedList.printElements(head);

        linkedList.searchElement(2);

        // System.out.println(linkedList.length());

        Node rev = linkedList.reverseLinkedList();
        linkedList.printElements(rev);

        linkedList.deleteFirst();
        linkedList.printElements(head);

        linkedList.deleteAtIndex(0);
        linkedList.printElements(head);
    } 
}
