package com.dusinski;

import com.dusinski.chapter1.*;
import com.dusinski.chapter2.*;
import com.dusinski.chapter3.*;


/**
 * Hello world!
 */

public class App {
    public static void main(String[] args) {
        SetOfStacks sof = new SetOfStacks();
        sof.push(1);
        sof.push(2);
        sof.push(3);
        sof.push(4);
        sof.push(5);
        sof.push(6);
        sof.push(7);
        sof.push(8);
        sof.push(9);
        sof.push(10);
        System.out.println(sof.printAll());
//        sof.pop();
//        sof.pop();
//        sof.pop();
//        sof.pop();
        sof.popAt(2);
        System.out.println(sof.printAll());

    }
}
