package solvedArchive.Arrays;

public class SubArray {
    public static void main(String[] args) {

        int arr[] = {1,2,3,4,5,6};

        int arr2 = subArraySum3(arr);

        System.out.println(arr2);

    }

    //max subArray sum (Brute force) (time complexity O(N^3))
    static int subArraySum1(int arr[]){

        int max = Integer.MIN_VALUE;

        for(int i=0 ; i<arr.length ; i++){
            for(int j=i ; j<arr.length ; j++){
                int sum = 0;

                for(int k=i ; k<=j ; k++)
                    sum += arr[k];

                max = Math.max(max, sum);
            }
        }

        return max;
    }


    //max subArray sum (Prefix sum) (time complexity O(N^2))
    static int subArraySum2(int arr[]){

        int max = Integer.MIN_VALUE;
        int prefixSum[] = new int[arr.length];
        prefixSum[0] = arr[0];

        for(int i=1; i<arr.length ; i++){
            prefixSum[i] = prefixSum[i-1] + arr[i];
        }

        for(int i=0 ; i<prefixSum.length ; i++){
            for(int j=i ; j<prefixSum.length ; j++){

                int subArraySum = i>0 ? prefixSum[j]-prefixSum[i-1] : prefixSum[j];
                max = Math.max(subArraySum,max);

            }
        }

        return max;
    }


    //max subArray sum (Kadane's algo) (time complexity O(N))
    static int subArraySum3(int arr[]){

        int max = Integer.MIN_VALUE;
        int currSum = 0;

        for(int i=0 ; i<arr.length ; i++){
            currSum += arr[i];

            if(currSum>max)
                max=currSum;

            if(currSum<0)
                currSum=0;

        }

        return max;
    }
}
