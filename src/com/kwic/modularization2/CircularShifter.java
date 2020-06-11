package com.kwic.modularization2;

public class CircularShifter {
    private LineStorage shifts;

    public void setup(LineStorage lines) {
        shifts = new LineStorage();

        for (int i = 0; i < lines.getLineCount(); i++) {
            String[] line = lines.getLine(i);
            for (int j = 0; j < line.length; j++) {
                shifts.addEmptyLine();
                for (int k = j; k < (line.length + j); k++) {
                    //放到最后一行
                    shifts.addWord(line[k % line.length], shifts.getLineCount() - 1);
                }
            }
        }

    }

    /**
     * @param position 第几个字母
     * @param word     第几个单词
     * @param line     第几行
     * @return 第几行第几个单词的第几个字母
     */
    public char getChar(int position, int word, int line) {
        return shifts.getChar(position, word, line);
    }

    public int getCharCount(int word, int line) {
        return shifts.getCharCount(word, line);
    }

    public String getWord(int word, int line) {
        return shifts.getWord(word, line);
    }

    public int getWordCount(int line) {
        return shifts.getWordCount(line);
    }

    public String[] getLine(int line) {
        return shifts.getLine(line);
    }

    public String getLineAsString(int line) {
        return shifts.getLineAsString(line);
    }

    public int getLineCount() {
        return shifts.getLineCount();
    }
}
