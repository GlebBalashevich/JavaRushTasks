package com.javarush.task.task18.task1823;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String fileName = reader.readLine();
            if (fileName.equals("exit")){
                reader.close();
                break;
            }
            ReadThread readThread = new ReadThread(fileName);
            readThread.start();
        }

        for(Map.Entry<String, Integer> pair : resultMap.entrySet()){
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
    }

    public static class ReadThread extends Thread {
        FileInputStream inputStream;
        String fileName;

        public ReadThread(String fileName) throws FileNotFoundException {
            this.fileName = fileName;
            inputStream = new FileInputStream(fileName);
        }
        public void run(){
            try {
                byte maxiByte = 0;
                int maxiCount = 0;
                while (inputStream.available() > 0) {
                    byte[] bytes = new byte[inputStream.available()];
                    inputStream.read(bytes);
                    for (int i = 0; i < bytes.length; i++){
                        byte currentByte = bytes[i];
                        int count = 0;
                        for(int j = 0; j < bytes.length; j++){
                            if (currentByte == bytes[j]){
                                count++;
                            }
                        }
                        if (count >= maxiCount){
                            maxiByte = currentByte;
                            maxiCount = count;
                        }
                    }
                }
                inputStream.close();
                resultMap.put(fileName, (int) maxiByte);
            }
            catch (IOException e){

            }
        }
    }
}
