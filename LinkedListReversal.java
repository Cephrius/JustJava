package dataStructures;

import org.w3c.dom.Node;

    class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
    }


public class LinkedListReversal {
    public static Node reverseLinkedList(Node head) {
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
        return head;
    }

    public static void printLinkedList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create a linked list: 1 -> 2 -> 3 -> 4 -> 5
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.print("Original Linked List: ");
        printLinkedList(head);

        // Reverse the linked list
        head = reverseLinkedList(head);

        System.out.print("Reversed Linked List: ");
        printLinkedList(head);
    }
}


