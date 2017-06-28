class LinkedList {

    private class Node {

        Node prevNode;
        Node nextNode;
        int data_ID;
        String data_name;

        Node(int inInt, String inString) {
            data_ID = inInt;
            data_name = inString;
            prevNode = nextNode = null;
        }

    }

    private int numItems;
    private Node headNode;
    private Node tailNode;
    private Node currentNode;

    // Constructors

    LinkedList() {
        numItems = 0;
        headNode = null;
        tailNode = null;
        currentNode = null;
    }

    LinkedList(Node firstNode) {
        initFirstNode(firstNode);
    }

    private void initFirstNode(Node inNode) {
        numItems = 1;
        headNode = tailNode = currentNode = inNode;
    }

    // Traversal

    void front() {
        currentNode = headNode;
    }

    void back() {
        currentNode = tailNode;
    }

    void advance() {
        if (currentNode != tailNode) {
            currentNode = currentNode.nextNode;
        }
    }

    void retreat() {
        if (currentNode != headNode) {
            currentNode = currentNode.prevNode;
        }
    }

    // Getters

    int size() {
        return numItems;
    }

    Node head() {
        return headNode;
    }

    Node tail() {
        return tailNode;
    }

    Node current() {
        return currentNode;
    }

    // Operations

    void pushFront(int inID, String inName) {
        Node newNode = new Node(inID,inName);

        if (numItems == 0) {
            initFirstNode(newNode);
        }
        else if (numItems == 1) {
            newNode.nextNode = headNode;
            headNode.prevNode = newNode;
            tailNode = newNode.nextNode;
            headNode = newNode;
        }
        else {
            newNode.nextNode = headNode;
            headNode = newNode;
            numItems++;
        }

        currentNode = newNode;

    }

    void pushBack(int inID, String inName) {
        Node newNode = new Node(inID,inName);

        if (numItems == 0) {
            initFirstNode(newNode);
        }
        else if (numItems == 1) {
            tailNode = newNode;
            headNode.nextNode = tailNode;
            newNode.prevNode = headNode;
            numItems++;
        }
        else {
            newNode.prevNode = tailNode;
            tailNode.nextNode = newNode;
            tailNode = newNode;
            numItems++;
        }

        currentNode = newNode;

    }

    void add(int inID, String inName) {
        if (numItems == 0) {
            initFirstNode(new Node(inID, inName));
        }
        else if (currentNode == headNode) {
            pushFront(inID, inName);
        }
        else if (currentNode == tailNode) {
            pushBack(inID, inName);
        }
        else {
            Node newNode = new Node(inID, inName);
            newNode.prevNode = currentNode;
            newNode.nextNode = currentNode.nextNode;
            currentNode.nextNode = newNode;
            currentNode = newNode;
            numItems++;
        }
    }

    void popFront() {
        headNode = headNode.nextNode;
        headNode.prevNode = null;
    }

    void popBack() {
        tailNode = tailNode.prevNode;
        tailNode.nextNode = null;
    }

    void removeCurrent() {
        currentNode.prevNode.nextNode = currentNode.nextNode;
        currentNode.nextNode.prevNode = currentNode.prevNode;
        currentNode = currentNode.prevNode;
    }

    void clearList() {
        front();
        while (currentNode.nextNode != null) {
            advance();
            currentNode.prevNode = null;
            numItems--;
        }
    }

    // Console

    void printCurrent() {
        System.out.print("Current Node Name: " + currentNode.data_name + "\n");
        System.out.print("Current Node ID: " + currentNode.data_ID + "\n");
    }

    void printNode(Node argNode) {
        System.out.print("Name: " + argNode.data_name + "\n");
        System.out.print("ID: " + argNode.data_ID + "\n");
    }

    void printList() {
        for (Node iterator = headNode; iterator != tailNode.nextNode; iterator = iterator.nextNode) {
            printNode(iterator);
        }
    }

    // Bolleans

    boolean isEmptyList() {
        return numItems == 0;
    }

    boolean isEmptyNode() {
        return currentNode == null;
    }

    boolean isEmptyNode(Node argNode) {
        return argNode == null;
    }

    // Algorithms

    void reverseList() {
        Node frontIterator = headNode;
        Node backIterator = tailNode;
        int count = 0;
        Node temp;

        while (count < numItems / 2) {
            temp = frontIterator;
            frontIterator = backIterator;
            backIterator = temp;
            frontIterator = frontIterator.nextNode;
            backIterator = backIterator.prevNode;
            count++;
        }

    }

    // To-Do
    void sort() {

    }

    Node search(int searchID) {
       for (Node iterator = headNode; iterator != tailNode.nextNode; iterator = iterator.nextNode) {
           if (iterator.data_ID == searchID) {
               return iterator;
           }
       }
       return null;
    }

}

class main {
    public static void main(String[] args) {

        LinkedList userList = new LinkedList();

        userList.pushBack(848120769, "Kyle O'Brien");
        userList.pushBack(707221668, "Lydia O'Brien");
        userList.pushBack(292014289, "Virginia O'Brien");
        userList.pushFront(974284933, "Theodore O'Brien");

        userList.printList();

    }
}