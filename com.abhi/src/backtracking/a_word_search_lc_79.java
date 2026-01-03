package backtracking;

import java.util.Arrays;

/**
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cells,
 * where adjacent cells are horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 * Input: board = [
 * ["A","B","C","E"],
 * ["S","F","C","S"],
 * ["A","D","E","E"]
 * ],
 * word = "ABCCED"
 * Output: true
 *
 * Input: board = [
 *  ["A","B","C","E"],
 *  ["S","F","C","S"],
 *  ["A","D","E","E"]],
 *  word = "SEE"
 * Output: true
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]],
 * word = "ABCB"
 * Output: false
 *
 * youtube.com/watch?v=whyax_vB8xY&list=PLpIkg8OmuX-KJPC18SGiRUzJQAYo839ox&index=1
 */
public class a_word_search_lc_79 {
    static void main() {
        SolutionWS s = new SolutionWS();
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "SEE";
        System.out.println(s.solve(board, word));
    }
}

class SolutionWS {
    boolean solve(char[][] board, String word){
        int n = board.length;
        int m = board[0].length;

        for(int i=0; i < n; i++){
            for(int j=0; j < m; j++){
                if(board[i][j] == word.charAt(0)){
                    // found the first occurrence of first char
                    System.out.println(">>>>>> Found Start Letter at i="+i+ " j="+j );
                    if(find(board, word, i, j , 0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    boolean find(char[][] board, String word, int i, int j, int idx){
        System.out.println("BT: i="+i +  " j="+j +" idx="+idx + " board="+ Arrays.deepToString(board));

        // focus here idx =2, l =3 for
        // BT: i=0 j=2 idx=2 board=[[A, B, C, $], [S, F, C, $], [A, D, E, E]]
        if(idx == word.length()){
            return true;
        }
        if(i<0 || j < 0 || i >= board.length || j >= board[0].length ){
            return false;
        }
        if(board[i][j] == '$'){
            return false;
        }
        if(board[i][j] != word.charAt(idx)){
            return false;
        }

        // set
        char temp = board[i][j];
        board[i][j] = '$';
        System.out.println("set >>i="+i +  " j="+j +" idx="+idx + " board="+ Arrays.deepToString(board));

        // do  up, down, right, left
        // up i-,j
        if(find(board, word, i-1, j, idx+1)){
            System.out.println("TRUE: i="+i +  " j="+j +" idx="+idx + " board="+ Arrays.deepToString(board));
            return true;
        };
        // down i+,j
        if(find(board, word, i+1, j, idx+1)){
            System.out.println("TRUE: i="+i +  " j="+j +" idx="+idx + " board="+ Arrays.deepToString(board));
            return true;
        };
        // right i,j+
        if(find(board, word, i, j+1, idx+1)){
            System.out.println("TRUE: i="+i +  " j="+j +" idx="+idx + " board="+ Arrays.deepToString(board));
            return true;
        };
        // left i,j-
        if(find(board, word, i, j-1, idx+1)){
            System.out.println("TRUE: i="+i +  " j="+j +" idx="+idx + " board="+ Arrays.deepToString(board));
            return true;
        };

        // unset
        System.out.println("un-set >>i="+i +  " j="+j +" idx="+idx + " board="+ Arrays.deepToString(board));
        board[i][j] = temp;
        return false;
    }

}
