import java.util.ArrayList;
import java.util.Arrays;

public class IntervalListIntersection {
    /**
     * Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.
     *
     * Return the intersection of these two interval lists.
     *
     * (Formally, a closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.  The intersection of two closed intervals is a set of real numbers that is either empty, or can be represented as a closed interval.  For example, the intersection of [1, 3] and [2, 4] is [2, 3].)
     *
     *
     *
     * Example 1:
     *
     *
     *
     * Input: A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
     * Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
     * Reminder: The inputs and the desired output are lists of Interval objects, and not arrays or lists.
     *
     *
     * Note:
     *
     * 0 <= A.length < 1000
     * 0 <= B.length < 1000
     * 0 <= A[i].start, A[i].end, B[i].start, B[i].end < 10^9
     * @param args
     */
    public static void main(String[] args){
        int[][] A = {{0,2},{5,10},{13,23},{24,25}};
        int[][] B = {{1,5},{8,12},{15,24},{25,26}};
        System.out.println(intervalIntersection(A,B));
    }

    private static ArrayList<ArrayList<Integer>> intervalIntersection(int[][] A, int[][] B){
        ArrayList<ArrayList<Integer>> res  = new ArrayList<ArrayList<Integer>>();
        int a=0,b=0;
        while(a<A.length && b<B.length){
            int w = A[a][0], x = A[a][1], y = B[b][0], z = B[b][1];
            int low = Math.max(w,y);
            int high = Math.min(x,z);
            if(low<=high){
                res.add(new ArrayList<>(Arrays.asList(low,high)));
            }
            if(x<z){
                a++;
            }
            else{
                b++;
            }
        }
        return res;
    }
}
