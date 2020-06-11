package com.kwic.modularization2;

import javax.sound.sampled.Line;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;


public class Input {

    private LineStorage lines = new LineStorage();
    private BufferedReader input;

    public Input(String filename) throws FileNotFoundException {
        input = new BufferedReader(new FileReader(filename));
    }

    public void read(){
        try{
        String line;
        while((line = input.readLine())!= null){
            String[] words = line.split(" ");
            lines.addEmptyLine();
            for (int i = 0; i < words.length; i++) {
                lines.addWord(words[i],lines.getLineCount() - 1);
            }

        }}
        catch (Exception e){
            e.printStackTrace();
        }
    }


    public LineStorage getLines() {
        return lines;
    }
}
