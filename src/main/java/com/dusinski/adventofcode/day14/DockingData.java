package com.dusinski.adventofcode.day14;

import java.util.*;

public class DockingData {
    List<String> dockingDataList;

    public DockingData(List<String> input) {
        this.dockingDataList = input;
    }


    public long sumOfValuesAfterProgInit() {
        Map<Integer, Long> valuesMap = new HashMap<>();
        long mask = 0;
        long oneMask = 0;

        for (String str : this.dockingDataList) {
            if (str.contains("mask")) {
                mask = Long.parseLong(str.substring(7).replaceAll("X", "0"), 2);
                oneMask = Long.parseLong(str.substring(8)
                                .replaceAll("1", "X")
                                .replaceAll("0", "1")
                                .replaceAll("X", "0")
                        , 2);
//                System.out.println(str + "|" + mask);
            }
            if (str.contains("mem")) {
                str = str.replaceAll(" ", "");
                long input = Long.valueOf(str.split("=")[1]);
                int memPosition = Integer.valueOf(str.split("=")[0].replaceAll("mem\\[", "").replaceAll("\\]", ""));

                long bitwise = mask | input;
                long bitwise2 = -(oneMask & input);

                valuesMap.put(memPosition, bitwise + bitwise2);
            }

        }
//        valuesMap.entrySet().forEach(entry -> System.out.println(entry.getKey() + "|" + entry.getValue()));
        return valuesMap.values().stream().reduce(0L, Long::sum);
    }

    private List<Long> getFloatingMemoryAddressList(String mask) {
        List<String> floatingList = new ArrayList<>();
        List<String> tempBitList = new ArrayList<>();
        List<Long> result = new ArrayList<>();

        Character bit = mask.charAt(0);
        if (bit == '1') {
            floatingList.add("1");
        } else if (bit == '0') {
            floatingList.add("0");
        } else {
            floatingList.add("1");
            floatingList.add("0");
        }

        for (int i = 1; i < mask.length(); i++) {
            tempBitList.clear();
            tempBitList.addAll(floatingList);
            floatingList.clear();
            bit = mask.charAt(i);
            if (bit == 'X') {
                for (String str : tempBitList) {
                    floatingList.add(str + "0");
                    floatingList.add(str + "1");
                }
            } else if (bit == '1') {
                for (String str : tempBitList) {
                    floatingList.add(str + "1");
                }
            } else if (bit == '0') {
                for (String str : tempBitList) {
                    floatingList.add(str + "0");
                }
            }
        }
        for (String str : floatingList) {
            result.add(Long.parseLong(str, 2));
        }
        return result;
    }


    public long getMemoryAccessDecoderSum() {
        Map<Long, Long> valuesMap = new HashMap<>();
        List<Long> permutationList = new LinkedList<>();
        long zeroMask = 0;

        for (String str : this.dockingDataList) {
            if (str.contains("mask")) {

                permutationList = getFloatingMemoryAddressList(str.substring(7));
                zeroMask = Long.parseLong(str.substring(7)
                                .replaceAll("1", "X")
                                .replaceAll("0", "1")
                                .replaceAll("X", "0")
                        , 2);
            }
            if (str.contains("mem")) {
                str = str.replaceAll(" ", "");
                long input = Long.valueOf(str.split("=")[1]);
                int memPosition = Integer.valueOf(str.split("=")[0].replaceAll("mem\\[", "").replaceAll("\\]", ""));
                for (Long permutationMask : permutationList) {
                    long newMemoryAddress=((zeroMask & memPosition) | permutationMask);
                    valuesMap.put(newMemoryAddress,input);

                }
            }
        }
//        valuesMap.entrySet().forEach(entry -> System.out.println(entry.getKey() + "|" + entry.getValue()));
        return valuesMap.values().stream().reduce(0L, Long::sum);
    }


}
