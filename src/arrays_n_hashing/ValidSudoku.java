package arrays_n_hashing;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public static boolean isValidSudoku(char[][] board) {

        return hasUnique3x3(board) &&
                hasUniqueRowsColumns(board, true) &&
                hasUniqueRowsColumns(board, false);
    }

    public static boolean hasUnique3x3(char[][] board) {

        for ( int k = 0; k < 3; k++ ) {
            for ( int l = 0; l < 3; l++ ) {
                Set<Character> letters = new HashSet<>();

                for ( int i = 0; i < 3; i++ ) {
                    for ( int j = 0; j < 3; j++ ) {
                        boolean b = letters.add(board[i + 3 * k][j + 3 * l]);
                        if ( !b ) {
                            if ( !(board[i + 3 * k][j + 3 * l] == '.') ) {
                                return false;
                            }
                        }
                    }
                }

            }
        }


        return true;
    }

    public static boolean hasUniqueRowsColumns(char[][] board, boolean isRow) {

        for ( int row = 0; row < 9; row++ ) {

            Set<Character> letters = new HashSet<>();

            for ( int col = 0; col < 9; col++ ) {
                boolean b = letters.add(isRow ? board[row][col] : board[col][row]);
                if ( !b ) {
                    if ( !((isRow ? board[row][col] : board[col][row]) == '.') ) {
                        return false;
                    }
                }

            }

        }
        return true;
    }


    public static void main(String[] args) {
        char[][] board1 = {
                {'1', '2', '.', '.', '3', '.', '.', '.', '.'},
                {'4', '.', '.', '5', '.', '.', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '.', '3'},
                {'5', '.', '.', '.', '6', '.', '.', '.', '4'},
                {'.', '.', '.', '8', '.', '3', '.', '.', '5'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '.', '.', '.', '.', '.', '2', '.', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '8'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'},
        };
        char[][] board2 = {
                {'1', '2', '.', '.', '3', '.', '.', '.', '.'},
                {'4', '.', '.', '5', '.', '.', '.', '.', '.'},
                {'.', '9', '1', '.', '.', '.', '.', '.', '3'},
                {'5', '.', '.', '.', '6', '.', '.', '.', '4'},
                {'.', '.', '.', '8', '.', '3', '.', '.', '5'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '.', '.', '.', '.', '.', '2', '.', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '8'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        System.out.println(isValidSudoku(board1));
        System.out.println(isValidSudoku(board2));
    }
}
