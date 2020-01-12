package com.github.hhenrichsen;

public class ComparableBox extends Box implements Comparable<ComparableBox> {

    public ComparableBox(int length, int width, int height) {
        super(length, width, height);
    }

    @Override
    public int compareTo(ComparableBox other) {
        return this.calcVolume() - other.calcVolume();
    }
}
