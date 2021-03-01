package 每日一题.DFS;

/**
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 *  
 *
 * 示例:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 */
public class DFS_79单词搜索 {
    /**
     *纯暴力 递归 回溯
     * @param board
     * @param word
     * @return
     */
/*    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(search(board,word,i,j,0)){
                    return true;
                }
            }
        }
        return  false;
    }

    private boolean search(char[][] board, String word, int i, int j, int len) {
        if(len >= word.length()) return true;

        if(i<0 ||
           i>=board.length ||
           j<0 ||
            j>= board[0].length ||
            board[i][j] != word.charAt(len)) return false;
        board[i][j] += 256;
        boolean result = search(board,word,i-1,j,len+1) ||
                         search(board,word,i+1,j,len+1) ||
                search(board,word,i,j+1,len+1) ||
                search(board,word,i,j-1,len+1) ;
        board[i][j] -= 256;
        return result;
    }*/
    /**
     * 老回溯算法，dfs+状态重置
     * @param board
     * @param word
     * @return
     */

    private boolean[][] marked;//做标记
    private int[][] direction = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    private int m;//行
    private int n;//列
    private char[][] board;
    private String word;
    public boolean exist(char[][] board, String word){
        m = board.length;
        if(m == 0){
            return false;
        }
        n = board[0].length;
        marked = new boolean[m][n];
        this.word  = word ;
        this.board  = board;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(dfs(i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, int start) {
        if(start == word.length() -1){
            //匹配到最后一个字母了
            return board[i][j] == word.charAt(start);
        }
        if(board[i][j] == word.charAt(start)){

            marked[i][j] = true;
            for (int k = 0; k < 4; k++) {
                int newX = i + direction[k][0];
                int newY = j + direction[k][1];
                if(inArea(newX,newY) && !marked[newX][newY]){
                    if(dfs(newX,newY,start + 1)){
                        return true;
                    }
                }
            }
            marked[i][j] = false;
        }
        return false;
    }

    private boolean inArea(int x, int y) {
        return x>= 0 && x < m && y>=0 && y<n;
    }


}
