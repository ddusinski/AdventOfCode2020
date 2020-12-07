package com.dusinski.AdventOfCode.Day7;

import java.util.*;

public class HandyHaversacksCheck {

    private Map<String, List<String>> bagContainingMap;
    private Map<String, List<String>> reversedBagContainingMap;
    private final List<String> bagRules;
    private ArrayList<String> bagKeys;

    public HandyHaversacksCheck(List<String> input) {
        this.bagRules = input;
    }

    private String getBagKey(String keyStr) {
        keyStr = keyStr.replaceAll("bags ", "").replaceAll(" ", "");

        return keyStr;
    }

    private void getBagKeysMap() {
        bagKeys = new ArrayList<>();
        for (String bag : this.bagRules) {
            bagKeys.add(getBagKey(bag.split("contain")[0]));
        }
    }

    //    joins bagKey with a list which all links to other bags
    private void genContainingMap() {
        bagContainingMap = new HashMap<>();

        for (String bag : this.bagRules) {
//            1 bright white bag, 2 muted yellow bags.
//            3 bright white bags, 4 muted yellow bags.
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
//                System.out.println(withoutNumber);
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
//                    System.out.println(bagColor);
                    calcQueue.add(bagColor);
                }

            }
        }


        return colors;
    }

    public int getPossibleBagColors() {
        int colorCount = 0;
        getBagKeysMap();
        genContainingMap();
        getReversedContainingMap();

//        this.bagContainingMap.entrySet().forEach(entry -> System.out.println(entry.getKey() + "|" + entry.getValue()));
//        System.out.println("reversed: ");
//        this.reversedBagContainingMap.entrySet().forEach(entry -> System.out.println(entry.getKey() + "|" + entry.getValue()));


//        System.out.println(this.bagKeys);

        return calculateColors("shinygold");
    }


}
