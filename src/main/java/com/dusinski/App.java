package com.dusinski;

import com.dusinski.chapter1.*;
import com.dusinski.chapter2.*;
import com.dusinski.chapter3.*;
import com.dusinski.chapter4.*;


/**
 * Hello world!
 */

public class App {
    public static void main(String[] args) {

        BinaryTree bt = new BinaryTree();
        bt.addValue(5);
        bt.addValue(6);
        bt.addValue(7);
        bt.addValue(8);
        bt.addValue(9);

//        bt.printAllIterative();
//        System.out.println(bt.printAll());
//        System.out.println(bt.isTreeBalanced());

        int[] testArray={6,5,4,3,2,1};
        System.out.println("result:");
        System.out.println(BinaryTree.convertSortedArrayToBST(testArray).printAll());


    }
}
