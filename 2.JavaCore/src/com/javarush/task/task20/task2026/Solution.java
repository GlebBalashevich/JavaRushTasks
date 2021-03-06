package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };

        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Должно быть 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Должно быть 4");
    }

    public static int getRectangleCount(byte[][] a) {
        int count = 0;
        byte[] coords = new byte[]{-1, -1};
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] == 1) {
                    count += findRectangle(i, j, a, coords);
                }
            }
        }
        return count;
    }

    public static int findRectangle(int i, int j, byte[][] a, byte[] coords) {
        int count = 0;
        int iIndex = i;
        int jIndex = j;
        if (coords[0] < iIndex || coords[1] < jIndex) {
            while (iIndex < a.length) {
                if (a[iIndex][jIndex] == 0) {
                    iIndex--;
                    break;
                }

                while (jIndex < a[iIndex].length) {
                    if (a[iIndex][jIndex] == 0) {
                        jIndex--;
                        break;
                    }
                    jIndex++;
                    if (jIndex == a[iIndex].length) {
                        jIndex--;
                        break;
                    }

                }

                iIndex++;
                if (iIndex == a.length) {
                    iIndex--;
                    break;
                }

            }
            coords[0] = (byte) iIndex;
            coords[1] = (byte) jIndex;
            count++;
        }
        return count;
    }
}


