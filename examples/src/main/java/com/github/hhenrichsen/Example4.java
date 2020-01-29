package com.github.hhenrichsen;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class Example4 {
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

        // Sort the boxes using a comparator that we provide in the BoxComparator class.
        // Comparators take two of whatever type we give it, and compare them. Using integers, this is normally done
        // by subtracting the values.
        boxes.sort(new BoxComparator());

        // Show the results.
        for (var box : boxes) {
            System.out.println(box);
        }
    }

}
