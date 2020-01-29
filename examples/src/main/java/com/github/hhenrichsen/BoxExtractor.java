package com.github.hhenrichsen;

import java.util.function.ToIntFunction;

public class BoxExtractor implements ToIntFunction<Box> {
    @Override
    public int applyAsInt(Box box) {
        return box.calcVolume();
    }
}
