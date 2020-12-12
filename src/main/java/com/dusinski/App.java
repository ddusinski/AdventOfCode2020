package com.dusinski;

import com.dusinski.AdventOfCode.*;
import com.dusinski.AdventOfCode.Day10.AdapterArray;
import com.dusinski.AdventOfCode.Day11.SeatingSystem;
import com.dusinski.AdventOfCode.Day12.NavigationInstructions;
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
        List<String> test = gi.getInputAsStringArray("day12navigationInstructions.txt");
        System.out.println(test.toString());
//        System.out.println(test.get(0));

        NavigationInstructions ni = new NavigationInstructions(test);
//        System.out.println("Manhattan distance: "+ni.getManhattanDistance());
        System.out.println("Manhattan distance: "+ni.getManhattanDistanceIndependentCoordinates());



    }
}
