package com.dusinski.adventofcode.day16;

import java.util.*;

public class TicketTranslation {


    private final List<String> ticketFieldsList;
    private Map<String, Set<Integer>> rulesMap;
    private List<List<Integer>> nearbyTicketsList;
    private List<Integer> myTicket;

    public TicketTranslation(List<String> input) {
        this.ticketFieldsList = input;
    }

    private Set<Integer> readRule(String ruleString) {
        ruleString = ruleString.replaceAll(" ", "");
        String[] array = ruleString.split(":");
        String[] setEdgesArray = array[1].split("or");
        Set<Integer> valuesSet = new HashSet<>();
        for (String edge : setEdgesArray) {
            int start = Integer.valueOf(edge.split("-")[0]);
            int end = Integer.valueOf(edge.split("-")[1]);
            for (int i = start; i <= end; i++) {
                valuesSet.add(i);
            }
        }
        return valuesSet;
    }

    private List<Integer> readNearbyTicket(String ticket) {
        List<Integer> valueSet = new LinkedList<>();
        String[] ticketArray = ticket.split(",");
        for (String ticketVal : ticketArray) {
            valueSet.add(Integer.valueOf(ticketVal));
        }
        return valueSet;
    }


    private void loadData() {
        rulesMap = new LinkedHashMap<>();
        nearbyTicketsList = new LinkedList<>();
        myTicket = new LinkedList<>();

        int readerPosition = 0;
        String line = this.ticketFieldsList.get(readerPosition);

        while (!line.isEmpty()) {
            rulesMap.put(line.split(":")[0], readRule(line));
            readerPosition++;
            line = this.ticketFieldsList.get(readerPosition);
        }

        while (!line.equals("your ticket:")) {
            readerPosition++;
            line = this.ticketFieldsList.get(readerPosition);
        }
        readerPosition++;
        this.myTicket = readNearbyTicket(this.ticketFieldsList.get(readerPosition));


        while (!line.equals("nearby tickets:")) {
            readerPosition++;
            line = this.ticketFieldsList.get(readerPosition);
        }
        readerPosition++;

        while (readerPosition < this.ticketFieldsList.size()) {
            line = this.ticketFieldsList.get(readerPosition);
            this.nearbyTicketsList.add(readNearbyTicket(line));
            readerPosition++;
        }

//        rulesMap.entrySet().forEach(entry -> System.out.println(entry.getKey() + "|" + entry.getValue()));
//        nearbyTicketsList.forEach(System.out::println);
//        myTicket.forEach(System.out::println);
    }


    public int getTicketErrorRate() {
        loadData();
        Set<Integer> jointClassesSet = new HashSet<>();
        for (Map.Entry<String, Set<Integer>> entry : this.rulesMap.entrySet()) {
            jointClassesSet.addAll(entry.getValue());
        }

        int ticketScanningErrorRate = 0;
        for (List<Integer> set : this.nearbyTicketsList) {
            for (Integer val : set) {
                if (!jointClassesSet.contains(val)) {
                    ticketScanningErrorRate += val;
                }
            }
        }

//        System.out.println("elements: " + this.nearbyTicketsList.size());
        return ticketScanningErrorRate;
    }


    private List<Set<Integer>> genColumns(List<List<Integer>> rows) {
        int columns = rows.get(0).size();
        List<Set<Integer>> result = new LinkedList<>();

        for (int i = 0; i < columns; i++) {
            Set<Integer> temp = new TreeSet<>();
            for (List<Integer> currentRow : rows) {
                temp.add(currentRow.get(i));
            }
            result.add(temp);
        }
        return result;
    }

    private long classToRemove(List<Set<Integer>> columnsValues, Map<String, Set<Integer>> inputRulesMap,
                               List<Integer> myTicket) {
        Map<String, List<Integer>> toRemove = new TreeMap<>();
        long departureProduct = 1L;
        while (inputRulesMap.size() > 0) {
            toRemove.clear();
            for (Map.Entry<String, Set<Integer>> rulesMapEntry : inputRulesMap.entrySet()) {
                for (Set<Integer> currentColumn : columnsValues) {
                    if (rulesMapEntry.getValue().containsAll(currentColumn)) {
                        if (toRemove.containsKey(rulesMapEntry.getKey())) {
                            List<Integer> val = toRemove.get(rulesMapEntry.getKey());
                            val.add(columnsValues.indexOf(currentColumn));
                            toRemove.put(rulesMapEntry.getKey(), val);
                        } else {
                            List<Integer> val = new ArrayList<>();
                            val.add(columnsValues.indexOf(currentColumn));
                            toRemove.put(rulesMapEntry.getKey(), val);
                        }
                    }
                }
            }

            for (Map.Entry<String, List<Integer>> listOfColumns : toRemove.entrySet()) {
                if (listOfColumns.getValue().size() == 1) {
                    if (listOfColumns.getKey().contains("departure")) {
                        departureProduct *= myTicket.get(listOfColumns.getValue().get(0));
                    }
                    int elementToDelete = listOfColumns.getValue().get(0);
                    myTicket.remove(elementToDelete);

                    inputRulesMap.remove(listOfColumns.getKey());
                    Set<Integer> setToDelete = columnsValues.get(listOfColumns.getValue().get(0));
                    columnsValues.remove(setToDelete);

                }
            }
        }
//        inputRulesMap.entrySet().forEach(entry -> System.out.println(entry.getKey() + "|" + entry.getValue()));
        return departureProduct;
    }


    public long getDepartureClassesProduct() {
        loadData();

        Set<Integer> jointClassesSet = new HashSet<>();
        for (Map.Entry<String, Set<Integer>> entry : this.rulesMap.entrySet()) {
            jointClassesSet.addAll(entry.getValue());
        }

//        deleting wrong tickets
        ListIterator<List<Integer>> iterator = this.nearbyTicketsList.listIterator();
        while (iterator.hasNext()) {
            for (Integer val : iterator.next()) {
                if (!jointClassesSet.contains(val)) {
                    iterator.remove();
                }
            }
        }
//        adding my ticket
        this.nearbyTicketsList.add(this.myTicket);


//        list of sets which contains all values in one column
        List<Set<Integer>> columnsValues = genColumns(this.nearbyTicketsList);

        return classToRemove(columnsValues, this.rulesMap, myTicket);
    }

}
