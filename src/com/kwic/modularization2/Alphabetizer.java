package com.kwic.modularization2;

import java.util.ArrayList;
import java.util.Collections;

public class Alphabetizer {

    private ArrayList<String> alpha = new ArrayList<>();

    public void sort(CircularShifter circularShifter){

        for (int i = 0; i < circularShifter.getLineCount(); i++) {

            alpha.add(circularShifter.getLineAsString(i));
        }

        Collections.sort(alpha, new AlphabetizerCompartor());

    }


    public String getLinesAsString(int i){
        return alpha.get(i);
    }

    public int getLineCount(){
        return alpha.size();
    }
}
