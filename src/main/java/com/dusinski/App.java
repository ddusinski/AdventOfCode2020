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

        int[] testArray = {15,14,13,12,11,10,9,8,7, 6, 5, 4, 3, 2, 1};
        BinaryTree bt = BinaryTree.convertSortedArrayToBST(testArray);
        System.out.println("result:");
        System.out.println(bt.printAll());
        System.out.println("Is binary search tree?:");
        System.out.println(bt.isBinarySearchTree());
        bt.changeNodeValue(7,0);
        bt.changeNodeValue(9,7);
        bt.changeNodeValue(0,9);
        System.out.println(bt.printAll());
        System.out.println("Is binary search tree?:");
        System.out.println(bt.isBinarySearchTree());


    }
}
