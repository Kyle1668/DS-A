package com.company;

class Queue {

    class Node {
        int userID;
        String userName;
        Node previousNode;

        Node(int id, String name) {
            userID = id;
            userName = name;
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
            rear.previousNode = new Node(inID, inName);
            length++;
        }
    }

    void dequeue() {
        if (length != 0) {
            front = front.previousNode;
            length--;
        }
    }

    Node peek() {
        return front;
    }

    boolean isEmpty() {
        return length == 0;
    }
    
}

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}
