package com.example.task;

public class Task01 {

    public static void main(String[] args) {
        int[][] matrix = {
                {5, 3, 4},
                {1, 5, 8},
                {6, 4, 2}};

        // sum of the elements at rows
        for (int row = 0; row < matrix.length; row++) {
            int rowSum = 0;
            for (int col = 0; col < matrix[row].length; col++) {
                rowSum += matrix[row][col];
            }
            System.out.println("Sum of the elements at row " + row + " is: " + rowSum);
        }
        // sum of the elements at columns
        for (int col = 0; col < matrix[0].length; col++) {
            int colSum = 0;
            for (int row = 0; row < matrix.length; row++) {
                colSum += matrix[row][col];
            }
            System.out.println("Sum of the elements at col " + col + " is: " + colSum);
        }
        // sum of the elements at diagonals
        int diagonalPrim = 0;
        int diagonalSec = 0;
        for (int d = 0; d < matrix.length; d++) {
            // sum of primary diagonal
            diagonalPrim += matrix[d][d];
            // sum of second diagonal
            diagonalSec += matrix[d][matrix.length - d - 1];
        }
        System.out.println("**********************");
        System.out.println(diagonalPrim);
        System.out.println(diagonalSec);
        int i = Task01.formingMagicSquare(new int[][]{
                {5, 3, 4},
                {1, 5, 8},
                {6, 4, 2}});
        System.out.println(i);

        int j = Task01.formingMagicSquare(new int[][]{
                {4, 8, 2},
                {4, 5, 7},
                {6, 1, 6}
        });
        System.out.println(j);
    }

    static int formingMagicSquare(int[][] s) {
        int cost = Integer.MAX_VALUE;
        int t[][] =
                {
                        {4, 9, 2, 3, 5, 7, 8, 1, 6},
                        {4, 3, 8, 9, 5, 1, 2, 7, 6},
                        {2, 9, 4, 7, 5, 3, 6, 1, 8},
                        {2, 7, 6, 9, 5, 1, 4, 3, 8},
                        {8, 1, 6, 3, 5, 7, 4, 9, 2},
                        {8, 3, 4, 1, 5, 9, 6, 7, 2},
                        {6, 7, 2, 1, 5, 9, 8, 3, 4},
                        {6, 1, 8, 7, 5, 3, 2, 9, 4},
                };
        int temp = 0;
        for (int i = 0; i < 8; i++) {
            temp = Math.abs(s[0][0] - t[i][0]) + Math.abs(s[0][1] - t[i][1]) +
                    Math.abs(s[0][2] - t[i][2]) + Math.abs(s[1][0] - t[i][3]) +
                    Math.abs(s[1][1] - t[i][4]) + Math.abs(s[1][2] - t[i][5]) +
                    Math.abs(s[2][0] - t[i][6]) + Math.abs(s[2][1] - t[i][7]) +
                    Math.abs(s[2][2] - t[i][8]);
            cost = temp < cost ? temp : cost;
        }
        return cost;
    }
}
