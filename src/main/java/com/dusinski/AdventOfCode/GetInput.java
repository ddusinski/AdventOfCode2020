package com.dusinski.AdventOfCode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class GetInput {

    String filePath = "/home/dd/IdeaProjects/CrackingTheCoding/advOfCoding/";
//    String filePath = "/home/dd/IdeaProjects/CrackingTheCoding/advOfCoding/day2passPolicyCheck.txt";

    public ArrayList<String> getInputAsStringArray(String fileName) {
        ArrayList<String> inputArray = new ArrayList<>();
        try {
            File inputFile = new File(filePath+fileName);
            Scanner reader = new Scanner(inputFile);

            while (reader.hasNextLine()) {
                inputArray.add(reader.nextLine());
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return inputArray;
    }


}
