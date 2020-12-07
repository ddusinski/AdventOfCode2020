package com.dusinski;

import com.dusinski.AdventOfCode.*;
import com.dusinski.AdventOfCode.Day6.CustomCustoms;
import com.dusinski.AdventOfCode.Day7.HandyHaversacksCheck;

import java.util.*;


/**
 * Hello world!
 */

public class App {

    public static void main(String[] args) {


        GetInput gi = new GetInput();
        List<String> test = gi.getInputAsStringArray("day7handyHaversacksRules.txt");
//        System.out.println(test.toString());
//        System.out.println(test.get(1));
        HandyHaversacksCheck hhc = new HandyHaversacksCheck(test);
        System.out.println("Colors count: "+hhc.getPossibleBagColors());

    }
}
