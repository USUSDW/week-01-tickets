package com.github.hhenrichsen;

import java.util.Comparator;

public class BoxComparator implements Comparator<Box> {
    @Override
    public int compare(Box box, Box other) {
        return box.calcVolume() - other.calcVolume();
    }
}
