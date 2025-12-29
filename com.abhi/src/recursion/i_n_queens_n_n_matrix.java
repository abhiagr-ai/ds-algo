package recursion;

import java.util.ArrayList;
import java.util.List;

public class i_n_queens_n_n_matrix {
    static void main() {
        SolutionNQ s = new SolutionNQ();
        List<String> board = new ArrayList<>();
        board.add("....");
        board.add("....");
        board.add("....");
        board.add("....");
        System.out.println(s.solve(board));
    }
}

class SolutionNQ {

    List<List<String>> results = new ArrayList<>();

    List<List<String>> solve(List<String> board) {
        placeQueens(board, 0);
        return results;
    }

    boolean isValid(List<String> board, int row, int col) {

        // Attack from Up
        for (int i = 0; i < board.size() && row - i >= 0; i++) {
            if (board.get(row - i).charAt(col) == 'Q') {
                return false;
            }
        }
        // Attack from Diagonal
        for (int i = 0; i < board.size() && row - i >= 0 && col + i < board.size(); i++) {
            if (board.get(row - i).charAt(col+i) == 'Q') {
                return false;
            }
        }

        // Attack from Anti-Diagonal
        for (int i = 0; i < board.size() && row - i >= 0 && col - i >=0; i++) {
            if (board.get(row - i).charAt(col-i) == 'Q') {
                return false;
            }
        }

        return true;
    }

    void placeQueens(List<String> board, int rowIndex) {

        if (rowIndex >= board.size()) {
            // **** focus
            results.add(new ArrayList<>(board));
            return;
        }

        // check only valid places

        for (int col = 0; col < board.size(); col++) {
            if (isValid(board, rowIndex, col)) {
                // DO Place Q at first col, first row
                StringBuilder newRow = new StringBuilder(board.get(rowIndex));
                newRow.setCharAt(col, 'Q');
                board.set(rowIndex, newRow.toString());
                //System.out.println(board);

                // Explore
                placeQueens(board, rowIndex + 1);
                //System.out.println(board);

                // Undo after path is explored
                newRow.setCharAt(col, '.');
                board.set(rowIndex, newRow.toString());
                //System.out.println(board);
            }
        }
    }
}

/**
 * [[.Q.., ...Q, Q..., ..Q.], [..Q., Q..., ...Q, .Q..]]
 *
 * ┌───┬───┬───┬───┐
 * │ . │ Q │ . │ . │
 * ├───┼───┼───┼───┤
 * │ . │ . │ . │ Q │
 * ├───┼───┼───┼───┤
 * │ Q │ . │ . │ . │
 * ├───┼───┼───┼───┤
 * │ . │ . │ Q │ . │
 * └───┴───┴───┴───┘
 *
 * ┌───┬───┬───┬───┐
 * │ . │ . │ Q │ . │
 * ├───┼───┼───┼───┤
 * │ Q │ . │ . │ . │
 * ├───┼───┼───┼───┤
 * │ . │ . │ . │ Q │
 * ├───┼───┼───┼───┤
 * │ . │ Q │ . │ . │
 * └───┴───┴───┴───┘
 *
 */