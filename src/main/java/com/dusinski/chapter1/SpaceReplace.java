package com.dusinski.chapter1;

public class SpaceReplace {

    private final String textInsteadSpace="%20";

    public String replaceSpace(String input){

        char[] charArray = input.toCharArray();
        StringBuilder str = new StringBuilder();

        for (char c:charArray) {
            if ((int)c==32){
                str.append(textInsteadSpace);
            }else
            {
                str.append(c);
            }
        }
        return str.toString();
    }

}
