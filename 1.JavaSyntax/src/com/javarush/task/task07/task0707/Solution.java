package com.javarush.task.task07.task0707;

import java.util.ArrayList;

/* 
Что за список такой?
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> stringList = new ArrayList<String>();
        stringList.add("Жить в эпоху великих перемен");
        stringList.add("И врагу своему не желай");
        stringList.add("Мир словно порох умов опасный крен");
        stringList.add("На дабы стала даже земля");
        stringList.add("Жить вопреки");
        System.out.println(stringList.size());
        for (int i = 0; i < stringList.size(); i++) {
            System.out.println(stringList.get(i));
        }
    }
}
