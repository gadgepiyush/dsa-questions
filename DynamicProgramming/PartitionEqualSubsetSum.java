package solvedArchive.DynamicProgramming;

import java.util.Arrays;

//leetcode 416
public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        int arr[] = {1,5,11,5};
        System.out.println(canPartition(arr));
    }

    static boolean canPartition(int[] arr){
        int sum = Arrays.stream(arr).sum();

        if(sum%2!=0)
            return false;

        return canPartitionHelper(arr, 0 ,sum/2);
    }

    static boolean canPartitionHelper(int arr[], int i, int sum){
        if(i==arr.length)
            return false;

        if(sum==0)
            return true;

        boolean exclude = canPartitionHelper(arr, i+1, sum);
        boolean include = false;
        if(arr[i]<=sum)
            include = canPartitionHelper(arr, i+1, sum-arr[i]);

        return exclude || include;
    }
}
