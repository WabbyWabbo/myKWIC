package com.kwic.modularization2;

import java.util.ArrayList;

public class LineStorage {


    private ArrayList<String> lines = new ArrayList<>();


    public char getChar(int position, int word, int line) {
        return this.getWord(word,line).charAt(position);
    }

    public int getCharCount(int word, int line) {
        return this.getWord(word,line).length();
    }

    public String getWord(int word, int line) {
        return this.getLine(line)[word];
    }

    public int getWordCount(int line) {
        return this.getLine(line).length;
    }

    public String[] getLine(int line) {
        return this.getLineAsString(line).split(" ");
    }

    public String getLineAsString(int line) {
        return lines.get(line);
    }

    public int getLineCount() {
        return lines.size();
    }

    public void addEmptyLine() {
        lines.add("");
    }

    public void addWord(String s, int row) {
        String temp;
        if(lines.get(row).equals("")){
            temp = s;
        }else{
            temp = lines.get(row) + " " + s;
        }

        lines.set(row,temp);
    }

    @Override
    public String toString() {
        return "LineStorage{" +
                "lines=" + lines +
                '}';
    }
}
