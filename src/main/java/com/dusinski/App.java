package com.dusinski;

import com.dusinski.AdventOfCode.Day2.PassPolicyCheck;
import com.dusinski.chapter4.BinaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;


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



        BinaryTree bt2 = new BinaryTree();
        bt2.addValue(20);
        bt2.addValue(10);
        bt2.addValue(30);
        bt2.addValue(8);
        bt2.addValue(15);
        bt2.addValue(9);
        System.out.println(bt2.printAll());
        System.out.println("Is binary search tree?:");
        System.out.println(bt2.isBinarySearchTree());
        bt2.changeNodeValue(9,12);
        System.out.println(bt2.printAll());
        System.out.println("Is binary search tree?:");
        System.out.println(bt2.isBinarySearchTree());

//        PassPolicyCheck psc= PassPolicyCheck.getInstance();
//        psc.readFile();
//        System.out.println("right passes: "+psc.checkPolicy());

//        List<Integer> intList = Arrays.asList(1,2,3,4);
//        Consumer<Integer> cns=p->System.out.println(p.toString());
////        intList.forEach(System.out::println);
//
//        intList.stream()
//                .filter(t->t>1)
//                .filter(t->t<4)
//                .forEach(cns);

    }
}
