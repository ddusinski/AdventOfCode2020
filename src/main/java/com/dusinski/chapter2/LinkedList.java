package com.dusinski.chapter2;

import java.util.HashMap;
import java.util.Hashtable;

class Node {
    Node next = null;
    int data;

    Node(int d) {
        this.data = d;
    }

    Node() {
    }
}

class IntWrapper {
    public int value = 0;
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


        if (this.head == null) {
            return "null";
        }
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


    public String printList(Node tempNode) {
        StringBuilder print = new StringBuilder();

//        Node tempNode = node;
        while (tempNode != null) {
            print.append(tempNode.data + " ");
            tempNode = tempNode.next;
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


    public int findKfromStart(int k) {
        Node tempNode = this.head;
        while (k > 0) {
            if (tempNode.next != null) {
                tempNode = tempNode.next;
            }
            k--;
        }
        return tempNode.data;
    }

    private int recFindFromEnd(int k, Node tempNode) {
        if (tempNode == null) {
            return 0;
        }
        int previous = recFindFromEnd(k, tempNode.next) + 1;
        if (previous == k) {
            System.out.println(tempNode.data);
        }
        return previous;

    }

    public int findKValuefromEnd(int k) {
        return recFindFromEnd(k, this.head);
    }

    public Node recKnodeFromEnd(int k, Node tempNode, IntWrapper i) {
        if (tempNode == null) {
            return null;
        }
        Node nextNode = recKnodeFromEnd(k, tempNode.next, i);
        i.value = i.value + 1;

        if (i.value == k) {
            return tempNode;
        }
        return nextNode;
    }

    public int findKnodeFromEnd(int k) {
        return recKnodeFromEnd(k, this.head, new IntWrapper()).data;
    }

    public String partitionLinkedList(int edgeValue) {
        Node smallStart = null;
        Node smallEnd = null;
        Node bigStart = null;
        Node bigEnd = null;

        Node tempNode = this.head;
        while (tempNode != null) {
            Node next = tempNode.next;
            tempNode.next = null;

            if (tempNode.data < edgeValue) {
                if (smallStart == null) {
                    smallStart = tempNode;
                    smallEnd = smallStart;
                } else {
                    smallEnd.next = tempNode;
                    smallEnd = tempNode;
                }
            } else {
                if (bigStart == null) {
                    bigStart = tempNode;
                    bigEnd = bigStart;
                } else {
                    bigEnd.next = tempNode;
                    bigEnd = tempNode;
                }
            }
            tempNode = next;
        }
        return (printList(smallStart) + "|" + printList(bigStart));
    }


}
