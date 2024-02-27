package Stack1;

public class StackArray {
    private int[] stack;
    public static int top;

    // constructor
    public StackArray() {
        top = -1;
        stack = new int[10];
    }

    // length of stack
    public int length() {
        return stack.length;
    }

    // print the elements in the stack
    public void printElements() {
        int temp = top;
        while(temp>=0) {
            System.out.println(stack[temp]+ " ");
            temp--;
        }
        System.out.println("");
    }

    // peek
    public int peek() {
        return stack[top];
    }

    // push method
    public void push(int val) {
        if(top == -1) {
            stack[0] = val;
            top++;
        } else {
            stack[top+1] = val;
            top++;
        }
    }

    // pop method
    public int pop() {
        if(stack.length == 0) {
            return 0;
        }

        int topValue = stack[stack.length-1];
        top--;
        return topValue;
    }

    public static void main(String[] args) {
        StackArray obj = new StackArray();

        obj.push(1);
        obj.push(2);
        obj.push(3);

        obj.printElements();

        obj.pop();

        obj.printElements();

    
    }

}
