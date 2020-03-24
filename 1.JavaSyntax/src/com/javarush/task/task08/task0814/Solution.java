package com.javarush.task.task08.task0814;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* 
Больше 10? Вы нам не подходите
*/

public class Solution {
    public static Set<Integer> createSet() {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 20; i++) {
            set.add(i);
        }
        return set;
    }

    public static Set<Integer> removeAllNumbersGreaterThan10(Set<Integer> set) {
        Iterator<Integer> setIterator = set.iterator();
        while(setIterator.hasNext()){
            Integer nextNumber = setIterator.next();
            if (nextNumber > 10){
                setIterator.remove();
            }
        }

        return set;
    }

    public static void main(String[] args) {
        Set setVal = createSet();
        removeAllNumbersGreaterThan10(setVal);
    }
}
