package Games.Sudoku;

import java.util.Arrays;
import java.util.Scanner;

public class SudokuSolver {
    public static void main(String[] args) {
        final int GRID_SIZE = 9;
        Scanner in = new Scanner(System.in);
        int[][] board = new int[GRID_SIZE][GRID_SIZE];

        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                System.out.print("Enter a number for a 9x9 sudoku grid at row " + (row + 1) + " and column " + (col + 1) + "\nEnter a 0 to indicate an empty space: ");
                board[row][col] = in.nextInt();
            }
        }
        System.out.println(Arrays.deepToString(board));
    }
}
