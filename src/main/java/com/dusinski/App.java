package com.dusinski;

import com.dusinski.chapter1.*;
import com.dusinski.chapter2.*;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        LinkedList testList = new LinkedList();
        testList.appendToTail(36);
        testList.appendToTail(36);
        testList.appendToTail(5);
        testList.appendToTail(5);

        System.out.println(testList.printList());

        testList.removeDuplicates();
        System.out.println(testList.printList());


    }
}
