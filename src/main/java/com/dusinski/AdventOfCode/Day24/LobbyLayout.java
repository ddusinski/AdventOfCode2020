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

//        List<AxialCoordinates> axialCoordinatesList = new ArrayList<>();
        Map<AxialCoordinates, Integer> axialCoordinatesMap = new HashMap<>();
//        Map<AxialCoordinates>

        for (String tilesPath : this.inputList) {
//            System.out.println("---");
            AxialCoordinates tempCoordinates = getCoordinates(tilesPath);

            if (axialCoordinatesMap.containsKey(tempCoordinates)) {
                int tempVal = axialCoordinatesMap.get(tempCoordinates);
                axialCoordinatesMap.put(tempCoordinates, tempVal + 1);
            } else {
                axialCoordinatesMap.put(tempCoordinates, 1);
            }
        }
//        axialCoordinatesMap.entrySet().forEach(entry -> System.out.println(entry.getKey() + " | " + entry.getValue()));

        int blackCount=0;
        for (Map.Entry<AxialCoordinates, Integer>entry:axialCoordinatesMap.entrySet()) {
            if (entry.getValue()%2==1){
                blackCount++;
            }
        }

        return blackCount;
    }


}
