package Stack_Queue;

public class StackusingArray {
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(6);
        s.push(3);
        s.push(7);
        System.out.println("Top of the stack before deleting any element " + s.top());
        System.out.println("Size of the stack before deleting any element " + s.size());
        System.out.println("The element deleted is " + s.pop());
        System.out.println("Size of the stack after deleting an element " + s.size());
        System.out.println("Top of the stack after deleting an element " + s.top());
    }
}

class Stack {
    int size = 1000;
    int arr[] = new int[size];
    int top = -1;

    void push(int element) {
        arr[++top] = element;
    }

    int pop() {
        return arr[top--];
    }

    int top() {
        return arr[top];
    }

    int size() {
        return top + 1;
    }

}
