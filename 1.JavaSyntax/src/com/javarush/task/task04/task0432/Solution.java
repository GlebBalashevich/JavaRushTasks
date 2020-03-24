package com.javarush.task.task04.task0432;

/* 
Хорошего много не бывает
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        String sI = reader.readLine();
        int i = Integer.parseInt(sI);
        while (i > 0){
            System.out.println(str);
            i--;
        }

    }
}
