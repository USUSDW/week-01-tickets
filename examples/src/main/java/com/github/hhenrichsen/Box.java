package com.github.hhenrichsen;

public class Box {
    public final int length, width, height;

    public Box(int length, int width, int height) {
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
}
