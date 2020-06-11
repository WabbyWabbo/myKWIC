package com.kwic.modularization2;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Output {
    private BufferedWriter output;
    //private Alphabetizer alphabetizer;

    public Output(String filename) throws IOException {
        output = new BufferedWriter(new FileWriter(filename));
    }

    public void write(Alphabetizer alphabetizer) throws IOException {
        for (int i = 0; i < alphabetizer.getLineCount(); i++) {
            output.write(alphabetizer.getLinesAsString(i) + "\n");
        }

        output.flush();
    }

}
