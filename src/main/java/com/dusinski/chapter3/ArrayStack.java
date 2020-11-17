package com.dusinski.chapter3;

public class ArrayStack {

    private static final int arraySize = 10;
    private final int[] stackArray = new int[arraySize];

    private int pointer1 = 0;
    private int pointer2 = arraySize / 3;
    private int pointer3 = arraySize / 3 * 2;

    public void push1(int value) {
        if (pointer1 < arraySize / 3) {
            stackArray[pointer1] = value;
            pointer1++;
        }
    }

    public void push2(int value) {
        if (pointer2 < arraySize / 3 * 2) {
            stackArray[pointer2] = value;
            pointer2++;
        }
    }

    public void push3(int value) {
        if (pointer3 < stackArray.length) {
            stackArray[pointer3] = value;
            pointer3++;
        }
    }

    public int pop1() {
        int result = 0;
        if (pointer1 > 0) {
            pointer1--;
            result = stackArray[pointer1];
            stackArray[pointer1] = 0;
        }
        return result;
    }

    public int pop2() {
        int result = 0;
        if (pointer2 > arraySize / 3) {
            pointer2--;
            result = stackArray[pointer2];
            stackArray[pointer2] = 0;
        }
        return result;
    }

    public int pop3() {
        int result = 0;
        if (pointer3 > arraySize / 3 * 2) {
            pointer3--;
            result = stackArray[pointer3];
            stackArray[pointer3] = 0;
        }
        return result;
    }

    public String printArray() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < this.stackArray.length; i++) {
            s = s.append(stackArray[i]).append(" ");
        }
        return s.toString();
    }

}
