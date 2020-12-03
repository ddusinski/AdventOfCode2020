package com.dusinski;

import com.dusinski.AdventOfCode.Day2.PassPolicyCheck;
import com.dusinski.AdventOfCode.*;
import com.dusinski.AdventOfCode.Day3.TobogganMap;
import com.dusinski.chapter4.BinaryTree;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collector;
import java.util.stream.Collectors;


/**
 * Hello world!
 */

public class App {
//    private static void testArray(int[] array) {
//        for (int i = 0; i < array.length; i++) {
//            array[i]++;
//        }
//    }

    public static void main(String[] args) {


        GetInput gi = new GetInput();
        List<String> test = gi.getInputAsStringArray("day3tobogganMap.txt");
        test.forEach(System.out::println);
//        test.add("..##.......");
//        test.add("#...#...#..");
//        test.add(".#....#..#.");
//        test.forEach(System.out::println);

        TobogganMap tm = new TobogganMap(test);
        Map<String,Long>result = new HashMap<>();
        result.put("1,1", (long) tm.countTreeOnTheWay(1,1));
        result.put("1,3",(long) tm.countTreeOnTheWay(1,3));
        result.put("1,5",(long) tm.countTreeOnTheWay(1,5));
        result.put("1,7",(long) tm.countTreeOnTheWay(1,7));
        result.put("2,1",(long) tm.countTreeOnTheWay(2,1));

        result.entrySet().stream().forEach(System.out::println);
//        result.values().forEach(System.out::println);
        System.out.println("Multiplication of results: "+result.values().stream().reduce((long) 1, (a,b)->a*b));


//        System.out.println(tm.countTreeOnTheWay(1,3));

    }
}
