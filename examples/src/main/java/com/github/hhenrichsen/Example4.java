package com.github.hhenrichsen;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.function.ToIntFunction;

public class Example4 implements ToIntFunction<Box> {
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

        // Compare the boxes using an Integer Extractor defined on this class.
        boxes.sort(Comparator.comparingInt(new Example4()));

        // Show the results.
        for (var box : boxes) {
            System.out.println(box);
        }
    }

    /**
     * Extracts an integer from a Box to compare.<br><br>
     *
     * See:<br>
     * <a href="https://docs.oracle.com/javase/8/docs/api/java/util/Comparator.html">Comparator</a><br>
     * <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/ToIntFunction.html">Comparator</a><br>
     *
     * @param box The box to extract an integer from.
     * @return An integer for Comparator to compare other boxes with.
     */
    public int applyAsInt(Box box) {
        return box.calcVolume();
    }
}
