package com.github.hhenrichsen;

import java.util.PriorityQueue;
import java.util.Random;

public class Example3 {
    private static final Random random = new Random();

    public static void main(String[] args) {
        // Init: creates 20 random boxes and a PriorityQueue.
        var boxes = new PriorityQueue<ComparableBox>();
        for (var i = 0; i < 20; i++) {
            boxes.add(new ComparableBox(
                    random.nextInt(50) + 1,
                    random.nextInt(50) + 1,
                    random.nextInt(50) + 1));
        }

        // Show the results.
        for (var i = 0; i < boxes.size(); i++) {
            System.out.println(boxes.poll());
        }
    }
}
