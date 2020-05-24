package arrays;

public class MinSwaps {


    /**
     *
     * @param arr - given array
     * @param k - given number
     * @return - minimum number of swaps to club all the elements less than k together
     */
    static int getMinSwaps(int[] arr, int k){
        //count the elements less than k
        int count =0;
        for(int x: arr)
            if(x<=k)
                count++;

        //count the elements greater then k in first window of size=count
        int num_elem_greater_then_k=0;
        for(int i=0;i<count;i++)
            if(arr[i]>k)
                num_elem_greater_then_k++;


        /*
            Now we have the sliding window size=count,
            As the idea is to have a window or subarray of size count ie all elements<=k together
            we can slide the window keep track of element going out from left and coming from right
         */
        int ans = num_elem_greater_then_k;
        for(int i=0,j=count;j<arr.length;i++,j++){

            //if element going out was greater than k then in the window we decrement the count
            if(arr[i]>k)
                num_elem_greater_then_k--;

            //if element coming in is greater than k then in the window we increment the count
            if(arr[j]>k)
                num_elem_greater_then_k++;

            ans = Math.min(ans,num_elem_greater_then_k); //after covering all the window we can find out
        }
        return ans;
    }

    public static void main(String [] args){

        int arr[] = {1, 12, 10, 3, 14, 10, 5};
        System.out.println(getMinSwaps(arr,8));

    }
}
