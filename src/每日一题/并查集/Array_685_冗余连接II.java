package 每日一题.并查集;

/**
 * 输入: [[1,2], [1,3], [2,3]]
 * 输出: [2,3]
 * 解释: 给定的有向图如下:
 *   1
 *  / \
 * v   v
 * 2-->3
 * 示例 2:
 *
 * 输入: [[1,2], [2,3], [3,4], [4,1], [1,5]]
 * 输出: [4,1]
 * 解释: 给定的有向图如下:
 * 5 <- 1 -> 2
 *      ^    |
 *      |    v
 *      4 <- 3
 */
public class Array_685_冗余连接II {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int  nodesCount = edges.length;

        UnionFind uf = new UnionFind(nodesCount+1);

        //父节点的数组
        int[] parent = new int[nodesCount + 1];
        for (int i = 1; i <= nodesCount; i++) {
            parent[i] = i;
        }

        int conflict = -1; // 冲突边
        int cycle = -1;
        for (int i = 0; i < nodesCount; ++i) {
            int[] edge = edges[i];
            int node1 = edge[0], node2 = edge[1];
            if (parent[node2] != node2) {
                conflict = i;
            } else {
                //Parent 内容是父节点，
                parent[node2] = node1;
                if (uf.find(node1) == uf.find(node2)) {
                    cycle = i;
                } else {
                    uf.union(node1, node2);
                }
            }
        }

        if (conflict < 0) { //没有冲突边   有环
            int[] redundant = {edges[cycle][0] , edges[cycle][1]};
            return redundant;
        }else {//有冲突边
            int[] confictEdge = edges[conflict];
            if (cycle >= 0) {  //有环 又有冲突边
                int[] redundant ={parent[confictEdge[1]],confictEdge[1]};
                return redundant;
            }else { //只有冲突边
                int[] redundant = {confictEdge[0],confictEdge[1]};
                return redundant;
            }
        }

    }

    class UnionFind{
        int[] ancestor;

        public UnionFind(int n){
            //初始化
            ancestor = new int[n];
            for (int i = 0; i < n; i++) {
                ancestor[i] = i;
            }
        }

        //合并两个集合
        public void union(int index1,int index2){
            //将祖先节点给 合并了
            ancestor[find(index1)] = find(index2);
        }

        //寻找index下标的祖先节点
        public int find(int index){
            if(ancestor[index] != index){
                ancestor[index] = find(ancestor[index]);
            }
            return ancestor[index];
        }


    }
}
