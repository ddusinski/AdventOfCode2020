package com.dusinski.adventofcode.day22;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class CrabCombat {
    private final List<String> inputList;

    public CrabCombat(List<String> input) {
        this.inputList = input;
        this.inputList.add("");
    }

    public int playGame(Deque<Integer> p1, Deque<Integer> p2) {
        while (!p1.isEmpty() && !p2.isEmpty()) {
            int p1Value = p1.pollFirst();
            int p2Value = p2.pollFirst();
            if (p1Value > p2Value) {
                p1.addLast(p1Value);
                p1.addLast(p2Value);
            } else {
                p2.addLast(p2Value);
                p2.addLast(p1Value);
            }
        }
//        System.out.println("P1" + p1.toString());
//        System.out.println("P2" + p2.toString());
        int result = 0;
        int max = 0;
        Deque<Integer> resultDeque;
        if (p1.size() > p2.size()) {
            resultDeque = p1;
            max = p1.size();
        } else {
            resultDeque = p2;
            max = p2.size();
        }
        for (int i = 1; i <= max; i++) {
            result += resultDeque.pollLast() * i;
        }
        return result;
    }


    public int winningPlayerScores() {
        Deque<Integer> player1Deque = new ArrayDeque<>();
        Deque<Integer> player2Deque = new ArrayDeque<>();

//        starting from 1 to omit Player1 String
        int pos = 1;
        while (!this.inputList.get(pos).isEmpty()) {
            player1Deque.addLast(Integer.valueOf(this.inputList.get(pos)));
            pos++;
        }
//        to omit blank and Player 2 Strings;
        pos = pos + 2;
        while (!this.inputList.get(pos).isEmpty()) {
            player2Deque.addLast(Integer.valueOf(this.inputList.get(pos)));
            pos++;
        }

//        System.out.println("P1" + player1Deque.toString());
//        System.out.println("P2" + player2Deque.toString());

        return playGame(player1Deque, player2Deque);
    }

}
