package solvedArchive.Arrays;

//leetcode - 152
public class MaxProductSubArray {
    public static void main(String[] args) {
        int arr[] = {0,0,0};

        System.out.println(maxProduct(arr));
    }

    static int maxProduct(int[] arr) {
        int leftProd = 1;
        int rightProd = 1;
        int max = arr[0];

        for(int i=0 ; i<arr.length ; i++){
            leftProd = (leftProd==0) ? 1 : leftProd;
            rightProd = (rightProd==0) ? 1 : rightProd;

            leftProd *= arr[i];
            rightProd *= arr[arr.length-i-1];

            max = Math.max(max, Math.max(leftProd, rightProd));
        }

        return max;
    }
}
