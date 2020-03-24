package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        String openTag = "<" + args[0];
        String closeTag = "</" + args[0];

        BufferedReader fileInputStream = new BufferedReader(new FileReader(fileName));
        StringBuilder stringBuilder = new StringBuilder();
        while(fileInputStream.ready()){
            stringBuilder.append(fileInputStream.readLine());
        }

        fileInputStream.close();
        String htmlText = stringBuilder.toString();


        for (int i = 0; i < htmlText.length(); i++) {
            i = htmlText.indexOf(openTag, i);
            if (i > 0){
                int startSubString = i;
                int openTagCount = 1;
                int closeTagCount = 0;
                int closeIndex = 0;
                int openIndex = 0;
                int j = i+1;
                while (j >= 0){
                    openIndex = htmlText.indexOf(openTag, j);
                    closeIndex = htmlText.indexOf(closeTag, j);
                    if (openIndex > closeIndex || openIndex == -1){
                        closeTagCount++;
                        j = closeIndex+1;
                    }
                    else{
                        openTagCount++;
                        j = openIndex+1;
                    }
                    if (openTagCount == closeTagCount){
                        String tagText = htmlText.substring(startSubString, closeIndex+closeTag.length()+1);
                        tagText = tagText.replaceAll("[\\r\\n]","");
                        tagText = tagText.trim();
                        System.out.println(tagText);
                        i = startSubString;
                        break;
                    }
                }
            }
            else{
                break;
            }
        }


    }
}
