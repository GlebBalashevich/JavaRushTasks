package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;


    /*
    Алгоритмы-числа
    */
    public class Test {
        public static long[] getNumbers(long N) {
            long[] arrayResults = new long[0];
            if (N > 0) {
                int digNum = (N + "").length();
                long[][] pows = new long[10][digNum + 1];
                makePows(pows, digNum);

                ArrayList<Long> results = new ArrayList<>();

                findPotentialArmstrong(digNum, N, results, pows);

                Collections.sort(results);

                if (!results.isEmpty()){
                    arrayResults = new long[results.size()];
                    for(int i = 0; i < arrayResults.length; i++){
                        arrayResults[i] = results.get(i);
                    }
                }
            }

            return arrayResults;
        }

        public static void makePows(long[][] pows, int digNum) {
            for (int i = 0; i < 10; i++) {
                for (int j = 1; j <= digNum; j++) {
                    pows[i][j] = (long) Math.pow(i, j);
                }
            }
        }


        public static void findPotentialArmstrong(int digNum, Long N, ArrayList<Long> result, long[][] pows) {
            Date date1 = new Date();
            for (int i = 1; i <= digNum; i++) {
                int[] digits = new int[i];
                digitIteration(1, 0, digits, N, result, pows);
            }
            //System.out.println("start time: " + date1);
            //System.out.println("stop time: " + new Date());
        }

        public static int digitIteration(int nextDigitNumber, int index, int[] digits, Long N, ArrayList<Long> result, long[][] pows) {
            if (index == digits.length - 1) {
                int number = nextDigitNumber;
                while (number <= 9) {
                    digits[index] = number;
                    number++;

                    if (!checkNumber(digits, N, result, pows)) {
                        return -1;
                    }

                }
            } else {
                while (digits[index] <= 9) {
                    int val = digitIteration(digits[index], index + 1, digits, N, result, pows);
                    if (val == -1) {
                        return -1;
                    }

                    digits[index] = val;

                    int j = index + 1;
                    while (j <= digits.length - 1) {
                        digits[j] = digits[index];
                        j++;
                    }
                }
            }
            return ++nextDigitNumber;
        }

        public static boolean checkNumber(int[] digits, Long N, ArrayList<Long> result, long[][] pows) {
            StringBuilder sb = new StringBuilder();
            long armstrongNumber = 0;
            for (int i = 0; i < digits.length; i++) {
                sb.append(digits[i]);
            }

            try {
                armstrongNumber = Integer.parseInt(sb.toString());
            } catch (NumberFormatException e) {
                return true;
            }

            if (armstrongNumber >= N) {
                return false;
            }
            if (armstrongNumber != 0 && digits.length < 10) {
                isArmstrong(digits, N, result, pows);
            }
            return true;
        }

        public static void isArmstrong(int[] digits, Long N, ArrayList<Long> result, long[][] pows) {
            long armstrongNumber = 0;
            long armstrongResult = 0;
            int digNum = digits.length;

            if (digNum < 10) {
                for (int i = 0; i < digNum; i++) {
                    armstrongNumber += pows[digits[i]][digNum];
                }

                if (armstrongNumber < N) {
                    long armstrongNumberMulti = armstrongNumber;
                    if (digNum >= String.valueOf(armstrongNumber).length()) {
                        digNum = String.valueOf(armstrongNumber).length();
                        for (int i = 1; i <= digNum; i++) {
                            try {
                                long pow = (pows[(int) armstrongNumberMulti % 10][digNum] < Long.MAX_VALUE) ? pows[(int) armstrongNumberMulti % 10][digNum] : 0;
                                armstrongResult += pow;
                                armstrongNumberMulti = armstrongNumberMulti / 10;
                            } catch (ArrayIndexOutOfBoundsException e) {
                                System.out.println(armstrongNumberMulti % 10 + " " + digNum);
                            }
                        }

                        if (armstrongNumber == armstrongResult && !result.contains(armstrongResult)) {
                            result.add(armstrongResult);
                        }
                    }
                }
            }
        }

        public static void main(String[] args) {
            getNumbers(2);
        }
    }


//    public static int digitIteration(int nextDigitNumber, int index, int[] digits) {
//        if (index == digits.length - 1) {
//            int number = nextDigitNumber;
//            while (number <= 9) {
//                digits[index] = number;
//                number++;
//                Print(digits);
//            }
//            return ++nextDigitNumber;
//        } else {
//            while (index >= 0) {
//                while (digits[index] <= 9) {
//                    digits[index] = digitIteration(digits[index], index + 1, digits);
//                    int j = index+1;
//                    while (j <= digits.length - 1){
//                        digits[j] = digits[index];
//                        j++;
//                    }
//                }
//                return ++nextDigitNumber;
//            }
//        }
//        return -1;
//    }

//    public static boolean checkNumber(int[] digits, Long N, ArrayList<Long> result, long[][] pows) {
//        int multiplier = 1;
//        int number = 0;
//        int digNum = 0;
//        for (int i = digits.length - 1; i >= 0; i--) {
//            digNum = (digits[i] != 0) ? digNum+1 : digNum;
//            number += digits[i] * multiplier;
//            multiplier *= 10;
//        }
//        if (number >= N) {
//            return false;
//        } else {
//            return isArmstrong(digits, digNum,  N, result, pows);
//        }
//    }
//
//    public static boolean isArmstrong(int[] digits, int digNum, Long N, ArrayList<Long> result, long[][] pows) {
//        int armstrongLength = 0;
//        int resultVal = 0;
//        int armstrongNum = 0;
//        for(int i = 0; i < digits.length; i++){
//            armstrongNum += pows[digits[i]][digNum];
//        }
//
//        if (armstrongNum > N) return false;
//
//        armstrongLength = String.valueOf(armstrongNum).length()-1;
//        for(int j = armstrongLength; j >= 0; j--){
//            resultVal += Math.pow(armstrongNum % 10, armstrongLength);
//            armstrongNum = armstrongNum / 10;
//        }
//
//        System.out.println(resultVal);
//        if (armstrongNum == resultVal) System.out.println("cha-cha-cha" + armstrongNum);
//        return true;
//    }




