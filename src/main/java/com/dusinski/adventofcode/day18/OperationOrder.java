package com.dusinski.adventofcode.day18;

import java.util.List;
import java.util.Stack;

public class OperationOrder {

    private final List<String> expressionsList;

    public OperationOrder(List<String> input) {
        this.expressionsList = input;
    }

    private long computeStack(Stack<Character> inputStack) {
        long a, b = 0L;
        char operation = '0';
        String number = "";
        Stack<Character> copyStack = new Stack<>();
        copyStack.addAll(inputStack);
        while (!inputStack.empty()) {
            char tempChar = inputStack.pop();
            if (tempChar == '+' || tempChar == '*') {
                b = Long.parseLong(number);
                number = "";
                operation = tempChar;
            } else {
                number = tempChar + number;
            }
        }
        a = Long.parseLong(number);

//        System.out.println(a + "|" + operation + "|" + b + " stack:" + copyStack.toString());
        if (operation == '+') {
            return a + b;
        } else {
            return a * b;
        }
    }

    private long computeExpressionRecursive(String expression) {
        expression = expression.replaceAll(" ", "");
//        System.out.println(expression);
        Stack<Character> computingStack = new Stack<>();
        char operation = '0';
        int expressionPosition = -1;
        while (expressionPosition < expression.length() - 1) {
            expressionPosition++;
            char tempChar = expression.charAt(expressionPosition);

            if (tempChar == '(') {
                expressionPosition++;
                tempChar = expression.charAt(expressionPosition);
                StringBuilder subExpression = new StringBuilder();

                int bracketsCount = 1;
                while (bracketsCount > 0) {
                    if (tempChar == '(') {
                        bracketsCount++;
                    } else if (tempChar == ')') {
                        bracketsCount--;
                    }
                    if (bracketsCount > 0) {
                        subExpression.append(tempChar);
                    }
                    if (expressionPosition < expression.length() - 1) {
                        expressionPosition++;
                        tempChar = expression.charAt(expressionPosition);
                    }
                }
                expressionPosition--;
                long subResult = computeExpressionRecursive(subExpression.toString());
                for (Character r : Long.toString(subResult).toCharArray()) {
                    computingStack.push(r);
                }

            } else {
                if (tempChar == '+' || tempChar == '*') {
                    if (operation == '0') {
                        operation = tempChar;
                    } else {
                        long result = computeStack(computingStack);
                        computingStack.clear();
                        for (Character r : Long.toString(result).toCharArray()) {
                            computingStack.push(r);
                        }
                        operation = tempChar;
                    }
                }
                if (tempChar != ')') {
                    computingStack.push(tempChar);
                }
            }
        }
//        System.out.println(computingStack.toString());
        return computeStack(computingStack);
    }


    public long computeExpression() {
        long homeworkSum=0L;
        for (String expr:this.expressionsList) {
            homeworkSum+=computeExpressionRecursive(expr);
        }

        return (homeworkSum);
    }

}
