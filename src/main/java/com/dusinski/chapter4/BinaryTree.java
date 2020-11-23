package com.dusinski.chapter4;

public class BinaryTree {
    Node root = null;

    public BinaryTree() {
    }

    private Node addRecursive(Node currentNode, int val) {

        if (currentNode == null) {
            return new Node(val);
        } else if (val < currentNode.value) {
            currentNode.leftNode = addRecursive(currentNode.leftNode, val);
        } else {
            currentNode.rightNode = addRecursive(currentNode.rightNode, val);
        }
        return currentNode;
    }

    public void addValue(int val) {
        Node newNode = new Node(val);
        if (this.root == null) {
            this.root = newNode;
//            System.out.println(newNode.value);
        } else {
            Node currentNode = this.root;
            Node previousNode = null;
            while (currentNode != null) {
                previousNode = currentNode;
                if (val < currentNode.value) {
                    currentNode = currentNode.leftNode;
                } else {
                    currentNode = currentNode.rightNode;
                }
            }
            if (val < previousNode.value) {
                previousNode.leftNode = newNode;
            } else {
                previousNode.rightNode = newNode;
            }
//                System.out.println(currentNode.value);
        }

    }

    private int findTreeHightRecursive(Node currentNode) {
        if (currentNode == null) {
            return 0;
        } else
            return 1 + Math.max(findTreeHightRecursive(currentNode.leftNode), findTreeHightRecursive(currentNode.rightNode));
    }

    public int findTreeHight() {
        return findTreeHightRecursive(this.root);
    }

    private String printLevelTraversal(Node currentNode, int level) {
        if (currentNode == null) {
            return "-";
        }
        if (level == 0) {
            return currentNode.value+"";
        } else {
            return
                    printLevelTraversal(currentNode.leftNode, level - 1) + "|" +
                            printLevelTraversal(currentNode.rightNode, level - 1);
        }
    }

    public void printAll() {
        int height=findTreeHight();
        for (int i = 0; i < height; i++) {

        System.out.println(" ".repeat((height-i))+printLevelTraversal(this.root, i));
        }
    }

}


