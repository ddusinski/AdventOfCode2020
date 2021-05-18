package com.dusinski.adventofcode.day21;

import java.util.*;

class AllergenListEntity {
    List<String> foods;
    List<String> allergens;

    public AllergenListEntity(String input) {
        foods = new ArrayList<>();
        allergens = new ArrayList<>();

        String foodsString = input.split(" \\(contains ")[0];
        String allergensString = input.split(" \\(contains ")[1].replaceAll("\\)", "");
//        System.out.println("foodsString: " + foodsString);
//        System.out.println("allergensString: " + allergensString);

        for (String str : foodsString.split(" ")) {
            foods.add(str);
        }
        for (String str : allergensString.split(", ")) {
            allergens.add(str);
        }
    }

    @Override
    public String toString() {
        return "foods=" + foods.toString() + ", allergens=" + allergens.toString();
    }
}


public class AllergenAssessment {


    private final List<String> inputList;
    Comparator<Map.Entry<String, List<String>>> compareMapByListSize = (
            Map.Entry<String, List<String>> m1, Map.Entry<String, List<String>> m2) -> (
            Integer.valueOf(m1.getValue().size()).compareTo(m2.getValue().size())
    );
    Comparator<Map.Entry<String, List<String>>> compareMapKeyValue = (
            Map.Entry<String, List<String>> m1, Map.Entry<String, List<String>> m2) -> (
            m1.getKey().compareTo(m2.getKey())
    );

    public AllergenAssessment(List<String> input) {
        this.inputList = input;
    }

    private Map<String, List<Integer>> getAllergensMap(List<AllergenListEntity> input) {
        Map<String, List<Integer>> allergensMapWithFoodEntitiesNumbers = new HashMap<>();
        List<Integer> listOfAllergenPositions;

        for (int i = 0; i < input.size(); i++) {
            AllergenListEntity entity = input.get(i);
            for (String allergen : entity.allergens) {
                if (!allergensMapWithFoodEntitiesNumbers.containsKey(allergen)) {
                    listOfAllergenPositions = new ArrayList<>();
                } else {
                    listOfAllergenPositions = allergensMapWithFoodEntitiesNumbers.get(allergen);
                }
                listOfAllergenPositions.add(i);
                allergensMapWithFoodEntitiesNumbers.put(allergen, listOfAllergenPositions);
            }
        }
        return allergensMapWithFoodEntitiesNumbers;
    }

    private Map<String, List<String>> genMapFoodWithAllergens(List<AllergenListEntity> allergensEntityList,
                                                              Map<String, List<Integer>> allergensMap) {
        Map<String, List<String>> allergenWithFoodMap = new HashMap<>();

        for (Map.Entry<String, List<Integer>> allergensEntry : allergensMap.entrySet()) {
            List<String> tempListForFood = new ArrayList<>();
            List<String> resultFoodsListForOneAllergen = new ArrayList<>();
            int firstFoodFromAllergenMap = allergensEntry.getValue().get(0);
            List<String> firstFoodListWithAllergen = allergensEntityList.get(firstFoodFromAllergenMap).foods;
            tempListForFood.addAll(firstFoodListWithAllergen);

            for (int i = 1; i < allergensEntry.getValue().size(); i++) {
                int foodFromAllergenMap = allergensEntry.getValue().get(i);
                for (String food : allergensEntityList.get(foodFromAllergenMap).foods) {
                    if (tempListForFood.contains(food)) {
                        resultFoodsListForOneAllergen.add(food);
                    }
                }
                tempListForFood.clear();
                tempListForFood.addAll(resultFoodsListForOneAllergen);
                resultFoodsListForOneAllergen.clear();
            }
            allergenWithFoodMap.put(allergensEntry.getKey(), tempListForFood);
        }
        return allergenWithFoodMap;
    }

    private Map<String, Integer> getCountAllFreeFoods(List<AllergenListEntity> allergensEntityList,
                                                      Map<String, List<String>> foodWithAllergens) {
        Map<String, Integer> foodWithoutAllergenMap = new HashMap<>();
        Set<String> setFoodWithAllergens = new HashSet<>();
        foodWithAllergens.entrySet().forEach(s -> setFoodWithAllergens.addAll(s.getValue()));
        for (AllergenListEntity entity : allergensEntityList) {
            for (String food : entity.foods) {
                if (!setFoodWithAllergens.contains(food)) {
                    if (foodWithoutAllergenMap.containsKey(food)) {
                        int val = foodWithoutAllergenMap.get(food) + 1;
                        foodWithoutAllergenMap.put(food, val);
                    } else {
                        foodWithoutAllergenMap.put(food, 1);
                    }
                }
            }
        }
        return foodWithoutAllergenMap;
    }

    public int getCountOfAllergenFreeFoods() {
        List<AllergenListEntity> aLE = new ArrayList<>();

        for (String s : this.inputList) {
            aLE.add(new AllergenListEntity(s));
        }
//        System.out.println(aLE.toString());
        Map<String, List<Integer>> allergensMap = getAllergensMap(aLE);
//        allergensMap.entrySet().forEach(entry -> System.out.println(entry.getKey() + " | " + entry.getValue()));
        Map<String, List<String>> foodWithAllergens = genMapFoodWithAllergens(aLE, allergensMap);
//        foodWithAllergens.entrySet().forEach(entry -> System.out.println(entry.getKey() + " | " + entry.getValue()));
        Map<String, Integer> allergensFreeFoodMap = getCountAllFreeFoods(aLE, foodWithAllergens);
//        allergensFreeFoodMap.entrySet().forEach(entry -> System.out.println(entry.getKey() + " | " + entry.getValue()));
        return allergensFreeFoodMap.values().stream().reduce(0, (a, b) -> a + b);
    }

    public String getCanonicalDangerousIngredientList() {
        List<AllergenListEntity> aLE = new ArrayList<>();
        for (String s : this.inputList) {
            aLE.add(new AllergenListEntity(s));
        }
        Map<String, List<Integer>> allergensMap = getAllergensMap(aLE);
//        allergensMap.entrySet().forEach(entry -> System.out.println(entry.getKey() + " | " + entry.getValue()));
        Map<String, List<String>> foodWithAllergens = genMapFoodWithAllergens(aLE, allergensMap);
//        foodWithAllergens.entrySet().forEach(entry -> System.out.println(entry.getKey() + " | " + entry.getValue()));
        List<Map.Entry<String, List<String>>> mapListToSort = new ArrayList<Map.Entry<String, List<String>>>(foodWithAllergens.entrySet());
//        System.out.println(mapListToSort);
        Collections.sort(mapListToSort, compareMapByListSize);
//        System.out.println(mapListToSort);
//        System.out.println("Test");


        String firstFood = mapListToSort.get(0).getValue().get(0);
        for (int i = 1; i < mapListToSort.size(); i++) {
            for (int j = i; j < mapListToSort.size(); j++) {
                if ( mapListToSort.get(j).getValue().contains(firstFood)) {
                    mapListToSort.get(j).getValue().remove(firstFood);
                }

            }
//            System.out.println(firstFood+" "+mapListToSort);
            Collections.sort(mapListToSort, compareMapByListSize);
            firstFood = mapListToSort.get(i).getValue().get(0);

        }
//        System.out.println(mapListToSort);
        Collections.sort(mapListToSort, compareMapKeyValue);
//        System.out.println(mapListToSort);

        StringBuilder result = new StringBuilder();
        mapListToSort.forEach(s -> result.append(s.getValue().get(0)).append(","));

        return result.substring(0, result.toString().length() - 1);
    }

}
