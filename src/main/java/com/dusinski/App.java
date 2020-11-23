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
        bt.addValue(2);
        bt.addValue(7);
        bt.addValue(3);
        bt.addValue(8);
        bt.addValue(9);

        bt.printAll();

        BinaryTree bt2 = new BinaryTree();
        bt2.addValue(4);
        bt2.addValue(2);
        bt2.addValue(6);
        bt2.addValue(3);
        bt2.addValue(1);
        bt2.addValue(5);
        bt2.addValue(7);

        bt2.printAll();

    }
}
