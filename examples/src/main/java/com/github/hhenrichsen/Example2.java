package com.github.hhenrichsen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Example2 {
    private static final Random random = new Random();

    public static void main(String[] args) {
        // Init: creates 20 random boxes.
        var boxes = new ArrayList<ComparableBox>();
        for (var i = 0; i < 20; i++) {
            boxes.add(new ComparableBox(
                    random.nextInt(50) + 1,
                    random.nextInt(50) + 1,
                    random.nextInt(50) + 1));
        }

        // We don't need to provide this with anything because ComparableBox implements Comparable.
        Collections.sort(boxes);

        // Show the results.
        for (var box : boxes) {
            System.out.println(box);
        }
    }
}
