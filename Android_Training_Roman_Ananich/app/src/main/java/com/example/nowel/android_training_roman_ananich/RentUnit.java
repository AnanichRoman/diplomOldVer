package com.example.nowel.android_training_roman_ananich;

/**
 * Created by Nowel on 02.04.2017.
 */

public class RentUnit {
    private Lesson[] units;
    public RentUnit(Lesson item){
        if (units.length+1<3) {
            units[units.length + 1] = item;
        }
        if (units.length==0) {
            units[0] = item;
        }
    }

    public void add(Lesson item){
        if (units.length+1<3) {
            units[units.length + 1] = item;
        }
    }
}
