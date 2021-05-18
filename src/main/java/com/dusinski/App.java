package com.dusinski;

import com.dusinski.adventofcode.*;
import com.dusinski.adventofcode.day24.LobbyLayout;

import java.util.*;


/**
 * Hello world!
 */

public class App {

    public static void main(String[] args) {
        GetInput gi = new GetInput();
        List<String> test = gi.getInputAsStringArray("day24lobbyLayout.txt");

        LobbyLayout ll = new LobbyLayout(test);
        System.out.println("Black after 100: " + ll.getBlackAfter100Changes());


//        389125467

    }
}
