package com.mahiznan.challenges;

public class SudokuSolver {
    static boolean SolveSudoku(int[][] grid, int p, int q) {
        System.out.println("Entering for [" + p + "," + q + "]");
        printGrid(grid);
        for (int i = p, l = q; i < 9; i++, l = 0) {
            for (int j = l; j < 9; j++) {
                if (i == 8)
                    System.out.println("Checking at 8");
                System.out.println("Loop for [" + i + "," + j + "]");
                if (grid[i][j] == 0) {
                    System.out.println("Checking for [" + i + "," + j + "]");
                    for (int v = 1; v <= 9; v++) {
                        if (canPlace(v, i, j, grid)) {
                            grid[i][j] = v;
                            printGrid(grid);
                            if (i == 8 && j == 8)
                                return true;
                            int newJ = (j + 1) % 9;
                            int newI = i;
                            if (newJ == 0)
                                newI = i + 1;
                            if (SolveSudoku(grid, newI, newJ))
                                return true;
                            System.out.println("Setting 0 back for [" + i + "," + j + "]");
                            grid[i][j] = 0;
                            printGrid(grid);
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean canPlace(int v, int i, int j, int[][] grid) {
        //Row level check
        for (int r = 0; r < 9; r++) {
            if (grid[r][j] == v)
                return false;
        }

        //Column level check
        for (int c = 0; c < 9; c++) {
            if (grid[i][c] == v)
                return false;
        }

        //Grid level check
        int p = getPosition(i);
        int q = getPosition(j);

        for (int r = p; r < p + 3; r++) {
            for (int c = q; c < q + 3; c++) {
                if (grid[r][c] == v)
                    return false;
            }
        }
        System.out.println("Can place " + v + " at place [" + i + "," + j + "]");
        return true;
    }

    private static int getPosition(int i) {
        switch (i) {
            case 0:
            case 1:
            case 2:
                return 0;
            case 3:
            case 4:
            case 5:
                return 3;
            case 6:
            case 7:
            case 8:
                return 6;
        }
        return -1;
    }

    static void printGrid(int[][] grid) {
        System.out.println("------------------");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        /*int[][] grid = {
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}};*/
        int[][] grid = {
                {0, 0, 7, 0, 0, 0, 3, 0, 2},
                {2, 0, 0, 0, 0, 5, 0, 1, 0},
                {0, 0, 0, 8, 0, 1, 4, 0, 0},
                {0, 1, 0, 0, 9, 6, 0, 0, 8},
                {7, 6, 0, 0, 0, 0, 0, 4, 9},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 3, 0, 0, 0},
                {8, 0, 1, 0, 6, 0, 0, 0, 0},
                {0, 0, 0, 7, 0, 0, 0, 6, 3}};

        System.out.println("Input ");
        printGrid(grid);
        System.out.println("-------------");
        if (SolveSudoku(grid, 0, 0)) {
            System.out.println("Answer is there");
            printGrid(grid);
        } else {
            System.out.println("Sudoku can't be solved");
        }
    }
}
