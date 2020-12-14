package com.dusinski.AdventOfCode.Day13;

import java.util.*;

public class ShuttleSearch {
    List<String> shuttleInstructions;

    public ShuttleSearch(List<String> input) {
        this.shuttleInstructions = input;
    }

    private int findDeparture(int startTime, int busNumber) {
        int mod = startTime % busNumber;
        return startTime + busNumber - mod;

    }


    public int findEarliestBusTimesTimeToWait() {
        int startTime = Integer.valueOf(this.shuttleInstructions.get(0));
        int nextDepartureTime = Integer.MAX_VALUE;
        int nextDepartureBusNumber = -1;
        int departureTime = -1;
        String[] busList = this.shuttleInstructions.get(1).split(",");
        for (int i = 0; i < busList.length; i++) {
            if (!busList[i].equals("x")) {
                int busNumber = Integer.valueOf(busList[i]);
                departureTime = findDeparture(startTime, busNumber);

                if (departureTime < nextDepartureTime) {
                    nextDepartureTime = departureTime;
                    nextDepartureBusNumber = busNumber;
                    System.out.println("start time: " + startTime + " bus number: " + busNumber + " nearest dep: " + findDeparture(startTime, busNumber));
                }
            }
        }

//        System.out.println(Arrays.asList(busList).toString());
        System.out.println("StartTime: " + startTime + "|departure time: " + nextDepartureTime + " nextBus: " + nextDepartureBusNumber);
        return nextDepartureBusNumber * (nextDepartureTime - startTime);
    }

    private boolean isTimeFitting(long multiplier, Map<Integer, Integer> busMap, List<Integer> sortedBusesDESC) {

        long mainStartTime = multiplier * sortedBusesDESC.get(0);
        long diffFromMainStartTime = busMap.get(sortedBusesDESC.get(0));
        boolean resultCheck = false;

        for (int i = 1; i < sortedBusesDESC.size(); i++) {
            long currentStarTime = mainStartTime + busMap.get(sortedBusesDESC.get(i)) - diffFromMainStartTime;
            if (currentStarTime % sortedBusesDESC.get(i) != 0) {
//                System.out.println("bus: "+sortedBusesDESC.get(i)+" currentStartTime"+currentStarTime);
                return false;
            }
        }

        return true;
    }

    public long findFirstCommonStartTime() {
        String[] busList = this.shuttleInstructions.get(1).split(",");
        Map<Integer, Integer> busMap = new HashMap<>();
        Map<Integer, Integer> reversedBusMap = new HashMap<>();
        for (int i = 0; i < busList.length; i++) {
            int value = busList[i].equals("x") ? -1 : Integer.valueOf(busList[i]);
            if (value != -1) {
                reversedBusMap.put(value, i);
                busMap.put(i, value);
            }
        }
        List<Integer> sortedBusList = new LinkedList(busMap.values());
        Collections.sort(sortedBusList, Collections.reverseOrder());

        long multiplier = 155520995334L;
        long counter=0;
        while (!isTimeFitting(multiplier, reversedBusMap, sortedBusList)) {
            multiplier++;
            counter++;
            if (counter - 1 == Integer.MAX_VALUE) {
                System.out.println(multiplier);
                counter=0;
            }
        }


//        reversedBusMap.entrySet().forEach(entry -> System.out.println(entry.getKey() + "|" + entry.getValue()));
//        System.out.println(sortedBusList);

        long resultTime = multiplier * sortedBusList.get(0) - reversedBusMap.get(sortedBusList.get(0));

        return resultTime;
    }

}
