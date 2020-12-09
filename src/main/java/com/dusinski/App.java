package com.dusinski;

import com.dusinski.AdventOfCode.*;
import com.dusinski.AdventOfCode.Day6.CustomCustoms;
import com.dusinski.AdventOfCode.Day7.HandyHaversacksCheck;
import com.dusinski.AdventOfCode.Day8.HandheldHalting;
import com.dusinski.AdventOfCode.Day9.EncodingError;

import java.util.*;


/**
 * Hello world!
 */

public class App {

    public static void main(String[] args) {


        GetInput gi = new GetInput();
        List<String> test = gi.getInputAsStringArray("day9EncodingError.txt");
//        System.out.println(test.toString());
//        System.out.println(test.get(0));

        EncodingError ee =  new EncodingError(test);
        int valWithoutSum=ee.getFirstNotMatchingNumber(25);
        System.out.println("val without sum: "+valWithoutSum);
        System.out.println("Sum of min and max of the set: "+ee.getEdgeSumOfInvValue(valWithoutSum));


    }
}
