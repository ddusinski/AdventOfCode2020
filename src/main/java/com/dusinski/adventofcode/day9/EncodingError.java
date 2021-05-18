package com.dusinski.adventofcode.day9;

import java.util.*;

public class EncodingError {
    private final List<String> numbersList;


    public EncodingError(List<String> input) {
        this.numbersList = input;
    }

    private boolean sumExist(int value, Set<Integer> inputSet) {
        for (Integer i : inputSet) {
            int reversed = i - value;
            if ((inputSet.contains( i - value) ||inputSet.contains(value - i))) {
                if ((i - value)!=i&&(value - i)!=i) {
//                    System.out.println(i);
                    return true;
                }
            }
        }
        return false;
    }

    public int getFirstNotMatchingNumber(int preamble) {
        Queue<Integer> countingFrameQueue = new LinkedList<>();
        Set<Integer> countingFrameSet = new HashSet<>();
        int checkedValue = 0;
        for (int i = 0; i < preamble; i++) {
            countingFrameQueue.add(Integer.parseInt(this.numbersList.get(i)));
            countingFrameSet.add(Integer.parseInt(this.numbersList.get(i)));
        }
        for (int i = preamble; i < this.numbersList.size(); i++) {
            checkedValue = Integer.parseInt(this.numbersList.get(i));
            if (sumExist(checkedValue, countingFrameSet)) {
                countingFrameSet.remove(countingFrameQueue.poll());
                countingFrameQueue.add(checkedValue);
                countingFrameSet.add(checkedValue);
            } else {
//                System.out.println("for following val sum not exist: " + checkedValue);
                return checkedValue;
            }
        }
        return -1;
    }

//    sum of set of successive numbers equals wrong number. Sum of min and max of the set is a result
    public int getEdgeSumOfInvValue(int invValue){
        Queue<Integer> countingFrameQueue = new LinkedList<>();
        int currentElement=0;
        int elementsSum = 0;
        int counter = 0;
        while (elementsSum<invValue){
            currentElement= Integer.parseInt(this.numbersList.get(counter));
            countingFrameQueue.add(currentElement);
            elementsSum+=currentElement;
            counter++;
        }
        while (elementsSum!=invValue){
            currentElement= Integer.parseInt(this.numbersList.get(counter));
            if (invValue>elementsSum){
                countingFrameQueue.add(currentElement);
                elementsSum+=currentElement;
                counter++;
            }else
            {
                int toRemove=countingFrameQueue.poll();
                elementsSum-=toRemove;
            }
        }
        int minElement = Collections.min(countingFrameQueue);
        int maxElement=Collections.max(countingFrameQueue);
//        System.out.println("min: "+minElement+" max: "+maxElement);
        return minElement+maxElement;
    }

}
