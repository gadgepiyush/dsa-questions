package solvedArchive.Arrays;

//leetcode - 918
public class MaxSumCircularSubArray {
    public static void main(String[] args) {
        int arr[] = new int[]{5,-3,5};
        System.out.println(maxSubarraySumCircular(arr));

    }

    static int maxSubarraySumCircular(int[] arr) {
        int sum = 0;

        //calculate the total sum of the array
        for(int i : arr)
            sum += i;

        //calculate min sum of in array using same kadanes algo logic
        int minSum = kadanesMin(arr);

        //calculate max sum using kadanes algo
        int maxSum = kadanesMax(arr);

        //calculate the circular sum
        int circular = sum - minSum;

        if(maxSum>0)
            return Math.max(maxSum, circular);

        return maxSum;
    }

    static int kadanesMin(int arr[]){
        int min = Integer.MAX_VALUE;
        int currSum = 0;

        for(int i : arr){
            currSum += i;

            if(currSum<min)
                min = currSum;

            if(currSum>0)
                currSum = 0;
        }

        return min;
    }

    static int kadanesMax(int arr[]){
        int max = Integer.MIN_VALUE;
        int currSum = 0;

        for(int i : arr){
            currSum += i;

            if(currSum>max)
                max = currSum;

            if(currSum<0)
                currSum = 0;
        }

        return max;
    }
}
