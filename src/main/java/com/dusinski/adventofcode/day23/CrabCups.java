package com.dusinski.adventofcode.day23;


import java.util.HashMap;
import java.util.Map;

class CupsNode {
    CupsNode next = null;
    int value = -1;

    public CupsNode(int v) {
        this.value = v;
    }

    public void appendToTail(int value) {
        CupsNode startNode = this;
        while (startNode.next != null) {
            startNode = startNode.next;
        }
        CupsNode temp = new CupsNode(value);
        startNode.next = temp;
    }


}

public class CrabCups {
    char[] cupsOrder;
    int minValue = Integer.MAX_VALUE;
    int maxValue = Integer.MIN_VALUE;

    Map<Integer, CupsNode> valueCupMap;

    public CrabCups(char[] input) {
        this.cupsOrder = input;
    }

    private void genValueCupMap(CupsNode node) {
        valueCupMap = new HashMap<>();
        while (node != null) {
            valueCupMap.put(node.value, node);
            node = node.next;
        }
    }

    public String printNodeLoop(CupsNode start) {
        StringBuilder sb = new StringBuilder();
        int startValue = start.value;
        while (start.next != null && start.next.value != startValue) {
            sb.append(start.value).append("|");
            start = start.next;
        }
        sb.append(start.value).append("|");

        return sb.toString();
    }


    private void closeLoopList(CupsNode start, CupsNode end) {
//        CupsNode tempNode = start;
//        while (tempNode.next != null) {
//            tempNode = tempNode.next;
//        }
        end.next = start;
    }

    private CupsNode takeThreeCups(CupsNode currentNode) {
        CupsNode takenCups = currentNode.next;
        CupsNode tempCup = takenCups;
        for (int i = 0; i < 2; i++) {
            tempCup = tempCup.next;
        }
        currentNode.next = tempCup.next;
        tempCup.next = null;
        return takenCups;
    }

    private int findDestinationValue(int value, CupsNode takenCups) {
        if (value < minValue) {
            value = maxValue;
        }
        boolean isTaken = false;
        CupsNode tempTakenCups = takenCups;
        while (tempTakenCups != null) {
            if (tempTakenCups.value == value) {
                isTaken = true;
            }
            tempTakenCups = tempTakenCups.next;
        }
        if (isTaken) {
            return findDestinationValue(value - 1, takenCups);
        }
        return value;
    }

    private void attachTakenCups(int destinationValue, CupsNode nodesLoop, CupsNode takenCups) {
//        while (nodesLoop.value != destinationValue) {
//            nodesLoop = nodesLoop.next;
//        }
//        CupsNode endNode = nodesLoop.next;
//System.out.println(destinationValue);
        CupsNode destinationNode = valueCupMap.get(destinationValue);
        CupsNode endNode = destinationNode.next;

//        nodesLoop.next = takenCups;
        destinationNode.next = takenCups;

        while (destinationNode.next != null) {
            destinationNode = destinationNode.next;
        }
        destinationNode.next = endNode;
    }

    public String printResultAfter1(CupsNode start) {
        StringBuilder sb = new StringBuilder();
        while (start.value != 1) {
            start = start.next;
        }
        start = start.next;
        while (start.value != 1) {
            sb.append(start.value);
            start = start.next;
        }
        return sb.toString();
    }

    private long multiplyTwoCupValuesAfterOne() {
        long firstAfterOne = valueCupMap.get(1).next.value;
        long secondAfterOne = valueCupMap.get(1).next.next.value;
//        System.out.println("first: " + firstAfterOne + " second: " + secondAfterOne);
        return firstAfterOne * secondAfterOne;
    }

    public String getOrderAfter100Moves() {
        CupsNode startNode = new CupsNode(this.cupsOrder[0] - '0');
        maxValue = startNode.value;
        minValue = startNode.value;
        CupsNode tempLastNode = startNode;
        for (int i = 1; i < this.cupsOrder.length; i++) {
            int val = this.cupsOrder[i] - '0';
            if (val > maxValue) {
                maxValue = val;
            }
            if (val < minValue) {
                minValue = val;
            }
            tempLastNode.next = new CupsNode(val);
            tempLastNode = tempLastNode.next;
//            startNode.appendToTail(val);
        }

        genValueCupMap(startNode);

        closeLoopList(startNode, tempLastNode);
        int simulationCount = 0;
        while (simulationCount < 100) {
            CupsNode taken = takeThreeCups(startNode);
            int destinationValue = findDestinationValue(startNode.value - 1, taken);
            attachTakenCups(destinationValue, startNode, taken);
            startNode = startNode.next;
            simulationCount++;
        }
        return printResultAfter1(startNode);
    }

    public String getOrderAfter1000000Moves() {
        CupsNode startNode = new CupsNode(this.cupsOrder[0] - '0');
        maxValue = startNode.value;
        minValue = startNode.value;
        CupsNode tempLastNode = startNode;
        for (int i = 1; i < this.cupsOrder.length; i++) {
            int val = this.cupsOrder[i] - '0';
            if (val > maxValue) {
                maxValue = val;
            }
            if (val < minValue) {
                minValue = val;
            }
            tempLastNode.next = new CupsNode(val);
            tempLastNode = tempLastNode.next;
        }

        for (int i = 1; i <= 1000000 - this.cupsOrder.length; i++) {
            tempLastNode.next = new CupsNode(maxValue + i);
            tempLastNode = tempLastNode.next;
        }
        maxValue = tempLastNode.value;
        genValueCupMap(startNode);

        closeLoopList(startNode, tempLastNode);

        int simulationCount = 0;

        while (simulationCount < 10000000) {
            CupsNode taken = takeThreeCups(startNode);
            int destinationValue = findDestinationValue(startNode.value - 1, taken);
            attachTakenCups(destinationValue, startNode, taken);
            startNode = startNode.next;
            simulationCount++;
        }
        return multiplyTwoCupValuesAfterOne() + "";
    }


}
