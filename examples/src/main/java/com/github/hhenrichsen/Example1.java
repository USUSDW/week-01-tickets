package com.github.hhenrichsen;

import java.util.Arrays;
import java.util.Random;

public class Example1 {
    private static final Random random = new Random();

    public static void main(String[] args) {
        // Init: creates 20 random boxes.
        Box[] boxes = new Box[20];
        for (var i = 0; i < 20; i++) {
            boxes[i] = new Box(
                    random.nextInt(50) + 1,
                    random.nextInt(50) + 1,
                    random.nextInt(50) + 1);
        }

        // Sort the boxes using an algorithm that we implemented.
        sort(boxes, boxes.length);

        // Show the results.
        for (var box : boxes) {
            System.out.println(box);
        }
    }

    /**
     * Sorts an array of boxes using a MergeSort.
     *
     * @param boxes The array of boxes to sort.
     * @param n The length of the array. Used to determine start/end.
     */
    public static void sort(Box[] boxes, int n) {
        if(n < 2) {
            return;
        }
        int mid = n/2;
        Box[] l = Arrays.copyOfRange(boxes, 0, mid);
        Box[] r = Arrays.copyOfRange(boxes, mid, boxes.length);
        sort(l, mid);
        sort(r, n - mid);

        merge(boxes, l, r, mid, n - mid);
    }

    /**
     * Merge function of a Merge sort.
     *
     * @param boxes The final array of boxes.
     * @param l The left component of boxes.
     * @param r The right component of boxes.
     * @param left The starting merge index.
     * @param right The ending merge index.
     */
    private static void merge(Box[] boxes, Box[] l, Box[] r, int left, int right) {
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i].calcVolume() <= r[j].calcVolume()) {
                boxes[k++] = l[i++];
            }
            else {
                boxes[k++] = r[j++];
            }
        }
        while (i < left) {
            boxes[k++] = l[i++];
        }
        while (j < right) {
            boxes[k++] = r[j++];
        }
    }
}
