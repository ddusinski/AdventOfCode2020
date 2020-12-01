package com.dusinski.Java8Lambda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

@FunctionalInterface
interface InterfaceCalculation{
    int calculation(int a, int b );

     static public String join (String a, String b){
        return  a+b;
    }
}

public class LambdaExpressions {

    InterfaceCalculation add = (a, b) -> a + b;
    InterfaceCalculation subtract = (a, b) -> a - b;


    public LambdaExpressions() {
        Map<String,InterfaceCalculation> calcMap = new HashMap<>();

        calcMap.put("+",(a, b) -> a + b);
        calcMap.put("-",(a, b) -> a - b);
        calcMap.put("/",(a, b) -> a / b);
        calcMap.put("*",(a, b) -> a * b);


        System.out.println("+ "+calcMap.get("+").calculation(12,6));
        System.out.println("- "+calcMap.get("-").calculation(12,6));
        System.out.println(InterfaceCalculation.join("str1","str2"));

        BiConsumer<Double, Double> biConsumer = (x, y) -> {
            System.out.println("Dodawanie: " + (x + y));
        };


        }

    public void testList(){
        List<String> stringList = new ArrayList<>();
        stringList.add("jeden");
        stringList.add("dwa");
        stringList.add("trzy");
        stringList.add("cztery");
        stringList.replaceAll((s -> s.toUpperCase()+s.length()));
        System.out.println(stringList.toString());
        stringList.removeIf(s->s.equals("DWA"));
        System.out.println(stringList.toString());
    }

}
