package com.dusinski.AdventOfCode.Day11;

import java.util.List;

public class SeatingSystem {
    private final List<String> seatingMap;

    public SeatingSystem(List<String> input) {
        this.seatingMap = input;
    }

    private char[][] getSeatingArray() {
        char[][] seatingArray = new char[this.seatingMap.size()][this.seatingMap.get(0).length()];
        for (int i = 0; i < this.seatingMap.size(); i++) {
            String str = this.seatingMap.get(i);
            for (int j = 0; j < str.length(); j++) {
                seatingArray[i][j] = str.charAt(j);
            }
        }
        return seatingArray;
    }


    private int[][] countAdjacentSeats(char[][] input) {
        int[][] adjacent = new int[input.length][input[0].length];

        for (int i = 0; i < adjacent.length; i++) {
            for (int j = 0; j < adjacent[0].length; j++) {
                int sumOfOccupied = 0;
                if (i - 1 >= 0 && j - 1 >= 0 && input[i - 1][j - 1] == '#') {
                    sumOfOccupied++;
                }
                if (i - 1 >= 0 && j - 0 >= 0 && input[i - 1][j - 0] == '#') {
                    sumOfOccupied++;
                }
                if (i - 1 >= 0 && j + 1 < input[0].length && input[i - 1][j + 1] == '#') {
                    sumOfOccupied++;
                }
                if (i - 0 >= 0 && j - 1 >= 0 && input[i - 0][j - 1] == '#') {
                    sumOfOccupied++;
                }
                if (i - 0 >= 0 && j + 1 < input[0].length && input[i - 0][j + 1] == '#') {
                    sumOfOccupied++;
                }
                if (i + 1 < input.length && j - 1 >= 0 && input[i + 1][j - 1] == '#') {
                    sumOfOccupied++;
                }
                if (i + 1 < input.length && j - 0 >= 0 && input[i + 1][j - 0] == '#') {
                    sumOfOccupied++;
                }
                if (i + 1 < input.length && j + 1 < input[0].length && input[i + 1][j + 1] == '#') {
                    sumOfOccupied++;
                }
                adjacent[i][j] = sumOfOccupied;
            }
        }
        return adjacent;
    }

    private void printArray(char[][] input) {
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                System.out.print(input[i][j]);
            }
            System.out.println();
        }
    }

    private void printArrayInt(int[][] input) {
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                System.out.print(input[i][j]);
            }
            System.out.println();
        }
    }

    private char[][] fillArray(char[][] inputSeats, int[][] occupationArray) {
        for (int i = 0; i < inputSeats.length; i++) {
            for (int j = 0; j < inputSeats[0].length; j++) {
                if (inputSeats[i][j] == 'L' && occupationArray[i][j] == 0) {
                    inputSeats[i][j] = '#';
                } else if (inputSeats[i][j] == '#' && occupationArray[i][j] > 3) {
                    inputSeats[i][j] = 'L';
                }
            }
        }
        return inputSeats;
    }

    private int getOccupiedCount(char[][] input) {
        int occupiedCount = 0;
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                if (input[i][j] == '#') {
                    occupiedCount++;
                }
            }
        }
        return occupiedCount;
    }

    public int getOccupiedSeatsWithNoChange() {
        char[][] seatsArray = getSeatingArray();
        int[][] occArray = countAdjacentSeats(seatsArray);
        int result = -1;
        while (result != getOccupiedCount(seatsArray)) {
            result = getOccupiedCount(seatsArray);
            seatsArray = fillArray(seatsArray, occArray);
            occArray = countAdjacentSeats(seatsArray);
        }
//        System.out.println(result);
        return result;
    }

    private boolean areOccupiedChars(char[][] input, int a, int b, String direction) {
        if (direction.equals("topLeft")) {
            a = a - 1;
            b = b - 1;
        }
        if (direction.equals("topTop")) {
            a = a - 1;
            b = b;
        }
        if (direction.equals("topRight")) {
            a = a - 1;
            b = b + 1;
        }
        if (direction.equals("leftLeft")) {
            a = a - 0;
            b = b - 1;
        }
        if (direction.equals("rightRight")) {
            a = a - 0;
            b = b + 1;
        }
        if (direction.equals("bottomLeft")) {
            a = a + 1;
            b = b - 1;
        }
        if (direction.equals("bottomBottom")) {
            a = a + 1;
            b = b + 0;
        }
        if (direction.equals("bottomRight")) {
            a = a + 1;
            b = b + 1;
        }

        if (a >= 0 && b >= 0 && b < input[0].length && a < input.length) {
            if (input[a][b] == '#') return true;
            else if (input[a][b] == 'L') return false;
            else return areOccupiedChars(input, a, b, direction);
        }
        return false;
    }


    private int[][] countAdjacentSeatsAllDirections(char[][] input) {
        int[][] adjacent = new int[input.length][input[0].length];

        for (int i = 0; i < adjacent.length; i++) {
            for (int j = 0; j < adjacent[0].length; j++) {
                int sumOfOccupied = 0;
                if (areOccupiedChars(input, i, j, "topLeft")) {
                    sumOfOccupied++;
                }
                if (areOccupiedChars(input, i, j, "topTop")) {
                    sumOfOccupied++;
                }
                if (areOccupiedChars(input, i, j, "topRight")) {
                    sumOfOccupied++;
                }
                if (areOccupiedChars(input, i, j, "leftLeft")) {
                    sumOfOccupied++;
                }
                if (areOccupiedChars(input, i, j, "rightRight")) {
                    sumOfOccupied++;
                }
                if (areOccupiedChars(input, i, j, "bottomLeft")) {
                    sumOfOccupied++;
                }
                if (areOccupiedChars(input, i, j, "bottomBottom")) {
                    sumOfOccupied++;
                }
                if (areOccupiedChars(input, i, j, "bottomRight")) {
                    sumOfOccupied++;
                }
                adjacent[i][j] = sumOfOccupied;
            }
        }
        return adjacent;
    }

    private char[][] fillArrayAllDirections(char[][] inputSeats, int[][] occupationArray) {
        for (int i = 0; i < inputSeats.length; i++) {
            for (int j = 0; j < inputSeats[0].length; j++) {
                if (inputSeats[i][j] == 'L' && occupationArray[i][j] == 0) {
                    inputSeats[i][j] = '#';
                } else if (inputSeats[i][j] == '#' && occupationArray[i][j] > 4) {
                    inputSeats[i][j] = 'L';
                }
            }
        }
        return inputSeats;
    }

    public int getOccupiedSeatsEachDirection() {
        char[][] seatsArray = getSeatingArray();
        int[][] occArray = countAdjacentSeatsAllDirections(seatsArray);
        int result = -1;
        while (result != getOccupiedCount(seatsArray)) {
            result = getOccupiedCount(seatsArray);
            seatsArray = fillArrayAllDirections(seatsArray, occArray);
            occArray = countAdjacentSeatsAllDirections(seatsArray);
        }
//        System.out.println(result);
        return result;

    }


}
