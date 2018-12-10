package mylib;

/******************************************
 *
 * 判断是否是一颗树--就是判断联通性问题
 * 178. 图是否是树
 * 给出 n 个节点，标号分别从 0 到 n - 1 并且给出一个 无向 边的列表 (给出每条边的两个顶点), 写一个函数去判断这张｀无向｀图是否是一棵树
 *
 * 样例
 * 给出n = 5 并且 edges = [[0, 1], [0, 2], [0, 3], [1, 4]], 返回 true.
 *
 * 给出n = 5 并且 edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], 返回 false.
 *
 * 注意事项
 * 你可以假设我们不会给出重复的边在边的列表当中. 无向边　[0, 1] 和 [1, 0]　是同一条边， 因此他们不会同时出现在我们给你的边的列表当中
 *
 * 思路：这里先建立联通表uionfind，然后再遍历节点
 *
 ******************************************/

public class IsTree {

    public boolean validTree(int n, int[][] edges) {
        // write your code here
//        boolean flag = false;
        Graph graph = new Graph(n);
        for (int i=0; i < edges.length; i++) {
            graph.union(edges[i][0],edges[i][1]);
        }
        System.out.println(graph.getCount());
        return graph.getCount() ==1;
    }

    class Graph {
        int[] id;//联通表,引用：节点，值：所属的联通表
//        int[] size;//联通表的大小，引用：联通表，值：联通表的大小--用以提升比较效率
        int n;//节点数量
        int count;//联通分量的数量

        Graph(int n) {
            this.n = n;
//            this.size = new int[n];
            this.id = new int[n];
            this.count = n;
            for (int i = 0; i < n; n++) {
//                size[i] = 1;
                id[i] = i;
            }
        }

        public int find(int p) {
            validate(p);
            while (p != id[p]) {
//                id[p] = id[id[p]];
                p = id[p];
            }
            return p;
        }

        public void union(int p, int q) {
//            int rootP = find(p);
//            int rootQ = find(q);
//            if (rootP == rootQ) return;
//
//            if      (size[rootP] < size[rootQ]) id[rootP] = rootQ;
//            else if (size[rootP] > size[rootQ]) id[rootQ] = rootP;
//            else {
//                id[rootQ] = rootP;
//                size[rootP]++;
//            }
//            count--;
            int m = find(p);
            int n = find(q);
            if (m == n) {
                return;
            } else {
                id[m] = n;
                count --;
            }


        }

        public void validate(int p) {
            int valid = id.length;
            if (p > valid || p < 0) {
                throw new IllegalArgumentException("dot is illegal!");
            }
        }

        public int getCount(){
            return count;}

    }

    public static void main(String[] args) {
        int[][] edges ={{0,1},{0,2},{0,3},{0,4}};

        IsTree isTree =new IsTree();
        System.out.println(isTree.validTree(5,edges));
    }
}
