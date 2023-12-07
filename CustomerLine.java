package dataStructures;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

class Customer {
    int arrivalTime;
    int servedTime;

    public Customer(int arrivalTime) {
        this.arrivalTime = arrivalTime;
        this.servedTime = 0; // Initialize served time to 0
    }
}

public class CustomerLine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Initialize variables and queue
        int totalCustomersServed = 0;
        int totalWaitTime = 0;
        int maxWaitTime = 0;
        Queue<Customer> customerQueue = new LinkedList<>();

        // Step 2: Get user input for simulation length
        System.out.print("Enter the simulation length (in minutes): ");
        int simLength = scanner.nextInt();

        // Step 3: Simulate the flow of customers through the line
        for (int minute = 0; minute < simLength; minute++) {
            // If the queue is not empty, remove a customer at the front
            if (!customerQueue.isEmpty()) {
                Customer servedCustomer = customerQueue.poll();
                int waitTime = minute - servedCustomer.arrivalTime;
                totalWaitTime += waitTime;
                maxWaitTime = Math.max(maxWaitTime, waitTime);
                totalCustomersServed++;
            }

            // Compute a random number k between 0 and 3
            int k = new Random().nextInt(4);

            // If k is 1, add one customer to the line. If k is 2, add two customers. Otherwise, add none.
            if (k == 1) {
                customerQueue.add(new Customer(minute));
            } else if (k == 2) {
                customerQueue.add(new Customer(minute));
                customerQueue.add(new Customer(minute));
            }
        }

        // Step 4: Display the results
        System.out.println("\nSimulation Results:");
        System.out.println("Total customers served: " + totalCustomersServed);
        System.out.println("Combined length of time customers spent waiting: " + totalWaitTime + " minutes");
        System.out.println("Maximum length of time any customer spent waiting: " + maxWaitTime + " minutes");

        // Calculate and display average wait time
        double averageWaitTime = (double) totalWaitTime / totalCustomersServed;
        System.out.println("Average wait time: " + averageWaitTime + " minutes");

        scanner.close();
    }
}
