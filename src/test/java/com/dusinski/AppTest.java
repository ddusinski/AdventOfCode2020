package com.dusinski;

import com.dusinski.chapter1.ArraysAndStrings;
import com.dusinski.chapter1.BasicStringCompression;
import com.dusinski.chapter1.CheckStringPermutation;
import com.dusinski.chapter1.SpaceReplace;
import com.dusinski.chapter2.LinkedList;
import com.dusinski.chapter3.ArrayStack;
import com.dusinski.chapter3.SetOfStacks;
import com.dusinski.chapter3.StackWithMin;
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

    @Test
    public void testStackWithMin(){
        StackWithMin swm= new StackWithMin();
        swm.push(4);
        swm.push(3);
        swm.push(2);
        swm.push(1);
        assertEquals(1,swm.min());
        swm.pop();
        swm.pop();
        swm.toString();
        assertEquals(3,swm.min());
    }

    @Test
    public void testArrayStack(){
        ArrayStack as = new ArrayStack();
        as.push1(1);
        as.push1(2);
        as.push1(3);
        as.push2(4);
        as.push2(5);
        as.push2(6);
        as.push3(7);
        as.push3(8);
        as.push3(9);
        as.push3(10);

        assertEquals("1 2 3 4 5 6 7 8 9 10 ",as.printArray());
        as.pop1();
        as.pop2();
        as.pop3();
        assertEquals("1 2 0 4 5 0 7 8 9 0 ",as.printArray());
        as.pop1();
        as.pop2();
        as.pop3();
        assertEquals("1 0 0 4 0 0 7 8 0 0 ",as.printArray());
    }

    @Test
    public void checkSetOfStacks(){
        SetOfStacks sof = new SetOfStacks();
        sof.push(1);
        sof.push(2);
        sof.push(3);
        sof.push(4);
        sof.push(5);
        sof.push(6);
        sof.push(7);
        sof.push(8);
        sof.push(9);
        sof.push(10);
        assertEquals("2 1 \n" +"4 3 \n"+"6 5 \n"+"8 7 \n"+"10 9 \n",sof.printAll());
        sof.popAt(1);
        assertEquals("2 1 \n"+"5 3 \n"+"7 6 \n"+"9 8 \n"+"10 \n",sof.printAll());
    }


}
