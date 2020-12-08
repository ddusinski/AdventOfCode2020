package com.dusinski.AdventOfCode.Day7;

import java.util.*;

public class HandyHaversacksCheck {

    private final List<String> bagRules;
    private Map<String, List<String>> bagContainingMap;
    private Map<String, List<String>> reversedBagContainingMap;


    public HandyHaversacksCheck(List<String> input) {
        this.bagRules = input;
    }

    private String getBagKey(String keyStr) {
        keyStr = keyStr.replaceAll("bags ", "").replaceAll(" ", "");

        return keyStr;
    }


    //    joins bagKey with a list which all links to other bags
    private void genContainingMap() {
        bagContainingMap = new HashMap<>();

        for (String bag : this.bagRules) {
            String bagKey = getBagKey(bag.split("contain")[0]);

            String contentPart = bag.split("contain")[1];
            contentPart = contentPart.replaceAll("bags", "").replaceAll("bag", "");
            contentPart = contentPart.replaceAll("\\.", "").replace(" ", "");
            String[] contentList = contentPart.split(",");

            bagContainingMap.put(bagKey, Arrays.asList(contentList));
        }
    }

    private void getReversedContainingMap() {
        reversedBagContainingMap = new HashMap<>();

        for (Map.Entry<String, List<String>> entry : this.bagContainingMap.entrySet()) {
            for (String bag : entry.getValue()) {
                String keyWithoutNumber = bag.replaceAll("[0-9]*", "");

                if (reversedBagContainingMap.containsKey(keyWithoutNumber)) {
                    reversedBagContainingMap.get(keyWithoutNumber).add(entry.getKey());
                } else {
                    ArrayList<String> newList = new ArrayList<String>();
                    newList.add(entry.getKey());
                    reversedBagContainingMap.put(keyWithoutNumber, newList);
                }
            }
        }
    }

    private int calculateColors(String firstElement) {
        int colors = 0;
        Set<String> calculatedColors = new HashSet<>();
        Queue<String> calcQueue = new LinkedList<>();
        calcQueue.add(firstElement);
        while (!calcQueue.isEmpty()) {
            List<String> currentElementsList = this.reversedBagContainingMap.get(calcQueue.poll());
            if (currentElementsList == null) {
            } else {
                for (String bagColor : currentElementsList) {
                    if (!calculatedColors.contains(bagColor)) {
                        colors++;
                        calculatedColors.add(bagColor);
                    }
                    calcQueue.add(bagColor);
                }
            }
        }
        return colors;
    }

    private int calcDepth(String firstElement, int bagNumber) {
        int bagSize=0;
        if (firstElement.equals("noother")) {
            return 0;
        } else {
            int sum = 0;
            for (String bag : bagContainingMap.get(firstElement)) {
                if (bag.equals("noother")) {
                    return 0;
                } else {
                    bagSize = Integer.parseInt(bag.replaceAll("[^0-9]*", ""));
                    String elementWihoutNumber = bag.replaceAll("[0-9]*", "");
                    int depth =bagSize*calcDepth(elementWihoutNumber,bagSize);
                    sum = sum + depth+bagSize ;
//                    System.out.println(elementWihoutNumber + '|' + bagSize + "|d" + depth+ "|s" +sum+"|"+bagNumber);
                }
            }
            sum = sum ;
            return sum;
        }
    }

    public int getPossibleBagColors() {
        genContainingMap();
        getReversedContainingMap();
//        this.bagContainingMap.entrySet().forEach(entry -> System.out.println(entry.getKey() + "|" + entry.getValue()));
//        System.out.println("reversed: ");
//        this.reversedBagContainingMap.entrySet().forEach(entry -> System.out.println(entry.getKey() + "|" + entry.getValue()));
//        System.out.println(this.bagKeys);
        return calculateColors("shinygold");
    }


    public int getBagsAmount() {
        genContainingMap();
        getReversedContainingMap();
//        this.bagContainingMap.entrySet().forEach(entry -> System.out.println(entry.getKey() + "|" + entry.getValue()));
//        System.out.println("reversed: ");
//        this.reversedBagContainingMap.entrySet().forEach(entry -> System.out.println(entry.getKey() + "|" + entry.getValue()));
//        System.out.println("depth: ");
//        this.bagsLevelDeep.entrySet().forEach(entry -> System.out.println(entry.getKey() + "|" + entry.getValue()));

        return calcDepth("shinygold",1);
    }


}
