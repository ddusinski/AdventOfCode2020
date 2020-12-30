package com.dusinski.AdventOfCode.Day25;

import java.util.List;

public class ComboBreaker {

    private final List<String> inputList;

    public ComboBreaker(List<String> input) {
        this.inputList = input;
    }

    private long findLoopSize(long inputPublicKey) {
        long loopSize = 0;
        long subjectNumber = 7;
        long value = 1;
        while (value != inputPublicKey) {
            value = value * subjectNumber;
            value = value % 20201227L;
            loopSize++;
        }
        return loopSize;
    }

    private long transformPrivateKey(long loopSize, long privateKey){
        long subjectNumber = privateKey;
        long value = 1;
        for (long i=0;i<loopSize;i++){
            value=value*subjectNumber;
            value=value % 20201227L;
        }
        return value;
    }

    public long getEncryptionKey() {
        long cardPublicKey = Long.valueOf(this.inputList.get(0));
        long doorPublicKey = Long.valueOf(this.inputList.get(1));
        return transformPrivateKey(findLoopSize(cardPublicKey),doorPublicKey);
    }


}
