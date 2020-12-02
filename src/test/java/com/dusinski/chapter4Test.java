package com.dusinski;


import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import com.dusinski.chapter4.*;
import org.junit.Assert;
import org.junit.Test;

public class chapter4Test {
    @Test
    public void convertSortedArrayToBST(){
        int[] testArray={6,5,4,3,2,1};

        Assert.assertEquals("   3\n" +"  1|5\n" +" -|2|4|6\n",
                BinaryTree.convertSortedArrayToBST(testArray).printAll());
        assertTrue(BinaryTree.convertSortedArrayToBST(testArray).isTreeBalanced());

        int[] testArray2={8,7,6,5,4,3,2,1};
        Assert.assertEquals("    4\n" + "   2|6\n" + "  1|3|5|7\n" + " -|-|-|-|-|-|-|8\n",
                BinaryTree.convertSortedArrayToBST(testArray2).printAll());
        assertTrue(BinaryTree.convertSortedArrayToBST(testArray2).isTreeBalanced());
    }

    @Test
    public void printTreeTest() {
        BinaryTree bt2 = new BinaryTree();
        bt2.addValue(4);
        bt2.addValue(2);
        bt2.addValue(6);
        bt2.addValue(3);
        bt2.addValue(1);
        bt2.addValue(5);
        bt2.addValue(7);
        bt2.addValue(7);

        assertEquals("    4\n" +
                "   2|6\n" +
                "  1|3|5|7\n" +
                " -|-|-|-|-|-|-|7\n", bt2.printAll());
    }

    @Test
    public void testIsTreeBalancedTest() {
        BinaryTree bt2 = new BinaryTree();
        bt2.addValue(4);
        bt2.addValue(2);
        bt2.addValue(6);
        bt2.addValue(3);
        bt2.addValue(1);
        bt2.addValue(5);
        bt2.addValue(7);
        assertTrue(bt2.isTreeBalanced());
        bt2.addValue(7);
        assertTrue(bt2.isTreeBalanced());
        bt2.addValue(7);
        assertFalse(bt2.isTreeBalanced());
    }

    @Test
    public void testIsBinarySearchTree(){
        int[] testArray = {15,14,13,12,11,10,9,8,7, 6, 5, 4, 3, 2, 1};
        BinaryTree bt = BinaryTree.convertSortedArrayToBST(testArray);
        assertTrue(bt.isBinarySearchTree());
        bt.changeNodeValue(7,0);
        bt.changeNodeValue(9,7);
        bt.changeNodeValue(0,9);
        assertFalse(bt.isBinarySearchTree());
        BinaryTree bt2 = new BinaryTree();
        bt2.addValue(20);
        bt2.addValue(10);
        bt2.addValue(30);
        bt2.addValue(8);
        bt2.addValue(15);
        bt2.addValue(9);
        assertTrue(bt2.isBinarySearchTree());
        bt2.changeNodeValue(9,12);
        assertFalse(bt2.isBinarySearchTree());
    }

}
