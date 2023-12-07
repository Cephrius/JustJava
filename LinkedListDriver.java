package dataStructures;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    public void reverse() {
        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.next;   // Save the next node
            current.next = prev;   // Reverse the pointer
            prev = current;        // Move one step forward
            current = next;        // Move one step forward
        }

        head = prev;   // Update the head to point to the last node
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

public class LinkedListDriver {
    public static void main(String[] args) {
        // Create a linked list: 1 -> 2 -> 3 -> 4 -> 5
        LinkedList linkedList = new LinkedList();
        linkedList.head = new Node(1);
        linkedList.head.next = new Node(2);
        linkedList.head.next.next = new Node(3);
        linkedList.head.next.next.next = new Node(4);
        linkedList.head.next.next.next.next = new Node(5);

        // Print the original list
        System.out.println("Original Linked List:");
        linkedList.printList();

        // Reverse the linked list
        linkedList.reverse();

        // Print the reversed list
        System.out.println("\nReversed Linked List:");
        linkedList.printList();
    }
}
