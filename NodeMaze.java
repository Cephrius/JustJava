package dataStructures;

import java.util.Scanner;

class Node {
    char room;
    Node north, south, east, west;

    public Node(char room) {
        this.room = room;
        this.north = null;
        this.south = null;
        this.east = null;
        this.west = null;
    }

    public void printRoomInfo() {
        System.out.println("You are in room " + room + " of a maze of twisty little passages, all alike.");

        // Print possible moves
        System.out.print("You can go ");
        if (north != null) System.out.print("north ");
        if (south != null) System.out.print("south ");
        if (east != null) System.out.print("east ");
        if (west != null) System.out.print("west ");
        System.out.println();
    }
}

public class NodeMaze {
    public static void main(String[] args) {
        // Create nodes for each room in the maze
        Node A = new Node('A');
        Node B = new Node('B');
        Node C = new Node('C');
        Node D = new Node('D');
        Node E = new Node('E');
        Node F = new Node('F');
        Node G = new Node('G');
        Node H = new Node('H');
        Node I = new Node('I');
        Node J = new Node('J');
        Node K = new Node('K');
        Node L = new Node('L');

        // Connect nodes to represent the maze structure
        A.south = E;
        A.west = B;


        B.west = A;
        B.south = F;

        C.east = D;
        C.south = G;

        D.west = C;

        E.north = A;
        E.south = I;

        F.north = B;
        F.east = G;

        G.north = C;
        G.east = H;
        G.west = F;
        G.south = K;

        H.west = G;
        H.south = L;

        I.east = J;

        J.west = I;

        K.north = G;

        L.north = H;

        // Start the user in room A
        Node currentRoom = A;

        // Execute the sample execution as described
        Scanner scanner = new Scanner(System.in);
        while (currentRoom != L) {
            currentRoom.printRoomInfo();
            System.out.print("Enter your move (N/S/E/W): ");
            char move = scanner.next().charAt(0);

            // Update current room based on user's move
            switch (move) {
                case 'N':
                    currentRoom = currentRoom.north;
                    break;
                case 'S':
                    currentRoom = currentRoom.south;
                    break;
                case 'E':
                    currentRoom = currentRoom.east;
                    break;
                case 'W':
                    currentRoom = currentRoom.west;
                    break;
                default:
                    System.out.println("Invalid move. Please enter N, S, E, or W.");
                    break;
            }
        }

        // User reached the finish in room L
        System.out.println("Congratulations! You reached the finish in room L.");
        scanner.close();
    }
}



