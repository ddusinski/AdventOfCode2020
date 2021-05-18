package com.dusinski.adventofcode.day3;

import java.util.List;

public class TobogganMap {
    private final List<String> tobogganMap;

    public TobogganMap(List<String> input) {
        this.tobogganMap = input;
    }

    private boolean hasStringTree(String str, int position) {
        if (position > str.length() - 1) {
            int modulo = position % str.length();
            position = modulo;
        }
        return str.charAt(position) == '#';
    }

    public int countTreeOnTheWay(int forward, int right) {

        int trees = 0;
        int currentPositionH = 0;
        int currentPositionV = 0;


        while (currentPositionV<tobogganMap.size()-1){
            currentPositionH += right;
            currentPositionV += forward;
            if (hasStringTree(tobogganMap.get(currentPositionV), currentPositionH)) {
                trees++;
            }
        }

        return trees;
    }

}
