package com.dusinski.AdventOfCode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GetInput {

    String filePath = "/home/dd/IdeaProjects/CrackingTheCoding/advOfCoding/";

    public ArrayList<String> getInputAsStringArray(String fileName) {
        ArrayList<String> inputArray = new ArrayList<>();
        try {
            File inputFile = new File(filePath + fileName);
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

    public List<String> getPassFileAsStringArray(String fileName) {
        ArrayList<String> inputArray = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        try {
            String line="";
            File inputFile = new File(filePath + fileName);
            Scanner reader = new Scanner(inputFile);
            while (reader.hasNextLine()) {
                line =reader.nextLine();
                if (line.isEmpty()){
                    inputArray.add(sb.toString());
                    sb.setLength(0);
                } else
                    sb.append(line).append(" ");
            }
            inputArray.add(sb.toString());
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return inputArray;
    }

}
