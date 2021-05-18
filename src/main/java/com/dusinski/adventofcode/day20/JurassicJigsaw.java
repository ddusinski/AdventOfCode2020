package com.dusinski.adventofcode.day20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Tile {
    public int tileNumber;
    public String[] tileBody;
    public int[] hashTagArray;
    public int[] invertedHashTagArray;

    public Tile(int number, String[] body) {
        this.tileNumber = number;
        this.tileBody = body;
        this.hashTagArray = fillHashtags();
        this.invertedHashTagArray = fillInvertedHashtags();
    }

    public boolean hasValue(int val) {
        return val == hashTagArray[0] || val == hashTagArray[1] || val == hashTagArray[2] || val == hashTagArray[3]
                || val == invertedHashTagArray[0] || val == invertedHashTagArray[1] || val == invertedHashTagArray[2]
                || val == invertedHashTagArray[3]
                ;
    }

    public boolean isCorner(List<Tile> input) {
        boolean fitTop = false;
        boolean fitRight = false;
        boolean fitBottom = false;
        boolean fitLeft = false;

        for (Tile inputTile : input) {
            fitTop = fitTop || inputTile.hasValue(hashTagArray[0]) || inputTile.hasValue(invertedHashTagArray[0]);
            fitRight = fitRight || inputTile.hasValue(hashTagArray[1]) || inputTile.hasValue(invertedHashTagArray[1]);
            fitBottom = fitBottom || inputTile.hasValue(hashTagArray[2]) || inputTile.hasValue(invertedHashTagArray[2]);
            fitLeft = fitLeft || inputTile.hasValue(hashTagArray[3]) || inputTile.hasValue(invertedHashTagArray[3]);
        }
        if (fitTop && fitRight && fitBottom && fitLeft) {
            return false;
        } else return ((fitTop && fitRight) && !(fitBottom || fitLeft)) ||
                ((fitTop && fitBottom) && !(fitRight || fitLeft)) ||
                ((fitTop && fitLeft) && !(fitRight || fitBottom)) ||
                ((fitRight && fitBottom) && !(fitTop || fitLeft)) ||
                ((fitRight && fitLeft) && !(fitTop || fitBottom)) ||
                ((fitBottom && fitLeft) && !(fitTop || fitRight));
    }

    private int[] fillHashtags() {
        String top = tileBody[0].replaceAll("#", "1").replaceAll("\\.", "0");
        String bottom = tileBody[tileBody.length - 1].replaceAll("#", "1").replaceAll("\\.", "0");
        StringBuilder left = new StringBuilder();
        for (String str : tileBody) {
            left.append(str.charAt(0));
        }
        String leftString = left.toString().replaceAll("#", "1").replaceAll("\\.", "0");
        StringBuilder right = new StringBuilder();
        for (String str : tileBody) {
            right.append(str.charAt(str.length() - 1));
        }
        String rightString = right.toString().replaceAll("#", "1").replaceAll("\\.", "0");
        int first = Integer.parseInt(top, 2);
        int second = Integer.parseInt(rightString, 2);
        int third = Integer.parseInt(bottom, 2);
        int fourth = Integer.parseInt(leftString, 2);
        return new int[]{first, second, third, fourth};
    }

    private int[] fillInvertedHashtags() {
        String t = tileBody[0].replaceAll("#", "1").replaceAll("\\.", "0");
        String top = new StringBuilder(t).reverse().toString();
        String b = tileBody[tileBody.length - 1].replaceAll("#", "1").replaceAll("\\.", "0");
        String bottom = new StringBuilder(b).reverse().toString();
        StringBuilder left = new StringBuilder();
        for (int i = tileBody.length - 1; i >= 0; i--) {
            left.append(tileBody[i].charAt(0));
        }
        String leftString = left.toString().replaceAll("#", "1").replaceAll("\\.", "0");
        StringBuilder right = new StringBuilder();
        for (int i = tileBody.length - 1; i >= 0; i--) {
            right.append(tileBody[i].charAt(tileBody[i].length() - 1));
        }
        String rightString = right.toString().replaceAll("#", "1").replaceAll("\\.", "0");
        int first = Integer.parseInt(top, 2);
        int second = Integer.parseInt(rightString, 2);
        int third = Integer.parseInt(bottom, 2);
        int fourth = Integer.parseInt(leftString, 2);
        return new int[]{first, second, third, fourth};
    }


    @Override
    public String toString() {
        return "Tile: " + this.tileNumber + "|" + Arrays.toString(tileBody)
                + " hashtags: " + Arrays.toString(hashTagArray)
                + " invHashtags: " + Arrays.toString(invertedHashTagArray)
                ;
    }

}

public class JurassicJigsaw {

    private final List<String> inputList;


    public JurassicJigsaw(List<String> input) {
        this.inputList = input;
    }

    private List<Tile> genTileList() {
        List<Tile> tileList = new ArrayList<>();
        int tileNumber = 0;
        List<String> tileBodyList = new ArrayList<>();
        String[] tilesBodyArray = new String[1];
        for (String str : this.inputList) {
            if (str.contains("Tile")) {
                tileNumber = Integer.valueOf(str.replaceAll("Tile ", "")
                        .replaceAll(":", ""));
            } else if (str.isBlank()) {
                tilesBodyArray = new String[tileBodyList.size()];
                tileBodyList.toArray(tilesBodyArray);
                tileList.add(new Tile(tileNumber, tilesBodyArray));
                tileBodyList.clear();
            } else {
                tileBodyList.add(str);
            }
        }
        tileBodyList.toArray(tilesBodyArray);
        tileList.add(new Tile(tileNumber, tilesBodyArray));
        return tileList;
    }

    private List<Tile> getCorners(List<Tile> input) {
        List<Tile> temp = new ArrayList<>();

        for (Tile t : input) {
            List<Tile> tempTileList = new ArrayList<>(input);
            tempTileList.remove(t);
            if (t.isCorner(tempTileList)) {
                temp.add(t);
//                System.out.println("corener: " + t);
            }
        }
    return temp;
    }

    public long getCornersProduct() {
        List<Tile> tList = genTileList();

//        System.out.println(tList.toString());

        tList.forEach(System.out::println);
        List<Tile> toRemove=getCorners(tList);

        long result=1;
        for (Tile t:toRemove) {
            result=result*t.tileNumber;
        }

        return result;
    }


}
