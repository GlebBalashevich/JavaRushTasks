package com.javarush.task.task07.task0713;

import sun.util.BuddhistCalendar;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> mainList = new ArrayList<Integer>();
        ArrayList<Integer> threeList = new ArrayList<Integer>();
        ArrayList<Integer> twoList = new ArrayList<Integer>();
        ArrayList<Integer> otherList = new ArrayList<Integer>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 20; i++) {
            mainList.add(Integer.parseInt(reader.readLine()));
        }



//        for (int i = 0; i < mainList.size(); i++) {
//            if (mainList.get(i) % 2 == 0 || mainList.get(i) % 3 == 0) {
//                if (mainList.get(i) % 3 == 0) {
//                    threeList.add(mainList.get(i));
//                }
//
//                if (mainList.get(i) % 2 == 0) {
//                    twoList.add(mainList.get(i));
//                }
//            }
//            else{
//                otherList.add(mainList.get(i));
//            }
//        }

        moveList(mainList,threeList,3);
        moveList(mainList,twoList,2);
        moveList(mainList,otherList,1);

        printList(threeList);
        printList(twoList);
        printList(otherList);



    }

    public static void moveList(ArrayList<Integer> list, ArrayList<Integer> sortList, int decimal){
        for (int i = 0; i < list.size(); i++) {
            if (decimal != 1) {
                if (list.get(i) % decimal == 0) {
                    sortList.add(list.get(i));
                }
            }
            else{
                if (list.get(i) % 3 != 0 && list.get(i) % 2 != 0){
                    sortList.add(list.get(i));
                }
            }
        }
    }

    public static void printList(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
