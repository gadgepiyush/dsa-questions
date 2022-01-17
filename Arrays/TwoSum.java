package solvedArchive.Arrays;

import java.util.Arrays;

public class TwoSum {

    public static void main(String[] args) {
        int[] arr = {2,7,11,15};


        for(int i : twoSum(arr,9))
            System.out.print(i+" ");

    }


    // two sum using pointers and sorting
    static int[] twoSum(int[] arr, int target){

        int[] indexes = new int[2];

        int start = 0;
        int end = arr.length-1;

        int[] original = arr.clone();
        Arrays.sort(arr);

        while(start<end){

            if(arr[start]+arr[end] == target){

                int j=0;
                for(int i=0 ; i<original.length ; i++){
                    if(original[i]==arr[start] || original[i]==arr[end]){
                        indexes[j]= i;
                        j++;
                    }
                    if(j>1){
                        break;
                    }
                }
                break;
            }

            if(arr[start]+arr[end] > target){
                end--;
            }
            else {
                start++;
            }
        }


        return indexes;
    }

    // two pointers using hashmap

}
