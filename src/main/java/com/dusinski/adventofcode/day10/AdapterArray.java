package com.dusinski.adventofcode.day10;

import java.util.*;

public class AdapterArray {

    private final List<String> adapterList;
    private TreeSet<Integer> joltSortedSet;

    public AdapterArray(List<String> input) {
        this.adapterList = input;
        createIntegerSet();
    }

    private void createIntegerSet() {
        joltSortedSet = new TreeSet<>();
        for (String str : this.adapterList) {
            joltSortedSet.add(Integer.parseInt(str));
        }
    }

    public int getOneAndThreeDiffProduct() {
        int oneDiff = 0;
        int twoDiff = 0;
        int threeDiff = 0;
        int previousJolt = 0;

        for (Integer currentJoil : joltSortedSet) {
            if (currentJoil - previousJolt == 1) {
                oneDiff++;
            } else if (currentJoil - previousJolt == 2) {
                twoDiff++;
            } else if (currentJoil - previousJolt == 3) {
                threeDiff++;
            }
            previousJolt = currentJoil;
        }
        threeDiff++;
        System.out.println(joltSortedSet.toString());
        System.out.println("one diff: " + oneDiff + " two diff: " + twoDiff + " three diff: " + threeDiff);
        return oneDiff * threeDiff;
    }

    private Long arrangementCount() {


        List<Long> wayNumberList = new ArrayList<>();
        List<Integer> sortedArray = new ArrayList<>(this.joltSortedSet);
//        sortedArray.add(sortedArray.get(sortedArray.size()-1)+3);
        Long possibleWays = 0L;


        wayNumberList.add(1L);
        wayNumberList.add(2L);

        if (sortedArray.get(2)  <= 3) {
            wayNumberList.add(4L);
        } else {
            wayNumberList.add(1L);
        }

        for (Integer i = 3; i < sortedArray.size(); i++) {
            possibleWays = 0L;
            if (sortedArray.get(i) - sortedArray.get(i - 1) == 3){
                possibleWays+=wayNumberList.get(i-1);
            }else
                {
                if (sortedArray.get(i) - sortedArray.get(i - 1) <= 3){
                    possibleWays+=wayNumberList.get(i-1);
                }
                if (sortedArray.get(i) - sortedArray.get(i - 2) <= 3){
                    possibleWays+=wayNumberList.get(i-2);
                }
                if (sortedArray.get(i) - sortedArray.get(i - 3) <= 3){
                    possibleWays+=wayNumberList.get(i-3);
                }
            }
            wayNumberList.add(possibleWays);
        }


        System.out.println(sortedArray);
        System.out.println(wayNumberList);
        return Long.valueOf(possibleWays);
    }

    public Long checkDistinctArrangements() {

        Long arrangementCount = arrangementCount();


        return arrangementCount;
    }

}
