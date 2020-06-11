package com.kwic.modularization2_1;

import java.util.ArrayList;

/**
 *
 * 循环移位
 */
public class CircularShifter {

    private ArrayList<String> shirtedLines;

    public CircularShifter() {
        shirtedLines = new ArrayList<String>();
    }


    private ArrayList<Integer> getShiftPosition(InputStore inputStore) {

        ArrayList<Integer> shiftedLineIndexes = new ArrayList<Integer>();

        //用来计数左移一次开始单词的position
        int counter = 0;
        for(int i=0;i<inputStore.getTextLines().size();i++){
            //每行开头需要记录
            shiftedLineIndexes.add(counter);
            for(int j=0;j<inputStore.getTextLines().get(i).length();j++){

                if((inputStore.getTextLines().get(i).charAt(j)==' ')&&(inputStore.getTextLines().get(i).charAt(j+1)!=' ')){
                    shiftedLineIndexes.add(counter+1);
                }

                counter++;
            }
        }
        return shiftedLineIndexes;
    }

    public void shift(InputStore inputStore) {

        ArrayList<Integer> shiftedLineIndexes = getShiftPosition(inputStore);

        int lengthCounter = 0;
        int j = 0;

        for(int i=0;i<inputStore.getTextLines().size();i++){

            lengthCounter = lengthCounter + inputStore.getTextLines().get(i).length();

            while(shiftedLineIndexes.get(j)<lengthCounter){

                char[] newStr = new char[inputStore.getTextLines().get(i).length()+1];
                int charSet = 0;

                //赋值
                for(int x = shiftedLineIndexes.get(j) - lengthCounter + inputStore.getTextLines().get(i).length();x<inputStore.getTextLines().get(i).length();x++){
                    newStr[charSet] = inputStore.getTextLines().get(i).charAt(x);
                    charSet++;
                }

                if(inputStore.getTextLines().get(i).length()- lengthCounter + shiftedLineIndexes.get(j)!=0){
                    newStr[charSet] = ' ';
                    charSet++;
                }

                for(int x = 0; x <(inputStore.getTextLines().get(i).length()- lengthCounter + shiftedLineIndexes.get(j));x++){
                    newStr[charSet] = inputStore.getTextLines().get(i).charAt(x);
                    charSet++;
                }
                shirtedLines.add(new String(newStr));

                j++;

                //如果所有位置记录都已经被遍历，则跳出
                if(j>=shiftedLineIndexes.size()){
                    break;
                }

            }
        }
    }

    public ArrayList<String> getShiftedLines() {
        return this.shirtedLines;
    }
}