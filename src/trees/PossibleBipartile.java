package trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Given a set of N people (numbered 1, 2, ..., N), we would like to split everyone into two groups of any size.
 *
 * Each person may dislike some other people, and they should not go into the same group.
 *
 * Formally, if dislikes[i] = [a, b], it means it is not allowed to put the people numbered a and b into the same group.
 *
 * Return true if and only if it is possible to split everyone into two groups in this way.
 *
 * Input: N = 4, dislikes = [[1,2],[1,3],[2,4]]
 * Output: true
 * Explanation: group1 [1,4], group2 [2,3]
 *
 * Input: N = 3, dislikes = [[1,2],[1,3],[2,3]]
 * Output: false
 *
 * Input: N = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
 * Output: false
 */
class PossibleBipartile {
    static ArrayList<Integer>[] graph;
    static Map<Integer, Integer> color;

    public static void main(String[] args){
//        int [][] dislikes = {{1,2},{1,3},{2,4}};
//        int N = 4;
        int [][] dislikes = {{1,2},{1,3},{2,3}};
        int N = 3;
        System.out.println(possibleBipartition(N,dislikes));
    }


    public static boolean possibleBipartition(int N, int[][] dislikes) {
        graph = new ArrayList[N+1];
        for (int i = 1; i <= N; ++i)
            graph[i] = new ArrayList();

        for (int[] edge: dislikes) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }


        color = new HashMap();
        for (int node = 1; node <= N; ++node)
            if (!color.containsKey(node) && !dfs(node, 0))
                return false;
        return true;
    }

    public static boolean dfs(int node, int c) {
        if (color.containsKey(node))
            return color.get(node) == c;
        color.put(node, c);

        for (int nei: graph[node])
            if (!dfs(nei, c ^ 1))
                return false;
        return true;
    }
}