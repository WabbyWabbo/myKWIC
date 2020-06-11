package com.kwic.modularization2_1;

public class MainTest {

    public static void main(String[] args) {
        InputStore inputStore = new InputStore("resources/input.txt");

        CircularShifter circularShifter = new CircularShifter();
        circularShifter.shift(inputStore);

        Alphabetizer alphabetizer = new Alphabetizer();
        alphabetizer.sort(circularShifter);

        Outputer outputer = new Outputer();
        outputer.printKWIC(alphabetizer);
    }

}