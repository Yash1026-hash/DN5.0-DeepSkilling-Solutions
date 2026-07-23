public class StackOperations {

    int[] stack;
    int top;
    int capacity;

    public StackOperations(int size) {
        stack = new int[size];
        capacity = size;
        top = -1;
    }

    public void push(int value) {
        if (top == capacity - 1) {
            System.out.println("Stack is full");
            return;
        }
        stack[++top] = value;
    }

    public int pop() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return -1;
        }
        return stack[top--];
    }

    public int peek() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return -1;
        }
        return stack[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void display() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.print("Stack: ");
        for (int i = top; i >= 0; i--) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        StackOperations s = new StackOperations(5);

        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);

        s.display();

        System.out.println("Peek: " + s.peek());

        System.out.println("Popped: " + s.pop());
        System.out.println("Popped: " + s.pop());

        s.display();

        System.out.println("Is Empty: " + s.isEmpty());
    }
}
