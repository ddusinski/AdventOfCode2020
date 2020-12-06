package com.dusinski;

import com.dusinski.AdventOfCode.Day2.PassPolicyCheck;
import com.dusinski.AdventOfCode.*;
import com.dusinski.AdventOfCode.Day3.TobogganMap;
import com.dusinski.AdventOfCode.Day4.PassportCheck;
import com.dusinski.AdventOfCode.Day5.BinaryPlaneBoarding;
import com.dusinski.AdventOfCode.Day6.CustomCustoms;
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
        List<String> test = gi.getPassFileAsStringArray("day6customList.txt");
        System.out.println(test.toString());
        CustomCustoms cc = new CustomCustoms(test);
        System.out.println("Customs sum: "+cc.getEveryAnswersCount());

    }
}
