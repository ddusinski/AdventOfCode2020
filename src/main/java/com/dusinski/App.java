package com.dusinski;

import com.dusinski.AdventOfCode.*;
import com.dusinski.AdventOfCode.Day10.AdapterArray;
import com.dusinski.AdventOfCode.Day11.SeatingSystem;
import com.dusinski.AdventOfCode.Day12.NavigationInstructions;
import com.dusinski.AdventOfCode.Day13.ShuttleSearch;
import com.dusinski.AdventOfCode.Day14.DockingData;
import com.dusinski.AdventOfCode.Day15.RambunctiousRecitation;
import com.dusinski.AdventOfCode.Day16.TicketTranslation;
import com.dusinski.AdventOfCode.Day17.ConwayCubes;
import com.dusinski.AdventOfCode.Day17.ConwayCubes4Dimensions;
import com.dusinski.AdventOfCode.Day18.OperationOrder;
import com.dusinski.AdventOfCode.Day18.OperationOrderDiffPrecedence;
import com.dusinski.AdventOfCode.Day19.MonsterMessages;
import com.dusinski.AdventOfCode.Day20.JurassicJigsaw;
import com.dusinski.AdventOfCode.Day21.AllergenAssessment;
import com.dusinski.AdventOfCode.Day22.CrabCombat;
import com.dusinski.AdventOfCode.Day22.RecursiveCrabCombat;
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
        List<String> test = gi.getInputAsStringArray("day22crabCombat.txt");
         RecursiveCrabCombat ccr =new RecursiveCrabCombat(test);

        System.out.println("Crab combat recursive "+ ccr.winningPlayerScores());



//

    }
}
