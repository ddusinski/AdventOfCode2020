package com.dusinski;

import com.dusinski.chapter1.*;
import com.dusinski.chapter2.*;
import com.dusinski.chapter3.StackWithMin;

/**
 * Hello world!
 */
class DominikInt {
    int value = 0;
}

public class App {
    public static void main(String[] args) {

        StackWithMin swm= new StackWithMin();
        swm.push(4);
        swm.push(3);
        swm.push(2);
        swm.push(1);
        System.out.println(swm.toString());
        System.out.println(swm.min());
        System.out.println(swm.pop());
        System.out.println(swm.pop());
        System.out.println(swm.toString());
        System.out.println(swm.min());


    }
}
