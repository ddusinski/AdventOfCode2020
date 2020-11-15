package com.dusinski.chapter3;

class Node {
    Node next = null;
    int data;

    int minValue=0;

    Node(int d) {
        this.data = d;
    }

    Node() {
    }


    public static String printList(Node n) {
        StringBuilder print = new StringBuilder();
        if (n == null) {
            return "null";
        } else {
            Node tempNode = n;
            while (tempNode != null) {
                print.append(tempNode.data + " ");
                tempNode = tempNode.next;
            }
        }
        return print.toString();
    }
}