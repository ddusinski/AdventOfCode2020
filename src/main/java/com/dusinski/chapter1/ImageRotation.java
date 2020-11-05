package com.dusinski.chapter1;

public class ImageRotation {

    private void printArray(int[][] array) {
//        int[][] array = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        for (int i = 0; i < array[0].length; i++) {
            for (int j = 0; j < array[1].length; j++) {
                System.out.print(" | " + array[i][j]);
            }
            System.out.println(" | ");
        }
    }

    private int findRow(int inputRow) {
        switch (inputRow) {
            case 0:
                return 0;
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            default:
                return -1;
        }


    }

    private int findColumn(int inputColumn) {
        switch (inputColumn) {
            case 0:
                return 2;
            case 1:
                return 1;
            case 2:
                return 0;
            default:
                return -1;
        }

    }


    public void rotateImage() {
        int[][] array = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};


//        number of rows and columns
        int n = array[0].length;
//        deeps of array
        int d = n / 2;

        int[][] result = new int[n][n];

        for (int i = 0; i < n; i++) {
            int tempColumn = findColumn(i);
            for (int j = 0; j < n; j++) {
                result[j][tempColumn] = array[i][j];
            }
        }

        printArray(array);
        System.out.println();
        printArray(result);
    }


}


