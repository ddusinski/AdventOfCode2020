package com.dusinski.AdventOfCode.Day15;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RambunctiousRecitation {

    List<String> recitationList;

    public RambunctiousRecitation(List<String> input) {
        this.recitationList = input;
    }

    public int get200thElementOfRecitation(int checkPosition) {

        Map<Integer, Integer> existingCheck = new HashMap<>();
        String[] input = this.recitationList.get(0).split(",");
        int position = 1;
        int lastSpokeNumber = Integer.parseInt(input[0]);

        for (int i = 1; i < input.length; i++) {
            existingCheck.put(lastSpokeNumber, position);
            lastSpokeNumber = Integer.parseInt(input[position]);
            position++;
        }

        int diff = 0;
        while (position <= checkPosition - 1) {
            if (!existingCheck.containsKey(lastSpokeNumber)) {
                existingCheck.put(lastSpokeNumber, position);
                lastSpokeNumber = 0;
            } else {
                diff = position - existingCheck.get(lastSpokeNumber);
                existingCheck.put(lastSpokeNumber, position);
                lastSpokeNumber = diff;
            }
            position++;
        }
//        existingCheck.entrySet().forEach(entry -> System.out.println(entry.getKey() + "|" + entry.getValue()));
        return lastSpokeNumber;
    }

}
