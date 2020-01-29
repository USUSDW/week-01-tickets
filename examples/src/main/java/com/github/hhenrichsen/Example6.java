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

        // Sort the boxes using a comparator and a Single Abstract Method lambda.
        // Note: I apply the suggestion for this one in the next example, but this is another way we can consider
        // extracting things to base sorts off of. If we wanted to do some more complex computations, like take both
        // surface area and volume into account, this would be the way to go.
        boxes.sort(Comparator.comparingInt(i -> i.calcVolume()));

        // Show the results.
        for (var box : boxes) {
            System.out.println(box);
        }
    }
}
