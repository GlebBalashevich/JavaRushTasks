package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'e', 'm', 'o', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };

        for(Word word : detectAllWords(crossword,  "home", "same"))
            System.out.println(word);


    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> wordsList = new ArrayList<>();

        for (String word : words) {
            if (!word.equals("")) {
                char[] letters = word.toCharArray();
                int[] indexes = new int[]{0, 0};
                int yCrossLength = crossword.length;
                int xCrossLength = crossword[0].length;

                for (int i = 0; i < yCrossLength; i++) {
                    for (int j = 0; j < xCrossLength; j++) {
                        if (letters[0] == crossword[i][j]) {

                            findIndexes(i, j, yCrossLength, xCrossLength, indexes, letters, crossword, wordsList, word);

                        }
                    }
                }
            }
        }

        return wordsList;
    }

    public static void findIndexes(int i, int j, int yCrossLength, int xCrossLength, int[] indexes, char[] letters, int[][] crossword, List<Word> wordsList, String word) {
        if (letters.length > 1) {
            if (i + 1 < yCrossLength && letters[1] == crossword[i + 1][j]) {
                indexes[0] = 1;
                indexes[1] = 0;
                findWordPoints(i, j, yCrossLength, xCrossLength, indexes, letters, crossword, wordsList, word);
            }
            if (i - 1 >= 0 && letters[1] == crossword[i - 1][j]) {
                indexes[0] = -1;
                indexes[1] = 0;
                findWordPoints(i, j, yCrossLength, xCrossLength, indexes, letters, crossword, wordsList, word);
            }
            if (i + 1 < yCrossLength && j + 1 < xCrossLength && letters[1] == crossword[i + 1][j + 1]) {
                indexes[0] = 1;
                indexes[1] = 1;
                findWordPoints(i, j, yCrossLength, xCrossLength, indexes, letters, crossword, wordsList, word);
            }
            if (i - 1 >= 0 && j - 1 >= 0 && letters[1] == crossword[i - 1][j - 1]) {
                indexes[0] = -1;
                indexes[1] = -1;
                findWordPoints(i, j, yCrossLength, xCrossLength, indexes, letters, crossword, wordsList, word);
            }
            if (j - 1 >= 0 && letters[1] == crossword[i][j - 1]) {
                indexes[0] = 0;
                indexes[1] = -1;
                findWordPoints(i, j, yCrossLength, xCrossLength, indexes, letters, crossword, wordsList, word);
            }
            if (j + 1 < xCrossLength && letters[1] == crossword[i][j + 1]) {
                indexes[0] = 0;
                indexes[1] = 1;
                findWordPoints(i, j, yCrossLength, xCrossLength, indexes, letters, crossword, wordsList, word);
            }
            if (i - 1 >= 0 && j + 1 < xCrossLength && letters[1] == crossword[i - 1][j + 1]) {
                indexes[0] = -1;
                indexes[1] = 1;
                findWordPoints(i, j, yCrossLength, xCrossLength, indexes, letters, crossword, wordsList, word);
            }
            if (i + 1 < yCrossLength && j - 1 >= 0 && letters[1] == crossword[i + 1][j - 1]) {
                indexes[0] = 1;
                indexes[1] = -1;
                findWordPoints(i, j, yCrossLength, xCrossLength, indexes, letters, crossword, wordsList, word);
            }
        }
    }

    public static void findWordPoints(int i, int j, int yCrossLength, int xCrossLength, int[] indexes, char[] letters, int[][] crossword, List<Word> wordsList, String word){
        Word findingWord = new Word(word);
        for (int k = 0; k < letters.length; k++) {
            if (i >= 0 && i < yCrossLength && j >= 0 && j < xCrossLength) {
                if (crossword[i][j] == letters[k]) {
                    if (k == 0) {
                        findingWord.setStartPoint(j, i);
                    }
                    if (k == letters.length - 1) {
                        findingWord.setEndPoint(j, i);
                        wordsList.add(findingWord);
                    }
                    i += indexes[0];
                    j += indexes[1];
                } else {
                    break;
                }
            }
        }
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}


//    public static List<Word> detectAllWords(int[][] crossword, String... words) {
//        List<Word> wordsList = new ArrayList<>();
//
//        for (String word : words) {
//            if (!word.equals("")) {
//                char[] letters = word.toCharArray();
//                int[] indexes = new int[]{0, 0};
//                int yCrossLength = crossword.length;
//                int xCrossLength = crossword[0].length;
//
//                for (int i = 0; i < yCrossLength; i++) {
//                    for (int j = 0; j < xCrossLength; j++) {
//                        if (letters[0] == crossword[i][j]) {
//
//                            if(findIndexes(i, j, yCrossLength, xCrossLength, indexes, letters, crossword, wordsList)) {
//                                int iCross = i;
//                                int jCross = j;
//                                Word findingWord = new Word(word);
//
//                                for (int k = 0; k < letters.length; k++) {
//                                    if (iCross >= 0 && iCross < yCrossLength && jCross >= 0 && jCross < xCrossLength) {
//                                        if (crossword[iCross][jCross] == letters[k]) {
//                                            if (k == 0) {
//                                                findingWord.setStartPoint(jCross, iCross);
//                                            }
//                                            if (k == letters.length - 1) {
//                                                findingWord.setEndPoint(jCross, iCross);
//                                                wordsList.add(findingWord);
//                                            }
//                                            iCross += indexes[0];
//                                            jCross += indexes[1];
//                                        } else {
//                                            break;
//                                        }
//                                    }
//                                }
//
//                            }
//                        }
//                    }
//                }
//            }
//        }
//
//        return wordsList;
//    }
//
//    public static boolean findIndexes(int i, int j, int yCrossLength, int xCrossLength, int[] indexes, char[] letters, int[][] crossword, List<Word> wordsList) {
//        if (letters.length > 1) {
//            if (i + 1 < yCrossLength && letters[1] == crossword[i + 1][j]) {
//                indexes[0] = 1;
//                indexes[1] = 0;
//                return true;
//            } else if (i - 1 >= 0 && letters[1] == crossword[i - 1][j]) {
//                indexes[0] = -1;
//                indexes[1] = 0;
//                return true;
//            } else if (i + 1 < yCrossLength && j + 1 < xCrossLength && letters[1] == crossword[i + 1][j + 1]) {
//                indexes[0] = 1;
//                indexes[1] = 1;
//                return true;
//            } else if (i - 1 >= 0 && j - 1 >= 0 && letters[1] == crossword[i - 1][j - 1]) {
//                indexes[0] = -1;
//                indexes[1] = -1;
//                return true;
//            } else if (j - 1 >= 0 && letters[1] == crossword[i][j - 1]) {
//                indexes[0] = 0;
//                indexes[1] = -1;
//                return true;
//            } else if (j + 1 < xCrossLength && letters[1] == crossword[i][j + 1]) {
//                indexes[0] = 0;
//                indexes[1] = 1;
//                return true;
//            } else if (i - 1 >= 0 && j + 1 < xCrossLength && letters[1] == crossword[i - 1][j + 1]) {
//                indexes[0] = -1;
//                indexes[1] = 1;
//                return true;
//            } else if (i + 1 < yCrossLength && j - 1 >= 0 && letters[1] == crossword[i + 1][j - 1]) {
//                indexes[0] = 1;
//                indexes[1] = -1;
//                return true;
//            }
//        }
//        return false;
//    }