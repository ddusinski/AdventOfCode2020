package com.dusinski;

import com.dusinski.chapter1.*;
import com.dusinski.chapter2.*;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        LinkedList testList1 = new LinkedList();
        testList1.appendToTail(1);
        testList1.appendToTail(2);
        testList1.appendToTail(3);
        testList1.appendToTail(2);
        testList1.appendToTail(1);
//        testList1.appendToTail(8);
        System.out.println(testList1.printList());



        System.out.println(testList1.isPalindrome());

    }
}
