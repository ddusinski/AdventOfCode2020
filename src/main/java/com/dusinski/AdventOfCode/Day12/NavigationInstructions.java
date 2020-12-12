package com.dusinski.AdventOfCode.Day12;

import java.util.List;

enum CardinalDirection {
    NORTH, EAST, WEST, SOUTH
}


public class NavigationInstructions {
    List<String> instructionsList;

    public NavigationInstructions(List<String> input) {
        this.instructionsList = input;
    }

    private char rotate(char currentDirection, int angle) {

        if (angle > 0) {
            for (int i = 0; i < angle / 90; i++) {
                switch (currentDirection) {
                    case 'N':
                        currentDirection = 'E';
                        break;
                    case 'E':
                        currentDirection = 'S';
                        break;
                    case 'S':
                        currentDirection = 'W';
                        break;
                    case 'W':
                        currentDirection = 'N';
                        break;
                }
            }
        }
        if (angle < 0) {
            for (int i = 0; i < -angle / 90; i++) {
                switch (currentDirection) {
                    case 'N':
                        currentDirection = 'W';
                        break;
                    case 'W':
                        currentDirection = 'S';
                        break;
                    case 'S':
                        currentDirection = 'E';
                        break;
                    case 'E':
                        currentDirection = 'N';
                        break;
                }
            }
        }
        return currentDirection;
    }


    public long getManhattanDistance() {
        int manhattanDistanceVer = 0;
        int manhattanDistanceHor = 0;
        char direction = 'E';

        for (String instr : this.instructionsList) {
//            int instrValue = Integer.valueOf(instr.replaceAll("[^0-9]",""));
            instr = instr.replaceAll(" ", "");
            int instrValue = Integer.parseInt(instr.substring(1));
            char instrType = instr.charAt(0);

            if (instrType == 'F') {
                instrType = direction;
            }

            switch (instrType) {
                case 'N':
                    manhattanDistanceVer += instrValue;
                    break;
                case 'S':
                    manhattanDistanceVer -= instrValue;
                    break;
                case 'E':
                    manhattanDistanceHor += instrValue;
                    break;
                case 'W':
                    manhattanDistanceHor -= instrValue;
                    break;
                case 'R':
                    direction = rotate(direction, instrValue);
                    break;
                case 'L':
                    direction = rotate(direction, -instrValue);
                    break;
                default:
                    break;
            }

//            System.out.println("dir:" + direction + "|" + instr + "|" + "|V:" + manhattanDistanceVer + "|H:" + manhattanDistanceHor);

        }

        return Math.abs(manhattanDistanceVer) + Math.abs(manhattanDistanceHor);
    }

    private long[] rotateWaypointVer(long currentVer, long currentHor, long angle) {
        long[] result = {0, 0};
        long temp = 0;

        if (angle > 0) {
            for (int i = 0; i < angle / 90; i++) {
//                if (currentHor > 0 && currentVer > 0)
                {
                    temp = currentVer;
                    currentVer = -currentHor;
                    currentHor = temp;
                }
            }
        }
        if (angle < 0) {
            for (int i = 0; i < -angle / 90; i++) {
//                if (currentHor > 0 && currentVer > 0)
                {
                    temp = currentVer;
                    currentVer = currentHor;
                    currentHor = -temp;
                }
            }
        }
        result[0] = currentHor;
        result[1] = currentVer;
        return result;


    }


    public int getManhattanDistanceIndependentCoordinates() {
        long manhattanDistanceVer = 0;
        long manhattanDistanceHor = 0;

        long waypointVer = 1;
        long waypointHor = 10;
        long tmpV = 0;
        long tmpH = 0;


        for (String instr : this.instructionsList) {
//            int instrValue = Integer.valueOf(instr.replaceAll("[^0-9]",""));
            instr = instr.replaceAll(" ", "");
            int instrValue = Integer.parseInt(instr.substring(1));
            char instrType = instr.charAt(0);

            if (instrType == 'F') {
                manhattanDistanceVer += waypointVer * instrValue;
                manhattanDistanceHor += waypointHor * instrValue;
            }

            switch (instrType) {
                case 'N':
                    waypointVer += instrValue;
                    break;
                case 'S':
                    waypointVer -= instrValue;
                    break;
                case 'E':
                    waypointHor += instrValue;
                    break;
                case 'W':
                    waypointHor -= instrValue;
                    break;
                case 'R':
                    tmpH = waypointHor;
                    tmpV = waypointVer;
                    waypointVer = rotateWaypointVer(tmpV, tmpH, instrValue)[1];
                    waypointHor = rotateWaypointVer(tmpV, tmpH, instrValue)[0];
                    break;
                case 'L':
                    tmpH = waypointHor;
                    tmpV = waypointVer;
                    waypointVer = rotateWaypointVer(tmpV, tmpH, -instrValue)[1];
                    waypointHor = rotateWaypointVer(tmpV, tmpH, -instrValue)[0];
                    break;
                default:
                    break;
            }

//            System.out.println(instr + "|" + "wV:" + waypointVer + "|" + "wH:" + waypointHor + "|" + "|V:" + manhattanDistanceVer + "|H:" + manhattanDistanceHor);

        }


        return Math.abs((int) manhattanDistanceVer) + Math.abs((int) manhattanDistanceHor);
    }

}
