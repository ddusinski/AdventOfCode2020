package com.dusinski.chapter1;

import java.util.HashMap;
import java.util.Map;

public class ArraysAndStrings {


    public boolean uniqueCharactersCheckDominik(String sentence) {

        //if second parameter true, the char has appear more than once
        StringBuilder st = new StringBuilder();

        for (int i = 0; i < sentence.length(); i++) {
            Character c = sentence.charAt(i);
            if (!st.toString().contains(String.valueOf(c))) {
                st.append(c);
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean uniqueCharactersCheckBooleanArray(String sentence) {
        boolean[] array = new boolean[256];
        for (int i = 0; i < sentence.length(); i++) {
            int charVal = sentence.charAt(i);
            if (array[charVal]){return false;}
            array[charVal]=true;
        }
        return  true;
    }


}
