package com.company;

class BinarySearchTree {

    private class Node {
        int ID;
        String name;
        Node leftChild;
        Node rightChild;

        Node(int inID, String inName) {
            ID = inID;
            name = inName;
            leftChild = null;
            rightChild = null;
        }

    }

    private int size;
    private Node root;

    BinarySearchTree() {
        size = 0;
        root = null;
    }

    BinarySearchTree(int inID, String inName) {
        size = 1;
        root = new Node(inID, inName);
    }

    void add(int inID, String inName) {
        Node newNode = new Node(inID, inName);
        add(newNode, root);
    }

    private void add(Node newNode, Node parent) {
        if (parent == null) {
            parent = newNode;
            size++;
        }
        else if (newNode.ID < parent.ID) {
            add(newNode, parent.leftChild);
        }
        else {
            add(newNode, parent.rightChild);
        }
    }

    Node search(int userID) {
        return search(userID, root);
    }

    private Node search(int userID, Node parent) {
        if (userID == parent.ID) {
            return parent;
        }
        else if (userID < parent.ID) {
            return search(userID, parent.leftChild);
        }
        else if (userID > parent.ID) {
            return search(userID, parent.rightChild);
        }
        else {
            return null;
        }
    }
}

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}
