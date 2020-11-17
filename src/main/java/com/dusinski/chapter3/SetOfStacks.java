package com.dusinski.chapter3;

public class SetOfStacks {
    //  capacity of one stack counting from 0
    private final static int stackItemThreshold = 1;
    //  max stack numbers in SetOfStack
    private final static int stackThreshold = 20;

    private final Node[] topNodeStackArray = new Node[stackThreshold];
    private int currentStack = 0;

    public void push(int value) {
//        Node length automatically set to 1;
        Node newNode = new Node(value);
        if (topNodeStackArray[currentStack] == null) {
            topNodeStackArray[currentStack] = newNode;
        } else if (topNodeStackArray[currentStack].stackLength > stackItemThreshold) {
            currentStack++;
            topNodeStackArray[currentStack] = newNode;
        } else {
            newNode.stackLength = topNodeStackArray[currentStack].stackLength + 1;
            newNode.next = topNodeStackArray[currentStack];
            topNodeStackArray[currentStack] = newNode;
        }
    }

    public int pop() {
        if (topNodeStackArray[currentStack] == null) {
            if (currentStack == 0) {
                return 0;
            }
            currentStack--;
        }
        return popFromStack(currentStack);
    }

    private int popFromStack(int stackNumber) {
        int result = topNodeStackArray[stackNumber].data;
        topNodeStackArray[stackNumber] = topNodeStackArray[stackNumber].next;
        return result;
    }

    private Node findLastNode(int stackNumber) {
        Node tempNode = topNodeStackArray[stackNumber];
//        if (tempNode.next==null ||tempNode.next.next==null){
//            return null;
//        }

        while (tempNode.next.next != null) {
            tempNode = tempNode.next;

        }
        Node lastNode = new Node(tempNode.next.data);
        tempNode.next = null;
//System.out.println(lastNode.data);
        return lastNode;
    }

    public int popAt(int stackNumber) {
        if (stackNumber >= currentStack) {
            return pop();
        }
        int result = popFromStack(stackNumber);
        for (int i = stackNumber; i < currentStack ; i++) {
//        for (int i = stackNumber; i < currentStack - stackNumber ; i++) {

            Node movedNode = findLastNode(i + 1);
            movedNode.next = topNodeStackArray[i];
            topNodeStackArray[i] = movedNode;
        }
        return result;
    }

    public String printAll() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < topNodeStackArray.length; i++) {
            if (topNodeStackArray[i] != null) {
                s.append(Node.printList(topNodeStackArray[i])).append("\n");
            }
        }
        return s.toString();
    }


}
