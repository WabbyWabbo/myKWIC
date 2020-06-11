package com.kwic.modularization2_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * 输入
 */
public class InputStore {

    private ArrayList<String> textLines;

    //对textLines进行初始化
    public InputStore(String filePath) {
        textLines = new ArrayList<String>();
        String line = new String();
        BufferedReader reader;
        try{
            reader = new BufferedReader(new FileReader(filePath));
            while((line=reader.readLine())!=null){
                textLines.add(line);
            }
            reader.close();
        }catch(IOException e){
            System.out.println("Input File Does Not Exsit!");
        }
    }

    //对外提供的接口
    public ArrayList<String> getTextLines(){
        return this.textLines;
    }
}