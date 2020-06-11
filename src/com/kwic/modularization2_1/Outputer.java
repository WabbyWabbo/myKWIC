package com.kwic.modularization2_1;

public class Outputer {

    public void printKWIC(Alphabetizer alphabetizer) {
        for(int x = 0;x<alphabetizer.getSortedLines().size();x++){
            System.out.println(alphabetizer.getSortedLines().get(x));
        }
    }
}