package solvedArchive.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7};
        rotate(arr, 3);

        for(int i:arr){
            System.out.print(i + " ");
        }
    }

    static void rotate(int[] arr, int k) {
        k = k%arr.length;

        //reverse the whole array
        reverse(arr, 0, arr.length-1);

        //revserse the first k elements
        reverse(arr, 0, k-1);

        //revserse the remaining elements
        reverse(arr, k, arr.length-1);
    }

    static void reverse(int[] arr, int start, int end){
        while(start<end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }
}
