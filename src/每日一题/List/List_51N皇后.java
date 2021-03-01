package 每日一题.List;

import java.util.*;


public class List_51N皇后 {

    /**
     * 回溯法：用集合
     * @param n
     * @return
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<List<String>>();

        //存放女王的位置
        int[] queens = new int[n];
        Arrays.fill(queens,-1);
        //存放当前列包含的女王
        Set<Integer> columns = new HashSet<>();
        //存放左斜线包含的女王的集合
        Set<Integer> diagonals1 = new HashSet<>();
        //存放右斜线包含的女王的集合
        Set<Integer> diagonals2 = new HashSet<>();

        //开始递归
        dfs(solutions,queens,n,0,columns,diagonals1,diagonals2);

        return solutions;
    }

    /**
     * 递归方法
     * @param solutions 最终结果集
     * @param queens    女王位置数组
     * @param n         n皇后
     * @param row       当前行数
     * @param columns   列集合
     * @param diagonals1 左斜集合
     * @param diagonals2 右斜集合
     */
    public void dfs(List<List<String>> solutions,int [] queens,int n,int row,Set<Integer> columns,Set<Integer> diagonals1,Set<Integer> diagonals2){
        if(row == n){
            //最后一个皇后已经放好，可以开始形成列表了
            List<String> board = generateBoard(queens,n);
            solutions.add(board);
        }else {
            //每一行都要从第一列开始判断
            for (int i = 0; i < n; i++) {
                //如果当前列存在于集合，跳过
                if(columns.contains(i)){
                    continue;
                }
                //当前点 的左斜数字
                int diagonal1 = row - i;
                if(diagonals1.contains(diagonal1)){
                    continue;
                }
                //当前点 的右斜数字
                int diagonal2 = row + i;
                if(diagonals2.contains(diagonal2)){
                    continue;
                }
                queens[row] = i;
                columns.add(i);
                diagonals1.add(diagonal1);
                diagonals2.add(diagonal2);
                //进入下一层
                dfs(solutions,queens,n,row + 1,columns,diagonals1,diagonals2);
                //从上一层跳出来后，说明不符合要求，刚刚做的添加都要删除
                //当前节点空出来
                queens[row] = -1;
                columns.remove(i);
                diagonals1.remove(diagonal1);
                diagonals2.remove(diagonal2);
            }
        }
    }

    private List<String> generateBoard(int[] queens, int n) {
        List<String> board = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row,'.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }

    /***************************************************************/
    //方法二：回溯法：用三个 boolean数组
    private int n ;
    //记录某一列是否存放皇后
    private boolean[] col;
    //记录 左对角线上 是否放置皇后
    private boolean[] left;
    //记录了 右对角线上 是否存放皇后
    private boolean[] right;
    private List<List<String>> res;

    public List<List<String>> solveNQueens2(int n){
        res = new ArrayList<>();
        if(n == 0){
            return res;
        }

        //设置成员变量，减少参数传递，具体作为方法参数还是作为成员变量
        this.n = n;
        this.col = new boolean[n];
        this.left = new boolean[2 * n - 1];
        this.right = new boolean[2 * n - 1];
        Deque<Integer> path = new ArrayDeque<>();
        dfs(0,path);
        return res;
    }

    private void dfs(int row,Deque<Integer> path){
        if(row == n){
            //深度优先遍历到下标n，表示[0..n-1]已经填完，得到一个结果
            List<String> board = conver2board(path);
            res.add(board);
            return;
        }

        //针对下标为row的每一列，尝试
        for (int i = 0; i < n; i++) {
            if(!col[i] && !left[row - i + n -1] && !right[row + i]){
                path.addLast(i);
                col[i] = true;
                right[row + i] = true;
                left[row - i + n - 1 ] = true;

                dfs(row + 1,path);

                path.removeLast();
                col[i] = false;
                right[row + i] = false;
                left[row - i + n - 1 ] = false;
            }
        }
    }

    private List<String> conver2board(Deque<Integer> path) {
        List<String> board = new ArrayList<>();
        for (Integer num : path) {
            StringBuilder row = new StringBuilder();
            for (int i = 0; i < n; i++) {
                row.append(".");
            };
            row.replace(num,num + 1,"Q");
            board.add(row.toString());
        }
        return board;
    }

/*************************************************************/
    //方法三：位运算
public List<List<String>> solveNQueens3(int n) {
    //数组 用于记录每行中皇后的所在位置
    int[] queens = new int[n];
    Arrays.fill(queens,-1);

    List<List<String>> res = new ArrayList<>();
    solve(res,queens,n,0,0,0,0);
    return res;
}

    /**
     * 遍历可以放置皇后的位置时，可以利用以下两个按位与运算的性质：
     *
     * x & (−x) 可以获得 x 的二进制表示中的最低位的 1 的位置；
     *
     * x & (x−1) 可以将 x 的二进制表示中的最低位的 1 置成 0。
     *
     */

    /**
     *
     * @param solutions
     * @param queens
     * @param n 总行数
     * @param row   当前行数
     * @param columns   不可选的列
     * @param diagonals1    不可选的左斜边
     * @param diagonals2    不可选的右斜边
     */
    public void solve(List<List<String>> solutions, int[] queens, int n, int row, int columns, int diagonals1, int diagonals2) {

        //如果走到这一步，说明搜索已经到底了，我们记录下一个可行的方案
        if(row == n){
            //直接生成一个结果，存入
            List<String> board = generateBoard2(queens, n);
            solutions.add(board);
        }else{
            //  1<<n-1 为了转换一个长度为n的 每位都是1的二进制数，用于定位放置皇后的位置
            //  这里用于定位所有可选的位置，这里有一步取反
            //上面我们用1表示不可选的位置，但是 取反后，1表示可选的位置
            //~按位取反，负数
            int availablePositions = ((1 << n) - 1) & (~(columns | diagonals1 | diagonals2));//可用的位置 的字节码  1111 -> 1110 -> 1100 -> 1000 -> 0000
            //这个地方 ~取反 0 -> -1 0000  1111111

            //通过下面的操作保持之前所有的行对下一行的影响

            //开始检查每个可选的位置
            while(availablePositions  != 0){
                //定位最后一个1的位置，这个操作可以手写验证一阿信（不要忘了把负数 转成 补码）

                //得到最低位 为1的位置      它的作用很重要，相当于从最低为开始放，放完后，dfs的时候，在 列，左右斜边，上进行增加 当前最底点的 皇后已经放好啦  从最低为开始取皇后
                int position = availablePositions  & (-availablePositions );
                // 减一操作，把当前位置 给移除=等同于 把皇后放进去了
                availablePositions  = availablePositions  & (availablePositions  - 1);    //清除刚刚取出来的皇后
                //统计一个二进制数中所有的1的个数  比如 1-1 = 0 0000 = 1数量=0  2-1=0001 数量为1 4-1=011 数量为2 8-1=111 数量为3 代表第几列
                int column = Integer.bitCount(position - 1);
                //将这个位置添加到记录数组中
                queens[row] = column;//当前行 填入第 column列

                //接着继续dfs, 可选行 和 可选列 变化即可，这样不需要重置状态了

                //这个地方 columns | position 就是把刚刚填入的节点位置 给加上，再左右移
                solve(solutions, queens, n, row + 1, columns | position, (diagonals1 | position) << 1, (diagonals2 | position) >> 1);
                //每次循环上次的结果都会被覆盖
//                queens[row] = -1;
            }
        }
    }

    // 生成字符串
    public List<String> generateBoard2(int[] queens, int n) {
        List<String> board = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }


    /***********************************************************************************************/
    public List<List<String>> solveNQueens4(int n) {
        //数组 用于记录每行中皇后的所在位置
        int[] queens = new int[n];
        Arrays.fill(queens,-1);

        List<List<String>> res = new ArrayList<>();
        dfs2(res,queens,n,0,0,0,0);
        return res;
    }

    /**
     * 遍历可以放置皇后的位置时，可以利用以下两个按位与运算的性质：
     *
     * x & (−x) 可以获得 x 的二进制表示中的最低位的 1 的位置；
     *
     * x & (x−1) 可以将 x 的二进制表示中的最低位的 1 置成 0。
     *
     */

    /**
     *
     * @param res
     * @param queens
     * @param n 总行数
     * @param row   当前行数
     * @param columns   不可选的列
     * @param diagonals1    不可选的左斜边
     * @param diagonals2    不可选的右斜边
     */
    private void dfs2(List<List<String>> res, int[] queens,int n,int row,int columns,int diagonals1,int diagonals2) {
        //如果走到这一步，说明搜索已经到底了，我们记录下一个可行的方案
        if(row == n){
            //直接生成一个结果，存入
            res.add(generateString(queens));
            return;
        }
        //  1<<n-1 为了转换一个长度为n的 每位都是1的二进制数，用于定位放置皇后的位置
        //  这里用于定位所有可选的位置，这里有一步取反
        //上面我们用1表示不可选的位置，但是 取反后，1表示可选的位置
        //~按位取反，负数
        int availableLocations = ((1<<n)-1&(~(columns|diagonals1|diagonals2)));//可用的位置
        //这个地方 ~取反 0 -> -1 0000  1111111

        //通过下面的操作保持之前所有的行对下一行的影响
        //左斜边因为下降了 一行，需要左移一行
        diagonals1<<=1;
        //左斜边因为下降了 一行，需要左移一行
        diagonals2>>=1;
        //开始检查每个可选的位置
        while(availableLocations != 0){
            //定位最后一个1的位置，这个操作可以手写验证一阿信（不要忘了把负数 转成 补码）

            //得到最低位 为1的位置      它的作用很重要，相当于从最低为开始放，放完后，dfs的时候，在 列，左右斜边，上进行增加 当前最底点的 皇后已经放好啦
            int position = availableLocations & (-1 * availableLocations);

            //统计一个二进制数中所有的1的个数
            int columnNum = Integer.bitCount(position-1);
            //将这个位置添加到记录数组中
            queens[row] = columnNum;//当前行 有几个位置可以填

            //将这一位从可选取的位中移除
            // 减一操作，把当前位置 给移除=等同于 把皇后放进去了
            availableLocations = availableLocations&(availableLocations-1);
            //接着继续dfs, 可选行 和 可选列 变化即可，这样不需要重置状态了
            dfs2(res,queens,n,row+1,columns|position,diagonals1|position<<1,diagonals2|position>>1);
            //每次循环上次的结果都会被覆盖
        }
    }

    // 生成字符串
    public List<String> generateString(int[] queens){
        List<String> result=new ArrayList<>();
        for(int i:queens){
            char[] chars=new char[queens.length];
            Arrays.fill(chars,'.');
            chars[i]='Q';
            result.add(String.valueOf(chars));
        }
        return result;
    }
}
