public class DoublyLinkedList {

    class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    Node head = null;
    Node tail = null;

    public void insertFront(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public void insertEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    public void delete(int key) {

        if (head == null) {
            return;
        }

        Node temp = head;

        while (temp != null && temp.data != key) {
            temp = temp.next;
        }

        if (temp == null) {
            return;
        }

        if (temp == head) {
            head = head.next;

            if (head != null) {
                head.prev = null;
            }
        } else if (temp == tail) {
            tail = tail.prev;

            if (tail != null) {
                tail.next = null;
            }
        } else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }
    }

    public void traverseForward() {

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    public void traverseBackward() {

        Node temp = tail;

        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.prev;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        DoublyLinkedList list = new DoublyLinkedList();

        list.insertFront(20);
        list.insertFront(10);

        list.insertEnd(30);
        list.insertEnd(40);

        System.out.println("Forward Traversal:");
        list.traverseForward();

        System.out.println("Backward Traversal:");
        list.traverseBackward();

        list.delete(30);

        System.out.println("After Deleting 30:");
        list.traverseForward();
    }
}