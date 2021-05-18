package com.dusinski.adventofcode.day19;

import java.util.*;

class Node {
    public String instrString;
    public Node sonA = null;
    public Node sonB = null;
    public List<String> combinationList;

    public Node(String input) {
        this.instrString = input;
    }
}

class OrNode extends Node {
    public Node orSonA = null;
    public Node orSonB = null;
    public List<String> orCombinationList;

    public OrNode(String input) {
        super(input);
    }
}


public class MonsterMessages {
    private final List<String> inputList;
    private Map<Integer, String> rulesMap;

    public MonsterMessages(List<String> input) {
        this.inputList = input;
    }


    private Node addNode(String input) {
        int sonA = 0;
        int sonB = 0;
        int orSonA = 0;
        int orSonB = 0;

        if (input.equals("\"a\"") || input.equals("\"b\"")) {
            Node tmp = new Node(input);
            tmp.sonA = null;
            tmp.sonB = null;
            return tmp;
        }

        if (input.contains("|")) {
            OrNode tmp = new OrNode(input);
            String[] orString = input.split("\\| ");
            sonA = Integer.valueOf(orString[0].split(" ")[0]);
            tmp.sonA = addNode(this.rulesMap.get(sonA));
            if (orString[0].split(" ").length > 1) {
                sonB = Integer.valueOf(orString[0].split(" ")[1]);
                tmp.sonB = addNode(this.rulesMap.get(sonB));
            }
            orSonA = Integer.valueOf(orString[1].split(" ")[0]);
            tmp.orSonA = addNode(this.rulesMap.get(orSonA));
            if (orString[1].split(" ").length > 1) {
                orSonB = Integer.valueOf(orString[1].split(" ")[1]);
                tmp.orSonB = addNode(this.rulesMap.get(orSonB));
            }
            return tmp;
        } else {
            Node tmp = new Node(input);

            sonA = Integer.valueOf(input.split(" ")[0]);
            tmp.sonA = addNode(this.rulesMap.get(sonA));
            if (input.split(" ").length > 1) {
                sonB = Integer.valueOf(input.split(" ")[1]);
                tmp.sonB = addNode(this.rulesMap.get(sonB));
            }

            return tmp;
        }
    }

    private List<String> getCombination(List<String> firstList, List<String> secondList) {
        List<String> result = new LinkedList<>();
        if (firstList == null) {
            return secondList;
        } else if (secondList == null) {
            return firstList;
        } else {

            for (String str1 : firstList) {
                for (String str2 : secondList) {
                    result.add(str1 + str2);
                }
            }
            return result;
        }
    }

    private List<String> getMessagesCombinationList(Node input) {
        List<String> combList = new LinkedList<>();
        if (input != null) {
            if (input.instrString.equals("\"a\"") || input.instrString.equals("\"b\"")) {
                combList.add(input.instrString.replaceAll("\"",""));
            } else if (input instanceof OrNode) {
                combList.clear();
                combList.addAll(getCombination(getMessagesCombinationList(input.sonA),
                        getMessagesCombinationList(input.sonB)));
                combList.addAll(getCombination(getMessagesCombinationList(((OrNode) input).orSonA),
                        getMessagesCombinationList(((OrNode) input).orSonB)));
            } else {
                combList.clear();
                combList.addAll(getCombination(getMessagesCombinationList(input.sonA),
                        getMessagesCombinationList(input.sonB)));
            }
            return combList;
        }
        combList.add("");
        return combList;
    }


    public int matchesMessagesCount() {
        List<String> rulesList = new ArrayList<>();
        List<String> messagesList = new ArrayList<>();
        int pos = 0;
        while (!this.inputList.get(pos).isEmpty()) {
            rulesList.add(this.inputList.get(pos));
            pos++;
        }
        pos++;
        while (pos < this.inputList.size()) {
            messagesList.add(this.inputList.get(pos));
            pos++;
        }
        rulesMap = new TreeMap<>();
        for (String ruleString : rulesList) {
            String[] temp = ruleString.split(": ");
            int rulesNumber = Integer.valueOf(temp[0]);
            String ruleInstruction = temp[1];
            rulesMap.put(rulesNumber, ruleInstruction);
        }

//        System.out.println("rules" + rulesList);
//        System.out.println("messages" + messagesList);
//        rulesMap.entrySet().forEach(entry -> System.out.println(entry.getKey() + "+" + entry.getValue()));
        Node start = addNode(rulesMap.get(0));
        List<String> result = getMessagesCombinationList(start);
        int counter=0;
        for (String message:messagesList) {
            if(result.contains(message)){
//                System.out.println("Contains: "+message);
            counter++;
            }
        }

        return counter;
    }


}
