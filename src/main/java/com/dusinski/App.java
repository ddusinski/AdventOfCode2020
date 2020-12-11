package com.dusinski;

import com.dusinski.AdventOfCode.*;
import com.dusinski.AdventOfCode.Day10.AdapterArray;
import com.dusinski.AdventOfCode.Day11.SeatingSystem;
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
        List<String> test = gi.getInputAsStringArray("day11SeatingSystem.txt");
//        System.out.println(test.toString());
//        System.out.println(test.get(0));


        SeatingSystem ss = new SeatingSystem(test);
//        ss.getOccupiedSeatsWithNoChange();
        ss.getOccupiedSeatsEachDirection();


    }
}
