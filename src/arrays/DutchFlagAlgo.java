package arrays;

public class DutchFlagAlgo {

    public static void sort(int[] arr){
        int low = 0, mid = 0, high = arr.length-1;

        while(mid<=high){
            switch(arr[mid]){
                case 0: {
                        int temp = arr[low];
                        arr[low] = arr[mid];
                        arr[mid] = temp;
                        low++;
                        mid++;
                        break;
                }
                case 1:{
                        mid++;
                        break;
                }
                case 2:{
                        int temp = arr[high];
                        arr[high] = arr[mid];
                        arr[mid] = temp;
                        high--;
                }
            }
        }

        for(int x : arr){
            System.out.print(x+" ");
        }
    }

    public static void main(String[] args){
        int arr[] = {1,1,0,0,2,2,1,1,2};
        sort(arr);
    }
}
