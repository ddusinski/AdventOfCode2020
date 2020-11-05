package com.dusinski.chapter1;

public class BasicStringCompression {

//    aaabbcdddd -> a3b2cd4

    public String compressString(String input) {

        StringBuilder stringBuilder = new StringBuilder();
        char[] array = input.toCharArray();
        int cnt = 0;
        char currentChar = array[0];
        stringBuilder.append(array[0]);

        for (char c : array) {
            if (c == currentChar) {
                cnt++;
            } else {
                if (cnt > 1) {
                    stringBuilder.append(cnt);
                }
                stringBuilder.append(c);
                currentChar = c;
                cnt = 1;
            }
        }
        if (cnt > 1) {
            stringBuilder.append(cnt);
        }
        return stringBuilder.toString();
    }
}
