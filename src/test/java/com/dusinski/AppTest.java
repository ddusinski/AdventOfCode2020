package com.dusinski;

import com.dusinski.chapter1.ArraysAndStrings;
import com.dusinski.chapter1.BasicStringCompression;
import com.dusinski.chapter1.CheckStringPermutation;
import com.dusinski.chapter1.SpaceReplace;
import com.dusinski.chapter2.LinkedList;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class AppTest {


    @Test
    public void testCheckStringPermutation() {
        CheckStringPermutation csp = new CheckStringPermutation();
        String a = "abcd";
        String b = "dabc";
        assertTrue(csp.checkPermutation(a, b));
        b = "dabcf";
        assertFalse(csp.checkPermutation(a, b));
    }

    @Test
    public void testSpaceReplace() {
        SpaceReplace sr = new SpaceReplace();
        String a = "ab cd";
        assertEquals("ab%20cd", sr.replaceSpace(a));
    }

    @Test
    public void testUniqueCharacterDominikCheck() {
        ArraysAndStrings ars = new ArraysAndStrings();
        assertTrue(ars.uniqueCharactersCheckDominik("abcdefghijklmnoprstw"));
        assertFalse(ars.uniqueCharactersCheckDominik("aabcdefghijklmnoprstw"));

    }

    @Test
    public void testUniqueCharactersCheckBooleanArray() {
        ArraysAndStrings ars = new ArraysAndStrings();
        assertTrue(ars.uniqueCharactersCheckBooleanArray("abcdefghijklmnoprstw"));
        assertFalse(ars.uniqueCharactersCheckBooleanArray("aabcdefghijklmnoprstw"));
    }

    @Test
    public void testBasicStringCompression() {
        BasicStringCompression bsc = new BasicStringCompression();
        assertEquals("a3bc4de3", bsc.compressString("aaabccccdeee"));
    }

    @Test
    public void testLinkedList1() {
        LinkedList testList = new LinkedList();
        testList.appendToTail(36);
        testList.appendToTail(89);
        testList.appendToTail(120);

        assertEquals("36 89 120 ", testList.printList());
        testList.deleteNode(36);
        assertEquals("89 120 ", testList.printList());
    }

    @Test
    public void testLinkedList2() {
        LinkedList testList = new LinkedList();
        testList.appendToTail(36);
        testList.appendToTail(89);
        testList.appendToTail(120);
        testList.appendToTail(89);
        assertEquals("36 89 120 ", testList.printList());
        assertEquals("36 89 ", testList.printList());
    }

    @Test
//    cannot works because is returing System.out instead of String. New method is needed
    public void testFindKnodeFromEnd() {
        LinkedList testList = new LinkedList();
        testList.appendToTail(36);
        testList.appendToTail(8);
        testList.appendToTail(28);
        testList.appendToTail(5);
        System.out.println(testList.printList());
        System.out.println(testList.findKValuefromEnd(2));

        assertEquals(28, testList.findKValuefromEnd(2));
    }

    @Test
    public void testListPartitioning() {
        LinkedList testList = new LinkedList();
        testList.appendToTail(36);
        testList.appendToTail(8);
        testList.appendToTail(28);
        testList.appendToTail(5);
        assertEquals("8 28 5 |36 ", testList.partitionLinkedList(29));
    }

    @Test
    public void testAddTwoLinkedListNumbers() {
        LinkedList testList1 = new LinkedList();
        testList1.appendToTail(1);
        testList1.appendToTail(9);
        LinkedList testList2 = new LinkedList();
        testList2.appendToTail(9);
        testList2.appendToTail(8);
        testList2.appendToTail(7);
        assertEquals("8 8 0 ", LinkedList.addTwoLinkedListNumbers(testList1, testList2));
    }

    @Test
    public void testIsLinkedListCircular() {
        LinkedList testList1 = new LinkedList();
        testList1.appendToTail(1);
        testList1.appendToTail(9);
        testList1.appendToTail(3);
        testList1.appendToTail(5);
        testList1.appendToTail(9);
        testList1.appendToTail(8);
        assertFalse(testList1.isLinkedListCircular());
        testList1.roundLinkedList(2);
        assertTrue(testList1.isLinkedListCircular());
    }

    @Test
    public void testReturnLoopBeginningNode() {
        LinkedList testList1 = new LinkedList();
        testList1.appendToTail(1);
        testList1.appendToTail(9);
        testList1.appendToTail(3);
        testList1.appendToTail(5);
        testList1.appendToTail(7);
        testList1.appendToTail(8);
        System.out.println(testList1.printList());
        testList1.roundLinkedList(4);
        System.out.println(testList1.returnLoopBeginningNode());
        assertEquals(7, testList1.returnLoopBeginningNode());
    }

    @Test
    public void testIsPalindrom() {
        LinkedList testList1 = new LinkedList();
        testList1.appendToTail(1);
        testList1.appendToTail(2);
        testList1.appendToTail(3);
        testList1.appendToTail(2);
        testList1.appendToTail(1);
        assertTrue(testList1.isPalindrome());
        testList1.appendToTail(8);
        assertFalse(testList1.isPalindrome());
    }

    @Test
    public void testIsPalindrom2() {
        LinkedList testList1 = new LinkedList();
        testList1.appendToTail(1);
        testList1.appendToTail(2);
        testList1.appendToTail(3);
        testList1.appendToTail(2);
        testList1.appendToTail(1);
        assertTrue(testList1.isPalindrome2());
        testList1.appendToTail(8);
        assertFalse(testList1.isPalindrome2());
    }


}
