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
        testList1.appendToTail(9);
        testList1.appendToTail(3);
        testList1.appendToTail(5);
        testList1.appendToTail(7);
        testList1.appendToTail(8);;
        System.out.println(testList1.printList());
        testList1.roundLinkedList(4);
//        System.out.println(testList1.printList());

        System.out.println(testList1.returnLoopBeginningNode());

    }
}
