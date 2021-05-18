package com.dusinski.adventofcode.day5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryPlaneBoarding {
    List<String> binaryPassList;
    List<Integer> seatsIDlist;

    public BinaryPlaneBoarding(List<String> inputPassList) {
        this.binaryPassList = inputPassList;
    }

    private int findRow(String rowString) {

        String binaryString = rowString.replace('F', '0').replace('B', '1');
        byte row = Byte.parseByte(binaryString, 2);
//        System.out.println(rowString+"|"+binaryString+"|"+row);

        return row;
    }

    private int findColumn(String columnString) {
        String binaryString = columnString.replace('L', '0').replace('R', '1');
        byte column = Byte.parseByte(binaryString, 2);
//        System.out.println(columnString+"|"+binaryString+"|"+column);
        return column;
    }

    private int evaluateBoardingID(String inputString) {
        String rowString = inputString.substring(0, 7);
        String columnString = inputString.substring(7);
        int row = findRow(rowString);
        int column = findColumn(columnString);
        int boardingID = row * 8 + column;
//        System.out.println("added row: "+row+" column: "+column+" is: "+occupiedSeats[row][column]);
        return boardingID;
    }

    public int findMaxBoardingID() {
        int maxID = Integer.MIN_VALUE;
        this.seatsIDlist = new ArrayList<>();

        for (String str : this.binaryPassList) {
            int tempBoardingID = evaluateBoardingID(str);
            this.seatsIDlist.add(tempBoardingID);
            if (tempBoardingID > maxID) {
                maxID = tempBoardingID;
            }
        }
        return maxID;
    }

    public int findEmptySeatsID() {
//        System.out.println(this.seatsIDlist.size());
        if (this.seatsIDlist == null) {
            findMaxBoardingID();
        }
        Collections.sort(this.seatsIDlist);
        int current = this.seatsIDlist.get(0);

        for (int seatId : this.seatsIDlist) {
            if (!(current == seatId)) {
                return current;
            }
            current++;
        }
        return -1;
    }
}
    
    


