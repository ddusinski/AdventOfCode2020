package com.dusinski.AdventOfCode.Day22;

import java.util.*;

public class RecursiveCrabCombat {
    private final List<String> inputList;

    public RecursiveCrabCombat(List<String> input) {
        this.inputList = input;
        this.inputList.add("");
    }

    public int getResult(Deque<Integer> input) {
        int result = 0;
        int max = input.size();

        for (int i = 1; i <= max; i++) {
            result += input.pollLast() * i;
        }
        return result;
    }

    public long playGame(Deque<Integer> p1, Deque<Integer> p2) {
        List<String> player1History = new ArrayList<>();
        List<String> player2History = new ArrayList<>();

        while (!p1.isEmpty() && !p2.isEmpty()) {

            if ((player1History.contains(p1.toString()) && player2History.contains(p2.toString())))
            // when existed in history
            {
                return 1;
            }
            player1History.add(p1.toString());
            player2History.add(p2.toString());

            int p1Value = p1.pollFirst();
            int p2Value = p2.pollFirst();

            if (p1Value <= p1.size() && p2Value <= p2.size()) {
//                    playing subgame
                Deque<Integer> tempdeque = new ArrayDeque<>(p1);
                Deque<Integer> subgameP1deque = new ArrayDeque<>();
                Deque<Integer> subgameP2deque = new ArrayDeque<>();
                for (int i = 0; i < p1Value; i++) {
                    subgameP1deque.add(tempdeque.pollFirst());
                }
                tempdeque = new ArrayDeque<>(p2);
                for (int i = 0; i < p2Value; i++) {
                    subgameP2deque.add(tempdeque.pollFirst());
                }

                if (playGame(subgameP1deque, subgameP2deque) == 1) {
                    p1.addLast(p1Value);
                    p1.addLast(p2Value);
                } else {
                    p2.addLast(p2Value);
                    p2.addLast(p1Value);
                }
            } else {
                if (p1Value > p2Value) {
                    p1.addLast(p1Value);
                    p1.addLast(p2Value);
                } else {
                    p2.addLast(p2Value);
                    p2.addLast(p1Value);
                }
            }

        }
        if (p1.size() > p2.size()) {
            return 1;

        } else {
            return 2;
        }
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

        if (playGame(player1Deque, player2Deque) == 1) {
            return getResult(player1Deque);
        } else {
            return getResult(player2Deque);
        }
    }
}
