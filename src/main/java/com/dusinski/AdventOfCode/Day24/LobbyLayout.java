package com.dusinski.AdventOfCode.Day24;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class AxialCoordinates extends Object {
    int qAxialCoordinate;
    int rAxialCoordinate;

    AxialCoordinates(int q, int r) {
        this.qAxialCoordinate = q;
        this.rAxialCoordinate = r;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null) {
            return false;
        }
        if (obj instanceof AxialCoordinates) {
            AxialCoordinates tempAC = (AxialCoordinates) obj;
            return this.qAxialCoordinate == tempAC.qAxialCoordinate
                    && this.rAxialCoordinate == tempAC.rAxialCoordinate;
        }
        return false;
    }

    @Override
    public String toString() {
        return "qAxialCoordinate=" + qAxialCoordinate +
                ", rAxialCoordinate=" + rAxialCoordinate;
    }

    @Override
    public int hashCode() {
        return this.rAxialCoordinate + this.qAxialCoordinate;
    }
}


public class LobbyLayout {
    private final List<String> inputList;

    public LobbyLayout(List<String> input) {
        this.inputList = input;
    }

    private AxialCoordinates getCoordinates(String pathString) {
        int qAxialCoordinate = 0;
        int rAxialCoordinate = 0;

        int position = 0;
        while (position < pathString.length()) {
            if (pathString.charAt(position) == 'e') {
                qAxialCoordinate++;
            } else if (pathString.charAt(position) == 'w') {
                qAxialCoordinate--;
            } else if (pathString.charAt(position) == 'n') {
                position++;
                if (pathString.charAt(position) == 'w') {
                    rAxialCoordinate--;
                } else //NE
                {
                    qAxialCoordinate++;
                    rAxialCoordinate--;
                }
            } else if (pathString.charAt(position) == 's') {
                position++;
                if (pathString.charAt(position) == 'w') {
                    qAxialCoordinate--;
                    rAxialCoordinate++;
                }//SE
                else {
                    rAxialCoordinate++;
                }
            }
            position++;
        }
//        System.out.println("q: " + qAxialCoordinate + " r: " + rAxialCoordinate + " string: " + pathString);
        return new AxialCoordinates(qAxialCoordinate, rAxialCoordinate);
    }

    public int getBlackTilesCount() {

        Map<AxialCoordinates, Integer> axialCoordinatesMap = genAxialCoordinatesMap();

//        axialCoordinatesMap.entrySet().forEach(entry -> System.out.println(entry.getKey() + " | " + entry.getValue()));
        int blackCount = 0;
        for (Map.Entry<AxialCoordinates, Integer> entry : axialCoordinatesMap.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                blackCount++;
            }
        }
        return blackCount;
    }

    private Map<AxialCoordinates, Integer> genAxialCoordinatesMap() {
        Map<AxialCoordinates, Integer> axialCoordinatesMap = new HashMap<>();
        for (String tilesPath : this.inputList) {
            AxialCoordinates tempCoordinates = getCoordinates(tilesPath);

            if (axialCoordinatesMap.containsKey(tempCoordinates)) {
                int tempVal = axialCoordinatesMap.get(tempCoordinates);
                axialCoordinatesMap.put(tempCoordinates, tempVal + 1);
            } else {
                axialCoordinatesMap.put(tempCoordinates, 1);
            }
        }
        return axialCoordinatesMap;
    }

    private char[][] genLobbyLayout(Map<AxialCoordinates, Integer> inputAxialCoordinatesMap) {
        char[][] layout = new char[200][200];
        for (int i = 0; i < layout.length; i++) {
            for (int j = 0; j < layout[0].length; j++) {
                layout[i][j] = 'w';
            }
        }
        for (Map.Entry<AxialCoordinates, Integer> coordinate : inputAxialCoordinatesMap.entrySet()) {
            if (coordinate.getValue() % 2 == 1) {
                layout[coordinate.getKey().qAxialCoordinate +100][coordinate.getKey().rAxialCoordinate +100] = 'b';
            }
        }
        return layout;
    }

    private void printLayout(char[][] layout) {
        for (int i = 0; i < layout.length; i++) {
            for (int j = 0; j < layout[0].length; j++) {
                System.out.print(layout[i][j]);
            }
            System.out.println();
        }
    }

    private void printIntArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }

    private int[][] genBlackAdjacentTilesCount(char[][] lobby) {
//        i == q, j==r
        int[][] neighborsCount = new int[lobby.length][lobby[0].length];

        for (int i = 0; i < lobby.length; i++) {
            for (int j = 0; j < lobby[0].length; j++) {
                List<AxialCoordinates> neighbors = findNeighbors(i, j);
                int blackCount = 0;
                for (AxialCoordinates coo : neighbors) {
                    if (coo.rAxialCoordinate > 0 && coo.qAxialCoordinate > 0
                            && coo.qAxialCoordinate < lobby.length && coo.rAxialCoordinate < lobby[0].length) {
                        if (lobby[coo.qAxialCoordinate][coo.rAxialCoordinate] == 'b') {
                            blackCount++;
                        }
                    }
                }
                neighborsCount[i][j] = blackCount;
            }
//            System.out.println();
        }
        return neighborsCount;
    }

    private List<AxialCoordinates> findNeighbors( int q,int r) {
        List<AxialCoordinates> neighborsList = new ArrayList<>();
        neighborsList.add(new AxialCoordinates(q, r - 1));
        neighborsList.add(new AxialCoordinates(q + 1, r - 1));
        neighborsList.add(new AxialCoordinates(q + 1, r));
        neighborsList.add(new AxialCoordinates(q, r + 1));
        neighborsList.add(new AxialCoordinates(q - 1, r + 1));
        neighborsList.add(new AxialCoordinates(q - 1, r));
        return neighborsList;
    }

    private char[][] mixTiles(char[][] input, int[][] blackCount) {
        char[][] result = input;

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                if (input[i][j] == 'b' && (blackCount[i][j] == 0 || blackCount[i][j] > 2)) {
                    result[i][j] = 'w';
                }
                if (input[i][j] == 'w' && blackCount[i][j] == 2) {
                    result[i][j] = 'b';
                }
            }
        }
        return input;
    }

    private int getBlackCount(char[][] input) {
        int count = 0;
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                if (input[i][j] == 'b') {
                    count++;
                }
            }
        }
        return count;
    }

    public int getBlackAfter100Changes() {

        Map<AxialCoordinates, Integer> axialCoordinatesMap = genAxialCoordinatesMap();

        char[][] lobbyLayout = genLobbyLayout(axialCoordinatesMap);
        int[][] nCount = genBlackAdjacentTilesCount(lobbyLayout);
//        printIntArray(nCount);
        lobbyLayout = mixTiles(lobbyLayout, nCount);

        for (int i = 0; i < 99; i++) {
            nCount = genBlackAdjacentTilesCount(lobbyLayout);
            lobbyLayout = mixTiles(lobbyLayout, nCount);
//            printLayout(lobbyLayout);
//            System.out.println("black count: " + getBlackCount(lobbyLayout));
//            nCount = genBlackAdjacentTilesCount(lobbyLayout);
        }
        return getBlackCount(lobbyLayout);
    }
}
