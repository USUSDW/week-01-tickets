package com.github.hhenrichsen;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class Example3 implements Comparator<Box> {
    private static final Random random = new Random();

    public static void main(String[] args) {
        // Init: creates 20 random boxes.
        var boxes = new ArrayList<Box>();
        for (var i = 0; i < 20; i++) {
            boxes.add(new Box(
                    random.nextInt(50) + 1,
                    random.nextInt(50) + 1,
                    random.nextInt(50) + 1));
        }

        // Sort the boxes using a comparator that we provide on this class.
        // Comparators take two of whatever type we give it, and compare them. Using integers, this is normally done
        // by subtracting the values.
        boxes.sort(new Example3());

        // Show the results.
        for (var box : boxes) {
            System.out.println(box);
        }
    }

    /**
     * Compares two boxes.<br><br>
     *
     * See:<br>
     * <a href="https://docs.oracle.com/javase/8/docs/api/java/lang/Comparable.html">Comparable</a><br>
     * <a href="https://docs.oracle.com/javase/8/docs/api/java/util/Comparator.html">Comparator</a><br>
     *
     * @param box One of the boxes to compare.
     * @param other One of the boxes to compare.
     * @return An integer that helps to compare things. See {@link Comparable#compareTo(Object)}. 0 if the same, a
     * positive if box is greater than other, and a negative number if other is greater than box.
     */
    @Override
    public int compare(Box box, Box other) {
        return box.calcVolume() - other.calcVolume();
    }
}
