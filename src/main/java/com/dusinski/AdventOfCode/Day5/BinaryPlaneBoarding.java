package com.dusinski.AdventOfCode.Day5;

import java.util.List;
import java.util.Map;

public class BinaryPlaneBoarding {
    List<String> binaryPassList;
    boolean[][] occupiedSeats= new boolean[128][8];

    public BinaryPlaneBoarding(List<String> inputPassList){
        this.binaryPassList=inputPassList;
    }
    private int findRow(String rowString){

        String binaryString=rowString.replace('F','0').replace('B','1');
        byte row = Byte.parseByte(binaryString,2);
//        System.out.println(rowString+"|"+binaryString+"|"+row);

        return row;
    }
    private  int findColumn(String columnString){
        String binaryString=columnString.replace('L','0').replace('R','1');
        byte column=Byte.parseByte(binaryString,2);
//        System.out.println(columnString+"|"+binaryString+"|"+column);
        return column;
    }

    private int evaluateBoardingID(String inputString){
        String rowString=inputString.substring(0,7);
        String columnString=inputString.substring(7);
        int row = findRow(rowString);
        int column= findColumn(columnString);
        int boardingID=row*8+column;
        occupiedSeats[row][column]=true;
//        System.out.println(inputString+ ":" + rowString+ "|"+columnString+"|"+row+"|"+column+"|"+boardingID);

//        System.out.println(boardingID);
        return boardingID;
    }

    public int findMaxBoardingID(){
        int maxID=Integer.MIN_VALUE;

        for (String str:this.binaryPassList) {
            int tempBoardingID=evaluateBoardingID(str);
            if (tempBoardingID>maxID){
                maxID=tempBoardingID;
            }
        }
        return maxID;
    }

    public void findFreeSeats(){
        for (int i=0;i<this.occupiedSeats[0].length;i++){
            for (int j=0;j<this.occupiedSeats[1].length;j++){
               if (!this.occupiedSeats[i][j]){
                   System.out.println("Is empty: row: "+i+" column: "+j);
               }
            }
        }
    }

}
