package binary_search;

/**
 *
 * A lot to Merge
 * Nebula gave Groot an integer N and M and an algorithm to construct a matrix of size N*M. The matrix is constructed as follows:
 *
 * The entry at the intersection of i'th row and j'th column will be i*j.
 *
 * Once Groot is done making the matrix, Nebula asked him to take all the elements of the matrix and arrange them in ascending order.
 *
 * Now Nebula gave Groot an integer K and asked Groot to find the K'th element in the arranged list.
 *
 * Constraints:
 *
 * 1) 1<=N,M<= 10^4
 * 2) 1<=K<=N*M
 * Input Format Three integers N,M and K
 *
 * Output Format Value of the K'th element in the sorted list of N*M elements
 *
 * Example Input
 *
 * N:2
 * M:2
 * K:2
 * Example Output
 *
 * 2
 * Explanation
 *
 * Value of the Kth element is 2
 */
public class SearchInProductMatrix {

    static int check(int mid, int n,int m){
        int ans = 0;
//        System.out.println("Calculating count.....");
        for(int i=1;i<n;i++){
//            System.out.println("i="+i+" ans = "+ans+"+Math.min("+m+","+mid+"/"+i+")");
            ans = ans + Math.min(m,mid/i);

        }
        return ans;
    }

    static int searchElement(int a, int b, int c){
        int n = a;
        int m= b;
        int k = c;

        int low = 0;
        int high = n*m;

        while(low <= high){
            int mid = low+(high-low)/2;
//            System.out.println(low+"--"+mid+"--"+high);
            int count = check(mid,n,m);
//            System.out.println("count = "+count);
            if(count == 0)
                return 1;
            if(count < c){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }

        return low;
    }
    public static void main(String[] args){
        System.out.println(searchElement(1,1,1));
    }
}
