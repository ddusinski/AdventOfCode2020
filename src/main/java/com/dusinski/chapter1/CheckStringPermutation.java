package com.dusinski.chapter1;


import java.util.Arrays;

//Exercise 1.3
public class CheckStringPermutation {


    public boolean checkPermutation(String firstString, String secondString) {

        fillingArray fa = (String str) -> {
            int[] array = new int[256];
            for (int i = 0; i < str.length(); i++) {
                int letter = str.charAt(i);
                array[letter]++;
            }
            return array;
        };


        if (firstString.equals(secondString)) {
            return true;
        }
        if (firstString.length() != secondString.length()) {
            return false;
        }

        int[] firstArray = fa.fill(firstString);
        int[] secondArray = fa.fill(secondString);


        return Arrays.equals(firstArray, secondArray);

    }


    interface fillingArray {
        int[] fill(String str);
    }

}
