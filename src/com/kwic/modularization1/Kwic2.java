package com.kwic.modularization1;

import java.util.ArrayList;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Kwic2 {


    private ArrayList<String> kwicList = new ArrayList<String>();
    private ArrayList<String> lineTxt = new ArrayList<String>();
    private BufferedReader inputFile;

    public static void main(String[] args) {

        Kwic2 kwic2 = new Kwic2();
        kwic2.input("/Users/fisher/IdeaProjects/KWIC/resources/input.txt");
        kwic2.shift();
        kwic2.alphabetizer();
        kwic2.output();

    }


    public void input(String fileName) {
        try {
            inputFile = new BufferedReader(new FileReader(fileName));
        } catch (Exception e) {
            System.err.print("File not found");
            System.exit(1);
        }
        String line;
        try {
            while ((line = inputFile.readLine()) != null) {
                lineTxt.add(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void output() {
        Iterator<String> it = kwicList.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    public void shift() {
        Iterator<String> it = lineTxt.iterator();
        //逐行处理
        while (it.hasNext()) {
            StringTokenizer token = new StringTokenizer(it.next());
            ArrayList<String> tokens = new ArrayList<String>();

            int count = token.countTokens();

            //将一行分割
            int i = 0;
            while (i < count) {
                tokens.add(token.nextToken());
                i++;
            }

            //i作为起始值
            for (i = 0; i < count; i++) {
                StringBuffer lineBuffer = new StringBuffer();

                int index = i;

                //移动index共count次
                for (int f = 0; f < count; f++) {
                    lineBuffer.append(tokens.get(index));
                    lineBuffer.append(" ");
                    //闭环
                    index = (index + 1) % count;
                }

                String tmp = lineBuffer.toString();
                kwicList.add(tmp);

            }

        }

    }


    public void alphabetizer() {
        Collections.sort(this.kwicList, new AlphabetizerComparator());
    }

    private class AlphabetizerComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            if (o1 == null && o2 == null) {
                throw new NullPointerException();
            }
            int compareValue = 0;
            char o1c = o1.charAt(0);
            char o2c = o2.charAt(0);
            compareValue = o1c - o2c;
            return compareValue;

        }

    }
}