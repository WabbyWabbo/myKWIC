package com.kwic.modularization2;

import java.io.IOException;

public class MasterControl {
    public static void main(String[] args) throws IOException {

        Input input = new Input("resources/input.txt");
        input.read();

        LineStorage lines = input.getLines();

        CircularShifter circularShifter = new CircularShifter();
        circularShifter.setup(lines);

        Alphabetizer alphabetizer = new Alphabetizer();
        alphabetizer.sort(circularShifter);

        Output output = new Output("resources/output.txt");
        output.write(alphabetizer);
    }


}
