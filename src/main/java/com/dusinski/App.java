package com.dusinski;

import com.dusinski.AdventOfCode.Day2.PassPolicyCheck;
import com.dusinski.AdventOfCode.*;
import com.dusinski.AdventOfCode.Day3.TobogganMap;
import com.dusinski.AdventOfCode.Day4.PassportCheck;
import com.dusinski.AdventOfCode.Day5.BinaryPlaneBoarding;
import com.dusinski.chapter4.BinaryTree;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collector;
import java.util.stream.Collectors;


/**
 * Hello world!
 */

public class App {

    public static void main(String[] args) {


        GetInput gi = new GetInput();
        List<String> test = gi.getInputAsStringArray("day5binaryBoarding.txt");
//        System.out.println(test.toString());
        BinaryPlaneBoarding bpb = new BinaryPlaneBoarding(test);
        System.out.println("Max boarding ID: "+bpb.findMaxBoardingID());
//        bpb.findFreeSeats();
        System.out.println(bpb.findEmptySeatsID());
//        PassportCheck pc = new PassportCheck(test);
//        System.out.println("Number of valid passports: "+pc.howManyPassportIsValid());



//        System.out.println(tm.countTreeOnTheWay(1,3));

    }
}
