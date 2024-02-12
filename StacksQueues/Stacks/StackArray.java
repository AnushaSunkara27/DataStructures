package StacksQueues.Stacks;

public class StackArray {
    private int capacity;
    private int top;
    private int[] arr;

    
    StackArray(int size) {
        arr = new int[size];
        capacity = size;
        top = -1;
    }

    // push - insert element in array
    void push(int value) {
        if(isFull()) {
            System.out.println("stack is full can't push");
        }
        top = top+1;
        arr[top] = value;
    }

    // pop - remove top element from array
    int pop() {
        if(isEmpty()) {
            System.out.println("stack is empty");
            return -1;
        }
        int result = arr[top];
        top = top-1;
        return result;
    }

    // peek - Retrieve last element 
    int peek() {
        if(isEmpty()) {
            System.out.println("stack is empty");
            return -1;
        }
        return arr[top];
    }

    // isEmpty - checks if the stack is empty
    boolean isEmpty() {
        return top==-1;
    }

    // checks if the stack is full
    boolean isFull() {
        return top == capacity-1;
    }

    void printArray() {
        for (int i = 0; i <= top; i++) {
            System.out.println(arr[i]);
          }
    }

    public static void main(String[] args) {
        StackArray obj = new StackArray(5);

        System.out.println("Initial array");
        obj.printArray();
        obj.push(0);
        obj.push(1);
        obj.push(2);
        obj.push(3);
        obj.push(4);

        System.out.println("Array after adding elements");
        obj.printArray();

        obj.pop();

        System.out.println("Array after pop");
        obj.printArray();
        obj.peek();

        System.out.println("Array after peek");
        obj.printArray();
    }
}
