package arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class SpecialInteger {

    public static void main(String[] args){
        ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println(solve(arr,10));
    }

    public static int solve(ArrayList<Integer> A, int B) {
        int low = 0, high = A.size(), max = 0;
        while(low <= high){
            int mid = low + (high-low)/2;
            System.out.println("low ="+low+" high ="+high+" mid = "+mid);
            boolean isPossible = true;
            int i = 0, j = 0, sum = 0;
            while(j <A.size()){
                if(j-i >= mid){
                    sum-=A.get(i);
                    i++;
                }
                sum+=A.get(j);
                System.out.println(j+" "+i+" "+sum);

                if(sum > B){
                    isPossible = false;
                    break;
                }
                j++;
            }
            System.out.println(mid+ " "+max+" "+isPossible);

            if(isPossible){

                if(max < mid){
                    max = mid;
                }
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return max;
    }
}
