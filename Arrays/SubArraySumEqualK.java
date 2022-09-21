package solvedArchive.Arrays;

//leetcode 560
public class SubArraySumEqualK {
    public static void main(String[] args) {

        int arr[] = {0,0};
        System.out.println(subarraySum(arr,0));

    }

    static int subarraySum(int[] arr, int k) {

        int count =0;

        if(arr[0]==k)
            count++;

        for(int i=1 ; i<arr.length ; i++){
            arr[i] += arr[i-1];
            if(arr[i]==k)
                count++;
        }

        for(int i=1 ; i<arr.length ; i++){
            for(int j=i ; j<arr.length ; j++){
                if (arr[j] - arr[i-1] == k)
                    count++;

            }
        }

        return count;
    }
}
