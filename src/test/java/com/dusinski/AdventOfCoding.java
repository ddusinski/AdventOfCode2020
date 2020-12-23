package com.dusinski;

import com.dusinski.AdventOfCode.Day10.AdapterArray;
import com.dusinski.AdventOfCode.Day11.SeatingSystem;
import com.dusinski.AdventOfCode.Day12.NavigationInstructions;
import com.dusinski.AdventOfCode.Day14.DockingData;
import com.dusinski.AdventOfCode.Day15.RambunctiousRecitation;
import com.dusinski.AdventOfCode.Day16.TicketTranslation;
import com.dusinski.AdventOfCode.Day17.ConwayCubes;
import com.dusinski.AdventOfCode.Day17.ConwayCubes4Dimensions;
import com.dusinski.AdventOfCode.Day18.OperationOrder;
import com.dusinski.AdventOfCode.Day18.OperationOrderDiffPrecedence;
import com.dusinski.AdventOfCode.Day19.MonsterMessages;
import com.dusinski.AdventOfCode.Day20.JurassicJigsaw;
import com.dusinski.AdventOfCode.Day21.AllergenAssessment;
import com.dusinski.AdventOfCode.Day22.CrabCombat;
import com.dusinski.AdventOfCode.Day22.RecursiveCrabCombat;
import com.dusinski.AdventOfCode.Day3.TobogganMap;
import com.dusinski.AdventOfCode.Day4.PassportCheck;
import com.dusinski.AdventOfCode.Day5.BinaryPlaneBoarding;
import com.dusinski.AdventOfCode.Day6.CustomCustoms;
import com.dusinski.AdventOfCode.Day7.HandyHaversacksCheck;
import com.dusinski.AdventOfCode.Day8.HandheldHalting;
import com.dusinski.AdventOfCode.Day9.EncodingError;
import com.dusinski.AdventOfCode.GetInput;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AdventOfCoding {

    //        PassPolicyCheck psc= PassPolicyCheck.getInstance();
//        psc.readFile();
//        System.out.println("right passes: "+psc.checkPolicy());

//        List<Integer> intList = Arrays.asList(1,2,3,4);
//        Consumer<Integer> cns=p->System.out.println(p.toString());
////        intList.forEach(System.out::println);
//        intList.stream()
//                .filter(t->t>1)
//                .filter(t->t<4)
//                .forEach(cns);


    //        int[] testArray = {15,14,13,12,11,10,9,8,7, 6, 5, 4, 3, 2, 1};
//        System.out.println(Arrays.stream(testArray).boxed().collect(Collectors.toList()));
//        testArray(testArray);
//        System.out.println(Arrays.stream(testArray).boxed().collect(Collectors.toList()));

    @Test
    public void Day3TobogganMapCheck() {
        GetInput gi = new GetInput();
        List<String> test = gi.getInputAsStringArray("day3tobogganMap.txt");
        TobogganMap tm = new TobogganMap(test);
        Map<String, Long> result = new HashMap<>();
        result.put("1,1", (long) tm.countTreeOnTheWay(1, 1));
        result.put("1,3", (long) tm.countTreeOnTheWay(1, 3));
        result.put("1,5", (long) tm.countTreeOnTheWay(1, 5));
        result.put("1,7", (long) tm.countTreeOnTheWay(1, 7));
        result.put("2,1", (long) tm.countTreeOnTheWay(2, 1));
        assertEquals(2698900776L, (long) result.values().stream().reduce((long) 1, (a, b) -> a * b));

        //        test.forEach(System.out::println);
//        result.entrySet().stream().forEach(System.out::println);
    }

    @Test
    public void day4PassportCheck() {
        GetInput gi = new GetInput();
        List<String> test = gi.getPassFileAsStringArray("day4PassportList.txt");
        PassportCheck pc = new PassportCheck(test);
        assertEquals(147, pc.howManyPassportIsValid());
    }

    @Test
    public void day5FindMaxBoardingId() {
        GetInput gi = new GetInput();
        List<String> test = gi.getInputAsStringArray("day5binaryBoarding.txt");
        BinaryPlaneBoarding bpb = new BinaryPlaneBoarding(test);
        assertEquals(926, bpb.findMaxBoardingID());
    }

    @Test
    public void findEmptySeatId() {
        GetInput gi = new GetInput();
        List<String> test = gi.getInputAsStringArray("day5binaryBoarding.txt");
        BinaryPlaneBoarding bpb = new BinaryPlaneBoarding(test);
        assertEquals(657, bpb.findEmptySeatsID());

    }

    @Test
    public void testGetCustomAnswersCount() {
        GetInput gi = new GetInput();
        List<String> test = gi.getPassFileAsStringArray("day6customList.txt");
        CustomCustoms cc = new CustomCustoms(test);
        assertEquals(6778, cc.getAnswersCount());
    }

    @Test
    public void tstGetEveryCustomAnswerCount() {
        GetInput gi = new GetInput();
        List<String> test = gi.getPassFileAsStringArray("day6customList.txt");
        CustomCustoms cc = new CustomCustoms(test);
        assertEquals(3406, cc.getEveryAnswersCount());
    }

    @Test
    public void testHandyHaversacksColorsCheck() {
        GetInput gi = new GetInput();
        List<String> test = gi.getInputAsStringArray("day7handyHaversacksRules.txt");
        HandyHaversacksCheck hhc = new HandyHaversacksCheck(test);
        assertEquals(287, hhc.getPossibleBagColors());

    }

    @Test
    public void testHandyHaversacksCountCheck() {
        GetInput gi = new GetInput();
        List<String> test = gi.getInputAsStringArray("day7handyHaversacksRules.txt");
        HandyHaversacksCheck hhc = new HandyHaversacksCheck(test);
        assertEquals(48160, hhc.getBagsAmount());
    }

    @Test
    public void testHandheldHaltingAccBeforeStop() {
        GetInput gi = new GetInput();
        List<String> test = gi.getInputAsStringArray("day8HandheldHaltingGame.txt");
        HandheldHalting hh = new HandheldHalting(test);
        assertEquals(1501, hh.getAccBeforeHandStop());
    }

    @Test
    public void testHandheldHaltingWhenAppCorrect() {
        GetInput gi = new GetInput();
        List<String> test = gi.getInputAsStringArray("day8HandheldHaltingGame.txt");
        HandheldHalting hh = new HandheldHalting(test);
        assertEquals(509, hh.getAccWhenAppCorrected());
    }

    @Test
    public void testgetFirstNotMatchingNumber() {
        GetInput gi = new GetInput();
        List<String> test = gi.getInputAsStringArray("day9EncodingError.txt");
        EncodingError ee = new EncodingError(test);
        assertEquals(1038347917, ee.getFirstNotMatchingNumber(25));
    }

    @Test
    public void testgetEdgeSumOfInvValue() {
        GetInput gi = new GetInput();
        List<String> test = gi.getInputAsStringArray("day9EncodingError.txt");
        EncodingError ee = new EncodingError(test);
        int valWithoutSum = ee.getFirstNotMatchingNumber(25);
        assertEquals(137394018, ee.getEdgeSumOfInvValue(valWithoutSum));
    }

    @Test
    public void testGetOneAndThreeDiffProduct() {
        GetInput gi = new GetInput();
        List<String> test = gi.getInputAsStringArray("day10AdapterArray.txt");
        AdapterArray aa = new AdapterArray(test);
        assertEquals(2574, aa.getOneAndThreeDiffProduct());
    }

    @Test
    public void testCheckDistinctArrangements() {
        GetInput gi = new GetInput();
        List<String> test = gi.getInputAsStringArray("day10AdapterArray.txt");
        AdapterArray aa = new AdapterArray(test);
        assertEquals(2644613988352L, (long) aa.checkDistinctArrangements());
    }

    @Test
    public void testSeatingSystemGetOccupiedSeatsWithNoChange() {
        GetInput gi = new GetInput();
        List<String> test = gi.getInputAsStringArray("day11SeatingSystem.txt");
        SeatingSystem ss = new SeatingSystem(test);
        assertEquals(2273, ss.getOccupiedSeatsWithNoChange());
    }

    @Test
    public void testSeatingSystemGetOccupiedSeatsEachDirection() {
        GetInput gi = new GetInput();
        List<String> test = gi.getInputAsStringArray("day11SeatingSystem.txt");
        SeatingSystem ss = new SeatingSystem(test);
        assertEquals(2064, ss.getOccupiedSeatsEachDirection());
    }

    @Test
    public void testNavigationInstructionsGetManhattanDistance() {
        GetInput gi = new GetInput();
        List<String> test = gi.getInputAsStringArray("day12navigationInstructions.txt");
        NavigationInstructions ni = new NavigationInstructions(test);
        assertEquals(2847, ni.getManhattanDistance());
    }

    @Test
    public void testNavigationInstructionsGetManhattanDistanceIndependentCoordinates() {
        GetInput gi = new GetInput();
        List<String> test = gi.getInputAsStringArray("day12navigationInstructions.txt");
        NavigationInstructions ni = new NavigationInstructions(test);
        assertEquals(29839, ni.getManhattanDistanceIndependentCoordinates());
    }


    @Test
    public void testDockingDataPart1() {
        GetInput gi = new GetInput();
        List<String> test = gi.getInputAsStringArray("day14dockingData.txt");
        DockingData dd = new DockingData(test);
        assertEquals(14553106347726L, dd.sumOfValuesAfterProgInit());
    }

    @Test
    public void testDockingDataPart2() {
        GetInput gi = new GetInput();
        List<String> test = gi.getInputAsStringArray("day14dockingData.txt");
        DockingData dd = new DockingData(test);
        assertEquals(2737766154126L, dd.getMemoryAccessDecoderSum());
    }

    @Test
    public void testRambunctiousRecitationPart1(){
        GetInput gi = new GetInput();
        List<String> test = gi.getInputAsStringArray("day15rambunctiousRecitation.txt");
        RambunctiousRecitation rr =new RambunctiousRecitation(test);
        assertEquals(1618,rr.get200thElementOfRecitation(2020));
    }
    @Test
    public void testRambunctiousRecitationPart2(){
        GetInput gi = new GetInput();
        List<String> test = gi.getInputAsStringArray("day15rambunctiousRecitation.txt");
        RambunctiousRecitation rr =new RambunctiousRecitation(test);
        assertEquals(548531,rr.get200thElementOfRecitation(30000000));
    }

    @Test
    public void testTicketTranslationPar1(){
        GetInput gi = new GetInput();
        List<String> test = gi.getInputAsStringArray("day16ticketTranslation.txt");
        TicketTranslation tt = new TicketTranslation(test);
        assertEquals(22057,tt.getTicketErrorRate());
    }

    @Test
    public void testTicketTranslationPar2(){
        GetInput gi = new GetInput();
        List<String> test = gi.getInputAsStringArray("day16ticketTranslation.txt");
        TicketTranslation tt = new TicketTranslation(test);
        assertEquals(1093427331937L,tt.getDepartureClassesProduct());
    }

    @Test
    public void testConwayCubes(){
        GetInput gi = new GetInput();
        List<String> test = gi.getInputAsStringArray("day17conwayCubes.txt");
        ConwayCubes cc = new ConwayCubes(test);
        assertEquals(257, cc.activeLeftAfter6Cycles());
    }
    @Test
    public void testConwayCubes4Dimensions(){
        GetInput gi = new GetInput();
        List<String> test = gi.getInputAsStringArray("day17conwayCubes.txt");
        ConwayCubes4Dimensions cc = new ConwayCubes4Dimensions(test);
        assertEquals(2532, cc.activeLeftAfter6Cycles());
    }

    @Test
    public void testOperationalOrderOnlyPart1(){
        GetInput gi = new GetInput();
        List<String> test = gi.getInputAsStringArray("day18operationOrder.txt");
        OperationOrder oo = new OperationOrder(test);
        assertEquals(3885386961962L,oo.computeExpression());

//        Lets do the second part but in more ordered way

    }


    @Test
    public void testMonsterMessagesOnlyPart1(){
        GetInput gi = new GetInput();
        List<String> test = gi.getInputAsStringArray("day19monsterMessages.txt");
        MonsterMessages mm =new MonsterMessages(test);
        assertEquals(241, mm.matchesMessagesCount());
    }

    @Test
    public void testJurassicJigsawPart1(){
        GetInput gi = new GetInput();
        List<String> test = gi.getInputAsStringArray("day20_JurassicJigsaw.txt");
        JurassicJigsaw jj = new JurassicJigsaw(test);
        assertEquals(16937516456219L, jj.getCornersProduct());
    }

    @Test
    public void testCrabCombatPart1(){
        GetInput gi = new GetInput();
        List<String> test = gi.getInputAsStringArray("day22crabCombat.txt");
        CrabCombat cc =new CrabCombat(test);
        assertEquals(34324, cc.winningPlayerScores());
    }

    @Test
    public void testCrabCombatPart2(){
        GetInput gi = new GetInput();
        List<String> test = gi.getInputAsStringArray("day22crabCombat.txt");
        RecursiveCrabCombat ccr =new RecursiveCrabCombat(test);
        assertEquals(33259, ccr.winningPlayerScores());
    }


    @Test
    public void testAllergenAssessmentPart1(){
        GetInput gi = new GetInput();
        List<String> test = gi.getInputAsStringArray("day21allergenAssessment.txt");
        AllergenAssessment aa = new AllergenAssessment(test);
        assertEquals(2410,aa.getCountOfAllergenFreeFoods());
    }

    @Test
    public void testAllergenAssessmentPart2(){
        GetInput gi = new GetInput();
        List<String> test = gi.getInputAsStringArray("day21allergenAssessment.txt");
        AllergenAssessment aa = new AllergenAssessment(test);
        assertEquals("tmp,pdpgm,cdslv,zrvtg,ttkn,mkpmkx,vxzpfp,flnhl", aa.getCanonicalDangerousIngredientList());
    }


}
