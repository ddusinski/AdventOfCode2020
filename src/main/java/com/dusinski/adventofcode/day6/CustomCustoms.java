package com.dusinski.adventofcode.day6;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CustomCustoms {
    private final List<String> customGroupsAnswersList;

    public CustomCustoms(List<String> input) {
        this.customGroupsAnswersList = input;
    }

    private int countAnswersForGroup(String str) {
        Set<Character> answersSet = new HashSet<>();
        str = str.replaceAll(" ", "");
        for (char chr : str.toCharArray()) {
            answersSet.add(chr);
        }
//        System.out.println("str: "+str+" set: "+answersSet.toString()+" size: "+answersSet.size());
        return answersSet.size();
    }

    private int countEveryAnswersCountForGroup(String group) {
        String[] personAnswersInGroup = group.split(" ");
        if (personAnswersInGroup.length == 1) {
//            System.out.println("str:|" + group + "|matches: " +personAnswersInGroup[0].length());
            return personAnswersInGroup[0].length();
        }

        String firstAnswer = personAnswersInGroup[0];
        int matches = 0;

        for (int j = 0; j < firstAnswer.length(); j++) {
            boolean allContains = true;
            String firstAnswerLetter = firstAnswer.substring(j, j + 1);
            for (String answer : personAnswersInGroup) {
                if (!answer.contains(firstAnswerLetter)) {
                    allContains = false;
                }
            }
            if (allContains) {
                matches++;
            }
        }
//        System.out.println("str:|" + group + "|matches: " +matches);
        return matches;
    }

    public int getAnswersCount() {
        int answerCount = 0;
        for (String str : this.customGroupsAnswersList) {
            answerCount += countAnswersForGroup(str);
        }
        return answerCount;
    }

    public int getEveryAnswersCount() {
        int answerCount = 0;
        for (String str : this.customGroupsAnswersList) {
            answerCount += countEveryAnswersCountForGroup(str);
        }
        return answerCount;
    }


}
