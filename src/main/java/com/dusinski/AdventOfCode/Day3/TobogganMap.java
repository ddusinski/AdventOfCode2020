package com.dusinski.AdventOfCode.Day3;

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
//        System.out.println(str.charAt(position));
        return str.charAt(position) == '#';
    }

    public int countTreeOnTheWay(int forward, int right) {
//        int stepRight = right;
//        int stepForward = forward;
        int trees = 0;
        int currentPositionH = 0;
        int currentPositionV = 0;



//        for (String str : this.tobogganMap) {
//        for (int i = 0; i < this.tobogganMap.size(); i+=stepForward) {
//            if (hasStringTree(tobogganMap.get(i), currentPosition)) {
//                trees++;
//            }
//            currentPosition += stepRight;
//        }
        while (currentPositionV<tobogganMap.size()-1){
            currentPositionH += right;
            currentPositionV += forward;
//            System.out.println("H: "+currentPositionH+ "V: "+currentPositionV);
            if (hasStringTree(tobogganMap.get(currentPositionV), currentPositionH)) {
                trees++;
            }
        }

        return trees;
    }

}
