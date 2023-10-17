package DoublyLinkedList;

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;
        Node prev;
        public Node(int value) {
            this.value = value;
        }
    }

    public DoublyLinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = length+1;
    }

    public void printList() {
        Node temp = head;
        while(temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void append(int value) {
        Node newNode = new Node(value);

        if(length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        } 
        length++;
    }

    public Node removeLast() {
        if(length == 0) return null;
        Node temp = tail;
        tail = tail.prev;
        temp.prev = null;
        tail.next = null;
        length--;
        if(length == 0) {
            head = null;
            tail = null;
        }
        return temp;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        if(length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public Node removeFirst() {
        Node temp = head;
        if(length == 0) return null;
        if(length == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
            temp.next = null;
        }
        length--;
        return temp;
    }

    public Node get(int index) {
        if(index < 0 || index >= length) return null;
        Node temp = head;
        if(index < length/2) {
            for(int i=0; i< index; i++) {
                temp = temp.next;
            }
        } else {
            temp = tail;
            for(int i=length-1; i> index; i--) {
                temp = temp.prev;
            }
        }
        return temp;
    }

    public boolean set(int index, int value) {
        Node temp = get(index);
        if(temp != null) {
            temp.value = value;
            return true;
        }
        return false;
    }

    public boolean insert(int index, int value) {
        Node newNode = new Node(value);
        if(index < 0 || index > length) return false;
        if(index == 0) {
            prepend(value);
            return true;
        }
        if (index == length) {
            append(value);
            return true;
        }
        Node before = get(index-1);
        Node after = before.next;
        newNode.prev = before;
        newNode.next = after;
        before.next = newNode;
        after.prev = newNode;
        length++;
        return true;
    }
    
    public Node remove(int index) {
        if(index < 0 || index >= length) return null;
        if(index == 0) {
            return removeFirst();
        }
        if(index == length) {
            return removeLast();
        }
        Node temp = get(index);
        Node before = temp.prev;
        Node after = temp.next;
        before.next = after;
        after.prev = before;
        temp.prev = null;
        temp.next = null;
        length--;
        return temp;
    }

    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList(1);

        doublyLinkedList.printList();
        doublyLinkedList.append(2);
        doublyLinkedList.printList();
        doublyLinkedList.prepend(0);
        doublyLinkedList.removeFirst();
    }
}
