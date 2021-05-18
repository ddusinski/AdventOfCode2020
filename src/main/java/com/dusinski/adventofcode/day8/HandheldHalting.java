package com.dusinski.adventofcode.day8;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class RepeatChecker{
    public boolean isRepeating;
}


public class HandheldHalting {
    private final List<String> instructionsList;

    public HandheldHalting(List<String> input) {
        this.instructionsList = input;
    }

    //                acc -99
    private String getInstructionName(List<String> changedInstructionList, int instructionNumber) {
        return changedInstructionList.get(instructionNumber).substring(0, 3);
    }

    private int getInstructionValue(List<String> changedInstructionList, int instructionNumber) {
        String valueString = changedInstructionList.get(instructionNumber).replaceAll("[a-z ]*", "");
        return Integer.parseInt(valueString);
    }


    private int getAccBeforeHandStopChangedList(List<String> changedInstructionList, RepeatChecker isRepeating) {
        int accumulator = 0;
        Set<Integer> visitedInstructionSet = new HashSet<>();
        int currInstr = 0;
        while (!visitedInstructionSet.contains(currInstr)&&currInstr<changedInstructionList.size()-1) {

            visitedInstructionSet.add(currInstr);
            String instrName = getInstructionName(changedInstructionList, currInstr);
            int instrVal = getInstructionValue(changedInstructionList, currInstr);
            if (instrName.equals("nop")) {
                currInstr++;
            } else if (instrName.equals("acc")) {
                accumulator += instrVal;
                currInstr++;
            } else if (instrName.equals("jmp")) {
                currInstr += instrVal;
            }
//            System.out.println(currInstr + "|" + instructionsList.get(currInstr) + "|" + instrName + "|" + instrVal+"|"+accumulator);
        }
        isRepeating.isRepeating=visitedInstructionSet.contains(currInstr);
        if (!isRepeating.isRepeating&&getInstructionName(changedInstructionList, currInstr).equals("acc")){
            System.out.println(getInstructionValue(changedInstructionList, currInstr));
            accumulator+=getInstructionValue(changedInstructionList, currInstr);
        }
//        System.out.println("The instruction is repeating: " + visitedInstructionSet.contains(currInstr));
//        System.out.println("repeating instruction: " + currInstr + "|" + instructionsList.get(currInstr)+"|"+accumulator);
        return accumulator;
    }


    public int getAccBeforeHandStop() {
        RepeatChecker rc =new RepeatChecker();
        rc.isRepeating=false;

        int result = getAccBeforeHandStopChangedList(this.instructionsList, rc);
//        System.out.println("should be true: "+rc.isRepeating);
        return result;
    }

    public int getAccWhenAppCorrected(){


        for (int i=0;i<this.instructionsList.size();i++){
            String instrName = getInstructionName(this.instructionsList, i);
            int instrVal = getInstructionValue(this.instructionsList, i);

            if (instrName.equals("jmp")){
                List<String> tempInstrList = new ArrayList<>(this.instructionsList);
                tempInstrList.set(i,"nop +0");
                RepeatChecker rc =new RepeatChecker();
                rc.isRepeating=false;
                int result = getAccBeforeHandStopChangedList(tempInstrList, rc);
                if (!rc.isRepeating){
//                    System.out.println(i+"|org:"+instructionsList.get(i));
                    return result;
                }
            }
            if (instrName.equals("nop")){
                List<String> tempInstrList = new ArrayList<>(this.instructionsList);
                tempInstrList.set(i,"jmp "+instrVal);
                RepeatChecker rc =new RepeatChecker();
                rc.isRepeating=false;
                int result = getAccBeforeHandStopChangedList(tempInstrList, rc);
                if (!rc.isRepeating){
//                    System.out.println(i+"|org:"+instructionsList.get(i));
                    return result;
                }
            }

        }

        return -1;
    }




}
