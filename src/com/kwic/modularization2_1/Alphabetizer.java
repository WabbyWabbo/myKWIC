package com.kwic.modularization2_1;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 *  按字母排序
 */
public class Alphabetizer {

    private ArrayList<String> sortedLines;

    public Alphabetizer() {
        sortedLines = new ArrayList<String>();
    }

    public void sort(CircularShifter circularShifter) {
        Collections.sort(circularShifter.getShiftedLines());
        for(int x = 0;x<circularShifter.getShiftedLines().size();x++) {
            sortedLines.add(circularShifter.getShiftedLines().get(x));
        }
    }

    public ArrayList<String> getSortedLines(){
        return sortedLines;
    }
}