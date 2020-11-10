package com.dusinski.chapter2;

import java.io.IOException;
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
    //    to check if list is Circular
    private final int MAX_STEPS = 10000;
    private Node head;

    public static String printList(Node tempNode) {
        StringBuilder print = new StringBuilder();

//        Node tempNode = node;
        while (tempNode != null) {
            print.append(tempNode.data + " ");
            tempNode = tempNode.next;
        }


        return print.toString();
    }

    //    there are given two linked lists. Each represent a number. Its digits are in reversed order:
//    227 = 7->2->2
//  + 54  = 4->5
//    The function return the result. Its digits are in reverse order 281 = 1->8->2
    public static String addTwoLinkedListNumbers(LinkedList listA, LinkedList listB) {
        Node currentNodeA = listA.head;
        Node currentNodeB = listB.head;
        Node result = null;
        int decadePart = 0;

        while (currentNodeA != null) {
            int partA = currentNodeA.data;
            int partB = 0;
            if (currentNodeB != null) {
                partB = currentNodeB.data;
            }
            int sum = partA + partB + decadePart;
            Node digit = new Node();

            if (sum < 10) {
                digit.data = sum;
                decadePart = 0;
            } else {
                digit.data = sum % 10;
                decadePart = sum / 10;
            }
            if (result == null) {
                result = digit;
            } else {

                digit.next = result;
                result = digit;
            }
            currentNodeA = currentNodeA.next;
            if (currentNodeB != null) {
                currentNodeB = currentNodeB.next;
            }
        }
        while (currentNodeB != null) {
            int partB = currentNodeB.data;
            int sum = partB + decadePart;
            Node digit = new Node();
            if (sum < 10) {
                digit.data = sum;
                decadePart = 0;
            } else {
                digit.data = sum % 10;
                decadePart = sum / 10;
            }
            digit.next = result;
            result = digit;
            currentNodeB = currentNodeB.next;
        }
        if (decadePart > 0) {
            Node digit = new Node(decadePart);
            digit.next = result;
            result = digit;
        }
        return printList(result);
    }

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

    public void roundLinkedList(int elementToPointFromStart) {
        Node tempNode = this.head;
        while (tempNode != null && elementToPointFromStart > 0) {
            tempNode = tempNode.next;
            elementToPointFromStart--;
        }
        Node middleNode = tempNode;
        while (tempNode.next != null) {
            tempNode = tempNode.next;
        }
        tempNode.next = middleNode;
    }


    public boolean isLinkedListCircular() {
        Node slowNode = this.head;
        Node fastNode = this.head;
        int iterator = this.MAX_STEPS;

        while (fastNode != null && fastNode.next != null && iterator > 0) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
            iterator--;
        }
        return iterator == 0;
    }

    //    returns the node of a Circular LinkedList which is on the beginning of the Loop
//    provied LinkedList should be circular
    public int returnLoopBeginningNode() {
        Node slowNode = this.head;
        Node fastNode = slowNode.next;

        while (slowNode != fastNode) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        slowNode = this.head;
        fastNode = fastNode.next;
        while (slowNode != fastNode) {
            slowNode = slowNode.next;
            fastNode = fastNode.next;
        }
        return slowNode.data;
    }

    public boolean isPalindrome() {
        int listLenght = 0;
        Node reverseList = new Node(this.head.data);
        Node tempList = this.head;

        while (tempList != null) {
            Node temp =new Node(tempList.data);
            temp.next=reverseList;
            reverseList = temp;
            tempList = tempList.next;
            listLenght++;
        }

        tempList = this.head;
        while (listLenght > 1) {
            if (tempList.data == reverseList.data) {
                tempList = tempList.next;
                reverseList = reverseList.next;
                listLenght--;
            } else {
                return false;
            }
        }
        return true;
    }

}



