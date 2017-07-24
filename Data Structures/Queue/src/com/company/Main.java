package com.company;

class Queue {

    class Node {
        
        int userID;
        String userName;
        Node nextNode;

        Node(int id, String name) {
            userID = id;
            userName = name;
        }

        void print() {
            System.out.print("\n" + "ID: " + userID + "\n");
            System.out.print("Name: " + userName  + "\n");
        }

    }

    private int length;
    private Node front;
    private Node rear;

    Queue() {
        front = null;
        rear = null;
        length = 0;
    }

    Queue(int inID, String inName) {
        initFirstNode(inID, inName);
    }

    private void initFirstNode(int inID, String inName) {
        front = rear = new Node(inID, inName);
        length = 1;
    }

    void enqueue(int inID, String inName) {
        if (length == 0) {
            initFirstNode(inID, inName);
        }
        else {
            rear.nextNode = new Node(inID, inName);
            rear = rear.nextNode;
            length++;
        }
    }

    void dequeue() {
        if (length != 0) {
            front = front.nextNode;
            length--;
        }
    }

    void clear() {
        clear(front);
    }

    private void clear(Node current) {
        if (current != null) {
            current = current.nextNode;
            length--;
            clear(current);
        }
    }

    Node peek() {
        return front;
    }

    boolean isEmpty() {
        return length == 0;
    }

    void print() {
        print(front);
    }

    private void print(Node current) {
        if (current != null) {
            current.print();
            print(current.nextNode);
        }
    }

}

public class Main {

    public static void main(String[] args) {

        Queue users = new Queue();

        users.enqueue(848120769, "Kyle");
        users.enqueue(707832172, "Lydia");
        users.enqueue(707292014, "Peter");
        users.enqueue(124986311, "Donna");
        users.enqueue(937491068, "Emmy");

        users.print();

        users.dequeue();
        users.dequeue();

        users.print();

    }
}
