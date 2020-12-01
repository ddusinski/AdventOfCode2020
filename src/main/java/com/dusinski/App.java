package com.dusinski;

import com.dusinski.chapter1.*;
import com.dusinski.chapter2.*;
import com.dusinski.chapter3.*;
import com.dusinski.chapter4.*;
import com.dusinski.AdventOfCode.*;
import com.dusinski.Java8Lambda.*;

import java.util.ArrayList;
import java.util.List;


/**
 * Hello world!
 */

public class App {
    public static void main(String[] args) {

        int[] testArray = {7, 6, 5, 4, 3, 2, 1};
        BinaryTree bt = BinaryTree.convertSortedArrayToBST(testArray);
        System.out.println("result:");
        System.out.println(bt.printAll());
        System.out.println("Is binary search tree?:");
        System.out.println(bt.isBinarySearchTree());
        bt.mixNodes(3,5);
        System.out.println(bt.printAll());
        System.out.println("Is binary search tree?:");
        System.out.println(bt.isBinarySearchTree());


        BinaryTree bt2 = new BinaryTree();
        bt2.addValue(4);
        bt2.addValue(2);
        bt2.addValue(6);
        bt2.addValue(3);
        bt2.addValue(1);
        bt2.addValue(5);
        bt2.addValue(7);
        bt2.mixNodes(3,5);
        System.out.println(bt2.printAll());

//        System.out.println(BinaryTree.convertSortedArrayToBST(testArray).isTreeBalanced());


    }
}
