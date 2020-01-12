package com.github.hhenrichsen;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class Example6 {
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

        // Sort the boxes using a comparator and a function reference.
        boxes.sort(Comparator.comparingInt(Box::calcVolume));

        // Show the results.
        for (var box : boxes) {
            System.out.println(box);
        }
    }
}
