package com.dusinski.chapter2;

import java.util.HashMap;
import java.util.Hashtable;

class Node {
    Node next = null;
    int data;

    Node(int d) {
        this.data = d;
    }
}

public class LinkedList {
    private Node head;

    public void appendToTail(int d) {
        Node end = new Node(d);

        if (this.head == null) {
            this.head = end;
        } else {
            Node n = this.head;
            while (n.next != null) {
                n = n.next;
            }
            n.next = end;
        }
    }

    public void deleteNode(int d) {
        if (head.data == d) {
            head = head.next;
        } else {
            Node n = head;
            while (n.next != null) {
                if (n.next.data == d) {
                    if (n.next.next != null) {
                        n.next = n.next.next;
                    } else {
                        n.next = null;
                    }
                } else {
                    n = n.next;
                }
            }
        }
    }

    public String printList() {
        StringBuilder print = new StringBuilder();
        print.append(this.head.data + " ");

        if (this.head.next != null) {
            Node tempNode = this.head.next;
            print.append(tempNode.data + " ");
            while (tempNode.next != null) {
                tempNode = tempNode.next;
                print.append(tempNode.data + " ");
            }
        }
        return print.toString();
    }

    public void removeDuplicates() {
        HashMap<Integer, Boolean> duplicateMap = new HashMap<>();
        Node tempNode = this.head;

        duplicateMap.put(tempNode.data, true);

        while (tempNode.next != null) {
            if (duplicateMap.containsKey(tempNode.next.data)) {
                if (tempNode.next.next == null) {
                    tempNode.next = null;
                } else {
                    duplicateMap.put(tempNode.next.next.data, true);
                    tempNode.next = tempNode.next.next;
                    tempNode = tempNode.next;
                }
            } else {
                duplicateMap.put(tempNode.next.data, true);
                tempNode = tempNode.next;
            }

        }

    }


}
