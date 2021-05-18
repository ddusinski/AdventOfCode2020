package com.dusinski.adventofcode.day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PassPolicyCheck {

    private static final PassPolicyCheck instance = new PassPolicyCheck();
    public ArrayList<String> inputArray = new ArrayList<>();
    String fileName = "/home/dd/IdeaProjects/CrackingTheCoding/advOfCoding/day2passPolicyCheck.txt";


    private PassPolicyCheck() {
    }

    public static PassPolicyCheck getInstance() {
        return instance;
    }

    public void readFile() {
        try {
            File inputFile = new File(fileName);
            Scanner reader = new Scanner(inputFile);

            while (reader.hasNextLine()) {
                inputArray.add(reader.nextLine());
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public int checkPolicy() {
        int rightPass = 0;

        for (String str : this.inputArray) {
            String[] split = str.split(" ");
            int minOccurrence = Integer.parseInt(split[0].split("-")[0]);
            int maxOccurrence = Integer.parseInt(split[0].split("-")[1]);
            String letter = split[1].split(":")[0];
            String pass = split[2];
            int occurrence = pass.split(letter, -1).length - 1;

            char firstChar = pass.charAt(minOccurrence - 1);
            char secondChar = pass.charAt(maxOccurrence - 1);

//            boolean isValid = occurrence >= minOccurrence && occurrence <= maxOccurrence;
            boolean validFirst = letter.equals(String.valueOf(firstChar));
            boolean validSecond = letter.equals(String.valueOf(secondChar));
            boolean isValid = false;
            
            if (!(validFirst && validSecond)) {
                isValid = (validFirst || validSecond);
            }


            if (isValid) {
                rightPass++;
            }
            System.out.println(minOccurrence + "|" + maxOccurrence + "|" + letter + "|" + pass
                    + "|" + Arrays.toString(pass.split(letter, -1))
                    + "|" + firstChar + "|" + secondChar
                    + "|" + validFirst + "|" + validSecond+ "|" + isValid
            );
        }
        return rightPass;
    }


}
