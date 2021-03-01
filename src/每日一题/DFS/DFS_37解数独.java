package 每日一题.DFS;

/**
 * 编写一个程序，通过已填充的空格来解决数独问题。
 *
 * 一个数独的解法需遵循如下规则：
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 空白格用 '.' 表示。

 */
public class DFS_37解数独 {

    public void solveSudoku(char[][] board) {
        //3个布尔数组
        boolean[][] rowUsed = new boolean[9][10];//行
        boolean[][] colUsed = new boolean[9][10];//列
        boolean[][][] boxUsed = new boolean[3][3][10];//在哪一个方格

        //1.首先遍历所有的空，把每个空的情况填进去
        //初始化
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int num = board[i][j] - '0';
                if( 1 <= num && num <= 9){
                    rowUsed[i][num] = true;
                    colUsed[j][num] = true;
                    boxUsed[i/3][j/3][num] = true;
                }
            }
        }

        //开始递归 填充数组
        dfs(board,rowUsed,colUsed,boxUsed,0,0);
    }

    private boolean dfs(char[][] board, boolean[][] rowUsed, boolean[][] colUsed, boolean[][][] boxUsed, int row, int col) {
        //边界检验，如果填充完成，返回true，表示结束
        if(col == board[0].length){
            col = 0;
            row++;
            if (row == board.length) {
                return true;
            }
        }

        //如果是空 尝试填空，否则跳到下一个位置
        if (board[row][col] == '.') {
            //尝试填 1~9
            for(int num = 1;num<=9;num++){
                boolean canUsed = !(rowUsed[row][num] || colUsed[col][num] || boxUsed[row/3][col/3][num]);
                if(canUsed){
                    rowUsed[row][num] = true;
                    colUsed[col][num] = true;
                    boxUsed[row/3][col/3][num] = true;

                    board[row][col] = (char)(num+'0');

                    if(dfs(board,rowUsed,colUsed,boxUsed,row,col+1)){
                        //继续向下递归，如果完全没问题，就返回true，结束程序
                        return true;
                    }
                    board[row][col] = '.';

                    //回溯，出现了问题，
                    rowUsed[row][num] = false;
                    colUsed[col][num] = false;
                    boxUsed[row/3][col/3][num] = false;
                }
            }
        }else {
            dfs(board,rowUsed,colUsed,boxUsed,row,col++);
        }
        return false;
    }


}
