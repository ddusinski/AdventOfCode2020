package com.dusinski.AdventOfCode.Day18;

import java.util.List;
import java.util.Stack;

public class OperationOrderDiffPrecedence {

    private final List<String> expressionsList;

    public OperationOrderDiffPrecedence(List<String> input) {
        this.expressionsList = input;
    }

    private Stack<Character> computeStack(Stack<Character> inputStack) {
        long a, b = 0L;
        char operation = '0';
        String number = "";
        Stack<Character> copyStack = new Stack<>();
        copyStack.addAll(inputStack);
        char tempChar = '0';
        tempChar = inputStack.pop();
        while (!inputStack.empty() && tempChar != '*') {
//            tempChar = inputStack.pop();
            if (tempChar == '+') {
                b = Long.parseLong(number);
                number = "";
                operation = tempChar;
            } else {
                number = tempChar + number;
            }
            tempChar = inputStack.pop();
        }

        if (tempChar == '*') {
            a = Long.parseLong(number);
            inputStack.push('*');
        } else {
            a = Long.parseLong(tempChar + number);
        }
        long result = a + b;

//        if (tempChar == '*') {
//            inputStack.push('*');
//        }
        for (Character r : Long.toString(result).toCharArray()) {
            inputStack.push(r);
        }

//        System.out.println(a + "|" + operation + "|" + b + " stack:" + copyStack.toString());
        return inputStack;
    }

    private long computeExpressionRecursive(String expression) {
        expression = expression.replaceAll(" ", "");
        System.out.println(expression);
        Stack<Character> computingStack = new Stack<>();
        char operation = '0';
        char tempChar = '0';
        int expressionPosition = 0;


        tempChar = expression.charAt(expressionPosition);

        while (expressionPosition < expression.length()-1) {

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
                System.out.println("cs:"+computingStack);

            } else {
                if (tempChar == '+' || tempChar == '*') {
                    if (operation == '0') {
                        operation = tempChar;
                    } else {  //
                        if (operation != '*') {
                            computingStack = computeStack(computingStack);
                        }
                        operation = tempChar;
                    }
                }
                if (tempChar != ')') {
                    computingStack.push(tempChar);
                }

            }
            expressionPosition++;
            tempChar = expression.charAt(expressionPosition);
        }

        computingStack.pop();

//        System.out.println(computingStack.toString());

        return printStackMultiplication(computingStack);
    }


    private long printStackMultiplication(Stack<Character> computingStack) {

        long result = 1;
        String number = "";
        char tempChar = '0';
        tempChar = computingStack.pop();
        while (!computingStack.empty()) {
            if (tempChar == '*') {
                result *= Long.parseLong(number);

                number = "";
            } else {
                number = tempChar + number;
            }
            tempChar = computingStack.pop();
        }
        result *= Long.parseLong(tempChar + number);
        System.out.println("mulit: "+computingStack+ " result: "+result);
        return result;
    }

    public long computeExpression() {
        long homeworkSum = 0L;
        for (String expr : this.expressionsList) {
//            homeworkSum += computeExpressionRecursive(expr);
        }
        computeExpressionRecursive(this.expressionsList.get(0));

        return (homeworkSum);
    }

}
