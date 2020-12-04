package com.dusinski.AdventOfCode.Day4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PassportCheck {

    private final List<String> passportsList;

    public PassportCheck(List<String> inputList) {
        this.passportsList = inputList;
    }

    private boolean getPassportFromString(String str) {
        Passport passport = new Passport();
        Map<String, String> passKeyValueMap = new HashMap<>();

        String[] passElements = str.split(" ");

        for (String element : passElements) {
            String[] passKeyValue = element.split(":");
            passKeyValueMap.put(passKeyValue[0], passKeyValue[1]);
        }

        boolean isValid = Passport.checkECL(passKeyValueMap.get("ecl")) &&
                Passport.isIYRvalid(passKeyValueMap.get("iyr")) &&
                Passport.isBYRvalid(passKeyValueMap.get("byr")) &&
                Passport.isEYRvalid(passKeyValueMap.get("eyr")) &&
                Passport.isHeightValid(passKeyValueMap.get("hgt")) &&
                Passport.isPIDvalid(passKeyValueMap.get("pid")) &&
                Passport.isHCLvalid(passKeyValueMap.get("hcl"));
        return isValid;
    }

    private boolean isPassValid(String pass) {

        return pass.contains("byr") &&
                pass.contains("iyr") &&
                pass.contains("eyr") &&
                pass.contains("hgt") &&
                pass.contains("hcl") &&
                pass.contains("ecl") &&
//                pass.contains("cid")&&
                pass.contains("pid")
                ;
    }

    public int howManyPassportIsValid() {
        int passValid = 0;

        for (String str : this.passportsList) {

            if (getPassportFromString(str)) {
                passValid++;
            }
        }
        return passValid;
    }


}
