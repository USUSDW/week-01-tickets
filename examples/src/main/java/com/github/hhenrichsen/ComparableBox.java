package com.github.hhenrichsen;

public class ComparableBox implements Comparable<ComparableBox> {

    public final int length, width, height;

    public ComparableBox(int length, int width, int height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public int calcVolume() {
        return this.length * this.width * this.height;
    }

    public int calcSurfaceArea() {
        return 2 * (length * width) + 2 * (width * height) + 2 * (height * length);
    }

    @Override
    public String toString() {
        return "Box{" +
                "length=" + length +
                ", width=" + width +
                ", height=" + height +
                ", volume=" + calcVolume() +
                '}';
    }

    @Override
    public int compareTo(ComparableBox other) {
        return this.calcSurfaceArea() - other.calcSurfaceArea();
    }
}
