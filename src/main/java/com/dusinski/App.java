package com.dusinski;

import com.dusinski.AdventOfCode.*;
import com.dusinski.AdventOfCode.Day6.CustomCustoms;
import com.dusinski.AdventOfCode.Day7.HandyHaversacksCheck;
import com.dusinski.AdventOfCode.Day8.HandheldHalting;

import java.util.*;


/**
 * Hello world!
 */

public class App {

    public static void main(String[] args) {


        GetInput gi = new GetInput();
        List<String> test = gi.getInputAsStringArray("day8HandheldHaltingGame.txt");
        System.out.println(test.toString());
//        System.out.println(test.get(0));

        HandheldHalting hh = new HandheldHalting(test);
        System.out.println("accumulator: "+hh.getAccBeforeHandStop());
//        System.out.println("accumulator: "+hh.getAccWhenAppCorrected());


    }
}
