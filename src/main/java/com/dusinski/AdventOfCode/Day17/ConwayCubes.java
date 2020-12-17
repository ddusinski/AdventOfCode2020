package com.dusinski.AdventOfCode.Day17;

import java.util.*;

public class ConwayCubes {

    private final List<String> startingState;


    public ConwayCubes(List<String> input) {
        this.startingState = input;
    }


    private char[][][] getConwayCubesInitialState(int n) {
        int m = this.startingState.size();
        int middleFromEdge = (n - m) / 2;

        char[][][] cubesState = new char[n][n][n];
//        fill all with empty
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    cubesState[i][j][k] = '.';
                }
            }
        }
//      fill middle
        for (int i = 0; i < m; i++) {
            String str = this.startingState.get(i);
            for (int j = 0; j < m; j++) {
                cubesState[i + middleFromEdge][j + middleFromEdge][n / 2] = str.charAt(j);
            }
        }
        return cubesState;
    }

    private void printArray(char[][][] input) {
        for (int k = 0; k < input[1].length; k++) {
            System.out.println("z:" + k);
            for (int i = 0; i < input.length; i++) {
                for (int j = 0; j < input[0].length; j++) {
                    System.out.print(input[i][j][k]);
                }
                System.out.println();
            }
            System.out.println("-----");
        }
    }

    private void printIntArray(int[][][] input) {
        for (int k = 0; k < input[1].length; k++) {
            System.out.println("z:" + k);
            for (int i = 0; i < input.length; i++) {
                for (int j = 0; j < input[0].length; j++) {
                    System.out.print(input[i][j][k]);
                }
                System.out.println();
            }
            System.out.println("-----");
        }
    }


    private int countActive(char[][][] input) {
        int activeCount = 0;
        for (int k = 0; k < input[1].length; k++) {
            for (int i = 0; i < input.length; i++) {
                for (int j = 0; j < input[0].length; j++) {
                    if (input[i][j][k] == '#') {
                        activeCount++;
                    }
                }
            }
        }
        return activeCount;
    }


    private List<Integer[]> findNeighborsNEW(int x, int y, int z, int n) {
        List<Integer[]> neighborsList = new ArrayList<>();
        int edgeMin = (n - 1) / 2;
        int edgeMax = (n - 1) - edgeMin;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                for (int k = -1; k <= 1; k++) {
                    if (!(0 == i && 0 == j && 0 == k)) {
                        if ((x + i) >= -0 && (y + j) >= -0 && (z + k) >= -0) {
                            if ((x + i) < n - 1 && (y + j) < n - 1 && (z + k) < n - 1) {
                                neighborsList.add(new Integer[]{x + i, y + j, z + k});
                            }
                        }
                    }
                }
            }
        }
//        neighborsList.forEach(integers -> System.out.println(Arrays.asList(integers).toString()));
        return neighborsList;
    }

    private int[][][] getActiveNeighborsArray(char[][][] input) {
        int[][][] result = new int[input.length][input[0].length][input[1].length];
        int n = input.length;

        int edgeMin = (n - 1) / 2;
        int edgeMax = (n - 1) - edgeMin;

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                for (int k = 0; k < input[1].length; k++) {
                    List<Integer[]> neighborsCoordinates = findNeighborsNEW(i, j, k, n);
                    int active = 0;
                    for (Integer[] coordinates : neighborsCoordinates) {
                        if (input[coordinates[0]][coordinates[1]][coordinates[2]] == '#') {
                            active++;
                        }
                        result[i][j][k] = active;
                    }
                }
            }
        }
        return result;
    }

    private char[][][] changeState(char[][][] inputChar, int[][][] inputInt) {
        char[][][] newState = new char[inputChar.length][inputChar.length][inputChar.length];

        //        fill all with empty
        for (int i = 0; i < newState.length; i++) {
            for (int j = 0; j < newState.length; j++) {
                for (int k = 0; k < newState.length; k++) {
                    newState[i][j][k] = '.';
                }
            }
        }

        for (int i = 0; i < inputChar.length; i++) {
            for (int j = 0; j < inputChar[0].length; j++) {
                for (int k = 0; k < inputChar[1].length; k++) {
                    int neighborsCount = inputInt[i][j][k];
                    if (inputChar[i][j][k] == '#' && (neighborsCount == 2 || neighborsCount == 3)) {
                        newState[i][j][k] = '#';
                    }
                    if (inputChar[i][j][k] == '.' && neighborsCount == 3) {
                        newState[i][j][k] = '#';
                    }
                }
            }
        }
        return newState;
    }

    public int activeLeftAfter6Cycles() {
        int n = 4;
        char[][][] cubeState = getConwayCubesInitialState(20);
        int[][][] activeFields = getActiveNeighborsArray(cubeState);
//        printArray(cubeState);
//        printIntArray(activeFields);
//        System.out.println("after 1 change");
        for (int i = 0; i <6; i++) {

            cubeState = changeState(cubeState, activeFields);
            activeFields = getActiveNeighborsArray(cubeState);
//        printArray(cubeState);
//        printIntArray(activeFields);

        }
        return countActive(cubeState);
    }


}
