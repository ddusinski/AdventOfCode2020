package com.dusinski.adventofcode.day4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

enum Ecl {
    amb, blu, brn, gry, grn, hzl, oth
};

public class Passport {
    Ecl personECL;
    int passPID;
    int expirationEYR;
    String hariColorHCL;
    int birthYearBYR;
    int issueYearIYR;
    int countryCID;
    String heightHGT;

    public static boolean checkECL(String inputECL){
        if (inputECL==null){
            return false;
        }
        return inputECL.equals("amb")||inputECL.equals("blu")||inputECL.equals("brn")||inputECL.equals("gry")||
                inputECL.equals("grn")||inputECL.equals("hzl")||inputECL.equals("oth");
    }
    public static boolean isBYRvalid(String input){
        return checkYear(input,1920,2002);
    }
    public static boolean isIYRvalid(String input){
        return checkYear(input,2010,2020);
    }
    public static boolean isEYRvalid(String input){
        return checkYear(input,2020,2030);
    }

    private static boolean checkYear(String y, int min, int max){
        if (y==null){
            return false;
        }
        int year = Integer.parseInt(y);
        return  (year>=min&&year<=max);
    }

    public  static boolean isHeightValid(String input){
        if (input==null){
            return false;
        }
        if (!(input.contains("cm")||input.contains("in"))){
            return false;
        }
        int height = Integer.parseInt(input.substring(0, input.length()-2));
        String unit = input.substring(input.length()-2);
        if (unit.equals("cm")&&height>=150&&height<=193){
            return true;
        }
        if (unit.equals("in")&&height>=59&&height<=76){
            return true;
        }
        return false;
    }

    public static boolean isPIDvalid(String input){
        if (input==null){
            return false;
        }
        if (input.matches("[0-9]{9}")){
            return  true;
        }
        return false;
    }

    public static boolean isHCLvalid(String input){
        if (input==null){
            return false;
        }
        Pattern pattern =Pattern.compile("#[0-9a-f]{5}");

        Matcher matcher =pattern.matcher(input);
        return matcher.find();
    }


//    ecl:gry pid:860033327 eyr:2020 hcl:#fffffd
//    byr:1937 iyr:2017 cid:147 hgt:183cm
}
