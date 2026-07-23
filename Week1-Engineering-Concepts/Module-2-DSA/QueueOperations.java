public class QueueOperations {

    int[] queue;
    int front;
    int rear;
    int capacity;

    public QueueOperations(int size) {
        queue = new int[size];
        capacity = size;
        front = 0;
        rear = -1;
    }

    public void enqueue(int value) {
        if (rear == capacity - 1) {
            System.out.println("Queue is full");
            return;
        }
        queue[++rear] = value;
    }

    public int dequeue() {
        if (front > rear) {
            System.out.println("Queue is empty");
            return -1;
        }
        return queue[front++];
    }

    public int peek() {
        if (front > rear) {
            System.out.println("Queue is empty");
            return -1;
        }
        return queue[front];
    }

    public boolean isEmpty() {
        return front > rear;
    }

    public void display() {
        if (front > rear) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.print("Queue: ");
        for (int i = front; i <= rear; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        QueueOperations q = new QueueOperations(5);

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);

        q.display();

        System.out.println("Peek: " + q.peek());

        System.out.println("Dequeued: " + q.dequeue());
        System.out.println("Dequeued: " + q.dequeue());

        q.display();

        System.out.println("Is Empty: " + q.isEmpty());
    }
}
