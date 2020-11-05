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
//        testList.deleteNode(120);
        assertEquals("36 89 ", testList.printList());
    }

}
